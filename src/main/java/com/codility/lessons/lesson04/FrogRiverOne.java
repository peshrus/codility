package com.codility.lessons.lesson04;

/**
 * A small frog wants to get to the other side of a river. The frog is currently located at position
 * 0, and wants to get to position X. Leaves fall from a tree onto the surface of the river.
 * <p/>
 * You are given a non-empty zero-indexed array A consisting of N integers representing the falling
 * leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 * <p/>
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The
 * frog can cross only when leaves appear at every position across the river from 1 to X. You may
 * assume that the speed of the current in the river is negligibly small, i.e. the leaves do not
 * change their positions once they fall in the river.
 * <p/>
 * For example, you are given integer X = 5 and array A such that:
 * <p/>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every
 * position across the river.
 * <p/>
 * Write a function:
 * <p/>
 * class Solution { public int solution(int X, int[] A); }
 * <p/>
 * that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the
 * earliest time when the frog can jump to the other side of the river.
 * <p/>
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 * <p/>
 * For example, given X = 5 and array A such that:
 * <p/>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * the function should return 6, as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(X), beyond input storage (not counting the storage
 * required for input arguments).
 * Elements of input arrays can be modified.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/training7YQQ5G-HE6/">The first result</a>
 */
public class FrogRiverOne {

  public int solution(int X, int[] A) {
    if (A == null || A.length == 0) {
      throw new IllegalArgumentException("A has to be a non-empty array");
    }
    if (A.length > 100000) {
      throw new IllegalArgumentException("A length has to be within the range [1..100,000]");
    }
    if (X < 1 || X > 100000) {
      throw new IllegalArgumentException("X has to be within the range [1..100,000]");
    }

    final int[] positions = new int[X];
    for (int i = 0; i < A.length; i++) {
      positions[A[i] - 1] = positions[A[i] - 1] > 0 ? Math.min(i + 1, positions[A[i] - 1]) : i + 1;
    }

    int result = -1;
    for (int pos : positions) {
      if (pos == 0) {
        result = -1;
        break; // If the frog is never able to jump to the other side of the river, the function should return −1.
      }
      result = Math.max(result, pos - 1);
    }

    return result;
  }
}
