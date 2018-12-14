package com.codility.lessons.lesson04;

import static org.junit.Assert.assertArrayEquals;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class MaxCountersTest {

  private MaxCounters maxCounters;

  @Before
  public void setUp() {
    maxCounters = new MaxCounters();
  }

  @Test
  public void testSolution() {
    assertArrayEquals(new int[]{3, 2, 2, 4, 2},
        maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    assertArrayEquals(new int[]{3}, maxCounters.solution(1, new int[]{1, 1, 2, 1}));
    assertArrayEquals(new int[]{4}, maxCounters.solution(1, new int[]{1, 1, 1, 1}));
    assertArrayEquals(new int[]{1, 0, 1, 4, 0},
        maxCounters.solution(5, new int[]{6, 4, 4, 3, 1, 4, 4}));
    assertArrayEquals(new int[]{4, 4, 4, 4, 4},
        maxCounters.solution(5, new int[]{3, 4, 4, 4, 1, 4, 6}));
    assertArrayEquals(new int[]{2, 2, 2, 3, 2},
        maxCounters.solution(5, new int[]{3, 4, 6, 4, 1, 6, 4}));
    assertArrayEquals(new int[]{3, 3, 3, 4, 3},
        maxCounters.solution(5, new int[]{3, 4, 1, 1, 6, 4, 1, 6, 4}));
    assertArrayEquals(new int[]{0, 0, 1, 0, 0}, maxCounters.solution(5, new int[]{3}));
    assertArrayEquals(new int[]{0, 0, 0, 0, 0}, maxCounters.solution(5, new int[]{6}));
    assertArrayEquals(new int[]{1, 1, 1, 4, 0},
        maxCounters.solution(5, new int[]{3, 4, 4, 2, 1, 4, 4}));

    // Performance test 1 without check
    final int[] testArr = new int[100000];
    final Random random = new Random();
    for (int i = 0; i < testArr.length; i++) {
      testArr[i] = random.nextInt(testArr.length + 2);
    }
    maxCounters.solution(testArr.length, testArr);

    // Performance test 2 without check
    final int[] testArr2 = new int[100000];
    for (int i = 0; i < testArr2.length; i++) {
      testArr2[i] = testArr2.length + 1;
    }
    maxCounters.solution(testArr2.length, testArr2);
  }
}