package dictionary.view;

import java.util.Scanner;

public class DictionaryView {
    Scanner sc = new Scanner(System.in);
    public void showMenu(){
        System.out.println("======== Dictionary Program ========");
        System.out.println("1. Add Word");
        System.out.println("2. Delete Word");
        System.out.println("3. Translate Word");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }
    public String inputEnglishWord(){
        System.out.println("Enter english word: ");
        String word = sc.nextLine();
        return word;
    }
    public String inputViWord(){
        System.out.println("Enter vi word: ");
        String word = sc.nextLine();
        return word;
    }
    public void displayResult(String result){
        System.out.println(result);
    }
    public void showMessage(String message) {
        System.out.println(message);
    }
    public int getChoice() {
        return Integer.parseInt(sc.nextLine());
    }


    }

