// get max frequency until index i 
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
// get dna Sequence

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

