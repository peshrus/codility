package com.codility.lessons.lesson07;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StoneWallTest {

  private StoneWall stoneWall;

  @Before
  public void setUp() {
    stoneWall = new StoneWall();
  }

  @Test
  public void solution() {
    assertEquals(0, stoneWall.solution(new int[0]));
    assertEquals(1, stoneWall.solution(new int[]{8}));
    assertEquals(1, stoneWall.solution(new int[]{8, 8}));
    assertEquals(6, stoneWall.solution(new int[]{8, 8, 5, 7, 9, 10, 7, 5, 8}));
    assertEquals(7, stoneWall.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
  }
}