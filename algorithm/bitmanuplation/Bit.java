package bitmanuplation;

import org.junit.Assert;

/**
 * Often, there is a tricky way to solve these problems. Bitwise xor can often
 * be used in a tricky way because two identical numbers in an expression
 * involving xor will "cancel out". For example, 15 ^ 12 ^ 15 = 12.
 * 
 * @author bin
 */
public class Bit {

  /**
   * Check whether the bit is set on pos (starting from 0 in the right)
   * 
   * @param num
   * @param pos
   * @return
   */
  public static boolean isBitSet(int num, int pos) {
    return ((num >> pos) & 1) == 1;
  }

  public static int setBitAt(int num, int pos) {
    int mask = (1 << pos);
    return num | mask;
  }

  public static int unsetBitAt(int num, int pos) {
    int mask = (1 << pos);
    mask = ~mask;
    return num & mask;
  }

  /**
   * start from most significant (0) to pos (exclusive)
   * 
   * @param num
   * @param pos
   * @return
   */
  public static int unsetMSBToPos(int num, int pos) {
    int mask = (1 << (pos)) - 1;
    return num & mask;
  }

  /**
   * reset all the bits from LST to pos (exclusive)
   * 
   * @param num
   * @param pos
   * @return
   */
  public static int unsetLSBToPos(int num, int pos) {
    int mask = (1 << pos) - 1;
    mask = ~mask;
    return num & mask;

  }

  /**
   * clear the last '1' in the right
   * 
   * @param num
   * @return
   */
  public static int unsetLastSetBit(int num) {
    return num & (num - 1);
  }

  /**
   * counter the number of 1 in the binary of num
   * 
   * @param num
   * @return
   */
  public static int countOne(int num) {
    int counter = 0;
    while (num != 0) {
      num = num & (num - 1);
      counter++;
    }
    return counter;
  }

  /**
   * how many times it will take to change the bit to make num1==num2
   * 
   * @param num1
   * @param num2
   * @return
   */
  public static int numberOfSwap(int num1, int num2) {
    int num = num1 ^ num2;
    return countOne(num);
  }

  /**
   * is the binary format of integer palindrome?
   * 
   * @param num
   * @return
   */
  public static boolean isPalindrome(int num) {
    return num == reverse(num);
  }

  /**
   * review the bit of an integer
   * 
   * @param num
   * @return
   */
  public static int reverse(int num) {
    int rev = 0;
    while (num > 0) {
      rev = (rev << 1 | (num & 1));
      num >>= 1;
    }
    return rev;
  }

  /**
   * swap the even position with the odd position. 1. get the even position
   * value 2. get the odd position value 3. move the even <<1, and move the
   * odd>>1 4. even & odd
   * 
   * @param num
   * @return
   */
  public static int swapEvenOdd(int num) {
    int maskEven = 0x55555555;
    int maskOdd = 0xAAAAAAAA;
    maskEven = (num & maskEven) << 1;
    maskOdd = (num & maskOdd) >> 1;

    return (maskEven | maskOdd);
  }

  public static int numberOfLeadingZeros(int num) {
    // return Integer.numberOfLeadingZeros(num);
    int counter = 0;
    while ((1 << counter) < num) {
      counter++;
    }
    return 32 - counter;
  }

  public static void main(String[] args) {
    int num = 0b10101100;
    Assert.assertTrue(isBitSet(num, 2));
    Assert.assertTrue(setBitAt(num, 4) == 0b10111100);
    Assert.assertTrue(unsetBitAt(num, 3) == 0b10100100);
    Assert.assertTrue(unsetMSBToPos(num, 4) == 0b1100);
    Assert.assertTrue(unsetLSBToPos(num, 3) == 0b10101000);
    Assert.assertTrue(unsetLastSetBit(num) == 0b10101000);
    Assert.assertTrue(countOne(num) == 4);
    Assert.assertTrue(isPalindrome(0b11011011));
    Assert.assertTrue(numberOfLeadingZeros(num) == Integer.numberOfLeadingZeros(num));
  }
}
