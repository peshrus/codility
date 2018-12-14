package com.codility.lessons.lesson06;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NumberOfDiscIntersectionsTest {

  private NumberOfDiscIntersections numberOfDiscIntersections;

  @Before
  public void setUp() {
    numberOfDiscIntersections = new NumberOfDiscIntersections();
  }

  @Test
  public void testSolution() {
    assertEquals(11, numberOfDiscIntersections.solution(new int[]{1, 5, 2, 1, 4, 0}));
    assertEquals(3, numberOfDiscIntersections.solution(new int[]{1, 1, 1}));
    assertEquals(1,
        numberOfDiscIntersections.solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}));
  }
}
