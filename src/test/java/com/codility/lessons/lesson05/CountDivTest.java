package com.codility.lessons.lesson05;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CountDivTest {

  private CountDiv countDiv;

  @Before
  public void setUp() {
    countDiv = new CountDiv();
  }

  @Test
  public void testSolution() {
    assertEquals(6, countDiv.solution(6, 11, 1));
    assertEquals(3, countDiv.solution(6, 11, 2));
    assertEquals(2, countDiv.solution(6, 11, 3));
    assertEquals(1, countDiv.solution(6, 11, 5));
    assertEquals(1, countDiv.solution(6, 11, 7));
    assertEquals(0, countDiv.solution(6, 11, 12));

    assertEquals(2, countDiv.solution(50, 100, 50));
    assertEquals(1, countDiv.solution(50, 51, 50));

    assertEquals(1, countDiv.solution(1999999999, 2000000000, 2000000000));
    assertEquals(2, countDiv.solution(1000000000, 2000000000, 1000000000));

    // codility check
    assertEquals(20, countDiv.solution(11, 345, 17));
    assertEquals(1, countDiv.solution(0, 0, 11));
    assertEquals(1, countDiv.solution(0, 1, 11));
    assertEquals(1, countDiv.solution(10, 10, 5));
    assertEquals(0, countDiv.solution(10, 10, 7));
    assertEquals(0, countDiv.solution(10, 10, 20));
    assertEquals(2000000001, countDiv.solution(0, 2000000000, 1));
    assertEquals(2, countDiv.solution(0, 2000000000, 2000000000));
  }
}
