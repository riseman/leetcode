package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


// @see https://leetcode.com/problems/two-sum/
public class TwoSumTests {

    @Test
    public void case1() {
        assertArrayEquals(new int[] {0,1}, twoSum(new int[] {2,7,11,15}, 9));
    }

    @Test
    public void case2() {
        assertArrayEquals(new int[] {1,2}, twoSum(new int[] {3,2,4}, 6));
    }

    @Test
    public void case3() {
        assertArrayEquals(new int[] {0,1}, twoSum(new int[] {3,3}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int first = 0; first < nums.length; first++)
            for (int second = first + 1; second < nums.length; second++)
                if (target == (nums[first] + nums[second]))
                    return new int[] {first, second};

        throw new RuntimeException("Not found");
    }
}
