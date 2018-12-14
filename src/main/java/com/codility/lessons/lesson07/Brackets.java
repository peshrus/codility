package com.codility.lessons.lesson07;

import java.util.Arrays;
import java.util.List;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following
 * conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0
 * otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the
 * function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * <p>
 * Created on 09.09.2018
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingU4UXZH-6X4/?showingAll=1">The first
 *     result</a>
 */
public class Brackets {

  private static final List<Character> CLOSE_BRACKETS = Arrays.asList('}', ']', ')');

  public int solution(String s) {
    int result = 0;

    if (s != null && ("".equals(s) || nonEmptyStrSolution(s))) {
      result = 1;
    }

    return result;
  }

  private boolean nonEmptyStrSolution(String s) {
    int openCurlyBracketCount = 0;
    int openSquareBracketCount = 0;
    int openBracketCount = 0;

    for (int i = 0; i < s.length(); i++) {
      final char character = s.charAt(i);

      if (character == '{') {
        ++openCurlyBracketCount;
      } else if (character == '[') {
        ++openSquareBracketCount;
      } else if (character == '(') {
        ++openBracketCount;
      } else if (i > 0) {
        final char prevChar = s.charAt(i - 1);
        final boolean prevCloseBracket = CLOSE_BRACKETS.contains(prevChar);

        if (character == '}' && (prevChar == '{' || prevCloseBracket)
            && openCurlyBracketCount > 0) {
          --openCurlyBracketCount;
        } else if (character == ']' && (prevChar == '[' || prevCloseBracket)
            && openSquareBracketCount > 0) {
          --openSquareBracketCount;
        } else if (character == ')' && (prevChar == '(' || prevCloseBracket)
            && openBracketCount > 0) {
          --openBracketCount;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }

    return (openCurlyBracketCount + openSquareBracketCount + openBracketCount) == 0;
  }
}
