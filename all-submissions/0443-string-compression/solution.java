class Solution {
    public int compress(char[] chars) {
        int indexAns = 0;
        int index = 0;
        while(index<chars.length)
        {
            char currchar = chars[index];
            int count = 0;
            while(index<chars.length && chars[index]==currchar)
            {
                count++;
                index++;
            }
            chars[indexAns++] = currchar;
            if(count!=1)
            {
                for(char c : Integer.toString(count).toCharArray())
                {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }
}
