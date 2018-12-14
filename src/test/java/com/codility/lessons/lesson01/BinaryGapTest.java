package com.codility.lessons.lesson01;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinaryGapTest {

  private BinaryGap binaryGap;

  @Before
  public void setUp() {
    binaryGap = new BinaryGap();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSolution_ZeroValue() {
    binaryGap.solution(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSolution_NegativeValue() {
    binaryGap.solution(-1);
  }

  @Test
  public void testSolution() {
    assertEquals(0, binaryGap.solution(4));
    assertEquals(2, binaryGap.solution(9));
    assertEquals(4, binaryGap.solution(529));
    assertEquals(1, binaryGap.solution(20));
    assertEquals(0, binaryGap.solution(15));
    assertEquals(5, binaryGap.solution(1041));
    assertEquals(0, binaryGap.solution(2147483647));
  }
}
