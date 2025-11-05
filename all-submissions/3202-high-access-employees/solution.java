class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> accessTimeMap = new HashMap<>();
        for(List<String> access_time: access_times){
            String employee = access_time.get(0);
            int time = Integer.parseInt(access_time.get(1));
            if(!accessTimeMap.containsKey(employee)){
                accessTimeMap.put(employee, new ArrayList<>());
            }
            accessTimeMap.get(employee).add(time);
        }
        for(String emp: accessTimeMap.keySet()){
            List<Integer> acc_times = accessTimeMap.get(emp);
            Collections.sort(acc_times);
            accessTimeMap.put(emp, acc_times);
        }
        List<String> answer = new ArrayList<>();
        for(String emp: accessTimeMap.keySet()){
            List<Integer> acc_times = accessTimeMap.get(emp);
            for(int i=0; i<acc_times.size()-2; i++) {
                int startTime = acc_times.get(i);
                int endTime = acc_times.get(i+2);
                if(endTime - startTime < 100){
                    answer.add(emp);
                    break;
                }
            }
        }
        return answer;

    }
}
