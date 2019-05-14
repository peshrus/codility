package com.codility.lessons.lesson10;

/**
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N
 * = D * M.
 *
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given a positive integer N, returns the number of its factors.
 *
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2,
 * 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 *
 * Created on 5/13/2019
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingBQQCFE-59P/">The first result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingST7WBJ-JZ2/">The second result</a>
 * @see <a href="https://app.codility.com/demo/results/trainingGRNFHA-JRW/">The third result</a>
 */
public class CountFactors {

  public int solution(int N) {
    if (N <= 0) {
      return 0;
    } else if (N < 2) {
      return 1;
    } else if (N == Integer.MAX_VALUE) {
      return 2;
    }

    int result = 2; // 1 and N are always included
    int i = 2;

    for (; i * i < N; i++) {
      if (N % i == 0) {
        result += 2;
      }
    }

    if (i * i == N) {
      ++result;
    }

    return result;
  }
}
