package com.codility.lessons.lesson03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PermMissingElemTest {

  private PermMissingElem permMissingElem;

  @Before
  public void setUp() {
    permMissingElem = new PermMissingElem();
  }

  @Test
  public void testSolution() {
    assertEquals(4, permMissingElem.solution(new int[]{2, 3, 1, 5}));
  }

  @Test
  public void testSolution_Large() {
    final int[] testData = new int[100000];
    for (int i = 0; i < testData.length; i++) {
      if (i != 10000) {
        testData[i] = i + 1;
      } else {
        testData[i] = testData.length + 1;
      }
    }
    assertEquals(10001, permMissingElem.solution(testData));
  }
}