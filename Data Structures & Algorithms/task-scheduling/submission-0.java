class Solution {
    public int leastInterval(char[] tasks, int n) {
    // 1. Map task to frequency: A -> 3, B -> 1
    int[] counts = new int[26];
    for (char c : tasks) counts[c - 'A']++;

    List<Character> schedule = new ArrayList<>();
    int totalTasks = tasks.length;

    while (totalTasks > 0) {
        int bestTask = -1;
        int maxFreq = 0;

        // 2. Look for the "Best" task to do RIGHT NOW
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                char task = (char) ('A' + i);
                
                // Check if this task is cooled down
                int lastIdx = schedule.lastIndexOf(task);
                // If never done, or distance > n
                if (lastIdx == -1 || (schedule.size() - lastIdx) > n) {
                    // Greedy: Pick the one with the highest remaining frequency
                    if (counts[i] > maxFreq) {
                        maxFreq = counts[i];
                        bestTask = i;
                    }
                }
            }
        }

        // 3. Either do the task or stay IDLE
        if (bestTask != -1) {
            schedule.add((char) ('A' + bestTask));
            counts[bestTask]--;
            totalTasks--;
        } else {
            // Nothing is cooled down yet! We MUST stay idle.
            schedule.add('#'); // Your MIN_VALUE equivalent
        }
    }

    return schedule.size();
}
}
