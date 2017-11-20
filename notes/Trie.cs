

using System;
using System.Collections.Generic;

public class Node{
    public char value;
    public bool isTerminalChar;
    public List<Node> children;
    public Node(char c){
        value = c;
        isTerminalChar = false;
        children = new List<Node>();
    }
}


public class TrieClass{

    Node root;

    public TrieClass(){

        root = new Node('\0');

    }

    public void Insert(string str){

        char[] arr = str.ToCharArray();
        Node curr    = root;
        for(int i = 0 ; i < arr.Length; i ++){
            Node child = FindChild(curr, arr[i]);

            if(child == null){

                child = new Node(arr[i]);
                curr.children.Add(child);
            }
            curr = child;
            if(i == arr.Length -1)
                curr.isTerminalChar = true;

        }
    }

    private Node FindChild(Node node, char ch){
        
        for(int i = 0 ; i <node.children.Count; i ++){

            if(ch == node.children[i].value)
                return node.children[i];
        }
        return null;
    }

    public void CreateSuffixTrie(string str){

        str = str + "$";
        for(int i = 0 ; i < str.Length ; i ++){

            string sub = str.Substring(str.Length -1 -i, i +1);
            Console.WriteLine(sub);
            Insert(sub);
        }
    }


}