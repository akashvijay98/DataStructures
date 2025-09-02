import java.util.Collections;
import java.util.PriorityQueue;

public class WarehouseScheduler {

    /**
     * Helper function to check if `d` dock bays are sufficient.
     * This simulates the unloading process.
     */
    private boolean canUnloadInTime(int d, int[] truckCargoSize, long maxTurnaroundTime) {
        // A Min-PriorityQueue to track when each of the `d` docks becomes free.
        PriorityQueue<Long> dockFinishTimes = new PriorityQueue<>();

        // Initially, all `d` docks are free at time 0.
        for (int i = 0; i < d; i++) {
            dockFinishTimes.add(0L);
        }

        // Assign each truck to the next available dock.
        for (int cargoSize : truckCargoSize) {
            // Get the dock that finishes earliest (the minimum time in the PQ).
            long earliestFreeTime = dockFinishTimes.poll();

            // The new finish time for this dock will be when it becomes free
            // plus the time it takes to unload the current truck.
            long newFinishTime = earliestFreeTime + cargoSize;

            // Add the new finish time back to the queue.
            dockFinishTimes.add(newFinishTime);
        }

        // After all trucks are scheduled, the total time taken is the
        // latest finish time among all docks.
        long totalTime = Collections.max(dockFinishTimes);

        return totalTime <= maxTurnaroundTime;
    }

    /**
     * Main function to find the minimum number of dock bays.
     */
    public int getMinimumDockBays(int[] truckCargoSize, long maxTurnaroundTime) {
        int n = truckCargoSize.length;
        if (n == 0) {
            return 0;
        }

        // Binary search for the number of dock bays `d`.
        // The number of bays can be between 1 and n.
        int low = 1;
        int high = n;
        int minBays = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canUnloadInTime(mid, truckCargoSize, maxTurnaroundTime)) {
                // `mid` bays are enough. This is a potential answer.
                // Let's try to find an even smaller number of bays.
                minBays = mid;
                high = mid - 1;
            } else {
                // `mid` bays are not enough. We need more.
                low = mid + 1;
            }
        }

        return minBays;
    }
}
