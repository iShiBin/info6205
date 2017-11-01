//Definition for singly-linked list.

package list;

public class ListNode {
   public ListNode next = null;
   public int val = 0;

   public ListNode(){}
   public ListNode(int d) {val = d;}
   public ListNode(int[] nums) {
     if(nums == null) return;
     this.val = nums[0];
     for(int i = 1; i < nums.length; i++){
       this.append(nums[i]);
     }
   }

   public void append(int d){
     ListNode end = new ListNode(d);
     ListNode n = this;
     while(n.next != null) {
       n = n.next;
     }
     n.next = end;
   }

   public void append(ListNode node){
     ListNode tail = this;
     while(tail.next != null) tail = tail.next;
     tail.next = node;
   }

   public int getLength() {
     ListNode literator = this;
     int length = 0;
     while(literator != null) {
       length++;
       literator = literator.next;
     }
     return length;
   }

   /**Use fast and slow pointer to get the middle node.
    * for example: [1,2,3] return 2
    * another example: [1,2,3,4] return 3.
    * @param head: The head of a singly linked list.
    * @return The head of second half node. For example: [1,2,3]->2; [1,2,3,4]->3
    */
   ListNode getMiddleNode(ListNode head) {
     ListNode fast = head, slow = head;
     while (fast != null && fast.next != null) {
       slow = slow.next;
       fast = fast.next.next;
     }
     return slow;
   }

   // reverse the list
   ListNode reverse(ListNode head) {
     ListNode pre = null, cur = head, nxt = null;
     while (cur != null) {
       nxt = cur.next;
       cur.next = pre;
       pre = cur;
       cur = nxt;
     }
     return pre;
   }

   //todo
   public void removeHead() {
     if(this == null || this.next==null) return ;
     // cannot move remove head if there is only one node

     ListNode node = this;

     do{
       node.val = node.next.val;
       node = node.next;
     }while(node.next != null);
     node = null;
   }

   //todo
   public void removeTail() {
     ListNode node = this.next;
     do{
       node = node.next;
     }while(false);
   }

   public boolean isCircling(){
     ListNode slow=this, fast=this;
     while(fast!=null && fast.next!=null){
       slow=slow.next;
       fast=fast.next.next;
       if(fast==slow) break; 
     }

     if(fast==null || fast.next==null) return false;
     else return true;
   }
       
   public String toString(){

     StringBuffer buffer = new StringBuffer("[");
     buffer.append(this.val);

     ListNode node = next;
     while(node != null ) {
       buffer.append("->");
       buffer.append(node.val);
       node = node.next;
     }
     buffer.append("]");

     return buffer.toString();
   }
 }
