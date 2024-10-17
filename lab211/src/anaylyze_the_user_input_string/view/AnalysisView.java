package anaylyze_the_user_input_string.view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AnalysisView {
    Scanner sc = new Scanner(System.in);
    public String getInput(){
        System.out.print("Input String: ");
        return sc.nextLine();
    }
    public void displayNumber(HashMap<String, List<Integer>> map){
        System.out.println("----- Result Analysis ------");
        System.out.println("Perfect Square Numbers: " + map.get("PerfectSquareNumber"));
        System.out.println("Odd numbers: " + map.get("OddNumber"));
        System.out.println("Even numbers: " + map.get("EvenNumber"));
        System.out.println("All numbers: " + map.get("AllNumber"));
    }
    public void  displayCharacter(HashMap<String, StringBuilder> map){
        System.out.println("Uppercase Characters: " + map.get("upperCaseCharacter"));
        System.out.println("Lowercase Characters: " + map.get("lowerCaseCharacter"));
        System.out.println("Special Characters: " + map.get("specialCharacter"));
        System.out.println("All characters: " + map.get("allCharacter"));
    }
}
