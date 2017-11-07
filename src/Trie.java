import java.util.*;

class TrieNode{
  char value;
  boolean isTerminal=false;
  List<TrieNode> children;
  
  TrieNode(char c){
    this.value=c;
    this.children=new ArrayList<>();
  }
}

class Trie {
  TrieNode root;
  
  void insert(String str){
    char[] arr=str.toCharArray();
    TrieNode curr=root;
    for(int i=0;i<arr.length;i++){
      TrieNode child=findChild(curr, arr[i]);
      
      if(child==null){
        child=new TrieNode(arr[i]);
        curr.children.add(child);
      }
      
      curr = child;
      if(i==arr.length-1) curr.isTerminal=true;
    }
  }
  
  private TrieNode findChild(TrieNode node, char ch){
    for(int i=0;i<node.children.size();i++){
      if(ch==node.children.get(i).value){
        return node.children.get(i);
      }
    }
    
    return null;
  }
  
  void createSuffixTrie(String str){
    str+="$";
    
    for(int i=0;i<str.length();i++){
      String sub=str.substring(str.length()-1-i, str.length());
      this.insert(sub);
      //homework: find whether there is a substring; the number of times; and the longest substring
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
