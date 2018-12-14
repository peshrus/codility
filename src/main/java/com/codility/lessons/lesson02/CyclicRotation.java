package com.codility.lessons.lesson02;

/**
 * A zero-indexed array A consisting of N integers is given. Rotation of the array means that each
 * element is shifted right by one index, and the last element of the array is also moved to the
 * first place.
 * <p/>
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate
 * array A K times; that is, each element of A will be shifted to the right by K indexes.
 * <p/>
 * Write a function:
 * <p/>
 * class BinaryGap { public int[] solution(int[] A, int K); }
 * <p/>
 * that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A
 * rotated K times.
 * <p/>
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3,
 * 8].
 * <p/>
 * Assume that:
 * <p/>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of
 * the assessment.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/training5J2SFQ-MEG/">The first result</a>
 */
public class CyclicRotation {

  public int[] solution(int[] A, int K) {
    if (A == null) {
      throw new IllegalArgumentException("A cannot be null");
    }
    final int aLength = A.length;
    if (aLength > 100) {
      throw new IllegalArgumentException("N is an integer within the range [0..100]");
    }
    if (K < 0 || K > 100) {
      throw new IllegalArgumentException("K is an integer within the range [0..100]");
    }
    if (aLength == 0) {
      return A;
    }

    final int[] result = new int[aLength];
    final int shiftSize = K % aLength;
    final int shiftedBlockLen = aLength - shiftSize;

    // It has to be faster than the loop below
    System.arraycopy(A, 0, result, shiftSize, shiftedBlockLen);
    System.arraycopy(A, shiftedBlockLen, result, 0, shiftSize);

		/*for (int pos = 0; pos < aLength; pos++) {
			result[(pos + K) % aLength] = A[pos];
		}*/

    return result;
  }
}
