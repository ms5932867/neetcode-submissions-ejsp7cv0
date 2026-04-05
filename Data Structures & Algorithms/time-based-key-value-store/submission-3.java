class TimeMap {
    Map<String, List<ValueItem>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new ValueItem(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<ValueItem> valueItems = timeMap.get(key);
        int size = valueItems.size();
        int l = 0;
        int r = size - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            ValueItem cur = valueItems.get(m);
            if (cur.time == timestamp) {
                return cur.val;
            } else if (cur.time > timestamp) {
                r = m;
            } else {
                l = m;
            }
        }
        if (valueItems.get(r).time <= timestamp) {
            return valueItems.get(r).val;
        }
        if (valueItems.get(l).time <= timestamp) {
            return valueItems.get(l).val;
        }
        return "";

    }

    private class ValueItem {
        String val;
        int time;
        ValueItem(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
}
