package com.codility.lessons.lesson09;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxSliceSumTest {

  private MaxSliceSum maxSliceSum;

  @Before
  public void setUp() {
    maxSliceSum = new MaxSliceSum();
  }

  @Test
  public void solution() {
    assertEquals(0, maxSliceSum.solution(null));
    assertEquals(0, maxSliceSum.solution(new int[0]));
    assertEquals(1, maxSliceSum.solution(new int[]{1}));
    assertEquals(5, maxSliceSum.solution(new int[]{3, 2, -6, 4, 0}));
    assertEquals(-10, maxSliceSum.solution(new int[]{-10}));
    assertEquals(1, maxSliceSum.solution(new int[]{-2, 1}));
  }
}