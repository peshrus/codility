package com.codility.lessons.lesson04;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MissingIntegerTest {

  private MissingInteger missingInteger;

  @Before
  public void setUp() {
    missingInteger = new MissingInteger();
  }

  @Test
  public void testSolution() {
    assertEquals(5, missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2}));
    assertEquals(2, missingInteger.solution(new int[]{1}));
    assertEquals(1, missingInteger.solution(new int[]{0}));
    assertEquals(1, missingInteger.solution(new int[]{-1}));
    assertEquals(6, missingInteger.solution(new int[]{1, 3, 5, 4, 1, 2}));
    assertEquals(1, missingInteger.solution(new int[]{0, 2, 3}));
    assertEquals(1, missingInteger.solution(new int[]{2, 3}));
    assertEquals(1, missingInteger.solution(new int[]{4, 5, 6, 2}));
    assertEquals(1, missingInteger.solution(new int[]{Integer.MIN_VALUE, 0, 3, Integer.MAX_VALUE}));
  }
}
