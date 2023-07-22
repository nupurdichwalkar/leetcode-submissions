class Logger {
    Map<String, Integer> myMap = new HashMap<>();

    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!myMap.containsKey(message)) {
            myMap.put(message, timestamp);
            return true;
        } 
        int oldTimeStamp = myMap.get(message);
        if (timestamp >= oldTimeStamp+10) {
            myMap.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
