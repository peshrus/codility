package com.codility.lessons.lesson05;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MinAvgTwoSliceTest {

  private MinAvgTwoSlice minAvgTwoSlice;

  @Before
  public void setUp() {
    minAvgTwoSlice = new MinAvgTwoSlice();
  }

  @Test
  public void testSolution() {
    assertEquals(1, minAvgTwoSlice.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    assertEquals(0, minAvgTwoSlice.solution(new int[]{-10000, 10000}));
    assertEquals(0, minAvgTwoSlice.solution(new int[]{-10000, 0}));
    assertEquals(0, minAvgTwoSlice.solution(new int[]{0, 10000}));

    assertEquals(2, minAvgTwoSlice.solution(new int[]{-3, -5, -8, -4, -10}));

    // test without check
    final int[] arr1 = new int[100000];
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = i % 10000 - 10000;
    }
    minAvgTwoSlice.solution(arr1);
  }
}
