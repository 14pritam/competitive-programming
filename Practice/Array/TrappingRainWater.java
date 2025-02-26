package Practice.Array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {1, 0, 3, 0, 1, 2};
        trap(height);
    }
        public static int trap(int[] height) {
            if (height == null || height.length == 0) return 0;

            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int water = 0;

            while (left < right) {
                System.out.println("Step:");
                System.out.println("Array: 1, 0, 3, 0, 1, 2");
                System.out.println("Left Pointer: " + left + ", Right Pointer: " + right);
                System.out.println("Height[L]: " + height[left] + ", Height[R]: " + height[right]);
                System.out.println("LeftMax: " + leftMax + ", RightMax: " + rightMax);

                if (height[left] < height[right]) {
                    if (height[left] >= leftMax) {
                        leftMax = height[left];
                        System.out.println("Updated LeftMax: " + leftMax);
                    } else {
                        water += leftMax - height[left];
                        System.out.println("Water Added: leftmax - height[left] :: " + (leftMax - height[left]));
                    }
                    left++;
                } else {
                    if (height[right] >= rightMax) {
                        rightMax = height[right];
                        System.out.println("Updated RightMax: " + rightMax);
                    } else {
                        water += rightMax - height[right];
                        System.out.println("Water Added: rightMax - height[right] :: " + (rightMax - height[right]));
                    }
                    right--;
                }

                System.out.println("Total Water Collected So Far: " + water);
                System.out.println("------------------------------------");
            }

            System.out.println("Total Trapped Water: " + water);
            return water;
        }


    }
