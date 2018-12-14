package com.codility.lessons.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PrefixSetTest {

  private PrefixSet prefixSet;

  @Before
  public void setUp() {
    prefixSet = new PrefixSet();
  }

  @Test
  public void testSolution() {
    assertEquals(3, prefixSet.solution(new int[]{2, 2, 1, 0, 1}));
    assertEquals(0, prefixSet.solution(new int[]{0}));
    assertEquals(1, prefixSet.solution(new int[]{0, 1}));
    assertEquals(1, prefixSet.solution(new int[]{1, 0}));
    assertEquals(1, prefixSet.solution(new int[]{1, 0, 1}));

    final int[] arr = new int[1000000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    assertEquals(arr.length - 1, prefixSet.solution(arr));
  }
}
