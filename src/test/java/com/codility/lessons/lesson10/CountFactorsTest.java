package com.codility.lessons.lesson10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountFactorsTest {

  private CountFactors countFactors = new CountFactors();

  @Test
  public void solution() {
    assertEquals(0, countFactors.solution(-1));
    assertEquals(0, countFactors.solution(0));
    assertEquals(1, countFactors.solution(1));
    assertEquals(2, countFactors.solution(2));
    assertEquals(2, countFactors.solution(3));
    assertEquals(3, countFactors.solution(4));
    assertEquals(2, countFactors.solution(5));
    assertEquals(4, countFactors.solution(6));
    assertEquals(2, countFactors.solution(7));
    assertEquals(4, countFactors.solution(8));
    assertEquals(3, countFactors.solution(9));
    assertEquals(8, countFactors.solution(24));
  }

  @Test(timeout = 6000)
  public void solution_long_1() {
    assertEquals(2, countFactors.solution(Integer.MAX_VALUE));
  }

  @Test(timeout = 1)
  public void solution_long_2() {
    assertEquals(2, countFactors.solution(780291637));
  }
}