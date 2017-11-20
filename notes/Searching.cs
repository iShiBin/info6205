using System;

namespace ConsoleApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {

            int[] arr = {2, 11, 5, 1, 4, 7};
            FindPairSumEqualRest(arr);
            Console.WriteLine("Hello World!");
        }

        static bool BinarySearch(int[] arr, int x){
            int low = 0;
            int high = arr.Length -1;

            while(low <= high){

                int mid = low/2 + high/2;
                if(arr[mid] == x){
                    Console.WriteLine("Found");
                    return true;
                }
                else if(arr[mid] < x){

                    low = mid +1;
                }else{

                    high = mid -1;
                }
            }
            return false;
        }


        static bool BinSearchRecursive(int[] arr, int x){

            return BinSearchRecursive(arr, x, 0, arr.Length -1);
        }

        static bool BinSearchRecursive(int[] arr, int x, int low, int high){
            if(low > high)
                return false;
            int mid = (low + high)/2;

            if( arr[mid] == x)
                return true;
            else if(arr[mid] < x)
                return BinSearchRecursive(arr, x, mid +1, high);
            else
                return BinSearchRecursive(arr, x, low, mid-1);

        }

        static void Swap(int[] arr, int start, int end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        static void Reverse(int[] arr){

            int start = 0 ; int end = arr.Length-1;

            while(start <= end){
                Swap(arr, start, end);
                start ++;
                end--;
            }
        }

        static void Reverse(int[] arr, int start, int end){
            while(start <= end){
                Swap(arr, start, end);
                start ++;
                end--;
            }
        }

        static void Rotate(int[] arr, int x){

            x = x% arr.Length;

            Reverse(arr);

            Reverse(arr, 0, x-1);
            Reverse(arr, x, arr.Length -1);
        }


        static int GetOccurances(int[] arr, int x){

            return GetOccurances( arr, x, 0, arr.Length -1);
        }

        static int GetOccurances(int[] arr, int x, int start, int end){

            if( arr[start] > x)
                return 0;
            if(arr[end] < x)
                return 0;
            if(arr[start] == x && arr[end] ==x)
                return end-start +1;
            int mid = (start + end)/2;

            if(arr[mid] == x)
                return (    1 + 
                            GetOccurances(arr, x, start, mid-1) + 
                            GetOccurances(arr, x, mid+1, end)
                        );
            else if( arr[mid] < x )
                return GetOccurances(arr, x, mid+1, end);
            else
                return GetOccurances(arr, x, start, mid-1);
        }

         static int FindFirstOccurance(int[] arr, int x){

            return FindFirstOccurance( arr, x, 0, arr.Length -1);
        }

        static int FindFirstOccurance(int[] arr, int x, int start, int end){
             
             if( arr[start] > x)
                return -1;
            if(arr[end] < x)
                return -1;

            if(arr[start] == x)
                return start;
            
            int mid = (start + end)/2;

            if(arr[mid] >= x )
                return FindFirstOccurance(arr, x, start, mid -1);
             else
                return FindFirstOccurance(arr, x, mid +1, end);
            
        }


        static int FindFirstBiggerThanK(int[] arr, int k){

            int result = -1;
            int start = 0 ; int end = arr.Length -1; 

            if(arr[ arr.Length -1] < k)
                return -1;

            while(start <= end){
                int mid = (start + end)/2;
                if(arr[mid] > k){
                    result = mid;
                    end = mid -1;
                }
                else
                    start = mid +1;
            }
            return result;

        }


        static int Ceiling(int[] arr, int k){
            if(arr[arr.Length -1] <k)
                return -1;
            int result = -1;
            int start = 0; int end = arr.Length -1;
            while(start <= end){
                int mid = (start + end)/2;

                if(arr[mid] == k)
                    return mid;
                else if( arr[mid] > k){
                    result = mid;
                    end = mid -1;
                }
                else
                    start = mid +1;
            }

            return result;

        }

        static int Floor(int[] arr, int k){
            if(arr[0] > k)
                return -1;
            int result = -1;
            int start = 0; int end = arr.Length -1;
            while(start <= end){
                int mid = (start + end)/2;

                if(arr[mid] == k)
                    return mid;
                else if( arr[mid] < k){
                    result = mid;
                    start = mid +1;
                }
                else
                    end = mid -1;
            }

            return result;

        }


        static int FindPeak(int[] arr){

            return FindPeak(arr, 0, arr.Length -1);
        }

        static int FindPeak(int[] arr, int low, int high){
            if(low > high)
                return -1;
            int mid = (low + high)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return mid;
            if(arr[mid] < arr[mid+1])
               return FindPeak(arr, mid+1, high );
            else if (arr[mid] > arr[mid+1])
               return FindPeak(arr, low, mid );

            return -1;
           

        }

        static void SortArrayWaveForm(int[] arr){
            Array.Sort(arr);

            for(int i = 0 ; i < arr.Length -1; i = i +2){

                Swap(arr, i ,i +1);
            }

        }

        static void SortArrayWaveFormLinear(int[] arr){

            for(int i = 0 ; i < arr.Length; i = i +2){
                if(i >0 && arr[i-1] > arr[i]){

                    Swap( arr, i-1, i);
                }

                if( i < arr.Length -1 && arr[i] < arr[i +1])
                {

                    Swap(arr, i, i +1);
                }

            }
        }

        static void FindSumEqualToX(int[] arr, int x){
            Array.Sort(arr);

            int start = 0; 
            int end = arr.Length -1;

            while(start < end){
                if(arr[start] + arr[end] == x){
                    Console.WriteLine("Found");
                    return;
                }
                else if (arr[start] + arr[end] < x) 
                    start ++;
                else
                    end --;

            }

        }


        static void FindSumClosestToX(int[] arr, int x){
            Array.Sort(arr);

            int start = 0; 
            int end = arr.Length -1;
            int finalLeft = 0;
            int finalRight = arr.Length -1;
            int sum = int.MaxValue;

            while(start < end){

                int diff = Math.Abs(arr[start] + arr[end] - x);
                if(diff < sum){
                    finalLeft = start;
                    finalRight = end;
                    sum = diff;
                }
                    
                if(diff == 0){
                    Console.WriteLine("Start = " + start + " end =" + end);
                    return;
                }
                else if (arr[start] + arr[end] < x) {
                    start ++;
                }
                    
                else{
                     end --;
                }
             

            }

            Console.WriteLine("Sum = " + sum);
            Console.WriteLine("Start = " + finalLeft + " end =" + finalRight);

        }

        static void FindPairSumEqualRest(int[] arr){

            Array.Sort(arr);
            int sum = 0; 

            for(int i = 0 ; i < arr.Length; i ++)
                sum+= arr[i];
            
            sum = sum/2;

            int start =0;
            int end = arr.Length-1;

            while(start < end){

                if(arr[start] + arr[end] == sum){
                    Console.WriteLine("Found");
                    return ;
                }
                else if(arr[start] + arr[end] < sum)
                    start ++;
                else
                    end --;

            }


        }

       

    }
}
