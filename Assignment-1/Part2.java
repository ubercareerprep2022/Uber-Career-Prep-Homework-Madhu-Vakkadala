import java.util.Arrays; 

public class Part2 {
    public static void main(String args[]) {

      System.out.println(isStringPermutation("asdf", "fsa"));               // false : diff string lengths
      System.out.println(isStringPermutation("asdf", "fsda"));              // true
      System.out.println(isStringPermutation("asdf", "fsax"));              // false
      System.out.println(isStringPermutation("", "fsa"));                   // false : null check
      System.out.println(isStringPermutation("aasd", "fsda"));              // false : repeated characters
      System.out.println(isStringPermutation("aadf", "addf"));              // false : repeated characters

    }
    
    public static boolean isStringPermutation(String s1, String s2) {
        if (s1 == "" || s2 == "" || s1.length() != s2.length()) {
         return false;   
        }
        
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1Arr[i] != s2Arr[i]) {
                return false;
            } 
        }
        
        return true;
    }
}