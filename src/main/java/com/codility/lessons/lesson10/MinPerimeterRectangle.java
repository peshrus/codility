package com.codility.lessons.lesson10;

/**
 * An integer N is given, representing the area of some rectangle.
 *
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A +
 * B).
 *
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this
 * rectangle should be only integers.
 *
 * For example, given integer N = 30, rectangles of area 30 are:
 *
 * (1, 30), with a perimeter of 62, (2, 15), with a perimeter of 34, (3, 10), with a perimeter of
 * 26, (5, 6), with a perimeter of 22. Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly
 * equal to N.
 *
 * For example, given an integer N = 30, the function should return 22, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000,000].
 *
 * Created on 5/14/2019
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingUG5F4K-H3W/">The first result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingUEE4AN-TAU/">The second result</a>
 */
public class MinPerimeterRectangle {

  public int solution(int N) {
    if (N < 1) {
      return 0;
    }

    int result = calcPerimeter(N, 1);
    int i = 2;

    for (; i * i < N; i++) {
      if (N % i == 0) {
        result = calcMinPerimeter(result, i, N / i);
      }
    }

    if (i * i == N) {
      result = calcMinPerimeter(result, i, i);
    }

    return result;
  }

  private int calcPerimeter(final int A, final int B) {
    return 2 * (A + B);
  }

  private int calcMinPerimeter(final int current, final int A, final int B) {
    final int newPerimeter = calcPerimeter(A, B);

    return Math.min(current, newPerimeter);
  }
}
