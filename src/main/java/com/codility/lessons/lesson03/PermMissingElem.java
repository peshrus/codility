package com.codility.lessons.lesson03;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains integers
 * in the range [1..(N + 1)], which means that exactly one element is missing.
 * <p/>
 * Your goal is to find that missing element.
 * <p/>
 * Write a function:
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given a zero-indexed array A, returns the value of the missing element.
 * <p/>
 * For example, given array A such that:
 * <p/>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage
 * required for input arguments).
 * Elements of input arrays can be modified.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingV5K23Z-TNP/">The first result</a>
 */
public class PermMissingElem {

  public int solution(int[] A) {
    if (A == null || A.length > 100000) {
      throw new IllegalArgumentException("A length has to be within the range [0..100,000]");
    }
    if (A.length == 0) {
      return 1; // that's strange expectation
    }

    final long checkSum = (1L + A.length) * A.length / 2L; // Arithmetic progression sum
    long sum = 0L;
    for (int a : A) {
      sum += a;
    }
    final long result = checkSum - sum + A.length + 1L;

    return Long.valueOf(result).intValue();
  }
}
