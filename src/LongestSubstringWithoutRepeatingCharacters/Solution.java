package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chentony on 2018/10/3.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int length = 1;
        // use dynamic programming
        for (int i = 1; i <= s.length(); i++) {
            if (i != 1) {
                // get possible longest sub-string
                String possibleLongestSubString = s.substring(i - (length + 1), i);
                // check if it have repeating char
                if (notRepeating(possibleLongestSubString)) {
                    length = possibleLongestSubString.length();
                }
            }
        }
        return length;
    }

    /**
     * check if the string have repeating char
     *
     * @param str
     * @return
     */
    public boolean notRepeating(String str) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char character : chars) {

            if (characterIntegerMap.get(character) == null) {
                characterIntegerMap.put(character, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Map<Character,Integer> characterIntegerMap = new HashMap<>();
//        int x = characterIntegerMap.get('a');
//        characterIntegerMap.put('b',1);
//        int y = characterIntegerMap.get('b');

//        String str = "12312312";
//        int i = str.length();
//        int length = 1;
//       String substring= str.substring(i-(length+1),i);
//
//        System.out.println(substring);

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("1234"));
        System.out.println(solution.lengthOfLongestSubstring("1232"));
        System.out.println(solution.lengthOfLongestSubstring("123123"));
        System.out.println(solution.lengthOfLongestSubstring("123a"));
        System.out.println(solution.lengthOfLongestSubstring("aas2"));
        System.out.println(solution.lengthOfLongestSubstring("8yv8y8y"));
        System.out.println(solution.lengthOfLongestSubstring("v12u3vu"));
        System.out.println(solution.lengthOfLongestSubstring("njqw0"));
    }
}
