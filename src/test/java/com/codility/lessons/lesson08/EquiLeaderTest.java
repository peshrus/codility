package com.codility.lessons.lesson08;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EquiLeaderTest {

  private EquiLeader equiLeader;

  @Before
  public void setUp() {
    equiLeader = new EquiLeader();
  }

  @Test
  public void solution() {
    assertEquals(0, equiLeader.solution(new int[0]));
    assertEquals(0, equiLeader.solution(new int[]{4}));
    assertEquals(1, equiLeader.solution(new int[]{-1000000000, -1000000000}));
    assertEquals(1, equiLeader.solution(new int[]{4, 4}));
    assertEquals(2, equiLeader.solution(new int[]{4, 4, 4}));
    assertEquals(0, equiLeader.solution(new int[]{4, 3, 4, 4, 4, 2, 3}));
    assertEquals(0, equiLeader.solution(new int[]{4, 3, 4, 4, 4, 2, 3, 3}));
    assertEquals(2, equiLeader.solution(new int[]{4, 3, 4, 4, 4, 2}));
    assertEquals(3, equiLeader.solution(new int[]{4, 4, 2, 5, 3, 4, 4, 4}));
    assertEquals(3, equiLeader.solution(new int[]{1, 2, 1, 1, 2, 1}));
    assertEquals(2, equiLeader.solution(new int[]{2, 1, 1, 1, 2, 1}));
  }
}