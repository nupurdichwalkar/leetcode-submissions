class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        
        for(String str : cpdomains){
            String[] line = str.split(" ");
            int count = Integer.valueOf(line[0]);
            String[] domains = line[1].split("\\.");
            String temp = "";
            for(int i = domains.length - 1;i >= 0;i--)
            {
                temp = domains[i] + (temp.equals("") ? temp : "." + temp);
                map.put(temp, map.getOrDefault(temp,0) + count);
            }
        }
        
        List<String> res = new ArrayList();
        for(String str : map.keySet()){
            res.add(map.get(str) + " " + str);
        }
        
        return res;
    }
}
