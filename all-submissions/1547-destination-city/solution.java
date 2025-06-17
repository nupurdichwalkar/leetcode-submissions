class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for(int i=0; i< paths.size(); i++) {
            List<String> path = paths.get(i);
            String source = path.get(0);
            String destination = path.get(1);
            map.put(source, destination);
        }
        for (String key: map.keySet()){
            String destination = map.get(key);
            if(!map.containsKey(destination)){
                return destination;
            }
        }
        return "";
    }
}
