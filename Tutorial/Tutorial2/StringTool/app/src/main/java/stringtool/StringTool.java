package stringtool;

import java.util.Random;
 
public class StringTool { 
    public static String spongebob(String words) { 
        Random rand = new Random(); 
        int upperbound = words.length(); 
        // Randomise the number of words to flip
        int flipCount = 1 + rand.nextInt(upperbound);

        String spongebobWord = words;
        while (flipCount != 0) {
            // Randomise the string index to flip
            int index = rand.nextInt(upperbound); 
            String word = spongebobWord.substring(0, index);

            if (Character.isUpperCase(spongebobWord.charAt(index))) {
                word += String.valueOf(spongebobWord.charAt(index)).toLowerCase();
            } else {
                word += String.valueOf(spongebobWord.charAt(index)).toUpperCase();
            }
            if (index != words.length() - 1)
                word += spongebobWord.substring(index+1);

            spongebobWord = word;
            flipCount--;
        }
        return spongebobWord;
    }
    
    public static String title(String texts) { 
        String newTexts = ""; 
        String[] words = texts.split(" "); 
        
        for (String letter : words) { 
            newTexts += String.valueOf(letter.charAt(0)).toUpperCase();
            
            if (letter.length() > 1)
                newTexts += letter.substring(1);
            newTexts += " ";
        }
        return newTexts.substring(0, newTexts.length() - 1);
    }
    
    public static String upper(String texts) {
        return texts.toUpperCase(); 
    }
    
    public static String lower(String texts) { 
        return texts.toLowerCase(); 
    }

    public static String reverse(String texts) { 
        String reverseText = new String(); 
        for (int i = texts.length() - 1; i >= 0; i --) 
            reverseText = reverseText += texts.charAt(i);
        
        return reverseText; 
    }
    
    public static void println(String text) { 
        System.out.println(text + "\n");
    }
    public static void main(String[] args) { 
        String text = new String("Never gonna give you up\nNever gonna let you down\nNever gonna run around and desert you\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you");

        println("\nNormal Text: " + text); 
        println("Upper Case: " + upper(text)); 
        println("Lower case: " + lower(text)); 
        println("Reverse: " + reverse(text)); 
        println("Title: " + title(text)); 
        println("Spongebob: " + spongebob(text));
    }

}
