using System;
using System.Collections.Generic;

class Node
{

    public int data { get; set; }
    public Node Left { get; set; }

    public Node Right { get; set; }
    public Node Parent { get; set; }
    private Node() { }

    public Node(int data)
    {
        this.data = data;
    }

}
class Tree{

    public Node root;

    public Node Parent;

    public Node test;

    public Node test1;
    public Tree(){
        CreateTree();
    }

    #region Done

    private void CreateTree(){

        Node node = new Node(1);
        root = node;

        root.Left = new Node(2);
        root.Right = new Node(3);

        root.Left.Left = new Node(4);
        root.Left.Right = new Node(5);

        test = root.Left.Right;
        
        root.Left.Left.Left = new Node(8);
        root.Left.Left.Right = new Node(9);

        root.Left.Right.Right = new Node(10);
        test1 = root.Left.Right.Right;

        root.Right.Left = new Node(6);

        root.Right.Right = new Node(7);
        root.Right.Right.Right = new Node(11);

    }


    public void PrintTopView(){

        Dictionary<int, int> hashTable = new Dictionary<int, int> ();
        PrintTopView(root, 0, hashTable);
        
        Console.WriteLine();
    }

    private void PrintTopView(Node node, int key, Dictionary<int, int> hashTable){
        if(node != null){
            if(!hashTable.ContainsKey(key))
                hashTable.Add(key, node.data);
            Console.Write(node.data + ",");
            PrintTopView(node.Left, key -1, hashTable);
            PrintTopView(node.Right, key +1, hashTable);
        }
    }


    public void PreOrder(){
        PreOrder(root);
        Console.WriteLine();
    }

    private void PreOrder(Node node){
        if(node != null){
            Console.Write(node.data + ",");
            PreOrder(node.Left);
            PreOrder(node.Right);
        }
    }

    public void InOrder(){
        InOrder(root);
        Console.WriteLine();
    }

    private void InOrder(Node node){
        if(node != null){
            InOrder(node.Left);
            Console.Write(node.data + ",");
            InOrder(node.Right);
        }
    }

        public void PostOrder(){
        PostOrder(root);
        Console.WriteLine();
    }

    private void PostOrder(Node node){
        if(node != null){
            PostOrder(node.Left);
            PostOrder(node.Right);
            Console.Write(node.data + ",");
        }
    }

    public int GetSize(){

        return GetSize(root);
    }

    private int GetSize(Node node){

        if(node == null)
            return 0;
        
        return  1 + GetSize(node.Left) + GetSize(node.Right);
    }

    public int GetHeight(){
        return GetHeight(root);
    }

    private int GetHeight(Node node){

        if(node == null)
            return 0;
        
        int lHeight = GetHeight(node.Left);
        int rHeight = GetHeight(node.Right);

        return 1 + Math.Max(lHeight, rHeight);

    }


    public void PrintRightView(){

        if(root == null)
            return;
        Queue<Node> queue = new Queue<Node>();
        queue.Enqueue(root);
        queue.Enqueue(null);
        int lastVal = root.data;
        while(queue.Count != 0){

            Node node = queue.Dequeue();

            if(node != null){
                lastVal = node.data;
                //Console.Write(node.data + ",");
                if(node.Left != null)
                    queue.Enqueue(node.Left);
                if(node.Right != null)
                    queue.Enqueue(node.Right);
            }
            else{
                Console.WriteLine(lastVal + ",");
                Console.WriteLine();
                if(queue.Count == 0)
                    break;
                
                queue.Enqueue(null);
            }
        }
        
    }


     public void PrintLeftView(){

        if(root == null)
            return;
        Queue<Node> queue = new Queue<Node>();
        queue.Enqueue(root);
        queue.Enqueue(null);
        bool printed = false;
        while(queue.Count != 0){

            Node node = queue.Dequeue();

            if(node != null){
                if(!printed){
                    Console.Write(node.data + ",");
                    printed = !printed;
                }
                if(node.Left != null)
                    queue.Enqueue(node.Left);
                if(node.Right != null)
                    queue.Enqueue(node.Right);
            }
            else{
                Console.WriteLine();
                if(queue.Count == 0)
                    break;
                printed = !printed;
                queue.Enqueue(null);
            }
        }
        
    }


    public void PrintLevelOrder(){

        if(root == null)
            return;
        Queue<Node> queue = new Queue<Node>();
        queue.Enqueue(root);
        queue.Enqueue(null);

        while(queue.Count != 0){

            Node node = queue.Dequeue();

            if(node != null){

                Console.Write(node.data + ",");
                if(node.Left != null)
                    queue.Enqueue(node.Left);
                if(node.Right != null)
                    queue.Enqueue(node.Right);
            }
            else{

                Console.WriteLine();
                if(queue.Count == 0)
                    break;
                
                queue.Enqueue(null);
            }
        }
        
    }

    public void PrintPerimeter(){
        if(root == null)
            return;
        Console.Write(root.data + ",");
        PrintPerimeter(root, 0,0);
        Console.WriteLine();
    }

    public void PrintLeftNodes(){
        
        if(root == null)
            return;
        Node node = root;
        while(node != null){
            Console.Write(node.data + ",");
            node = node.Left;
        }

        Console.WriteLine();

    }


    public void PrintRightNodes(){
        
        if(root == null)
            return;
        Node node = root;
        while(node != null){
            Console.Write(node.data + ",");
            node = node.Right;
        }

        Console.WriteLine();

    }

    public void PrintPerimeter2(){

        PrintLeftNodes();
        PrintAllLeaves();
        PrintRightNodes();
    }
    private void PrintPerimeter(Node node, int left, int right){
        if(node != null){

            if(right == 0  && left != 0){
                Console.Write(node.data + ",");
            }
            else if( left == 0 && right != 0){
                 Console.Write(node.data + ",");
            }
            else if(node.Left == null && node.Right == null){
                 Console.Write(node.data + ",");
            }

            PrintPerimeter(node.Left , left + 1, right);

            PrintPerimeter(node.Right ,left, right +1);
        }

    }


    public void PrintAllLeaves(){

        PrintAllLeaves(root);
        Console.WriteLine();
    }

    private void PrintAllLeaves(Node node){
        if(node != null){
            PrintAllLeaves(node.Left);
            PrintAllLeaves(node.Right);

            if(node.Left == null && node.Right == null)
                Console.Write(node.data + ",");

        }

    }

    public void PrintZigZag(){
        if(root == null)
            return;
        Queue<Node> queue = new Queue<Node>();
        queue.Enqueue(root);
        queue.Enqueue(null);

        bool print = true;

        Stack<Node> stack = new Stack<Node>();

        while(queue.Count != 0){

            Node node = queue.Dequeue();

            if(node != null){

                if(print)
                    Console.Write(node.data + ",");
                else
                    stack.Push(node);
                if(node.Left != null)
                    queue.Enqueue(node.Left);
                if(node.Right != null)
                    queue.Enqueue(node.Right);
            }
            else{

                
                if(queue.Count == 0)
                    break;
                
                queue.Enqueue(null);

                print = !print;

                while(stack.Count!= 0){
                    Console.Write(stack.Pop().data + ",");
                }
                Console.WriteLine();
                    
            }
        }

        while(stack.Count!= 0){
            Console.Write(stack.Pop().data + ",");
        }
        Console.WriteLine();
    }
    #endregion

    public void PrintNodesKDistance(Node node, int k){

        if(node == null)
            return;
        if(0 == k){
            Console.WriteLine(node.data);
            return;
        }

        PrintNodesKDistance(node.Left, k-1);
        PrintNodesKDistance(node.Right, k-1);
    }

    public bool AreSiblings(Node node, Node a, Node b){

        if(node == null)
            return false;
        
        return (    node.Left == a && node.Right == b ||
                    node.Left == b && node.Right == a ||
                    AreSiblings(node.Left , a, b) ||
                    AreSiblings(node.Right , a, b) 
        
                );
    }



    public bool Isomorphic(Node node1, Node node2){

        if(node1 == null && node2 == null)
            return true;
        
        if(node1 == null || node2 == null)
            return false;
        
        return Isomorphic(node1.Left , node2.Left) &&
                Isomorphic(node1.Right , node2.Right);

    }


     public bool SameTree(Node node1, Node node2){

        if(node1 == null && node2 == null)
            return true;
        
        if(node1 == null || node2 == null)
            return false;
        
        return  node1.data == node2.data &&
                SameTree(node1.Left , node2.Left) &&
                SameTree(node1.Right , node2.Right);

    }


    public bool HasPathSum(int sum){

        return HasPathSum(root, sum);

    }
    
    public bool HasPathSum(Node node,  int sum){

        if(node == null){
            return sum == 0;
        }

        bool ans = false;
        int subSum = sum - node.data;

        if(subSum == 0 && node.Left == null && node.Right == null){
            // Print Path
            return true;
        }
            

        if(node.Left != null)
            ans = ans || HasPathSum(node.Left, subSum);
        
        if(node.Right != null)
            ans = ans || HasPathSum(node.Right, subSum);
        
        return ans;
    }

    public void PrintAllPaths(){
        int[] path = new int[1000];
        PrintAllPaths(root, path, 0);

    }

    private void PrintAllPaths(Node node, int[] path, int ptr ){
        if(node == null)
            return;
        path[ptr] = node.data;
        ptr ++;

        if(node.Left == null && node.Right == null){
            PrintPath(path, ptr);
        }
        else{
            PrintAllPaths(node.Left, path, ptr);
            PrintAllPaths(node.Right, path, ptr);

        }

    }

    private void PrintPath(int[] path, int ptr){

        for(int i = 0 ; i < ptr; i ++){

            Console.Write(path[i] + ",");
        }
        Console.WriteLine();
    }


    public int Level(Node node, Node ptr, int level){
        if(node == null)
            return 0;

        if(node == ptr)
            return level;
        
        int left = Level(node.Left , ptr, level +1);
        if(left != 0)
            return left;
        
        return Level(node.Right, ptr, level +1);

    }

    public bool AreCousins(Node a, Node b){
        return AreCousins(root, a, b);

    }

    private bool AreCousins( Node node, Node a, Node b){

        if( 
                !AreSiblings(node, a, b) &&
                AreSiblings(node, a.Parent, b.Parent)
        )
            return true;
        else
            return false;
    }

    public Node LCA(Node A, Node B){

        if(A == B)
            return A;
        HashSet<Node> set = new HashSet<Node>();
        set.Add(A);
        set.Add(B);

        Node currA = A;
        Node currB = B;

        while(currA.Parent != null || currB.Parent != null){

            if(set.Contains(currA.Parent))
                return currA.Parent;
            if(set.Contains(currB.Parent))
                return currB.Parent;
            
            set.Add(currA.Parent);
            set.Add(currB.Parent);

            currA = currA.Parent;
            currB = currB.Parent;
        }

        return null;
    }

    public bool IsChildSum(){

        return IsChildSum(root);
    }

    private bool IsChildSum(Node node){
        if(node == null || (node.Left == null && node.Right == null) )
            return true;
        int left = 0;
        int right = 0;

        if(node.Left != null)
            left = node.Left.data;
         if(node.Right != null)
            left = node.Right.data;

        if( node.data == left + right &&
            IsChildSum(node.Left) &&
            IsChildSum(node.Right)
        
          )
            return true;
        
        else
            return false;
    }

    public void PrintAtLevel(int level){
        PrintAtLevel(root, level);
        Console.WriteLine();
    }

    void PrintAtLevel(Node node, int level){
        if(node == null)
            return;
        if(level == 1)
            Console.Write(node.data + " ");
        else
        {
            PrintAtLevel(node.Left , level -1);
            PrintAtLevel(node.Right , level -1);
        }
    }

    public bool AreAllLeavesAtSameLevel(){
        int maxLevel = 0;
        return AreAllLeavesAtSameLevel(root, ref maxLevel, 1);

    }

    private bool AreAllLeavesAtSameLevel(Node node, ref int maxLevel, int level){

        if(node == null)
            return true;
        
        if(node.Left == null && node.Right == null){
            if(maxLevel == 0){
                maxLevel = level;
            }else{
                if(level != maxLevel)
                    return false;
                else
                    return true;

            }

        }

        return  AreAllLeavesAtSameLevel(node.Left, ref maxLevel, level +1) &&
                AreAllLeavesAtSameLevel(node.Right, ref maxLevel, level +1);


    }

    public void GetmaxLeafSum(){
        int maxSum = 0;
        Node leafNode = null;

        GetmaxLeafSum(root, ref maxSum, 0, ref leafNode);

        Console.WriteLine();


    }


    public void GetmaxLeafSum(Node node, ref int maxSum, int currentSum, ref Node leafNode){

        if(node == null)
            return;
    
        // Update current sum
        currentSum += node.data;
        // check if this is leaf node
        if(node.Left == null && node.Right == null){

            if(currentSum > maxSum){
                maxSum = currentSum ;
                leafNode = node;
            }
        }

        GetmaxLeafSum(node.Left, ref maxSum, currentSum, ref leafNode);
        GetmaxLeafSum(node.Right, ref maxSum, currentSum, ref leafNode);
        
    }

}