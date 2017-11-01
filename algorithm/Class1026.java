import java.util.Arrays;

class Minheap{
  private int[] data;
  private int heapSize;
  
  Minheap(int size){
    this.data=new int[size];
    heapSize=0;
  }
  
  int getMin(){
    if(this.isEmpty()) throw new RuntimeException("Heap is empty") ;
    return heapSize;
  }
  
  boolean isEmpty(){
    return this.heapSize==0;
  }
  
  private int getLeftChild(int index){
    return 2*index + 2;
  }
  
  //todo
  private int getRightChild(int index){
    
    return 0;
  }
  
  private int getParent(int index){
    return (index-1)/2;
  }
  
  void insert(int value){
    if(this.heapSize==data.length) throw new RuntimeException("heap is full");
    
    this.heapSize++;
    this.data[heapSize-1] = value;
    siftUp(this.heapSize-1);
  }
  
  private void siftUp(int index){
    int parentIndex, tmp;
    
    if(index!=0){
      parentIndex=getParent(index);
      if(this.data[parentIndex] > data[index]) {
        this.data[parentIndex]= this.data[parentIndex] ^ data[index];
        data[index]=this.data[parentIndex] ^ data[index];
        this.data[parentIndex]= this.data[parentIndex] ^ data[index];
        this.siftUp(parentIndex);
      }
    }
  }
  
  public String toString(){
    return Arrays.toString(this.data);
  }
  
  void removeMin(){
    if(this.isEmpty()) throw new RuntimeException("hey, you cannot remove an empty heap");
    
    this.data[0] = data[this.heapSize-1];
    this.heapSize--;
    if(this.heapSize>0){
      siftDown(0);
    }
  }
  
  
  //todo
  private void siftDown(int index){
    int leftIndex=this.getLeftChild(index);
    int rightIndex=this.getRightChild(index);
    int minIndex;
    
    //understand
    if(rightIndex>=heapSize){
      if(leftIndex >= heapSize)
        return;
      else minIndex=leftIndex;
    }else{
      minIndex=rightIndex;
    }
    
    if(data[index] > data[minIndex]){
      data[index] = data[index] ^ data[minIndex];
      data[minIndex] = data[index] ^ data[minIndex];
      data[index] = data[index] ^ data[minIndex];
    }
    
    //todo something here
  }
}

public class Class1026 {

  public static void main(String[] args){
    Minheap heap = new Minheap(20);
    int[] values={6,3,5,1,9,8};
    
    for(int v:values){
      heap.insert(v);
    }
    
    System.out.println(heap);
    
    heap.insert(-2);
    System.out.println(heap);
    
    heap.removeMin();
    System.out.println(heap);
    
    //todo: write maxheap by myself
    
  }
  //max/min heap
  
}

// trie
