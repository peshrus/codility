package com.codility.lessons.lesson06;

import java.util.Arrays;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N
 * non-negative
 * integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center
 * at (J, 0) and radius
 * A[J].
 * <p/>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at
 * least one common point
 * (assuming that the discs contain their borders).
 * <p/>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * <p/>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 2
 * A[3] = 1
 * A[4] = 4
 * A[5] = 0
 * <p/>
 * <p/>
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <p/>
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * Write a function:
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given an array A describing N discs as explained above, returns the number of (unordered)
 * pairs of intersecting
 * discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 * <p/>
 * Given array A shown above, the function should return 11, as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage
 * required for input
 * arguments).
 * Elements of input arrays can be modified.
 * <p/>
 * Created on 25.02.2016
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://codility.com/demo/results/trainingZQGNGH-MKZ/">The first result</a>
 * @see <a href="https://codility.com/demo/results/trainingGEXWPH-X7P/">The second result</a>
 * @see <a href="https://codility.com/demo/results/training4USVGM-JA7/">The third result</a>
 * @see <a href="https://codility.com/demo/results/trainingGG3Z84-J39/">The fourth result</a>
 */
public class NumberOfDiscIntersections {

  public int solution(int[] A) {
    final long[] leftBoundaries = new long[A.length];
    final long[] rightBoundaries = new long[A.length];

    for (int i = 0; i < A.length; i++) {
      leftBoundaries[i] = (long) i - A[i];
      rightBoundaries[i] = (long) i + A[i];
    }

    Arrays.sort(leftBoundaries);
    Arrays.sort(rightBoundaries);

    long result = 0;
    int left = 0;
    for (int right = 0; right < A.length && result < 10000001; right++) {
      while (left < A.length && rightBoundaries[right] >= leftBoundaries[left]) {
        ++left;
      }

      result += left - right - 1;
    }

    if (result > 10000000) {
      result = -1;
    }

    return Long.valueOf(result).intValue();
  }
}
