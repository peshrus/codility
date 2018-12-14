package com.codility.lessons.lesson01;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is
 * surrounded by ones at both ends in the binary representation of N.
 * <p/>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The
 * number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and
 * one of length 3. The number 20 has binary representation 10100 and contains one binary gap of
 * length 1. The number 15 has binary representation 1111 and has no binary gaps.
 * <p/>
 * Write a function:
 * <p/>
 * class BinaryGap { public int solution(int N); }
 * <p/>
 * that, given a positive integer N, returns the length of its longest binary gap. The function
 * should return 0 if N doesn't contain a binary gap.
 * <p/>
 * For example, given N = 1041 the function should return 5, because N has binary representation
 * 10000010001 and so its longest binary gap is of length 5.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingE9RGGW-PR4/">The first result</a>
 */
public class BinaryGap {

  public int solution(int N) {
    if (N <= 0) {
      throw new IllegalArgumentException(
          "N has to be an integer within the range [1..2,147,483,647]");
    }

    int result = 0;
    int currentZerosCount = 0;

    while (N != 0) {
      if ((N & 1) == 1) {
        if (currentZerosCount - 1 > result) {
          result = currentZerosCount - 1;
        }
        currentZerosCount = 1;
      } else if (currentZerosCount > 0) {
        ++currentZerosCount;
      }

      N >>>= 1;
    }

    return result;
  }
}
