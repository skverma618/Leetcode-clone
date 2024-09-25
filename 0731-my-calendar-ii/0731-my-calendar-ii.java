class MyCalendarTwo {
    private TreeMap<Integer, Integer> m;
    
    public MyCalendarTwo() {
        m = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Increment start time
        m.put(start, m.getOrDefault(start, 0) + 1);
        // Decrement end time
        m.put(end, m.getOrDefault(end, 0) - 1);

        int count = 0;
        // Iterate over the map
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            count += entry.getValue();
            // If the count reaches 3, cancel the booking
            if (count == 3) {
                // Undo the changes made to start and end
                m.put(start, m.get(start) - 1);
                if (m.get(start) == 0) {
                    m.remove(start);
                }
                m.put(end, m.get(end) + 1);
                if (m.get(end) == 0) {
                    m.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}