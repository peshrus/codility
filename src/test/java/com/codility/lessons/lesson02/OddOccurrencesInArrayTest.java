package com.codility.lessons.lesson02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OddOccurrencesInArrayTest {

  private OddOccurrencesInArray oddOccurrencesInArray;

  @Before
  public void setUp() {
    oddOccurrencesInArray = new OddOccurrencesInArray();
  }

  @Test
  public void testSolution() {
    assertEquals(7, oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
  }
}