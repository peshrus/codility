package com.codility.lessons.lesson08;

/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs
 * in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with
 * indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element of array A in which
 * the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * <p>
 * Created on 15.09.2018
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingRF2R4C-ZXP/?showingAll=1">The first
 *     result</a>
 */
@SuppressWarnings("Duplicates")
public class Dominator {

  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }

    // find a dominator candidate
    int size = 0;
    Integer candidate = null;

    for (int a : A) {
      if (size == 0) {
        ++size;
        candidate = a;
      } else if (candidate != a) {
        --size;
      } else {
        ++size;
      }
    }

    // find the dominator
    Integer dominatorPos = null;
    int candidateCount = 0;

    if (size > 0) {
      for (int i = 0; i < A.length && candidateCount <= A.length / 2; i++) {
        int a = A[i];
        if (a == candidate) {
          dominatorPos = i;
          ++candidateCount;
        }
      }

      if (candidateCount <= A.length / 2) {
        dominatorPos = null;
      }
    }

    final int result = dominatorPos != null ? dominatorPos : -1;

    return result;
  }
}
