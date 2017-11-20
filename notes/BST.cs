using System;

public class Node
{
    public int data { get; set; }
    public Node Left { get; set; }
    public Node Right { get; set; }

    private Node() { }
    public Node(int data)
    {
        this.data = data;

    }

}


public class BST1
{

    public Node root;

    public BST1()
    {
        root = null;
        Initialize();
    }
    private void Initialize()
    {
        root = new Node(8);
        root.Left = new Node(3);
        root.Left.Left = new Node(1);
        root.Left.Right = new Node(6);
        root.Left.Right.Left = new Node(4);
        root.Left.Right.Right = new Node(7);


        root.Right = new Node(10);
        root.Right.Right = new Node(14);
        root.Right.Right.Left = new Node(13);
    }

    public void InOrder()
    {
        InOrder(root);
    }

    private void InOrder(Node node)
    {
        if (node != null)
        {
            InOrder(node.Left);
            Console.WriteLine(node.data);
            InOrder(node.Right);

        }

    }

    public int GetCount()
    {
        return GetCount(root);
    }

    private int GetCount(Node node)
    {

        if (node == null)
            return 0;

        return 1 + GetCount(node.Left) + GetCount(node.Right);
    }

    private void StoreValuesInArr(Node node, int[] arr, ref int ptr)
    {

        if (node == null)
            return;
        StoreValuesInArr(node.Left, arr, ref ptr);

        arr[ptr] = node.data;
        ptr++;

        StoreValuesInArr(node.Right, arr, ref ptr);

    }

    private void ArrToTree(Node node, int[] arr, ref int ptr)
    {
        if (node != null)
        {
            ArrToTree(node.Left, arr, ref ptr);

            node.data = arr[ptr];
            ptr++;

            ArrToTree(node.Right, arr, ref ptr);

        }

    }

    public void ConvertBinartTreeToBST()
    {

        if (root == null)
            return;
        int count = GetCount();
        int[] arr = new int[count];
        int ptr = 0;
        StoreValuesInArr(root, arr, ref ptr);

        Array.Sort(arr);

        ptr = 0;
        ArrToTree(root, arr, ref ptr);

    }

    public Node Ceiling(int key)
    {

        return Ceiling(root, key);

    }

    private Node Ceiling(Node node, int key)
    {

        if (node == null)
            return null;
        if (node.data == key)
            return node;

        else if (node.data < key)
            return Ceiling(node.Right, key);
        else
            return Ceiling(node.Left, key);

    }

    public void FindPairSumEqualX(int x)
    {
        if (root == null || (root.Left == null && root.Right == null))
            return;

        int count = GetCount();

        int[] arr = new int[count];
        int ptr = 0;
        StoreValuesInArr(root, arr, ref ptr);

        int start = 0;
        int end = arr.Length - 1;

        while (start < end)
        {
            if (arr[start] + arr[end] == x)
            {
                Console.WriteLine("Found Pair " + arr[start] + "," + arr[end]);
                return;
            }
            else if (arr[start] + arr[end] < x)
            {
                start++;

            }
            else
                end--;
        }

        Console.WriteLine("No Pair");

    }


    private int[] MergeArrays(int[] arr1, int[] arr2)
    {

        int[] merged = new int[arr1.Length + arr2.Length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.Length && j < arr2.Length)
        {

            if (arr1[i] < arr2[j])
            {

                merged[k] = arr1[i];
                k++; i++;
            }
            else
            {
                merged[k] = arr2[j];
                k++; j++;
            }
        }
        while (i < arr1.Length)
        {
            merged[k] = arr1[i];
            k++; i++;
        }

        while (j < arr2.Length)
        {
            merged[k] = arr2[j];
            k++; j++;
        }
        return merged;

    }

    public void MergeBST(Node node1, Node node2)
    {
        int ptr = 0;
        int count1 = GetCount(node1);
        int count2 = GetCount(node2);
        int[] arr1 = new int[count1];
        int[] arr2 = new int[count2];
        StoreValuesInArr(node1, arr1, ref ptr);
        ptr = 0;
        StoreValuesInArr(node2, arr2, ref ptr);

        int[] merged = MergeArrays(arr1, arr2);

        ptr = 0;
        Node mergedNode = ConvertSortedArrayToBST(merged, 0, merged.Length - 1);

    }

    private BST1 ConvertSortedArrayToBST(int[] arr)
    {
        BST1 tree = new BST1();
        tree.root = ConvertSortedArrayToBST(arr, 0, arr.Length - 1);
        return tree;

    }

    private Node ConvertSortedArrayToBST(int[] arr, int start, int end)
    {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.Left = ConvertSortedArrayToBST(arr, start, mid - 1);
        node.Right = ConvertSortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    public void ReverseInOrder()
    {
        ReverseInOrder(root);
    }

    private void ReverseInOrder(Node node)
    {
        if (node != null)
        {
            ReverseInOrder(node.Right);
            Console.WriteLine(node.data);
            ReverseInOrder(node.Left);

        }

    }

    public void FindKThLargest(int k)
    {
        int count = 0;
        FindKThLargest(root, ref count, k);
    }

    private void FindKThLargest(Node node, ref int count, int k)
    {
        if (node != null)
        {
            if (count > k)
                return;

            FindKThLargest(node.Right, ref count, k);
            count++;
            if (count == k)
            {
                Console.WriteLine("Kth Largest = " + node.data);
                return;
            }

            FindKThLargest(node.Left, ref count, k);
        }

    }

    public int FindSmallest()
    {
        return FindSmallest(root);
    }

    private int FindSmallest(Node node)
    {
        if (node == null)
            return int.MinValue;
        Node current = node;
        while (current.Left != null)
            current = current.Left;
        return current.data;

    }

    public int FindLargest()
    {
        return FindLargest(root);
    }

    private int FindLargest(Node node)
    {
        if (node == null)
            return int.MaxValue;
        Node current = node;
        while (current.Right != null)
            current = current.Right;
        return current.data;

    }

    public int PrintNodesInRange(int low, int high)
    {

        int counter = 0;
        PrintNodesInRange(root, low, high, ref counter);
        return counter;
    }

    private void PrintNodesInRange(Node node, int low, int high, ref int counter)
    {

        if (node != null)
        {
            if (node.data > high)
                return;
            PrintNodesInRange(node.Left, low, high, ref counter);
            if (node.data >= low && node.data <= high)
            {
                counter++;
                Console.Write(node.data + ",");
            }
            PrintNodesInRange(node.Right, low, high, ref counter);
        }
    }

    public void Insert(int data)
    {
        Node add = new Node(data);

        if (root == null)
        {
            root = add;
            return;
        }

        Node parent = null;
        Node current = root;

        while (current != null)
        {
            parent = current;
            if (current.data > data)
                current = current.Left;
            else
                current = current.Right;
        }
        if (parent.data > data)
            parent.Left = add;
        else
            parent.Right = add;

    }

    public int PrintNodesInRange1(int low, int high)
    {

        return PrintNodesInRange1(root, low, high);

    }

    private int PrintNodesInRange1(Node node, int low, int high)
    {

        if (node == null)
            return 0;

        if (node.data <= high && node.data >= low)
        {
            Console.Write(node.data + ",");
            return 1 + PrintNodesInRange1(node.Left, low, high) +
                        PrintNodesInRange1(node.Right, low, high);
        }


        else if (node.data < low)
            return PrintNodesInRange1(node.Right, low, high);
        else
            return PrintNodesInRange1(node.Left, low, high);

    }
}