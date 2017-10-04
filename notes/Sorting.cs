using System;

namespace ConsoleApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] arr = {6,5,3,1,8,7,2,4};
            int thirdSmallest = FindThirdSmallest(arr, 0, arr.Length -1);
            Console.WriteLine();
        }
        static void Swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        static void BubbleSort(int[] arr){

            for(int i = 0 ; i < arr.Length-1; i ++){

                for (int j = i + 1; j < arr.Length ; j ++){
                    if( arr[i] > arr[j]){
                        Swap(arr, i, j);
                    }
                }
            }
        }

        static void SelectionSort(int[] arr){
            int minIndex = 0;
            for(int i = 0 ; i < arr.Length ; i ++){

                minIndex = i;
                for(int j = i +1; j < arr.Length; j ++){
                    if(arr[j]< arr[minIndex])
                        minIndex = j;
                }
                if( i < minIndex){
                    Swap(arr, i, minIndex);
                }
            }


        }

        static void InsertionSort(int[] arr){
            int inner, temp;
            for(int outer = 1; outer < arr.Length; outer ++){
                temp = arr[outer];
                inner = outer;

                while(inner > 0 && arr[inner-1] >= temp){

                    arr[inner] = arr[inner -1];
                    inner -= 1;
                }
                arr[inner]= temp;
            }

        }

        static void MergeSort(int[] arr){
            MergeSortAux(arr, 0, arr.Length -1);
        }

        static void MergeSortAux(int[] arr, int low, int high){
            if(low >= high)
                return;
            int mid = (low + high)/2;
            MergeSortAux(arr, low, mid);
            MergeSortAux(arr, mid+1, high);
            Merge(arr, low, high);
        }

        static void Merge(int[] arr, int low, int high){
            int mid = (low + high)/2;

            int[] temp = new int[high - low +1];
            int i = low;
            int j = mid +1;
            int index = 0; 

            while( i <= mid && j <= high){
                if( arr[i] < arr[j]){
                    temp[index] = arr[i];
                    i ++;
                }
                else{
                    temp[index] = arr[j];
                    j ++;
                }
                index ++;
            }

            // left overs
            while(i <= mid)
                temp[index++] = arr[i++];
            while(j <= high)
                temp[index++] = arr[j++];

            i = low;

            for(int k = 0 ; k < temp.Length; k ++)
                arr[i++] = temp[k];
        }

        static void QuickSort(int[] arr, int i , int j){
            if(i < j){
                int pos = Partition(arr, i, j);
                QuickSort(arr, i, pos -1);
                QuickSort(arr, pos +1, j);
            }
        }

        static int Partition(int[] arr, int i, int j){
            int pivot = arr[j];
            int wall = i -1;
            for(int k = i; k < j; k ++){
                if(arr[k] <= pivot){
                    wall ++;
                    Swap(arr, k, wall);
                }
            }
            Swap ( arr, j, wall +1);
            return wall +1;
        }

        static void CountSort(int[] arr){
            int[] count = new int[10];

            for(int i = 0 ; i < arr.Length ; i ++)
                count[arr[i]]++;

                int index = 0; 
                for(int i = 0 ; i < 10; i ++){
                    while(count[i] >0)
                    {
                        arr[index]= i;
                        index ++;
                        count[i] --;
                    }

                }

        }
    }
}
