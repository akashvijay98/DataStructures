import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Calculates the minimum insertions to ensure no contiguous sub-array sums to zero.
     *
     * @param queueMessages The array of message values.
     * @return The minimum number of insertions required.
     */
    public int minInsertionsToEnsureNonZeroLoadSum(int[] queueMessages) {
        int insertions = 0;
        long currentSum = 0; // Use long to avoid potential integer overflow with large inputs.

        // This set stores all the prefix sums encountered in the current segment.
        Set<Long> seenSums = new HashSet<>();

        // A sum of 0 is the starting point before processing any elements.
        seenSums.add(0L);

        for (int message : queueMessages) {
            currentSum += message;

            // If the currentSum has been seen before, it means a sub-array
            // between the last occurrence and now sums to zero.
            if (seenSums.contains(currentSum)) {
                // We must make an "insertion" to break this zero-sum segment.
                insertions++;

                // The insertion starts a new, clean segment. We clear all previously
                // seen sums and start over from this point.
                seenSums.clear();

                // The new segment's starting sum is 0 (relative to the insertion point),
                // and the first element brings the sum to 'currentSum'.
                seenSums.add(0L);
                seenSums.add(currentSum);
            } else {
                // If the sum is new, just add it to our set of seen sums.
                seenSums.add(currentSum);
            }
        }

        return insertions;
    }
}


/*



The Scenario: An Instant Cancellation 🛒
Imagine a customer places an order for a new laptop costing $1,500. This action sends a message to the order processing queue.

Message 1 (Submission): +1500 representing "Order #58291 Placed."

A moment later, the customer realizes they used the wrong credit card, panics, and immediately cancels the order. This sends a second message.

Message 2 (Retrieval): -1500 representing "Order #58291 Cancelled."

The segment of messages in the queue for this event is [1500, -1500]. The processing burden is zero. A monitoring system just looking at the net financial change would see $0 and might completely miss this activity, hiding a potentially confusing user experience on the checkout page.

The Fix: Inserting an Audit Message 📝
To solve this, the system is designed to insert a tiny, non-zero "audit" message whenever a zero-sum segment is detected. This message represents the computational cost or the administrative action of processing the cancellation itself.

Let's say the system inserts a message with a value of +1 to signify "Cancellation Logged."

The sequence of operations now becomes: [1500, 1, -1500].

The Result: A Visible Trace
Now, let's look at the processing burden for the sub-segments:

[1500] = 1500

[1500, 1] = 1501

[1500, 1, -1500] = 1

[1, -1500] = -1499

No segment sums to zero anymore.

The overall impact on the queue is now +1. This small, non-zero value acts as a permanent flag. The monitoring dashboard no longer shows a net change of $0; it shows a net change of +$1. This signals to the analytics system that a self-canceling event occurred, ensuring that this "wasted work" is no longer invisible and can be tracked, analyzed, and used to improve the platform

*
