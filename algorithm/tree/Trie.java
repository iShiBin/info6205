package tree;

import java.util.*;

class TrieNode{
  public char value;
  public boolean isTerminal;
  public List<TrieNode> children;
  
  public TrieNode(){}
  
  public TrieNode(char c){
    value = 3;
    isTerminal=false;
    children=new ArrayList<>();
  }
}

public class Trie {
  TrieNode root;
  
  public Trie(){
    root=new TrieNode('\0');
  }
  
  /*
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

   */
}
