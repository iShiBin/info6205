using System;

public class Node{
    public int data;
    public Node Next;

    private Node(){}

    public Node(int data){
        this.data = data;
        this.Next = null;
    }
}

public class LinkList{

    public Node head;

    public LinkList(){

        head = null;
    }

    public void AddToHead(int data){

        Node add = new Node(data);
        add.Next = head;
        head = add;

    }

    public void AddToTail(int data){

        Node add = new Node(data);

        if(head == null){
            head = add;
            return;
        }
        Node temp = head;
        while(temp.Next != null)
            temp = temp.Next;
        temp.Next = add;
    }

    public void Reverse(){
        if(head == null || head.Next == null)
            return;
        
        Node back = null;
        Node mid = head;
        Node front = head.Next;

        while(front != null){
            mid.Next = back;
            back = mid;
            mid = front;
            front = front.Next;
        }

        mid.Next = back;
        head = mid;

    }

    public int Length(){
        if(head == null)
            return 0;
        
        Node temp = head;
        int count = 0;

        while(temp != null){
            temp = temp.Next;
            count++;
        }
        return count;
        

    }


    public Node FindNthFromEnd(int n){
        if(head == null || n <=0)
            return null;
        
        Node front = head;
        Node back = head;

        for(int i = 0 ; i < n ; i ++){
            if(front == null)
                return null;
            front = front.Next;
        }

        while(front != null){
            front = front.Next ;
            back = back.Next;
        }

        return back;

    }

    public bool IsCyclic(){
        if(head == null || head.Next == null)
            return false;

        Node front = head.Next.Next;
        Node back = head;
        while(front != null && front != back  ){
            front = front.Next;
            if(front != null){
                front = front.Next;
                back = back.Next;
            }
        }

        if(front == null)
            return false;
        return true;
    }


    public void CreateCycle(int n){
        Node tail = FindTail();
        Node startCycle = FindNthFromEnd(n);

        if(startCycle == null){
            // bad data 
            return ;
        }
        tail.Next = startCycle;

    }
    public Node FindTail(){
        if(head == null)
            return null;
        
        Node temp = head;
        while(temp.Next != null)
            temp = temp.Next;
        return temp;

    }
    public Node FindStartOfCycle(){
        if(head == null || head.Next == null)
            return null;
        Node front = head.Next.Next;
        Node back = head;
        while(front != null && front != back  ){
            front = front.Next.Next;
            back = back.Next;
        }

        if(front == null)
            return null;

        back = head;

        while(back != front){
            back = back.Next;
            front = front.Next;
        }

        return back;
    }

    public Node FindMid(){
        if(head == null)
            return null;
        if(head.Next == null)
            return head;

        Node front = head;
        Node back = head;
        while(front != null){
            front = front.Next;
            if(front != null){
                front = front.Next;
                back = back.Next;
            }
        }
        return back;

    }



}