package com.codility.lessons.lesson06;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q,
 * R) equates to A[P]
 * * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * contains the following example triplets:
 * <p>
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty zero-indexed array A, returns the value of the maximal product of any
 * triplet.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage
 * required for input
 * arguments).
 * Elements of input arrays can be modified.
 * <p>
 * Created on 19.02.2016
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://codility.com/demo/results/training8PBEDU-V9F/">The first result</a>
 * @see <a href="https://codility.com/demo/results/trainingQ6ZACB-FUJ/">The second result</a>
 * @see <a href="https://codility.com/demo/results/trainingEPMCDP-SF5/">The third result</a>
 */
public class MaxProductOfThree {

  private static void updateMaxes(int a, int[] maxes) {
    if (a >= maxes[2]) {
      maxes[0] = maxes[1];
      maxes[1] = maxes[2];
      maxes[2] = a;
    } else if (a >= maxes[1]) {
      maxes[0] = maxes[1];
      maxes[1] = a;
    } else if (a > maxes[0]) {
      maxes[0] = a;
    }
  }

  private static void updateMins(int a, int[] mins) {
    if (a <= mins[0]) {
      mins[1] = mins[0];
      mins[0] = a;
    } else if (a < mins[1]) {
      mins[1] = a;
    }
  }

  public int solution(int[] A) {
    final int[] maxes = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    final int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    for (int a : A) {
      updateMaxes(a, maxes);
      updateMins(a, mins);
    }

    long obvious = (long) maxes[0] * maxes[1] * maxes[2];
    long twoBigNegs = (long) mins[0] * mins[1] * maxes[2];

    return Long.valueOf(Math.max(obvious, twoBigNegs)).intValue();
  }
}