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
    Algorithm Logic:
        1. Sort by Parameter Values: We process the parameters in ascending order of their values. This is because smaller param[i] values have fewer possible hash values (0 to param[i]-1), so they have more constraints.
        2. Greedy Assignment: For each parameter (processed in sorted order), we assign the smallest possible hash value that hasn't been used yet.
        3. Track Used Values: We maintain a set of already assigned hash values to avoid duplicates.
*/

import java.util.*;

public class Solution {
    
    public static int findHash(int[] param) {
        int n = param.length;
        
        // Create pairs of (param[i], index) and sort by param value
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices based on param values (ascending order)
        Arrays.sort(indices, (a, b) -> Integer.compare(param[a], param[b]));
        
        Set<Integer> usedHashValues = new HashSet<>();
        
        // Process parameters in ascending order of their values
        for (int idx : indices) {
            int paramValue = param[idx];
            
            // Find the smallest hash value (0 to paramValue-1) that hasn't been used
            for (int hashVal = 0; hashVal < paramValue; hashVal++) {
                if (!usedHashValues.contains(hashVal)) {
                    usedHashValues.add(hashVal);
                    break;
                }
            }
        }
        
        return usedHashValues.size();
    }
    
    // Test method
    public static void main(String[] args) {
        // Example 1
        int[] param1 = {1, 2, 4};
        System.out.println("Example 1: " + findHash(param1)); // Expected: 3
        
        // Example 2
        int[] param2 = {1, 1, 1};
        System.out.println("Example 2: " + findHash(param2)); // Expected: 1
        
        // Additional test cases
        int[] param3 = {2, 3, 5};
        System.out.println("Test 3: " + findHash(param3)); // Expected: 3
        
        int[] param4 = {2, 2, 2};
        System.out.println("Test 4: " + findHash(param4)); // Expected: 2
    }
}

