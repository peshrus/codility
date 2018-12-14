package com.codility.lessons.lesson07;

/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty; S has the form "(U)" where U is a properly nested string; S has the form "VW" where V
 * and W are properly nested strings. For example, string "(()(())())" is properly nested but string
 * "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0
 * otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the
 * function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000]; string S consists only of the characters "("
 * and/or ")".
 * <p>
 * Created on 04.09.2017
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingU69E7Q-4TB/?showingAll=1">The first
 *     result</a>
 * @see <a href="https://app.codility.com/demo/results/training9GMADF-KB9/?showingAll=1">The second
 *     result</a>
 */
public class Nesting {

  public int solution(String s) {
    int result = 0;

    if (s != null && ("".equals(s) || nonEmptyStrSolution(s))) {
      result = 1;
    }

    return result;
  }

  private boolean nonEmptyStrSolution(String s) {
    int openBracketCount = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        ++openBracketCount;
      } else if (openBracketCount > 0) {
        --openBracketCount;
      } else {
        return false;
      }
    }

    return openBracketCount == 0;
  }
}
