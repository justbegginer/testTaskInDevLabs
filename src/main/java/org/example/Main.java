package org.example;


public class Main {
    // The description of the task is not very accurate,
    // in some places the missing number is indicated as a single element in the sequence -
    // "Given array of sequent numbers 0,1,2,3...N with missing member",
    // and somewhere there are hints of the presence of several missing values - "Function finds a first missing number..."
    // The code will be written based on the assumption that there is ONLY ONE missing element
    // TEST CONTAINS IN TEST DIRECTORY
    public static int findMissingNumber(int[] nums) {
        if (nums.length == 1) {
            throw new IllegalArgumentException("There is only one number. It is impossible to determine the missing number.");
        }
        if (nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty.");
        }
        int actualSum = 0;
        int min = nums[0];
        int max = min;


        // Calculate the actual sum of elements in the array
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            actualSum += num;
        }


        // Calculate the expected sum of numbers from min to max
        int expectedSum = (max + min) * (nums.length + 1) / 2;
        // The missing number is the difference between expected and actual sum
        return expectedSum - actualSum;
    }
}