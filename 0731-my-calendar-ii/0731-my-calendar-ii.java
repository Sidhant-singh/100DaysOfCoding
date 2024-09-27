class MyCalendarTwo {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarTwo() {
        timeline = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Update the timeline for the new booking
        timeline.put(start, timeline.getOrDefault(start, 0) + 1); // Start of the event
        timeline.put(end, timeline.getOrDefault(end, 0) - 1); // End of the event

        int activeEvents = 0;
        // Traverse the timeline to check for triple bookings
        for (Map.Entry<Integer, Integer> entry : timeline.entrySet()) {
            activeEvents += entry.getValue();
            // If activeEvents exceeds 2, rollback the changes
            if (activeEvents >= 3) {
                // Remove the updates
                timeline.put(start, timeline.get(start) - 1);
                timeline.put(end, timeline.get(end) + 1);
                // Clean up zero entries
                if (timeline.get(start) == 0) {
                    timeline.remove(start);
                }
                if (timeline.get(end) == 0) {
                    timeline.remove(end);
                }
                return false; // Triple booking detected
            }
        }

        return true; // Booking successful
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */