// 1. get max frequency until index i 
public int getMaximumCategoryMaxCount(String s) {
    int[] freq = new int[26]; // frequency of each character
    int[] categoryMaxCount = new int[26]; // result per character
    
    int maxFreq = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        int idx = c - 'a';
        
        freq[idx]++;
        
        // update current max frequency
        if (freq[idx] > maxFreq) {
            maxFreq = freq[idx];
        }
        
        // for all characters, if its freq == maxFreq, it’s a leader
        for (int j = 0; j < 26; j++) {
            if (freq[j] == maxFreq) {
                categoryMaxCount[j]++;
            }
        }
    }

    // return the max CategoryMaxCount
    int maxCount = 0;
    for (int count : categoryMaxCount) {
        maxCount = Math.max(maxCount, count);
    }

    return maxCount;
}
// 2. get dna Sequence

/*
We don’t care about exact frequencies, we just need to check:

“Do s1 and s2 share at least one common character?”
*/

import java.util.*;

public class Solution {

    public boolean[] getSequence(List<List<String>> dnaPairs) {
        boolean[] result = new boolean[dnaPairs.size()];
        int index = 0;

        for (List<String> pair : dnaPairs) {
            String s1 = pair.get(0);
            String s2 = pair.get(1);

            boolean[] seen = new boolean[26];
            for (char c : s1.toCharArray()) {
                seen[c - 'a'] = true;
            }

            boolean isSimilar = false;
            for (char c : s2.toCharArray()) {
                if (seen[c - 'a']) {
                    isSimilar = true;
                    break;
                }
            }

            result[index++] = isSimilar;
        }

        return result;
    }

    // main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> testPairs = Arrays.asList(
            Arrays.asList("abc", "cab"),      // true
            Arrays.asList("abc", "xyz"),      // false
            Arrays.asList("aabb", "abcc"),    // true
            Arrays.asList("aaa", "bbb"),      // false
            Arrays.asList("", ""),            // false
            Arrays.asList("a", "")            // false
        );

        boolean[] results = sol.getSequence(testPairs);

        System.out.println("Similar DNA Pairs:");
        for (int i = 0; i < results.length; i++) {
            System.out.println("Pair " + (i + 1) + ": " + results[i]);
        }
    }
}




// 3. Pairs of Candidates / Get Number of Teams
import java.util.*;

public class Solution {

    public long getNumTeams(int[] skill, int min_skill, int max_skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long count = 0;

        for (int i = 0; i < n - 1; i++) {
            int low = lowerBound(skill, i + 1, n - 1, min_skill - skill[i]);
            int high = upperBound(skill, i + 1, n - 1, max_skill - skill[i]);

            count += (high - low + 1);
        }

        return count;
    }

    // Returns index of first element >= target
    private int lowerBound(int[] arr, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Returns index of last element <= target
    private int upperBound(int[] arr, int left, int right, int target) {
        int ans = left - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] skill = {2, 3, 4, 5};
        int min_skill = 5;
        int max_skill = 7;

        long result = sol.getNumTeams(skill, min_skill, max_skill);
        System.out.println("Number of valid teams: " + result); // Output: 4
    }
}

// 4. Minimum Total Packaging Effort

import java.util.*;

public class Solution {
    public int minimumPackagingEffort(int[] packEffort, int[] packageCount) {
        Arrays.sort(packEffort);
        Arrays.sort(packageCount);

        int left = 0;                       // Pointer to smallest effort item (for free picks)
        int right = packEffort.length - 1;  // Pointer to largest effort item

        for (int i = 0; i < packageCount.length && right - left + 1 >= packageCount[i]; i++) {
            int k = packageCount[i];  // number of paid items

            // Get min among the k paid items
            int minPaidEffort = packEffort[right - k + 1];

            // Move 'right' pointer left by k items (those are paid)
            right -= k;

            // Try to take 2 free items (from the left) with effort <= minPaidEffort
            for (int j = 0; j < 2 && left <= right; j++) {
                if (packEffort[left] <= minPaidEffort) {
                    left++;  // take it as free
                } else {
                    break;   // can't pick more free items
                }
            }
        }

        // All remaining items are paid for
        int totalEffort = 0;
        for (int i = left; i <= right; i++) {
            totalEffort += packEffort[i];
        }

        return totalEffort;
    }

    // Sample usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] packEffort = {50, 50, 30, 50, 20};
        int[] packageCount = {2, 3};
        System.out.println(sol.minimumPackagingEffort(packEffort, packageCount)); // Output: 120
    }
}

// 5. get min subsegments 

/*
    "1110011000" → becomes: 11, 10, 01, 10, 00
    
    After flips: becomes 11, 11, 11, 11, 00
    
    So normalized = "11110" (1 char per pair)
*/

public class Segmentify {

    public static int getminSubsegments(String frames) {
        int n = frames.length();
        StringBuilder normalized = new StringBuilder(); // stores each normalized segment after flip
        int flips = 0;

        for (int i = 0; i < n; i += 2) {
            char a = frames.charAt(i);
            char b = frames.charAt(i + 1);

            if (a == b) {
                // No flip needed, both characters are same
                normalized.append(a);
            } else {
                // Flip one character to make them equal (choose '1' for consistency)
                flips++;
                normalized.append('1'); // or '0', doesn't matter as long as consistent
            }
        }

        // Now merge consecutive same segments (i.e., same character in normalized string)
        int segments = 1; // start with first segment
        for (int i = 1; i < normalized.length(); i++) {
            if (normalized.charAt(i) != normalized.charAt(i - 1)) {
                segments++;
            }
        }

        return segments;
    }

    public static void main(String[] args) {
        System.out.println(getminSubsegments("1110011000")); // Output: 2
        System.out.println(getminSubsegments("110011"));      // Output: 3
        System.out.println(getminSubsegments("100110"));      // Output: 1
    }
}


//4. find security level - Modular Hashing over Prefix Sums 
// similar to https://leetcode.com/problems/continuous-subarray-sum/description/
/*

condition: sum(i, j) % k == (j - i + 1)
(prefixSum[j+1] - (j + 1)) % k == (prefixSum[i] - i) % k

pid = [1, 3, 2, 4], k = 4
prefixSum: [0, 1, 4, 6, 10]

i=0 → prefixSum[1] = 1 → (1 - 1) % 4 = 0  
i=1 → prefixSum[2] = 4 → (4 - 2) % 4 = 2  
i=2 → prefixSum[3] = 6 → (6 - 3) % 4 = 3  
i=3 → prefixSum[4] = 10 → (10 - 4) % 4 = 2

We saw `2` before → found malicious subarray `[2, 3]`.


*/
import java.util.*;

public class AntivirusSecurity {

    public static long findSecurityLevel(int[] pid, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // Base case: empty prefix

        long risk = 0;
        long prefixSum = 0;

        for (int i = 0; i < pid.length; i++) {
            prefixSum += pid[i];

            // Calculate (prefixSum - index) % k and handle negative mod
            int modKey = (int) ((prefixSum - (i + 1)) % k);
            if (modKey < 0) modKey += k;

            // If this key has occurred before, we found that many malicious subarrays
            risk += countMap.getOrDefault(modKey, 0);

            // Update countMap with current modKey
            countMap.put(modKey, countMap.getOrDefault(modKey, 0) + 1);
        }

        return risk;
    }

    public static void main(String[] args) {
        int[] pid = {1, 3, 2, 4};
        int k = 4;
        System.out.println(findSecurityLevel(pid, k)); // Output: 2
    }
}


// 5. find hash - greedy approach
/*

param = [4, 4, 4, 4, 4]

max distinct hash values = min(4, 5) = 4

secretKey = [3, 4, 5, 6, 7]
hash      = [3, 0, 1, 2, 3]
✅ hash = [3, 0, 1, 2, 3] → distinct values = {0, 1, 2, 3}



*/

import java.util.*;

public class Solution {
    
    // TRUE O(n) solution - No sorting needed!
    public static int findHashOptimal(int[] param) {
        // Count frequency of each parameter value
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : param) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        
        int distinctValues = 0;
        
        // Process without sorting - order doesn't matter!
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int paramVal = entry.getKey();
            int count = entry.getValue();
            
            // This parameter can contribute at most min(paramVal, count) distinct values
            distinctValues += Math.min(paramVal, count);
        }
        
        return distinctValues;
    }
    
    // Alternative O(n) solution using counting sort when range is reasonable
    public static int findHashCountingSort(int[] param) {
        // Find max parameter value
        int maxParam = 0;
        for (int p : param) {
            maxParam = Math.max(maxParam, p);
        }
        
        // If range is too large, fall back to HashMap approach
        if (maxParam > 2 * param.length) {
            return findHashOptimal(param);
        }
        
        // Count frequency using array
        int[] freq = new int[maxParam + 1];
        for (int p : param) {
            freq[p]++;
        }
        
        int distinctValues = 0;
        for (int paramVal = 1; paramVal <= maxParam; paramVal++) {
            if (freq[paramVal] > 0) {
                distinctValues += Math.min(paramVal, freq[paramVal]);
            }
        }
        
        return distinctValues;
    }
    
    // Test method
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 4},      // Expected: 3
            {1, 1, 1},      // Expected: 1  
            {2, 2, 2, 2, 2}, // Expected: 2
            {3, 3, 3, 3},   // Expected: 3
            {1, 2, 3, 4, 5}, // Expected: 5
            {5, 5, 5, 5, 5, 5} // Expected: 5
        };
        
        for (int i = 0; i < testCases.length; i++) {
            int[] param = testCases[i];
            int result1 = findHashOptimal(param);
            int result2 = findHashCountingSort(param);
            
            System.out.printf("Test %d: HashMap=%d, CountingSort=%d, Input=%s%n", 
                            i+1, result1, result2, Arrays.toString(param));
        }
    }
}
// 6. Minimize variation
/*
    if we sort the array in ascending order, then left most element is always the minimum and right most will be max


*/
    
import java.util.*;

public class Solution {
    public static long minimizeVariation(int[] productSize) {
        int n = productSize.length;
        
        // Sort the array in ascending order
        Arrays.sort(productSize);
        
        long totalVariation = 0;
        
        // Calculate variation for each prefix
        for (int i = 0; i < n; i++) {
            // For prefix [0...i], min is productSize[0], max is productSize[i]
            long variation = (long)productSize[i] - (long)productSize[0];
            totalVariation += variation;
        }
        
        return totalVariation;
    }
    
    // Alternative optimized approach using mathematical formula
    public static long minimizeVariationOptimized(int[] productSize) {
        int n = productSize.length;
        Arrays.sort(productSize);
        
        long sum = 0;
        
        // Each element contributes to the sum based on its position
        for (int i = 0; i < n; i++) {
            // productSize[i] appears as max in (i+1) variations
            // productSize[0] appears as min in (n) variations
            sum += (long)(i + 1) * productSize[i] - (long)n * productSize[0];
        }
        
        return sum;
    }
    
    // Test method
    public static void main(String[] args) {
        // Test Example 1
        int[] test1 = {3, 1, 2};
        System.out.println("Example 1: " + minimizeVariation(test1)); // Expected: 3
        
        // Test Example 2  
        int[] test2 = {6, 1, 4, 2};
        System.out.println("Example 2: " + minimizeVariation(test2)); // Expected: 9
        
        // Test edge case
        int[] test3 = {5};
        System.out.println("Single element: " + minimizeVariation(test3)); // Expected: 0
        
        // Test with duplicates
        int[] test4 = {2, 2, 2};
        System.out.println("All same: " + minimizeVariation(test4)); // Expected: 0
    }
}

// 7. find Minimum Days - Binary Search
// - similar to https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/1290585201/ 

public class ChapterReadingExplanation {
    
    // Enhanced version with detailed comments and tracing
    public static long findMinimumDays(int[] pages, int k, int p) {
        int n = pages.length;
        long low = 0, high = 0;
        
        // Calculate upper bound: worst case scenario
        for (int pg : pages) {
            high = Math.max(high, pg);
        }
        // Conservative upper bound: max_pages * n / k + 1
        high = (long) high * n / k + 1;
        
        System.out.println("Binary search range: [" + low + ", " + high + "]");
        
        while (low < high) {
            long mid = (low + high) / 2;
            System.out.println("Trying " + mid + " days...");
            
            if (canFinish(pages, k, p, mid)) {
                System.out.println("✓ Can finish in " + mid + " days");
                high = mid;
            } else {
                System.out.println("✗ Cannot finish in " + mid + " days");
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private static boolean canFinish(int[] pages, int k, int p, long days) {
        int n = pages.length;
        
        // Difference array: tracks the "effect" of reading sessions
        long[] diff = new long[n + 1];
        
        // Current total reductions applied to each chapter
        long[] cur = new long[n];
        
        long totalDays = days;
        
        System.out.println("  Simulating " + days + " days:");
        
        // Process each chapter from left to right
        for (int i = 0; i < n; i++) {
            // Apply accumulated effects from difference array
            if (i > 0) diff[i] += diff[i - 1];
            cur[i] += diff[i];
            
            // Calculate remaining pages for this chapter
            long remaining = pages[i] - cur[i];
            
            System.out.printf("  Chapter %d: original=%d, reduced=%d, remaining=%d\n", 
                            i, pages[i], cur[i], remaining);
            
            if (remaining > 0) {
                // Calculate how many days needed to finish this chapter
                long neededDays = (remaining + p - 1) / p;  // Ceiling division
                
                System.out.printf("    Need %d days to finish this chapter\n", neededDays);
                
                if (neededDays > totalDays) {
                    System.out.println("    ✗ Not enough days left!");
                    return false;
                }
                
                // Use these days optimally
                totalDays -= neededDays;
                long reduceAmount = neededDays * p;
                
                System.out.printf("    Using %d days, reducing by %d pages\n", 
                                neededDays, reduceAmount);
                
                // Apply reduction to current chapter
                cur[i] += reduceAmount;
                
                // Use difference array to apply reduction to the sliding window
                // Add effect starting from next chapter
                if (i + 1 < n) {
                    diff[i + 1] += reduceAmount;
                }
                
                // Remove effect after the window of size k
                if (i + k < n) {
                    diff[i + k] -= reduceAmount;
                }
            }
            
            System.out.printf("    Days remaining: %d\n", totalDays);
        }
        
        System.out.println("  ✓ All chapters can be finished!");
        return true;
    }

    
    public static void main(String[] args) {
   
     
        System.out.println("\n=== EXAMPLE 1 ===");
        int[] pages1 = {3, 1, 4};
        int k1 = 2, p1 = 2;
        long result1 = findMinimumDays(pages1, k1, p1);
        System.out.println("Final result: " + result1);
        
        System.out.println("\n=== EXAMPLE 2 ===");
        int[] pages2 = {3, 4};
        int k2 = 1, p2 = 2;
        long result2 = findMinimumDays(pages2, k2, p2);
        System.out.println("Final result: " + result2);
    }
}


// 8. Split Prefix Suffix
public class CategorySplitter {

    public static int splitPrefixSuffix(String categories, int k) {
        int n = categories.length();
        int[] suffixFreq = new int[26];
        boolean[] suffixPresent = new boolean[26];

        // Step 1: count frequency in full string
        for (char ch : categories.toCharArray()) {
            suffixFreq[ch - 'a']++;
            suffixPresent[ch - 'a'] = true;
        }

        int[] prefixFreq = new int[26];
        boolean[] prefixPresent = new boolean[26];

        int count = 0;

        // Try all split points: from 1 to n - 1
        for (int i = 0; i < n - 1; i++) {
            char ch = categories.charAt(i);

            // Move ch from suffix to prefix
            prefixFreq[ch - 'a']++;
            prefixPresent[ch - 'a'] = true;

            suffixFreq[ch - 'a']--;
            if (suffixFreq[ch - 'a'] == 0) {
                suffixPresent[ch - 'a'] = false;
            }

            // Count how many characters are present in both prefix and suffix
            int currentShared = 0;
            for (int j = 0; j < 26; j++) {
                if (prefixPresent[j] && suffixPresent[j]) {
                    currentShared++;
                }
            }

            if (currentShared > k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String categories = "abbcac";
        int k = 1;
        System.out.println(splitPrefixSuffix(categories, k)); // Output: 2
    }
}

//9. Find Minimum Machine Sizes - Greedy
// similar to buy/sell stocks problem
public class MachineEfficiency {
    public static int findMinimumMachinesSize(int[] machineCapacity) {
        int n = machineCapacity.length;
        if (n <= 2) return n;

        int originalEfficiency = 0;
        for (int i = 1; i < n; i++) {
            originalEfficiency += Math.abs(machineCapacity[i] - machineCapacity[i - 1]);
        }

        // Try to minimize machine count
        int count = 1; // First machine is always included
        for (int i = 1; i < n - 1; i++) {
            int prev = machineCapacity[i - 1];
            int curr = machineCapacity[i];
            int next = machineCapacity[i + 1];

            // If this point is a turning point, include it
            if ((curr - prev) * (next - curr) < 0) {
                count++;
            } else if ((curr - prev) * (next - curr) > 0) {
                // Same direction (increasing or decreasing), we can skip this machine
                continue;
            } else {
                // Flat section or non-strict change, count it
                count++;
            }
        }
        count++; // Include the last machine

        return count;
    }

    public static void main(String[] args) {
        int[] machineCapacity1 = {1, 3, 2, 5, 4};
        System.out.println(findMinimumMachinesSize(machineCapacity1)); // Output: minimized number

        int[] machineCapacity2 = {5, 4, 3, 2, 1};
        System.out.println(findMinimumMachinesSize(machineCapacity2)); // Output: 2
    }
}


// 10. Server Selection
import java.util.*;

public class MaxCircularSubsequence {

    public static int maxValidCircularSubsequence(int[] powers) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int power : powers) {
            freq.put(power, freq.getOrDefault(power, 0) + 1);
        }

        int maxLen = 0;

        // Step 2: Single value groups (e.g., [1,1,1])
        for (int count : freq.values()) {
            if (count >= 3) {
                maxLen = Math.max(maxLen, count);
            }
        }

        // Step 3: Adjacent value pairs (e.g., [1,2,1])
        for (int key : freq.keySet()) {
            int curr = freq.get(key);
            int next = freq.getOrDefault(key + 1, 0);
            int total = curr + next;

            if (total >= 3) {
                maxLen = Math.max(maxLen, total);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] powers = {4, 3, 5, 1, 2, 1};
        System.out.println("Max Circular Subsequence Length: " + maxValidCircularSubsequence(powers));  // Output: 3
    }
}

// 11. Count Special Strings

    // Optimized solution using mathematical approach
    public static int countSpecialSubstringsOptimized(String s) {
        int n = s.length();
        int count = 0;
        
        // For each starting position
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            int ones = 0;
            
            // Extend substring from position i
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
                
                // Check special condition: zeros = ones²
                if (zeros == ones * ones) {
                    count++;
                }
                
                // Early termination: if zeros > ones², and we're adding more characters,
                // we can't decrease zeros, so no point continuing for larger ones values
                // But we might get ones to increase, so we continue
            }
        }
        
        return count;
    }
    
// 12. get maximum count
import java.util.*;

public class MaxKAfterSingleAddition {

    public static int maxFrequency(int[] arr, int k) {
        int n = arr.length;
        int countK = 0;

        // Step 1: Count already existing elements equal to k
        for (int num : arr) {
            if (num == k) {
                countK++;
            }
        }

        // Step 2: Use a map to count how many non-k elements can be converted to k with same x
        Map<Integer, Integer> deltaCount = new HashMap<>();
        int maxConvertible = 0;

        for (int num : arr) {
            if (num != k) {
                int x = k - num; // this is the delta we need to add to make it equal to k
                deltaCount.put(x, deltaCount.getOrDefault(x, 0) + 1);
                maxConvertible = Math.max(maxConvertible, deltaCount.get(x));
            }
        }

        // Step 3: Maximum frequency = already present k + best possible conversion
        return countK + maxConvertible;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int k = 3;
        int result = maxFrequency(arr, k);
        System.out.println("Max elements equal to " + k + " after operation: " + result);
    }
}
// 13.  Maximum Frequency After Subarray Operation
// https://leetcode.com/problems/maximum-frequency-after-subarray-operation/description/

class Solution{
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int maxFreq = 0;
        
        // For each possible value of x, find the maximum frequency we can achieve
        // x can range from (k - 50) to (k - 1) based on constraints
        for (int x = k - 50; x <= k + 50; x++) {
            // For this x, find the best contiguous subarray to apply it to
            int currentFreq = 0;
            int bestSubarrayGain = 0;
            int currentSubarrayGain = 0;
            
            for (int i = 0; i < n; i++) {
                if (nums[i] == k) {
                    currentFreq++;
                    // If we include this in subarray, we lose this k but don't gain anything
                    currentSubarrayGain = Math.max(0, currentSubarrayGain - 1);
                } else if (nums[i] + x == k) {
                    // If we include this in subarray, we gain a k
                    currentSubarrayGain = Math.max(0, currentSubarrayGain + 1);
                } else {
                    // If we include this in subarray, we don't gain or lose anything
                    currentSubarrayGain = Math.max(0, currentSubarrayGain);
                }
                
                bestSubarrayGain = Math.max(bestSubarrayGain, currentSubarrayGain);
            }
            
            maxFreq = Math.max(maxFreq, currentFreq + bestSubarrayGain);
        }
        
        return maxFreq;
    }
}
