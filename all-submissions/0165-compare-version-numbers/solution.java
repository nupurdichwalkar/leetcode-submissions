class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int val1 = 0;
        int val2 = 0;
        if(Integer.parseInt(ver1[0]) == Integer.parseInt(ver2[0])) {
            for(int i=1; i<ver1.length;i++) {
                if(ver1[i] != "0") {
                    val1 = val1*10 + Integer.parseInt(ver1[i]);
                }
            }
            for(int i=1; i<ver2.length;i++) {
                if(ver2[i] != "0") {
                    val2 = val2*10 + Integer.parseInt(ver2[i]);
                }
            }
            if (ver1.length > ver2.length) {
                int diff = ver1.length - ver2.length;
                while(diff != 0) {
                    val2 = val2*10;
                    diff--;
                }
            }

            if (ver2.length > ver1.length) {
                int diff = ver2.length - ver1.length;
                while(diff != 0) {
                    val1 = val1*10;
                    diff--;
                }
            }
        } else {
            val1 = Integer.parseInt(ver1[0]);
            val2 = Integer.parseInt(ver2[0]);
        }

        if (val1 < val2) return -1;
        if(val1 > val2) return 1;
        return 0;
        

    }
}
