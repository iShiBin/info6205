using System;

namespace BitManipulation
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }


        private static bool IsBitSet(int num, int pos){
            int mask = 1<< pos;

            if( ( mask & num) == 0 )
                return false;
            return true;
        }


        private static int SetBitAtPos(int num, int pos){
            int mask = 1<< pos;
            return (mask | num);
           
        }

         private static int ClearBitAtPos(int num, int pos){
            int mask = 1<< pos;
            mask = ~mask;
            return (mask & num);
        }

        private static int ClearMSBToPos(int num, int pos){
            int mask = 1 <<(pos +1);
            mask = mask -1;

            return (num & mask);

        }

        private static int ClearPosToLSB(int num, int pos){
            int mask = 1 <<(pos +1);
            mask = mask -1;
            mask = ~mask;

            return (num & mask);
        }

        private static int ClearLastSetBit(int num){
            return (num & (num -1));
        }

        private bool IsPowOfTwo(int num){
            if(num == 0 )
                return false;
            
            if((num & (num -1)) == 0)
                return true;
            
            return false;

        }

        private static int CountSetBits(int num){

            int count = 0 ; 

            while(num >0){
                num = (num & (num -1));
                count ++;

            }
            return count;
        }

        private static int NumBitsToSwap(int num1, int num2){

            int num = (num1 ^ num2);

            int count = 0;
             while(num >0){
                num = (num & (num -1));
                count ++;

            }
            return count;
        }


        private static bool Ispalindrome(int num){
            return (num == ReverseNum(num));
        }

        private static int ReverseNum(int num){
            int result = 0;

            while(num >0){
                result = (result << 1 | (num & 1));
                num = (num >> 1);
            }
            return result;
        }


        private static int SwapEvenOdd(int num){

            int maskEven = 0x55555555;
            int maskOdd  = int.Parse("AAAAAAAA");

            maskEven = (num & maskEven) <<1;
            maskOdd = (num & maskOdd) >> 1;

            return (maskEven | maskOdd);

        }

        private static int ReplaceBitsWithNum(int num , int replace, int i, int j){
            // i > j

            int rightMask = (1 << (j+1)) -1;
            int leftMask = (1 << (i +1)) -1;

            leftMask = ~ leftMask;

            int result = leftMask | rightMask;// now we have 1's on left and right

            // clear out the middle part
            result = result & num;

            replace = replace << j;

            result = result | replace;

            return result;



        }

    }
}
