package com.codility.lessons.lesson07;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NestingTest {

  private Nesting nesting;

  @Before
  public void setUp() {
    nesting = new Nesting();
  }

  @Test
  public void solution() {
    assertEquals(1, nesting.solution(""));
    assertEquals(0, nesting.solution("("));
    assertEquals(0, nesting.solution(")"));
    assertEquals(1, nesting.solution("()"));
    assertEquals(1, nesting.solution("(()(())())"));
    assertEquals(0, nesting.solution("())"));
    assertEquals(0, nesting.solution(")("));
  }
}