/*


roblem: Horizontally Scaling Servers
Problem Statement
AWS provides a set of n servers used for horizontally scaling an application. Each server has a specific computational power. The goal is to have the computational power of the servers in non-decreasing order to ensure system stability.

To achieve this, you can perform the following operation any number of times:

Choose any contiguous segment of servers.

Increase the computational power of each server in that segment by a chosen amount x.

Your task is to determine the minimum total cost to make the server powers non-decreasing. The total cost is the sum of all the x values used across all operations.

Input Format
The first line of input is an integer n, representing the number of servers.

The second line of input contains n space-separated integers, representing the initial computational power of each server.

Output Format
A single integer representing the minimum total cost (the sum of all x values) required to make the array of server powers non-decreasing.

Examples
Example 1
Input:

5
3 4 1 6 2
Output:

7
Explanation: A series of operations are performed to make the array non-decreasing. The final arrangement can be [3, 4, 4, 9, 9]. The minimum cost to achieve a non-decreasing order is 7.

Example 2
Input:

3
3 2 1
Output:

2
Explanation: Add 1 unit to the subarray from the second to the third server, making the array [3, 3, 2]. Then, add 1 unit to the third server, making the final arrangement [3, 3, 3]. The total cost is 1 + 1 = 2.

Example 3
Input:

4
3 5 2 3
Output:

3
Explanation: Add 3 units to the subarray from the third to the fourth server. The powers become [3, 5, 2+3, 3+3] which is [3, 5, 5, 6]. This is non-decreasing and the cost is 3.

*/


def getMinimumCost(power):
    """
    Calculates the minimum cost to make the power array non-decreasing.

    Args:
      power: A list of integers representing the computational power of servers.

    Returns:
      An integer representing the minimum total cost.
    """
    n = len(power)
    if n == 0:
        return 0

    total_cost = 0
    # carry tracks the sum of increases from operations started before the current index.
    carry = 0
    # max_val tracks the maximum value in the final, modified array seen so far.
    max_val = 0

    for p in power:
        # The effective power after considering increases from previous operations.
        effective_power = p + carry

        if effective_power < max_val:
            # The element is still too small, so we need a new increase.
            increase_needed = max_val - effective_power
            total_cost += increase_needed
            carry += increase_needed
            # After this increase, the element's final value becomes max_val.
            # max_val itself does not change in this case.
        else:
            # The element is large enough and becomes the new maximum.
            max_val = effective_power

    return total_cost

# Example from the problem description:
power_values = [3, 5, 2, 3]
cost = getMinimumCost(power_values)
print(f"The minimum cost is: {cost}")
# Expected output: The minimum cost is: 3
