class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length==0)
            return logs;
        List<String> letterlogs = new ArrayList<>();
        List<String> digitlogs = new ArrayList<>();
        String[] output = new String[logs.length];
        
        for(String value : logs){
            if(Character.isDigit(value.charAt(value.length()-1))){
                digitlogs.add(value);
            }
            else{
                letterlogs.add(value);
            }
        }
        
        Collections.sort(letterlogs, new Comparator<String>(){
            public int compare(String o1, String o2) {
			    String s1 = o1.substring(o1.indexOf(" ") + 1);
			    String s2 = o2.substring(o2.indexOf(" ") + 1);
                
                return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            }
        });
            
       for(int i= 0; i<letterlogs.size();i++)
        {
            output[i] = letterlogs.get(i);
        }
        
        for(int i = letterlogs.size(); i<output.length;i++)
        {
            output[i] = digitlogs.get(i-letterlogs.size());
        }
        return output;
    }
}
