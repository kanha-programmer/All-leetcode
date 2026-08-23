class Solution {
    public String reverseVowels(String s) {
      String ans="";
      int left=0,right=s.length()-1;
      String vowel="";
      String vowel2="aeiouAEIOU";
      for(int i=s.length()-1;i>=0;i--){
        char x=s.charAt(i);
        CharSequence cs = String.valueOf(x);
        if(vowel2.contains(cs)){
            vowel+=s.charAt(i);
        }
      }
      int ind=0;
      for(int i=0;i<s.length();i++){
        char x=s.charAt(i);
        CharSequence cs = String.valueOf(x);
        if(vowel2.contains(cs)){
            ans+=vowel.charAt(ind);
            ind++;
      }else{
        ans+=s.charAt(i);
      }
      }
      return ans;
    }
}