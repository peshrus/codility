package com.codility.lessons.lesson10;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinPerimeterRectangleTest {

  private MinPerimeterRectangle minPerimeterRectangle = new MinPerimeterRectangle();

  @Test
  public void solution() {
    assertEquals(0, minPerimeterRectangle.solution(-1));
    assertEquals(0, minPerimeterRectangle.solution(0));
    assertEquals(4, minPerimeterRectangle.solution(1));
    assertEquals(6, minPerimeterRectangle.solution(2));
    assertEquals(8, minPerimeterRectangle.solution(3));
    assertEquals(22, minPerimeterRectangle.solution(30));
    assertEquals(24, minPerimeterRectangle.solution(36));
    assertEquals(204, minPerimeterRectangle.solution(101));
    assertEquals(1238, minPerimeterRectangle.solution(1_234));
    assertEquals(30_972_904, minPerimeterRectangle.solution(15_486_451));
    assertEquals(40_000, minPerimeterRectangle.solution(100_000_000));
    assertEquals(1_964_903_308, minPerimeterRectangle.solution(982_451_653));
  }
}