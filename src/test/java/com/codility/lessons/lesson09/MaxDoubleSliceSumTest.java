package com.codility.lessons.lesson09;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxDoubleSliceSumTest {

  private MaxDoubleSliceSum maxDoubleSliceSum;

  @Before
  public void setUp() {
    maxDoubleSliceSum = new MaxDoubleSliceSum();
  }

  @Test
  public void solution() {
    assertEquals(0, maxDoubleSliceSum.solution(null));
    assertEquals(0, maxDoubleSliceSum.solution(new int[0]));
    assertEquals(0, maxDoubleSliceSum.solution(new int[]{1}));
    assertEquals(0, maxDoubleSliceSum.solution(new int[]{1, 2}));
    assertEquals(0, maxDoubleSliceSum.solution(new int[]{1, 2, 3}));
    assertEquals(3, maxDoubleSliceSum.solution(new int[]{1, 2, 3, 4}));
    assertEquals(6, maxDoubleSliceSum.solution(new int[]{1, 2, 3, 4, 5}));
    assertEquals(17, maxDoubleSliceSum.solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
    assertEquals(17, maxDoubleSliceSum.solution(new int[]{5, 17, 0, 3}));
  }
}