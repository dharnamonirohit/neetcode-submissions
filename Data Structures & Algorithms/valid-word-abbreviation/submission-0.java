class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0 , j = 0;
        int n = word.length();
        int m = abbr.length();
        while(i < n && j < m){
            //check if character is digit or not 
            //if digit - convert it to integer and increase i accordingly, and check for leading zero
            //if not digit - check if the characters are equal or not 
            char ch = word.charAt(i);
            char c = abbr.charAt(j);

            if(Character.isDigit(c)){
                if(c == '0'){
                    return false;
                }
                int count = 0;
                while(j < m && Character.isDigit(abbr.charAt(j))){
                    count = count * 10 + (abbr.charAt(j) - '0');
                    j++;
                }

                i += count;
            }else{
                if(ch != c){
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == n && j == m;
    }
}