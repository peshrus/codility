package com.codility.lessons.lesson06;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DistinctTest {

  private Distinct distinct;

  @Before
  public void setUp() {
    distinct = new Distinct();
  }

  @Test
  public void testSolution() {
    assertEquals(3, distinct.solution(new int[]{2, 1, 1, 2, 3, 1}));
    assertEquals(0, distinct.solution(new int[]{}));
    assertEquals(1, distinct.solution(new int[]{1}));
    assertEquals(1, distinct.solution(new int[]{1, 1, 1, 1, 1, 1}));

    final int[] arr = new int[100000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i - arr.length / 2;
    }
    assertEquals(arr.length, distinct.solution(arr));
  }
}
