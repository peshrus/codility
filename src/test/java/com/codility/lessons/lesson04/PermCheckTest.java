package com.codility.lessons.lesson04;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PermCheckTest {

  private PermCheck permCheck;

  @Before
  public void setUp() {
    permCheck = new PermCheck();
  }

  @Test
  public void testSolution() {
    assertEquals(1, permCheck.solution(new int[]{4, 1, 3, 2}));
    assertEquals(0, permCheck.solution(new int[]{4, 1, 3}));
    assertEquals(0, permCheck.solution(new int[]{1, 3}));
    assertEquals(1, permCheck.solution(new int[]{1, 2}));
  }
}
