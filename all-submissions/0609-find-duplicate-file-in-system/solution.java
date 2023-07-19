class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> dupMap = new HashMap<>();
        for(String path: paths) {
            String[] directory_file_text = path.split(" ");
            String directory = directory_file_text[0];
            for (int i=1; i<directory_file_text.length; i++) {
                String[] file_text = (directory_file_text[i]).split("\\(");
                String file_name = file_text[0];
                String filePath = directory.concat("/");
                filePath = filePath.concat(file_name);
                String text = file_text[1].replace(")", "");
                List<String> filePaths = new ArrayList<>();
                if (dupMap.containsKey(text)) {
                    filePaths = dupMap.get(text);
                } 
                filePaths.add(filePath);
                dupMap.put(text, filePaths);
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> dupMapEntry: dupMap.entrySet()){
            List<String> filePaths = dupMapEntry.getValue();
            if (filePaths.size() > 1){
                answer.add(filePaths);
            }
        }
        return answer;
    }
}
