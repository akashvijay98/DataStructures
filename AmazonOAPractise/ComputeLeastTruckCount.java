// https://www.fastprep.io/problems/amazon-get-minimum-number-of-trucks
import java.lang.Math;

public class TruckCalculator {

    public int getMinimumNumberOfTrucks(int[] items, int capacity, int max_same_type_limit) {
        long sum = 0; // Use long for sum to prevent potential overflow
        for (int val : items) {
            sum += val;
        }

        // Corrected calculation for the first bottleneck
        int maxTrucks_1 = (int) Math.ceil((double) sum / capacity);

        int maxTrucks_2 = 0; // Initialize to 0, not -1
        for (int item : items) {
            // Corrected calculation for the second bottleneck
            int div = (int) Math.ceil((double) item / max_same_type_limit);
            if (div > maxTrucks_2) {
                maxTrucks_2 = div;
            }
        }

        return Math.max(maxTrucks_1, maxTrucks_2);
    }
}
