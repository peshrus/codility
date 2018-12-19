package com.codility.lessons.lesson09;

import static java.lang.Math.max;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P
 * ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] +
 * ... + A[Q].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 * <p>
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 * <p>
 * Created on 21.09.2018
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/training7CER4Q-BQG/">The first result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingGHRSA5-3RP/">The second result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingA346GE-A6R/">The third result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingSP7UW5-K86/">Refactoring</a>
 */
public class MaxSliceSum {

  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    int lastMaxSum = 0;
    int result = Integer.MIN_VALUE;

    for (int a : A) {
      final int nextSum = lastMaxSum + a;
      lastMaxSum = max(nextSum, a);
      result = max(result, lastMaxSum);
    }

    return result;
  }
}
