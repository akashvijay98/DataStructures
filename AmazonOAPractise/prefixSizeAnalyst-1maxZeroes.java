/*

 Problem: Maximizing Zeroes
Problem Statement
You are given an array of positive integers, sequenceData. Your goal is to find the maximum number of zeroes you can introduce into this array by applying a specific operation any number of times.

The operation is as follows:

Choose a prefix of the array (e.g., the first s elements).

The chosen prefix must not contain any zeros.

Subtract 1 from every element in that chosen prefix.

You must perform these operations without ever causing an element in the array to become negative.

Input Format
The first line of input is an integer n, representing the number of elements in the array.

The second line of input contains n space-separated integers, representing the elements of the array sequenceData.

Output Format
A single integer representing the maximum number of zeroes that can be achieved in the final array.

Constraints
1≤n≤2⋅10 
5
 

1≤sequenceData[i]≤10 
9
 

Examples
Example 1
Input:

5
4 3 5 5 3
Output:

3
Explanation: It's possible to perform a series of prefix decrements to turn three elements of the array into zero. One such valid set of elements that can be turned to zero is at indices {1, 2, 4} (corresponding to original values {3, 5, 3}), resulting in a maximum of 3 zeroes.

Example 2
Input:

4
3 1 2 4
Output:

2
Explanation: The longest valid sequence of elements that can be turned to zero are at indices {0, 1} (corresponding to values {3, 1}). This allows for a maximum of 2 zeroes. A possible final array could be [0, 0, 1, 3].

*/


def getMaxZeroes(sequenceData):
    """
    Calculates the maximum number of zeroes achievable based on the described operations.

    Args:
      sequenceData: A list of positive integers.

    Returns:
      The maximum number of zeroes that can be achieved.
    """
    n = len(sequenceData)
    if n == 0:
        return 0

    # dp[i] will store the length of the longest valid sequence ending at index i.
    dp = [0] * n

    for i in range(n):
        max_prev_dp = 0
        # Find the best predecessor j for i.
        for j in range(i):
            # Condition 1: The value at the predecessor must be greater or equal.
            if sequenceData[j] >= sequenceData[i]:
                # Condition 2: All values between j and i must be greater or equal to the value at i.
                is_valid_predecessor = True
                for k in range(j + 1, i):
                    if sequenceData[k] < sequenceData[i]:
                        is_valid_predecessor = False
                        break
                
                if is_valid_predecessor:
                    max_prev_dp = max(max_prev_dp, dp[j])
        
        # The length of the sequence ending at i is 1 (for itself) + the length of the best preceding sequence.
        dp[i] = 1 + max_prev_dp

    # The result is the maximum length of any valid sequence.
    return max(dp) if dp else 0

# Example usage:
n = 5
sequenceData = [4, 3, 5, 5, 3]
result = getMaxZeroes(sequenceData)
print(f"For sequence {sequenceData}, the maximum number of zeroes is: {result}")
# Expected output: For sequence [4, 3, 5, 5, 3], the maximum number of zeroes is: 3












