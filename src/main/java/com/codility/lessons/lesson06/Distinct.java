package com.codility.lessons.lesson06;

import java.util.Arrays;

/**
 * Write a function
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given a zero-indexed array A consisting of N integers, returns the number of distinct
 * values in array A.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * For example, given array A consisting of six elements such that:
 * <p/>
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1,
 * 2 and 3.
 * <p/>
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage
 * required for input
 * arguments).
 * Elements of input arrays can be modified.
 * <p/>
 * Created on 18.02.2016
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://codility.com/demo/results/trainingJVM68F-VRE/">The first result</a>
 */
public class Distinct {

  public int solution(int[] A) {
    Arrays.sort(A);

    int result = A.length >= 1 ? 1 : 0;
    for (int i = 1; i < A.length; i++) {
      if (A[i] != A[i - 1]) {
        ++result;
      }
    }

    return result;
  }
}
