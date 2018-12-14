package com.codility.lessons.lesson06;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxProductOfThreeTest {

  private MaxProductOfThree maxProductOfThree;

  @Before
  public void setUp() {
    maxProductOfThree = new MaxProductOfThree();
  }

  @Test
  public void testSolution() {
    assertEquals(60, maxProductOfThree.solution(new int[]{-3, 1, 2, -2, 5, 6}));
    assertEquals(1000000000, maxProductOfThree.solution(new int[]{1000, 1000, 1000}));
    assertEquals(-1000000000, maxProductOfThree.solution(new int[]{-1000, 1000, 1000}));
    assertEquals(0, maxProductOfThree.solution(new int[]{-1000, 0, 1000}));
    assertEquals(-6, maxProductOfThree.solution(new int[]{-3, -2, -1}));
    assertEquals(18, maxProductOfThree.solution(new int[]{-3, -2, -1, 1, 2, 3}));
    assertEquals(0, maxProductOfThree.solution(new int[]{-3, -2, -1, 0}));

    assertEquals(125, maxProductOfThree.solution(new int[]{-5, 5, -5, 4}));
    assertEquals(1000000000,
        maxProductOfThree.solution(new int[]{-3, 1, 2, -2, 0, 999, 1000, 1000, 1000}));
  }
}
