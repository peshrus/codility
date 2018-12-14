package com.codility.lessons.lesson07;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BracketsTest {

  private Brackets brackets;

  @Before
  public void setUp() {
    brackets = new Brackets();
  }

  @Test
  public void solution() {
    assertEquals(1, brackets.solution(""));

    assertEquals(0, brackets.solution("{"));
    assertEquals(0, brackets.solution("}"));
    assertEquals(1, brackets.solution("{}"));

    assertEquals(0, brackets.solution("["));
    assertEquals(0, brackets.solution("]"));
    assertEquals(1, brackets.solution("[]"));

    assertEquals(0, brackets.solution("("));
    assertEquals(0, brackets.solution(")"));
    assertEquals(1, brackets.solution("()"));

    assertEquals(1, brackets.solution("{[()()]}"));
    assertEquals(0, brackets.solution("([)()]"));
    assertEquals(0, brackets.solution("(])()]"));

    assertEquals(0, brackets.solution("}{"));
    assertEquals(0, brackets.solution("]["));
    assertEquals(0, brackets.solution(")("));
  }
}