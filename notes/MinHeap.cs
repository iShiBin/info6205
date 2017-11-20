
using System;

public class BinaryMinHeap {
      private int[] data;
      private int heapSize;
 
      public BinaryMinHeap(int size) {
            data = new int[size];
            heapSize = 0;
      }
 
      public int getMinimum() {
            if (isEmpty())
                  throw new Exception("Heap is empty");
            else
                  return data[0];
      }
 
      public bool isEmpty() {
            return (heapSize == 0);
      }

       private int getLeftChildIndex(int nodeIndex) {
            return 2 * nodeIndex + 1;
      }
 
      private int getRightChildIndex(int nodeIndex) {
            return 2 * nodeIndex + 2;
      }
 
      private int getParentIndex(int nodeIndex) {
            return (nodeIndex - 1) / 2;
      }

      public void insert(int value) {
            if (heapSize == data.Length)
                  throw new Exception("Heap's underlying storage is overflow");
            else {
                  heapSize++;
                  data[heapSize - 1] = value;
                  siftUp(heapSize - 1);
            }
      } 

      private void siftUp(int nodeIndex) {
            int parentIndex, tmp;
            if (nodeIndex != 0) {
                  parentIndex = getParentIndex(nodeIndex);
                  if (data[parentIndex] > data[nodeIndex]) {
                        tmp = data[parentIndex];
                        data[parentIndex] = data[nodeIndex];
                        data[nodeIndex] = tmp;
                        siftUp(parentIndex);
                  }
            }
      }  


      public void removeMin() {
            if (isEmpty())
                  throw new Exception("Heap is empty");
            else {
                  data[0] = data[heapSize - 1];
                  heapSize--;
                  if (heapSize > 0)
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