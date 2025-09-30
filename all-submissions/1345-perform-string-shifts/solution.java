class Solution {
    public String stringShift(String s, int[][] shift) {
        String temp = s;
        if(s == null) return null;
        if(s.length() == 1) return s;
        for(int[] sh : shift) {
            int move = sh[1] % s.length();
            if(sh[0] == 0){ // left shift
                StringBuilder sb = new StringBuilder();
                String a = temp.substring(0, move);
                String b = temp.substring(move, s.length());
                sb.append(b);
                sb.append(a);
                temp = sb.toString();
            } else {   //right shift
                StringBuilder sb = new StringBuilder();
                String a = temp.substring(s.length()-move, s.length());
                String b = temp.substring(0, s.length()-move);
                sb.append(a);
                sb.append(b);
                temp = sb.toString();
            }
        }
        return temp;
    }
}
