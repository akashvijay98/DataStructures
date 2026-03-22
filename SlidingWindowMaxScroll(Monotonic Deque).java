// 239. Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];


        int index= 0;

        for(int right=0;right<n;right++){

            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[right]){
                dq.pollLast();
            }

            dq.addLast(right);

            while(dq.peekFirst()<right-k+1){
                dq.pollFirst();
            }

            if(right>=k-1){
                res[index++]= nums[dq.peekFirst()];
            }

           
        }

        return res;
    }
}

// 2398. Maximum Number of Robots Within Budget
class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> dq = new ArrayDeque<>();
        long  currentSum = 0;
        int n = chargeTimes.length;
        int left=0;

        int maxRobots = 0;

        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && chargeTimes[dq.peekLast()]<=chargeTimes[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            currentSum+=runningCosts[i];


            while(!dq.isEmpty() && chargeTimes[dq.peek()] + (long)(i-left+1) * currentSum > budget){
                currentSum-= runningCosts[left];
              
                if(dq.peekFirst() == left){
                    dq.pollFirst();
                }

                left++;

            }

            maxRobots = Math.max(maxRobots, i-left+1);


        }

        return maxRobots;
    }
}

// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq= new ArrayDeque<>();
        Deque<Integer> minDq= new ArrayDeque<>();

        int n= nums.length;

        int left =0;

        int maxLen=0;

        for(int right = 0; right<n;right++){
            while(!maxDq.isEmpty() && nums[maxDq.peekLast()]<=nums[right]){
                maxDq.pollLast();
            }
            maxDq.addLast(right);


            while(!minDq.isEmpty() && nums[minDq.peekLast()]>=nums[right]){
                minDq.pollLast();
            }
            minDq.addLast(right);

            while(nums[maxDq.peekFirst()]- nums[minDq.peekFirst()]>limit){

                if(!maxDq.isEmpty() && left == maxDq.peekFirst()){
                    maxDq.pollFirst();
                }

                if(!minDq.isEmpty() && minDq.peekFirst()==left){
                    minDq.pollFirst();
                }

                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);

        }

        return maxLen;
    }
}

/*
Question 1: Warehouse Robots with Threshold

Problem Description
You are given an integer array arr of size n, where arr[i] represents the threshold of the i-th robot.
Each robot can be assigned one of two states:
Running
Waiting
A configuration is valid if all robots satisfy the following conditions:
If a robot is Running, then the total number of running robots must be ≥ arr[i]
If a robot is Waiting, then the total number of waiting robots must be < arr[i]

Task
Return the total number of valid configurations.

Constraints
Each robot must be assigned exactly one state.
A configuration is valid only if no robot violates its condition.
*/


import java.util.Arrays;

public class RobotConfiguration {
    /**
     * Counts valid configurations based on the number of robots in 'Running' state.
     * @param arr Array of robot thresholds
     * @return Number of valid configurations
     */
    public static int countValidConfigurations(int[] arr) {
        // Sort the array to easily check boundary conditions
        Arrays.sort(arr);
        int n = arr.length;
        int validCount = 0;

        // R is the number of robots we choose to put in 'Running' state
        for (int R = 0; R <= n; R++) {
            
            // 1. Check Running Condition: 
            // For all running robots i, R >= arr[i].
            // Since arr is sorted, we only check the robot with the largest threshold 
            // among the first R robots (index R-1).
            boolean runningOk = true;
            if (R > 0) {
                if (arr[R - 1] > R) {
                    runningOk = false;
                }
            }

            // 2. Check Waiting Condition:
            // For all waiting robots i, (n - R) < arr[i].
            // Since arr is sorted, we check the robot with the smallest threshold 
            // among the remaining robots (index R).
            boolean waitingOk = true;
            if (R < n) {
                if ((n - R) >= arr[R]) {
                    waitingOk = false;
                }
            }

            if (runningOk && waitingOk) {
                validCount++;
            }
        }

        return validCount;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] robots = {1, 2, 0};
        System.out.println("Valid configurations: " + countValidConfigurations(robots));
    }
}
