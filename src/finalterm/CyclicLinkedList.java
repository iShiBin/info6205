package finalterm;

/**
 * Assignment:
 * 
 * Create a sorted sorted cyclic linked list class, which is sorted all the time
 * when inserting a new element.
 * 
 * The function name is "insert". If it is null, create it and make is cyclic.
 * 
 * Have a the head as the start of the list.
 */

/*
 * Approach I: Use singly linked list and point the tail to the head. [O(n)]
 * This is very trivial so I won't do it. Instead, I will build a more efficient one.
 * 
 * Approach II: Use TreeMap and ArrayDeque to store the value and node list [O(log(n))]
 * The TreeMap<Integer, Deque<ListNode>> is only for quick look up the right position to insert.
 * 
 * Here is the logic:
 * 1. If the node to be inserted is the first one, set it as the head's next and then put it in the map.
 * 2. Otherwise, if it is the smallest one:
 *    - take the head as it's previous node, and connect the node with its previous one, and its next one
 *    - point the tail node to this node and make it a circle
 *    If it is not the smallest, then just connect this node with its proper nodes before and after
 * 3. At last, put this node to the map.
 * 
 * This algorithm has a O(log(n)) time complexity because inserting to a binary tree. However, the expense is to use an extra map,
 * which has a O(n) space complexity.
 * 
 *  Note: If no nodes has the same value, we can use TreeSet instead of TreeMap.
 */

/**
 * The definition of the singly linked node.
 * @author bin
 *
 */

import java.util.*;
class ListNode {
    ListNode next;
    int data;

    ListNode() {}

    ListNode(int value) {
        this.data = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}

class CyclicLinkedList {
    private TreeMap<Integer, ArrayDeque<ListNode>> map = null;
    private ListNode head = null;

    CyclicLinkedList() {
        head = new ListNode();
        this.map = new TreeMap<>();
    }

    public void insert(int data) {

        ListNode node = new ListNode(data);
        if (map.isEmpty()) {// the very first node
            head.next = node;
            node.next = node;
        } else {
            Integer floor = map.floorKey(data);
            if (floor == null) {//value to be inserted is the smallest
                this.connectNode(head, node);
                map.lastEntry().getValue().getLast().next = node;//point the last node to this new node
            } else {
                //otherwise, just insert it and make node to pointer the pre.next 
                ListNode pre = map.ceilingEntry(floor).getValue().getLast();
                this.connectNode(pre, node);
            }
        }
        map.putIfAbsent(data, new ArrayDeque<>());
        map.get(data).add(node);//add new node to the map
    }

    /**
     * Connect this node with its previous node (the biggest one less than (or equal with) it)
     * @param pre
     * @param node
     */
    private void connectNode(ListNode pre, ListNode node) {
        ListNode temp = pre.next;
        pre.next = node;
        node.next = temp;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode node = head.next;
        do {
            // System.out.println(node.data);
            list.add(node.data);
            node = node.next;

        } while (node != head.next);

        return list.toString();
    }

    /**
     * For test purpose: verify if this is a cyclic linked list.
     * @return The joint node if it is cycled, otherwise, return null;
     */
    private ListNode getJoint() {
        ListNode fast = head, slow = head;

        if (fast.next == slow)
            return slow;// only one node but cyclic

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }

        return fast == slow ? slow : null;
    }
    
    public static void main(String[] args) {
        CyclicLinkedList test = new CyclicLinkedList();
        test.insert(8);
        test.insert(7);
        test.insert(5);
        test.insert(9);
        test.insert(7);
        test.insert(10);
        
        System.out.println(test.getJoint().data);//10
        System.out.println(test.toString());//[5, 7, 7, 8, 9, 10]
    }
}