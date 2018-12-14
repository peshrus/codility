package com.codility.lessons.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EquiTest {

  private Equi equi;

  @Before
  public void setUp() {
    equi = new Equi();
  }

  @Test
  public void testSolution() {
    assertEquals(1, equi.solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
  }
}
