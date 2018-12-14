package com.codility.lessons.lesson04;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FrogRiverOneTest {

  private FrogRiverOne frogRiverOne;

  @Before
  public void setUp() {
    frogRiverOne = new FrogRiverOne();
  }

  @Test
  public void testSolution() {
    assertEquals(6, frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    assertEquals(-1, frogRiverOne.solution(5, new int[]{1, 3, 1, 3, 2, 3, 5, 3}));
  }
}
