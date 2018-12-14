package com.codility.lessons.lesson04;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer
 * (greater than 0) that does not occur in A.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 6
 * A[3] = 4
 * A[4] = 1
 * A[5] = 2
 * the function should return 5.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage
 * required for input arguments).
 * Elements of input arrays can be modified.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingAMP9BJ-WDP/">The first result</a>
 */
public class MissingInteger {

  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      throw new IllegalArgumentException("A has to be a non-empty array");
    }
    if (A.length > 100000) {
      throw new IllegalArgumentException("A length has to be within the range [1..100,000]");
    }

    final int[] count = new int[A.length];
    int min = -1;
    int max = -1;
    int pos;
    for (int a : A) {
      if (a > 0) {
        if (min == -1) {
          min = a;
          max = a;
        }

        pos = (a % A.length) - 1;
        if (pos >= 0) {
          ++count[pos];
        } else {
          ++count[A.length - 1];
        }

        min = Math.min(min, a);
        max = Math.max(max, a);
      }
    }

    int result = -1;

    if (min > 0) {
      if (min > 1) {
        result = 1;
      }

      if (result < 0) {
        for (int i = 0; i < count.length; i++) {
          if (count[i] == 0) {
            result = min + i - ((min % A.length) - 1);
            break;
          }
        }
      }

      if (result < 0) {
        result = max + 1;
      }
    } else {
      result = 1;
    }

    return result;
  }
}
