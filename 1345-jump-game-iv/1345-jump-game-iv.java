class Solution {
    public int minJumps(int[] arr) {
        int len = arr.length;
        if (len <= 1)  return 0;
        if (arr[0] == arr[len - 1])  return 1;

        // Put all arr[] values in a HashMap so we can find matching values faster.
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        map.put(arr[0], list);              // Add arr[0] to the HashMap.
        list = new ArrayList<Integer>();
        list.add(len - 1);
        map.put(arr[len - 1], list);        // Add arr[len - 1] to the HashMap.
        // Loop to add arr[1..len-2] to HashMap.
        for (int i = 1; i < len - 1; i++) { 
            list = map.get(arr[i]);
            if (list == null) {             // If arr[i] not yet in HashMap...
                list = new ArrayList<Integer>();
                map.put(arr[i], list);
            }
            // Add arr[i] to the HashMap only if arr[i] is a different value from 
            // arr[i-1] or arr[i+1].  Repeated consecutive values can be reduced 
            // to only the first and last of those repeated consecutive values.  
            // Interior values of repeated consecutive values aren't needed because 
            // we want the minimum number of jumps and we could always jump from 
            // the same arr[n] value to the start or the end of the same repeated 
            // consecutive values.  Jumping to the middle of the repeated 
            // consecutive values would increase the number of jumps beyond the 
            // minimum number of jumps.  so we ignore interior values of repeated 
            // consecutive values.  One leetcode test case has more than 49_000 "7"s 
            // in a row.  We can ignore all but the first and last "7" of the 
            // repeated consecutive "7"s, which makes the Breadth First Search much 
            // faster.
            if (arr[i - 1] != arr[i] || arr[i + 1] != arr[i])
                list.add(i);
        }
        
        // Setup the Breadth First Search (BFS) values to start at the end-point 
        // of the jumps (last index in arr[]) and work the jumps back to the 
        // start-point of the jumps (index zero in arr[]).  This is faster than 
        // going forward, because of test cases for this leetcode problem that 
        // are designed to be more difficult when going forward.
        boolean[] used = new boolean[len];
        used[arr.length - 1] = true;
        int[] curLayer = new int[len];
        int curIdx = 0;
        curLayer[curIdx++] = arr.length - 1;
        int[] nextLayer = new int[len];
        int nextIdx = 0;
        int layerLevel = 1;
        int[] tmpLayer;
        
        // Loop until the Breadth First Search (BFS) finds its goal.  The goal is to 
        // jump to index 0 in arr[] because we are doing the jumps from end-point 
        // to start-point.
        while (true) {
            nextIdx = 0;

            // Loop through all nodes in the current level of the BFS.
            for (int i1 = 0; i1 < curIdx; i1++) {
                int i = curLayer[i1];
                // Save jump to previous array index, unless we already visited the 
                // previous array index, or we are at index 1 and therefore the previous 
                // index is 0 which means that we end the search at index 0.
                if (i > 0 && !used[i - 1]) {
                    if (i == 1)  return layerLevel;
                    used[i - 1] = true;
                    nextLayer[nextIdx++] = i - 1;
                }
                // Save jump to next array index, unless we already visited the next 
                // array index, or there is no next array index.
                if (i < arr.length - 1 && !used[i + 1]) {
                    used[i + 1] = true;
                    nextLayer[nextIdx++] = i + 1;
                }
                // Save jump to all other arr[] index that contain the same value as 
                // arr[i] (the current array entry).  The HashMap contains a list of 
                // arr[] indexes that contain the same value as arr[i].  If any of 
                // these jumps are to index 0, then the Breadth First Search is done.
                ArrayList<Integer> sameNumIndexes = map.get(arr[i]);
                if (sameNumIndexes.size() > 1) {
                    for (int j : sameNumIndexes) {
                        if (!used[j]) {
                            if (j == 0)  return layerLevel;
                            used[j] = true;
                            nextLayer[nextIdx++] = j;
                        }
                    }
                }
                // sameNumIndexes.clear();
            }
            // Swap the lext level of the BFS to become the new current level of the 
            // BFS for the next time through the main BFS loop.
            tmpLayer = curLayer;
            curLayer = nextLayer;
            nextLayer = tmpLayer;
            curIdx = nextIdx;
            layerLevel++;
        }
    }
}