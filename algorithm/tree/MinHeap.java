package tree;
/**
 * class notes of 1026
 */
import java.util.*;

public class MinHeap{
  private static final int INITIAL_SIZE=16;
  private static final int RATE=2;
  private int[] data=new int[INITIAL_SIZE]; // default;
  private int heapSize=0;
  
  public MinHeap(){ }
  
  public MinHeap(int[] values){    
    for(int i:values){
      this.insert(i);
    }
  }
  
  public int getSize(){
    return heapSize;
  }
  
  public boolean isEmpty(){
    return this.heapSize==0;
  }
  
  /**
   * tells whether the heap is a min heap
   * @return true: if it is a min heap; otherwise, return false
   */
  public boolean isValid(){
    return isValid(0);
  }
  
  private boolean isValid(int index){
    if(index<heapSize){
      int left = getLeftChildIndex(index);
      int right = getRightChildIndex(index);
      
      return (left >= heapSize || data[index]<=data[left]) && (right >= heapSize || data[index]<=data[right]) &&
          isValid(left) && isValid(right);
      
    }
    return true;
  }
  
  /**
   * @param index
   * @return left child's index or -1 if no left child
   */
  private int getLeftChildIndex(int index){
    return 2*index + 1;
  }
  
  /**
   * 
   * @param index
   * @return index of right child or -1 if it does not have one
   */
  private int getRightChildIndex(int index){
    return 2*index + 2;
  }
  
  private int getParent(int index){
    return (index-1)/2;
  }
  
  public void insert(int value){
    if(this.heapSize==data.length) {
      data=Arrays.copyOf(data, RATE*data.length);
      System.out.println("expaned since heap is full");
    }
    
    this.data[heapSize] = value;
    siftUp(this.heapSize);
    this.heapSize++;
  }
  
  private void siftUp(int index){
    if(index!=0){
      int parentIndex=getParent(index);
      if(this.data[parentIndex] > data[index]) {
        
        //swap
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
  
  public void removeMin(){
    if(this.isEmpty()) throw new RuntimeException("hey, you cannot remove an empty heap");
    
    this.data[0] = data[this.heapSize-1];
    this.heapSize--;
    if(this.heapSize>0){
      siftDown(0);
    }
  }
  
  private void siftDown(int nodeIndex) {
    int leftChildIndex, rightChildIndex, minIndex, tmp;
    leftChildIndex = getLeftChildIndex(nodeIndex);
    rightChildIndex = getRightChildIndex(nodeIndex);
    if (rightChildIndex >= heapSize) {
      if (leftChildIndex >= heapSize)
        return;
      else
        minIndex = leftChildIndex;
    } else {
      if (data[leftChildIndex] <= data[rightChildIndex])
        minIndex = leftChildIndex;
      else
        minIndex = rightChildIndex;
    }
    if (data[nodeIndex] > data[minIndex]) {
      tmp = data[minIndex];
      data[minIndex] = data[nodeIndex];
      data[nodeIndex] = tmp;
      siftDown(minIndex);
    }
  }
}