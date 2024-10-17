package anaylyze_the_user_input_string.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisString {
    public HashMap<String, List<Integer>> getNumber (String input) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<Integer> allNumber = new ArrayList<>();
        List<Integer> oddNumber = new ArrayList<>();
        List<Integer> evenNumber = new ArrayList<>();
        List<Integer> perfectSquareNumber = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            allNumber.add(number);
            if (number % 2 == 0) {
                evenNumber.add(number);
            } else {
                oddNumber.add(number);
            }
            int nums = (int) Math.sqrt(number);
            if(nums * nums == number){
                perfectSquareNumber.add(number);
            }
        }
       map.put("AllNumber", allNumber);
        map.put("EvenNumber", evenNumber);
        map.put("OddNumber", oddNumber);
        map.put("PerfectSquareNumber", perfectSquareNumber);

        return map;
    }
    public HashMap<String, StringBuilder> getCharacter (String input) {
        HashMap<String, StringBuilder> map = new HashMap<>();
        StringBuilder allCharacter = new StringBuilder();
        StringBuilder upperCaseCharacter = new StringBuilder();
        StringBuilder lowerCaseCharacter = new StringBuilder();
        StringBuilder specialCharacter = new StringBuilder();
        for(char c : input.toCharArray()){
            if(Character.isUpperCase(c)){
                upperCaseCharacter.append(c);
            } else if(Character.isLowerCase(c)){
                lowerCaseCharacter.append(c);
            } else if (!Character.isLetterOrDigit(c)) {
                specialCharacter.append(c);
            }
                if(!Character.isDigit(c)){
                    allCharacter.append(c);
                }
        }
        map.put("allCharacter", allCharacter);
        map.put("upperCaseCharacter", upperCaseCharacter);
        map.put("lowerCaseCharacter", lowerCaseCharacter);
        map.put("specialCharacter", specialCharacter);
        return map;
    }
}

