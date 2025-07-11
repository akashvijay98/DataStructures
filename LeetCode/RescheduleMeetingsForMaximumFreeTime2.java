import java.lang.Math;

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int maxFreeTimeNoMove = 0;

        maxFreeTimeNoMove = Math.max(maxFreeTimeNoMove, startTime[0]); 
        maxFreeTimeNoMove = Math.max(maxFreeTimeNoMove, eventTime - endTime[n - 1]);

        for (int i = 0; i < n - 1; i++) {
            maxFreeTimeNoMove = Math.max(maxFreeTimeNoMove, startTime[i + 1] - endTime[i]);
        }

        boolean[] q = new boolean[n];
        int t1 = 0;
        int t2 = 0;

        for (int i = 0; i < n; i++) {
            int currentMeetingDurationLeft = endTime[i] - startTime[i];
            
            // this checks if the current meeting can be fit into the largest free slot to hte left
            if (currentMeetingDurationLeft <= t1) {
                q[i] = true;
            }

            // compute the largest free slot to the left of the next meeting
            t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));

            int rightIndex = n - i - 1;
            int currentMeetingDurationRight = endTime[rightIndex] - startTime[rightIndex];
            
            // this will chekc is thecurrent meeting can be fit into the largest gap to the right
            if (currentMeetingDurationRight <= t2) {
                q[rightIndex] = true;
            }

            // compute the largest free slot to the right of current slot 
            t2 = Math.max(
                t2,
                (i == 0 ? eventTime : startTime[n - i]) - endTime[rightIndex]
            );
        }

        int maxFreeTimeIfMoved = 0;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : endTime[i - 1];
            int right = i == n - 1 ? eventTime : startTime[i + 1];

            // calculate the left(endTime[i-1]) and right (startTime[i+1]) boundaries if meeting i is removed

            // if the current meeting can be fit into the gaps of left or right
            if (q[i]) {
                maxFreeTimeIfMoved = Math.max(maxFreeTimeIfMoved, right - left);
            } else {
                maxFreeTimeIfMoved = Math.max(maxFreeTimeIfMoved, right - left - (endTime[i] - startTime[i]));
            }
        }

        return Math.max(maxFreeTimeNoMove, maxFreeTimeIfMoved);
    }
}
