package com.codility.lessons.lesson07;

import java.util.Stack;

/**
 * You are going to build a stone wall. The wall should be straight and N meters long, and its
 * thickness should be constant; however, it should have different heights in different places. The
 * height of the wall is specified by an array H of N positive integers. H[I] is the height of the
 * wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the
 * wall's left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are
 * rectangular). Your task is to compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] H); }
 * <p>
 * that, given an array H of N positive integers specifying the height of the wall, returns the
 * minimum number of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 * <p>
 * Created on 11.09.2018
 *
 * @author Ruslan Peshchuk (peshrus@gmail.com)
 * @see <a href="https://app.codility.com/demo/results/trainingBNAYBS-KQX/?showingAll=1">The first
 *     result</a>
 */
public class StoneWall {

  public int solution(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    int result = 1;
    final Stack<Integer> prevLowerHeights = new Stack<>();

    for (int i = 1; i < heights.length; i++) {
      final int height = heights[i];
      final int prevHeight = heights[i - 1];

      if (height != prevHeight) {
        ++result;

        if (height > prevHeight) {
          prevLowerHeights.push(prevHeight);
        } else {
          while (!prevLowerHeights.empty() && prevLowerHeights.peek() >= height) {
            if (prevLowerHeights.pop() == height) {
              --result;
            }
          }
        }
      }
    }

    return result;
  }
}
