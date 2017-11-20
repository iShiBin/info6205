using System;
using System.Collections.Generic;

namespace Dynamic
{
    class Program
    {
        static void Main(string[] args)
        {
            //int[] arr = {1,11,2,10, 4, 5, 2, 1};
            int[] arr = {1,3,5,8,9,2,6,7};
            int test = JumpsNeeded(arr);
           // int test = BitTonic(arr);

            Console.WriteLine(FindFibTabular(5));
            Console.WriteLine();
        }

        static int FindFib(int n){

            if(n <=1)
                return n;

            return FindFib (n-1) + FindFib(n-2);

        }
        static int FindFibTabular(int n){

            if(n <=1)
                return n;
            int[] arr = new int[n+1];
            arr[0] = 0;
            arr[1] = 1;

            for(int i = 2 ; i < arr.Length ; i ++ ){
                arr[i] = arr[i-1] + arr[i-2];

            }

            return arr[n];

        }

        static int FindFibMemoization(int n){
            Dictionary<int, int> dict = new Dictionary<int, int>();
            return FindFibMemoization(n, dict);

        }

        static int FindFibMemoization(int n, Dictionary<int, int> dict){

            if(!dict.ContainsKey(n)){
                if(n <= 1)
                    return n;
                int first = FindFibMemoization(n-1, dict);
                int second = FindFibMemoization(n-2, dict);

                dict.Add(n, first + second);

            }
            return dict[n];
        }

        static int LongestIncreasingSubSequence(int[] arr){

            int[] lis = new int[arr.Length];

            for(int i = 0 ; i < arr.Length ; i ++)
                lis[i] = 1;

            int max = int.MinValue;

            for(int i = 0 ; i < arr.Length ; i ++){

                for(int j = 0 ; j < i; j ++){

                    if(arr[i] >arr[j] && lis[i] < lis[j] +1){

                        lis[i] = lis[j] +1;
                        if(max < lis[i])
                            max = lis[i];
                    }
                }
            }
            return max;
        }


        static int BitTonic(int[] arr){

            int[] lis = new int[arr.Length];
            int[] lds = new int[arr.Length];
            for(int i = 0 ; i < arr.Length ; i ++){
                lis[i] = 1;
                lds[i] =1;
            }


            for(int i = 0 ; i < arr.Length ; i ++){

                for(int j = 0 ; j < i; j ++){

                    if(arr[i] > arr[j] && lis[i] < lis[j] +1){

                        lis[i] = lis[j] +1;
                    }
                }
            }

            for(int i = arr.Length -2; i >=0; i --){

                for(int j = arr.Length -1 ; j > i; j --){

                    if(arr[i] > arr[j] && lds[i] < lds[j] +1){

                        lds[i] = lds[j] +1;
                    }
                }
            }
            int max = 0 ;
            for(int i = 0 ; i < arr.Length ; i ++){
                if(max < lis[i] + lds[i] -1){
                    max = lis[i] + lds[i] -1;
                }
            }
            return max;


        }


        static int JumpsNeeded(int[] arr){

            int[] jumps = new int[arr.Length];
            int[] result = new int[arr.Length];

            jumps[0] = 0;

            for(int i = 1; i < arr.Length ; i ++){

                jumps[i] = int.MaxValue;
            }

            for(int i = 1; i < arr.Length; i ++){

                for(int j = 0; j < i; j ++){
                    if(arr[j] + j >= i){// check if we can jump
                        if(jumps[j] + 1 < jumps[i]){
                            jumps[i] = jumps[j] +1;
                            result[i] = j;
                        }
                    }
                }
            }
            Console.WriteLine();
            return jumps[arr.Length -1];

        }

    }
}
