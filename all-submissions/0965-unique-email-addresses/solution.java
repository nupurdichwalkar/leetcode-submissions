class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniquemail = new HashSet<String>();
        for(String email : emails)
        {
            String[] mail = email.split("@");
            String localname = mail[0].replace(".","");
            int index = localname.indexOf("+");
            localname = localname.substring(0,index);
            //int index1 = mail[1].indexOf(".com");
            String domainname = mail[1];
            // domainname = domainname.replace(".","");
            // domainname = domainname.replace("+","");
            String umail = localname+domainname;
            uniquemail.add(umail);
            }
        return uniquemail.size();
        }
        
    }
