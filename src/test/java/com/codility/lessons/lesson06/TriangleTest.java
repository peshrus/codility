package com.codility.lessons.lesson06;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

  private Triangle triangle;

  @Before
  public void setUp() {
    triangle = new Triangle();
  }

  @Test
  public void testSolution() {
    assertEquals(1, triangle.solution(new int[]{10, 2, 5, 1, 8, 20}));
    assertEquals(0, triangle.solution(new int[]{10, 50, 5, 1}));
    assertEquals(0, triangle.solution(new int[]{}));
    assertEquals(0, triangle.solution(new int[]{1}));
    assertEquals(0, triangle.solution(new int[]{1, 2}));
    assertEquals(0, triangle.solution(new int[]{1, 2, 3}));
    assertEquals(1, triangle.solution(new int[]{10, 5, 8}));
    assertEquals(1, triangle.solution(new int[]{10, 8, 2, 5, 10, 1, 8, 20, 5}));
    assertEquals(1, triangle.solution(
        new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE,
            Integer.MAX_VALUE - 2, Integer.MAX_VALUE}));
  }
}
