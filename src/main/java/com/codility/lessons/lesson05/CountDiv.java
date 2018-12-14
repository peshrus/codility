package com.codility.lessons.lesson05;

/**
 * Write a function:
 * <p/>
 * class Solution { public int solution(int A, int B, int K); }
 * <p/>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B]
 * that are divisible by K, i.e.:
 * <p/>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p/>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three
 * numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * <p/>
 * Assume that:
 * <p/>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(1);
 * expected worst-case space complexity is O(1).
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingTCMJ5D-DZZ/">The first result</a>
 */
public class CountDiv {

  public int solution(int A, int B, int K) {
    if (A < 0 || A > 2000000000) {
      throw new IllegalArgumentException("A is an integer within the range [0..2,000,000,000]");
    }
    if (B < 0 || B > 2000000000) {
      throw new IllegalArgumentException("B is an integer within the range [0..2,000,000,000]");
    }
    if (K < 1 || K > 2000000000) {
      throw new IllegalArgumentException("K is an integer within the range [1..2,000,000,000]");
    }
    if (A > B) {
      throw new IllegalArgumentException("A ≤ B");
    }

    final int left = Math.max(A % K > 0 ? (A - A % K + K) : A, Math.min(A, K));
    final int right = B % K > 0 ? (B - B % K) : B;
    final int result = (right - left) / K + 1;

    return result;
  }
}
