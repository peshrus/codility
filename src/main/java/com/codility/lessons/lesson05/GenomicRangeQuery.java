package com.codility.lessons.lesson05;

import java.util.Arrays;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which
 * correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact
 * factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3
 * and 4, respectively. You are going to answer several queries of the form: What is the minimal
 * impact factor of nucleotides contained in a particular part of the given DNA sequence?
 * <p/>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
 * There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides
 * contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 * <p/>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <p/>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 * <p/>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact
 * factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so
 * the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular
 * nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 * <p/>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * <p/>
 * that, given a non-empty zero-indexed string S consisting of N characters and two non-empty
 * zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M integers
 * specifying the consecutive answers to all queries.
 * <p/>
 * The sequence should be returned as:
 * <p/>
 * a Results structure (in C), or
 * a vector of integers (in C++), or
 * a Results record (in Pascal), or
 * an array of integers (in any other programming language).
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * <p/>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 * <p/>
 * Assume that:
 * <p/>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 * Complexity:
 * <p/>
 * expected worst-case time complexity is O(N+M);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage
 * required for input arguments).
 * Elements of input arrays can be modified.
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingHF7PA4-GMR/">The first result</a>
 */
public class GenomicRangeQuery {

  private static final int[] EMPTY_IMPACT_FACTORS = new int[4];

  public int[] solution(String S, int[] P, int[] Q) {
    if (S == null || S.length() < 1 || S.length() > 100000) {
      throw new IllegalArgumentException(
          "S has to be a non-empty string consisting of [1..100,000] characters");
    }
    if (P == null || P.length < 1 || P.length > 50000) {
      throw new IllegalArgumentException(
          "P has to be a non-empty array consisting of [1..50,000] integers");
    }
    if (Q == null || Q.length < 1 || Q.length > 50000) {
      throw new IllegalArgumentException(
          "Q has to be a non-empty array consisting of [1..50,000] integers");
    }
    if (P.length != Q.length) {
      throw new IllegalArgumentException("P and Q have to have the same length");
    }

    final int[][] impactFactors = new int[S.length()][4];
    ++impactFactors[0][Nucleotides.valueOf(String.valueOf(S.charAt(0))).getImpactFactor() - 1];
    for (int N = 1; N < S.length(); N++) {
      // String S consists only of upper-case English letters A, C, G, T
      // Otherwise Nucleotides.valueOf throws IllegalArgumentException
      final Nucleotides nucleotide = Nucleotides.valueOf(String.valueOf(S.charAt(N)));
      impactFactors[N] = Arrays.copyOf(impactFactors[N - 1], impactFactors[N - 1].length);
      ++impactFactors[N][nucleotide.getImpactFactor() - 1];
    }

    final int[] result = new int[P.length];
    for (int K = 0; K < P.length; K++) {
      if (P[K] >= 0 && P[K] < S.length() && Q[K] >= 0 && Q[K] < S.length()) {
        if (P[K] < Q[K]) {
          final int[] impactFactorsBeforeRange;
          if (P[K] > 0) {
            impactFactorsBeforeRange = impactFactors[P[K] - 1];
          } else {
            impactFactorsBeforeRange = EMPTY_IMPACT_FACTORS;
          }
          final int[] leftImpactFactors = impactFactors[P[K]];
          final int[] rightImpactFactors = impactFactors[Q[K]];

          for (int i = 0; i < leftImpactFactors.length; i++) {
            final int right = rightImpactFactors[i] - impactFactorsBeforeRange[i];
            final int left = leftImpactFactors[i] - impactFactorsBeforeRange[i];
            final int diff = right - left;

            if (diff > 0 || right > 0) {
              result[K] = (i + 1);
              break;
            }
          }
        } else if (P[K] == Q[K]) {
          result[K] = Nucleotides.valueOf(String.valueOf(S.charAt(P[K]))).getImpactFactor();
        } else {
          throw new IllegalArgumentException("P[K] ≤ Q[K]");
        }
      } else {
        throw new IllegalArgumentException(
            "Each element of arrays P, Q is an integer within the range [0..N − 1]");
      }
    }

    return result;
  }

  @SuppressWarnings("unused")
  public enum Nucleotides {
    A(1), C(2), G(3), T(4);

    private final int impactFactor;

    Nucleotides(int impactFactor) {
      this.impactFactor = impactFactor;
    }

    public int getImpactFactor() {
      return impactFactor;
    }
  }
}
