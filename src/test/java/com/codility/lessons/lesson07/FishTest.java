package com.codility.lessons.lesson07;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FishTest {

  private Fish fish;

  @Before
  public void setUp() {
    fish = new Fish();
  }

  @Test
  public void solution() {
    assertEquals(0, fish.solution(new int[0], new int[0]));
    assertEquals(1, fish.solution(new int[]{4, 3}, new int[]{1, 0}));
    assertEquals(2, fish.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    assertEquals(5, fish.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 0, 0, 0, 0}));
    assertEquals(5, fish.solution(new int[]{4, 3, 2, 1, 5}, new int[]{1, 1, 1, 1, 1}));
    assertEquals(1, fish.solution(new int[]{6, 3, 2, 1, 5}, new int[]{1, 1, 0, 0, 0}));
    assertEquals(2, fish.solution(new int[]{4, 5, 2, 1, 3}, new int[]{0, 1, 0, 0, 0}));
  }
}