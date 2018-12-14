package com.codility.lessons.lesson05;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of
 * array A represent consecutive cars on a road.
 * <p/>
 * Array A contains only 0s and/or 1s:
 * <p/>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is
 * passing when P is traveling to the east and Q is traveling to the west.
 * <p/>
 * For example, consider array A such that:
 * <p/>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p/>
 * Write a function:
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given a non-empty zero-indexed array A of N integers, returns the number of pairs of
 * passing cars.
 * <p/>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p/>
 * For example, given:
 * <p/>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * the function should return 5, as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage
 * required for input arguments).
 * Elements of input arrays can be modified.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingTRAVXK-XGN/">The first result</a>
 */
public class PassingCars {

  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      throw new IllegalArgumentException("A has to be a non-empty array");
    }
    if (A.length > 100000) {
      throw new IllegalArgumentException("A length has to be within the range [1..100,000]");
    }

    long zeroSum = 0L;
    long result = 0L;
    for (int a : A) {
      if (a == 0) {
        ++zeroSum;
      } else if (zeroSum > 0) {
        result += zeroSum;

        // The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
        if (result > 1000000000) {
          result = -1;
          break;
        }
      }
    }

    return Long.valueOf(result).intValue();
  }
}