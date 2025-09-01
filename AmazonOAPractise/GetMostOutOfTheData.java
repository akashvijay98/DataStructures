public int[] getMostOutOfData(int[] data) {
    int n = data.length;
    int[] res = new int[n];
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < data.length; i++) {
        list.add(new int[]{data[i], i + 1});
    }

    // Sort the list of pairs
    list.sort((a, b) -> {
        // Compare by value first
        int comp = Integer.compare(a[0], b[0]);

        // BUG FIX 1: The condition is now comp != 0.
        // If the values are not equal, use their comparison result.
        if (comp != 0) {
            return comp;
        }
        
        // Otherwise (if values are equal), use the index for the tie-breaker.
        return Integer.compare(a[1], b[1]);
    });

    // Build the final result from the sorted list
    for (int i = 0; i < data.length; i++) {
        // BUG FIX 2: Store the index (element at [1]), not the value.
        res[i] = list.get(i)[1];
    }
    
    return res;
}
