package com.codility.lessons.lesson03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TapeEquilibriumTest {

  private TapeEquilibrium tapeEquilibrium;

  @Before
  public void setUp() {
    tapeEquilibrium = new TapeEquilibrium();
  }

  @Test
  public void testSolution() {
    assertEquals(1, tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
    assertEquals(2000, tapeEquilibrium.solution(new int[]{3000, 1000}));
  }
}