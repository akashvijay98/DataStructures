/* 
Of course. Here is the original problem description and the main example from our conversation.

Code Question
Amazon is developing a string matching library. You are to develop a service that finds the longest substring that matches a given regex.

More formally, you are given two strings, a text string sourceString, and a regex expression pattern. The string pattern contains exactly one wildcard character (*). A wildcard character (*) matches any sequence of zero or more lowercase English characters.

A regex matches some string if it is possible to replace the wildcard character with some sequence of characters such that the regex expression becomes equal to the string. For example, the regex "abc*bcd" matches "abcbcd", "abcefgbed", and "abccbcd", whereas it does not match the strings "abcbd", "abzbed", or "abcd".

Return the length of the longest substring of sourceString that matches the expression pattern. Return -1 if there is no such substring.

Note: A substring is a contiguous sequence of characters within a string.

Example
Given:

sourceString = "hackerrank"

pattern = "ack*r"

Matching Substrings:

The following substrings of "hackerrank" match the pattern:

"acker"

This matches if we replace * with "e". The pattern becomes "acker".

Length = 5.

"ackerr"

This matches if we replace * with "er". The pattern becomes "ackerr".

Length = 6.

Result:

You must return the length of the longest matching substring. In this case, the answer is 6.

*/

// Solution using inbuilt indexOf() 
public class Solution {

    public int longestSubstring(String sourceString, String pattern) {
        // 1. Split the pattern correctly.
        // Using indexOf is safer than split() as it doesn't involve regex.
        int starIndex = pattern.indexOf('*');
        String prefix = pattern.substring(0, starIndex);
        String suffix = pattern.substring(starIndex + 1);

        // 2. Find the FIRST occurrence of the prefix using the built-in method.
        int firstPrefixIndex = sourceString.indexOf(prefix);
        if (firstPrefixIndex == -1) {
            return -1; // Prefix not found.
        }

        // 3. Find the LAST occurrence of the suffix.
        int lastSuffixIndex = sourceString.lastIndexOf(suffix);
        if (lastSuffixIndex == -1) {
            return -1; // Suffix not found.
        }

        // 4. ***CRITICAL VALIDATION***
        // Check that the suffix begins AFTER the prefix ends.
        int prefixEndIndex = firstPrefixIndex + prefix.length();
        if (lastSuffixIndex >= prefixEndIndex) {
            // 5. Calculate the correct length.
            // (end of suffix) - (start of prefix)
            int endOfSubstring = lastSuffixIndex + suffix.length();
            return endOfSubstring - firstPrefixIndex;
        }

        // If the suffix appears before the prefix ends, there is no valid match.
        return -1;
    }

}

// if you want your own implementation to find firstPrefixIndex and lastSuffixIndex 

public class Solution {

    public int longestSubstring(String sourceString, String pattern) {
        int starIndex = pattern.indexOf('*');
        String prefix = pattern.substring(0, starIndex);
        String suffix = pattern.substring(starIndex + 1);

        // Use our custom method instead of sourceString.indexOf()
        int firstPrefixIndex = findFirstOccurrence(sourceString, prefix);
        if (firstPrefixIndex == -1) {
            return -1;
        }

        // Use our custom method instead of sourceString.lastIndexOf()
        int lastSuffixIndex = findLastOccurrence(sourceString, suffix);
        if (lastSuffixIndex == -1) {
            return -1;
        }

        // The rest of the logic remains the same
        int prefixEndIndex = firstPrefixIndex + prefix.length();
        if (lastSuffixIndex >= prefixEndIndex) {
            int endOfSubstring = lastSuffixIndex + suffix.length();
            return endOfSubstring - firstPrefixIndex;
        }

        return -1;
    }

    // Helper method to find the first occurrence (our manual indexOf)
    private int findFirstOccurrence(String text, String target) {
        if (target.isEmpty()) return 0;
        int limit = text.length() - target.length();
        for (int i = 0; i <= limit; i++) {
            boolean matchFound = true;
            for (int j = 0; j < target.length(); j++) {
                if (text.charAt(i + j) != target.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }
            if (matchFound) {
                return i;
            }
        }
        return -1;
    }

    // Helper method to find the last occurrence (our manual lastIndexOf)
    private int findLastOccurrence(String text, String target) {
        if (target.isEmpty()) return text.length();
        int limit = text.length() - target.length();
        for (int i = limit; i >= 0; i--) {
            boolean matchFound = true;
            for (int j = 0; j < target.length(); j++) {
                if (text.charAt(i + j) != target.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }
            if (matchFound) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String source = "hackerrank";
        String pat = "ack*r";
        System.out.println("Longest match length: " + sol.longestSubstring(source, pat)); // Expected: 6
    }
}
