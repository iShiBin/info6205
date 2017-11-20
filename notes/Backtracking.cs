using System;
using System.Text;

namespace BackTracking
{
    class Program
    {
        static void Main(string[] args)
        {
            //int[] arr = {1,5,3,2,7,8,2,1};
            //GenerateSubSetsSumK(arr, 8);
            Permutations("ABC" , 2);
            Console.ReadLine();
        }


        public static void BinarySequence(int n)
        {
            if (n <= 0)
                return;

            int[] result = new int[n];
            int current = 0;

            BinarySequence(result, current);
        }

        private static void BinarySequence(int[] result, int current)
        {
            if (current == result.Length)
            {
                PrintArray(result);
                return;
            }

            for (int i = 0; i < 2; i++)
            {
                result[current] = i;
                BinarySequence(result, current + 1);
            }
        }

        public static void MarySequence(int n, int m)
        {
            if (n <= 0)
                return;

            int[] result = new int[n];
            int current = 0;

            MarySequence(result, current, m);
        }

        private static void MarySequence(int[] result, int current, int m)
        {
            if (current == result.Length)
            {
                PrintArray(result);
                return;
            }

            for (int i = 0; i < m; i++)
            {
                result[current] = i;
                MarySequence(result, current + 1, m);
            }
        }







        private static void PrintArray(int[] result)
        {

            for (int i = 0; i < result.Length; i++)
                Console.Write(result[i] + " ");
            Console.WriteLine();
        }


        public static void Combinations(string str, int n)
        {
            if (str.Length == 0 || n <= 0)
                return;
            int[] result = new int[n];
            int current = 0;
            Combinations(str, result, current, n);

        }

        private static void Combinations(string str,
                                            int[] result,
                                            int current,
                                            int n)
        {

            if (current == n)
            {
                PrintCombinations(str, result);
                return;

            }

            for (int i = 0; i < str.Length; i++)
            {
                result[current] = i;
                Combinations(str, result, current + 1, n);

            }
        }
        private static void PrintCombinations(string str, int[] result)
        {
            for(int i = 0 ; i < result.Length; i ++){
                Console.Write(str[result[i]] + " ");
            }
            Console.WriteLine();
        }


        public static void GenerateSubSets(string str){
            if(str.Length == 0)
                return;

            int[] result = new int[str.Length];
            int current = 0;
            GenerateSubSets(result, current, str);

        }
        private static void GenerateSubSets(int[] result, int current, string str){
            if(current == result.Length){
                PrintSubsets(result, str);
                return;
            }

            for(int i = 0 ; i < 2; i ++){
                result[current]= i;
                GenerateSubSets(result, current+1, str);
            }

        }

        private static void PrintSubsets(int[] result, string str){
            StringBuilder sb = new StringBuilder();
            sb.Append("{");
            for(int i = 0 ; i < result.Length; i ++){
                if(result[i] == 1)
                    sb.Append(str[i] + ",");
            }
            sb.Append("}");
            Console.WriteLine(sb.ToString());
        }

        public static void GenerateSubSetsSumK(int[] arr, int k){
            if(arr.Length == 0 || k <= 0)
                return;

            int[] result = new int[arr.Length];
            int current = 0;
            GenerateSubSetsSumK(arr, result, current, k);

        }

        private static void GenerateSubSetsSumK(int[] arr, int[] result, int current, int k){

            if(current == result.Length)
            {
                PrintSubSetsSumK(result, arr, k);
                return;

            }

            for(int i = 0 ; i < 2; i ++){
                result[current] = i;
                GenerateSubSetsSumK(arr, result, current +1, k);
            }

        }

        private static void PrintSubSetsSumK(int[] result, int[] arr, int k){
            int sum = 0 ;
            StringBuilder sb = new StringBuilder();
            sb.Append("{");

            for(int i = 0 ; i < result.Length; i ++){
                if(result[i] == 1){
                    sb.Append(arr[i] + ",");
                    sum += arr[i];
                }

            }
            sb.Append("}");

            if(sum == k ){
                Console.WriteLine(sb.ToString());
            }


        }


        public static void Permutations(string str, int n){

            if(str.Length == 0  || n <= 0)
                return;

                int[] result = new int[n];
                Permutations(result, 0, n, str);

        }

        private static void Permutations(int[] result, int current, int n, string str ){

            if(current == n){
                PrintCombinations(str, result);
                return;

            }

            for(int i = 0 ; i < str.Length; i ++){

                if(isValid(result, current, i)){
                    result[current] = i;
                    Permutations(result, current +1, n, str);
                }

            }

        }

        private static bool isValid(int[] result, int current, int num){

            for(int i = 0 ; i < current; i ++){

                if(result[i] == num)
                    return false;
            }
            return true;
        }




    }


}
