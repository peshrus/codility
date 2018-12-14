package com.codility.lessons.demo;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The first covering prefix of
 * array A is the
 * smallest integer P such that 0≤P<N and such that every value that occurs in array A also occurs
 * in sequence A[0],
 * A[1], ..., A[P].
 * <p/>
 * For example, the first covering prefix of the following 5−element array A:
 * <p/>
 * A[0] = 2
 * A[1] = 2
 * A[2] = 1
 * A[3] = 0
 * A[4] = 1
 * is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that
 * occur in array A.
 * <p/>
 * Write a function
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given a zero-indexed non-empty array A consisting of N integers, returns the first covering
 * prefix of A.
 * <p/>
 * For example, given array A such that
 * <p/>
 * A[0] = 2
 * A[1] = 2
 * A[2] = 1
 * A[3] = 0
 * A[4] = 1
 * the function should return 3, as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [0..N−1].
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage
 * required for input
 * arguments).
 * Elements of input arrays can be modified.
 * <p/>
 * Created on 25.02.2016
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://codility.com/demo/results/trainingQX54P8-SF6/">The first result</a>
 */
public class PrefixSet {

  public int solution(int[] A) {
    final int[] minPos = new int[A.length];

    for (int i = 0; i < A.length; i++) {
      minPos[A[i]] = minPos[A[i]] > 0 ? Math.min(i + 1, minPos[A[i]]) : i + 1;
    }

    int result = minPos[0];
    for (int maxPos : minPos) {
      result = Math.max(result, maxPos);
    }

    return result - 1;
  }
}
