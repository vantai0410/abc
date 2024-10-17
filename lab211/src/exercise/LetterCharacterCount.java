package exercise;

import java.util.Scanner;

public class LetterCharacterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        String input = sc.nextLine();

//        String[] words = input.split("\\s+ ");
//
//        int count = words.length;
//        System.out.println("Number of words: " + words.length);

        int[] charCount = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                charCount[c - 'a']++;
            }
        }

        System.out.print("{ ");

        boolean found = true;
        for(int i=0; i<26; i++){
            if(charCount[i] > 0){
                if(!found){
                    System.out.print(", ");
                }
                System.out.print((char) (i + 'a') + "=" + charCount[i]);
                found = false;
            }
        }
        System.out.print(" }");
    }
}
