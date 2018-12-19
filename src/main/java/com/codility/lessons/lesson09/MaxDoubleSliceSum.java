package com.codility.lessons.lesson09;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * <p>
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1]
 * + A[Y + 2] + ... + A[Z − 1].
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * contains the following example double slices:
 * <p>
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double
 * slice.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * <p>
 * Created on 17.12.2018.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingK8JKPR-ZYQ/">The first result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingK9G8BV-3W6/">The second result</a>
 * @see <a href="https://app.codility.com/demo/results/training5Y5W3N-2J4/">The third result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingY87JES-NXF/">The fourth result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingR33H3W-JE5/">The fifth result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingR33H3W-JE5/">The sixth result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingSH9K7K-CD9/">The seventh result</a>
 * @see <a href="https://app.codility.com/demo/results/training9ATG9R-3N3/">The eighth result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingWCD9M5-7WK/">The ninth result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingGV3RNS-4BD/">The tenth result</a>
 *
 */
public class MaxDoubleSliceSum {

  public int solution(int[] A) {
    if (A == null || A.length < 4) {
      return 0;
    }

    final List<Integer> slices = new ArrayList<>();
    int currentSliceMin = findSlices(A, slices);
    int result = findMaxDoubleSlice(slices, currentSliceMin);

    return result;
  }

  private int findSlices(int[] A, List<Integer> slices) {
    int currentSlice = 0;
    int currentSliceMin = A[1];

    for (int i = 1; i < A.length - 1; i++) {
      final int a = A[i];

      if (a < 0) {
        slices.add(currentSlice);
        currentSlice = 0;
        currentSliceMin = A[i + 1];

        continue;
      }

      currentSliceMin = min(currentSliceMin, a);
      currentSlice += a;
    }

    slices.add(currentSlice);

    return currentSliceMin;
  }

  private int findMaxDoubleSlice(List<Integer> slices, int currentSliceMin) {
    int result = slices.get(0);

    switch (slices.size()) {
      case 1:
        result -= currentSliceMin;
        break;
      case 2:
        result += slices.get(1);
        break;
      default: {
        for (int j = 0; j < slices.size() - 1; j++) {
          result = max(result, slices.get(j) + slices.get(j + 1));
        }
      }
    }

    return result;
  }
}
