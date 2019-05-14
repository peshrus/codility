package com.codility.lessons.lesson10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PeaksTest {

  private Peaks peaks = new Peaks();

  @Test
  public void solution() {
    assertEquals(0, peaks.solution(null));
    assertEquals(0, peaks.solution(new int[0]));
    assertEquals(0, peaks.solution(new int[]{1}));
    assertEquals(0, peaks.solution(new int[]{1, 2}));
    assertEquals(0, peaks.solution(new int[]{1, 2, 3}));
    // (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2)
    assertEquals(3, peaks.solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    assertEquals(1, peaks.solution(new int[]{1, 4, 3, 2}));
    assertEquals(1, peaks.solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 2, 2, 2, 2}));
    assertEquals(1, peaks.solution(new int[]{0, 1000000000, 0}));
    assertEquals(0, peaks.solution(new int[]{0, 0, 0}));
  }
}