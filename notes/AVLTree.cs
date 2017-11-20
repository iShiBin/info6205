using System;

class Node {
    public int data { get; set; }
    public Node Left { get; set; }
    public Node Right { get; set; }
    public int height { get; set; }

    private Node(){}

    public Node(int data){
        this.data = data;
        this.height = 1;
    }
}

class AVLTree{
    private Node root;
    public AVLTree(){}

    private int Height(Node node){
        if(node == null)
            return 0;
        return node.height;
    }

    private Node RotateRight(Node z){

        Node y = z.Left;
        Node x = y.Right;

        // Rotate right
        z.Left = y.Right;
        y.Right = z;

        z.height = Math.Max(Height(z.Left), Height(z.Right) ) + 1;
        y.height = Math.Max(Height(y.Left), Height(y.Right) ) + 1;

        return y;

    }

    private Node RotateLeft(Node z){

        Node y = z.Right;

        z.Right = y.Left;
        y.Left = z;

        z.height = Math.Max(Height(z.Left), Height(z.Right) ) + 1;
        y.height = Math.Max(Height(y.Left), Height(y.Right) ) + 1;

        return y;

    }

    private int GetDiff(Node node){
        if(node == null)
            return 0;
        return Height(node.Right) - Height(node.Left);

    }

    public void Insert(int data){
        root = Insert(root, data);
    }

    private Node Insert(Node node, int data){

        if(node == null)
            return new Node(data);
        
        if(data < node.data)
            node.Left = Insert(node.Left, data);
        else
            node.Right = Insert(node.Right, data);

        node.height = 1 + Math.Max(Height(node.Left) , Height(node.Right));

        int balance = GetDiff(node);

        // Left Left
        if(balance <-1 && node.data > data)
            return RotateRight(node);

        // Left Right
        if(balance < -1 && node.data < data)
        {
            node.Left = RotateLeft(node.Left);
            return RotateRight(node);

        }

        // right right
        if(balance > 1 && node.data < data){

            return RotateLeft(node);
        }

        // right Left

        if(balance > 1 && node.data > data){

            node.Right = RotateRight(node.Right);
            return RotateLeft(node);
        }

        return node;
    }

}