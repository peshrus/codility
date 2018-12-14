package com.codility.lessons.lesson03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FrogJmpTest {

  private FrogJmp frogJmp;

  @Before
  public void setUp() {
    frogJmp = new FrogJmp();
  }

  @Test
  public void testSolution() {
    assertEquals(3, frogJmp.solution(10, 85, 30));
    assertEquals(0, frogJmp.solution(85, 85, 30));
    assertEquals(1, frogJmp.solution(999999999, 1000000000, 30));
  }
}
