package com.codility.lessons.lesson05;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class PassingCarsTest {

  private PassingCars passingCars;

  @Before
  public void setUp() {
    passingCars = new PassingCars();
  }

  @Test
  public void testSolution() {
    assertEquals(5, passingCars.solution(new int[]{0, 1, 0, 1, 1}));
    assertEquals(0, passingCars.solution(new int[]{0}));
    assertEquals(0, passingCars.solution(new int[]{1}));
    assertEquals(0, passingCars.solution(new int[]{1, 0}));
    assertEquals(1, passingCars.solution(new int[]{0, 1}));
    assertEquals(0, passingCars.solution(new int[]{1, 1, 1, 1, 1}));
    assertEquals(4, passingCars.solution(new int[]{0, 1, 1, 1, 1}));
    assertEquals(0, passingCars.solution(new int[]{1, 1, 1, 1, 0}));
    assertEquals(2, passingCars.solution(new int[]{1, 1, 0, 1, 1}));
    assertEquals(6, passingCars.solution(new int[]{0, 1, 0, 1, 0, 1}));
    assertEquals(7, passingCars.solution(new int[]{0, 1, 0, 1, 1, 1}));

    // Performance test 1 without check
    final int[] testArr1 = new int[100000];
    for (int i = 0; i < testArr1.length; i++) {
      testArr1[i] = 0;
    }
    passingCars.solution(testArr1);

    // Performance test 2 without check
    final int[] testArr2 = new int[100000];
    for (int i = 0; i < testArr2.length; i++) {
      testArr2[i] = 0;
    }
    passingCars.solution(testArr2);

    // Performance test 3 without check
    final int[] testArr3 = new int[100000];
    for (int i = 0; i < testArr3.length; i++) {
      testArr3[i] = i % 2;
    }
    passingCars.solution(testArr3);

    // Performance test 4 without check
    final int[] testArr4 = new int[100000];
    final Random random = new Random();
    for (int i = 0; i < testArr4.length; i++) {
      testArr4[i] = random.nextInt(2);
    }
    passingCars.solution(testArr4);
  }
}