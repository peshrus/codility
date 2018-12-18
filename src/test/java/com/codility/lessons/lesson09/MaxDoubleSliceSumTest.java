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
    assertEquals(7, maxDoubleSliceSum.solution(new int[]{1, 2, 3, 4, 5}));
    assertEquals(17, maxDoubleSliceSum.solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
    assertEquals(17, maxDoubleSliceSum.solution(new int[]{5, 17, 0, 3}));
    assertEquals(10, maxDoubleSliceSum.solution(new int[]{0, 10, -5, -2, 0}));
    assertEquals(30, maxDoubleSliceSum.solution(new int[]{-8, 10, 20, -5, -7, -4}));
    assertEquals(0, maxDoubleSliceSum.solution(new int[]{-4, -5, -1, -5, -7, -19, -11}));
    assertEquals(1, maxDoubleSliceSum.solution(new int[]{-2, -3, -4, 1, -5, -6, -7}));
    assertEquals(18, maxDoubleSliceSum.solution(new int[]{3, 2, 6, 1, 4, 5, -1, 2}));
    assertEquals(18, maxDoubleSliceSum.solution(new int[]{3, 2, 6, -1, 4, 5, 1, 2}));
    assertEquals(17, maxDoubleSliceSum.solution(new int[]{3, 2, 6, -1, 4, 5, -2, 2}));
    assertEquals(18, maxDoubleSliceSum.solution(new int[]{3, -1, 2, 6, 4, 5, 1, 2}));
    assertEquals(17, maxDoubleSliceSum.solution(new int[]{3, -1, 2, 6, 4, 5, -1, 2}));
  }
}