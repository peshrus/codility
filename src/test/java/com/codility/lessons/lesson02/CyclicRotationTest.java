package com.codility.lessons.lesson02;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class CyclicRotationTest {

  private CyclicRotation cyclicRotation;

  @Before
  public void setUp() {
    cyclicRotation = new CyclicRotation();
  }

  @Test
  public void testSolution() {
    int[] testArray = {3, 8, 9, 7, 6};

    assertArrayEquals(new int[]{6, 3, 8, 9, 7}, cyclicRotation.solution(testArray, 1));
    assertArrayEquals(new int[]{9, 7, 6, 3, 8}, cyclicRotation.solution(testArray, 3));
    assertArrayEquals(testArray, cyclicRotation.solution(testArray, 100));
  }
}
