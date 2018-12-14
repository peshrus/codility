package com.codility.lessons.lesson05;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class GenomicRangeQueryTest {

  private GenomicRangeQuery genomicRangeQuery;

  @Before
  public void setUp() {
    genomicRangeQuery = new GenomicRangeQuery();
  }

  @Test
  public void testSolution() {
    assertArrayEquals(new int[]{2, 4, 1},
        genomicRangeQuery.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    assertArrayEquals(new int[]{1}, genomicRangeQuery.solution("A", new int[]{0}, new int[]{0}));
    assertArrayEquals(new int[]{2}, genomicRangeQuery.solution("C", new int[]{0}, new int[]{0}));
    assertArrayEquals(new int[]{3}, genomicRangeQuery.solution("G", new int[]{0}, new int[]{0}));
    assertArrayEquals(new int[]{4}, genomicRangeQuery.solution("T", new int[]{0}, new int[]{0}));

    // codility check
    assertArrayEquals(new int[]{1, 1, 2},
        genomicRangeQuery.solution("AC", new int[]{0, 0, 1}, new int[]{0, 1, 1}));
  }
}
