package com.codility.lessons.lesson08;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DominatorTest {

  private Dominator dominator;

  @Before
  public void setUp() {
    dominator = new Dominator();
  }

  @Test
  public void solution() {
    assertEquals(-1, dominator.solution(new int[0]));
    assertEquals(-1, dominator.solution(new int[]{1, 2, 3}));

    final int result = dominator.solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3});
    assertTrue(result + "", asList(0, 2, 4, 6, 7).contains(result));
  }
}