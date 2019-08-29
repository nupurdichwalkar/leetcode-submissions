class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List> res = new HashMap<>();
        for(String s : strs){
            char[] keychar = s.toCharArray();
            Arrays.sort(keychar);
           String key = String.valueOf(keychar);
            if(!res.containsKey(key))
            {
                res.put(key,new ArrayList<String>());
            }
            res.get(key).add(s);
        }
                List<List<String>> result = new ArrayList(res.values());
        return result;
    }
}
