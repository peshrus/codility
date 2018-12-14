package com.codility.lessons.lesson08;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * The leader of this array is the value that occurs in more than half of the elements of A.
 * <p>
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and
 * A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 * <p>
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * the function should return 2, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * <p>
 * Created on 11.09.2018
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/training4HZU3Q-G7P/?showingAll=1">The first
 *     result</a>
 * @see <a href="https://app.codility.com/demo/results/training59S2Y6-P3A/?showingAll=1">The second
 *     result</a>
 * @see <a href="https://app.codility.com/demo/results/training5EB7WG-NJA/?showingAll=1">The third
 *     result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingPQMGJ6-YX3/?showingAll=1">The fourth
 *     result</a>
 */
@SuppressWarnings("Duplicates")
public class EquiLeader {

  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    // find a leader candidate
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

    // find the leader
    Integer leader = null;
    int candidateCount = 0;

    if (size > 0) {
      for (int a : A) {
        if (a == candidate) {
          ++candidateCount;
        }
      }

      if (candidateCount > A.length / 2) {
        leader = candidate;
      }
    }

    // find equi leaders
    int result = 0;

    if (leader != null) {
      int leftPartLeadersCount = 0;
      int rightPartLeadersCount = candidateCount;

      for (int i = 0; i < A.length - 1 && rightPartLeadersCount > 0; i++) {
        if (A[i] == leader) {
          ++leftPartLeadersCount;
          --rightPartLeadersCount;
        }

        if (leftPartLeadersCount > ((i + 1) / 2) && rightPartLeadersCount > ((A.length - i - 1)
            / 2)) {
          ++result;
        }
      }
    }

    return result;
  }
}
