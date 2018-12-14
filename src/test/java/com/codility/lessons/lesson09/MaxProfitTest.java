package com.codility.lessons.lesson09;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxProfitTest {

  private MaxProfit maxProfit;

  @Before
  public void setUp() {
    maxProfit = new MaxProfit();
  }

  @Test
  public void solution() {
    assertEquals(0, maxProfit.solution(null));
    assertEquals(0, maxProfit.solution(new int[0]));
    assertEquals(0, maxProfit.solution(new int[]{23171}));
    assertEquals(0, maxProfit.solution(new int[]{23171, 21011}));
    assertEquals(2160, maxProfit.solution(new int[]{21011, 23171}));
    assertEquals(356, maxProfit.solution(new int[]{23171, 21013, 21123, 21366, 21011, 21367}));
    assertEquals(356, maxProfit.solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
  }
}