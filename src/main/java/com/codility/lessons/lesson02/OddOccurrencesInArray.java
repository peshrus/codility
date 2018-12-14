package com.codility.lessons.lesson02;

import java.util.HashSet;
import java.util.Set;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd
 * number of elements, and each element of the array can be paired with another element that has the
 * same value, except for one element that is left unpaired.
 * <p/>
 * For example, in array A such that:
 * <p/>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * <p/>
 * class Solution { public int solution(int[] A); }
 * <p/>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the
 * value of the unpaired element.
 * <p/>
 * For example, given array A such that:
 * <p/>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p/>
 * Assume that:
 * <p/>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage
 * required for input arguments).
 * Elements of input arrays can be modified.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingUEYZDH-VAN/">The first result</a>
 */
public class OddOccurrencesInArray {

  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      throw new IllegalArgumentException("A has to be a non-empty array");
    }
    if ((A.length % 2) == 0) {
      throw new IllegalArgumentException("A has to contain an odd number of elements");
    }
    if (A.length > 1000000) {
      throw new IllegalArgumentException(
          "N has to be an odd integer within the range [1..1,000,000]");
    }

    final Set<Integer> values = new HashSet<>(A.length, 1.0f);
    values.add(A[A.length - 1]);

    for (int i = 0; i < (A.length - 1) / 2; i++) {
      if (A[i] != A[A.length - 2 - i]) { // XOR could be more effective
        if (!values.remove(A[i])) {
          values.add(A[i]);
        }
        if (!values.remove(A[A.length - 2 - i])) {
          values.add(A[A.length - 2 - i]);
        }
      }
    }

    return values.iterator().next();
  }
}
