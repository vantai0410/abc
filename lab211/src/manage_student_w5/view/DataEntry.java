package manage_student_w5.view;

import java.util.Scanner;

public class DataEntry {
    public static String inputString(){
        Scanner scanner=new Scanner(System.in);
        while (true){
            String result=scanner.nextLine();
            if(!result.isEmpty()) return result;
            else{
                System.out.println("Please enter a string");
                System.out.println("Enter again");
            }
        }
    }
    public static String inputCourseName(){
        while (true){
            String result=inputString();
            if (result.equals("Java") || result.equals(".Net") || result.equals("C/C++")){
                return result;
            }else{
                System.out.println("Only three Course: Java, .Net, C/C++");
            }
        }
    }
    public static int inputPositiveInteger(){
        Scanner scanner=new Scanner(System.in);
        while (true){
            try{
                int result=Integer.parseInt(scanner.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Enter a integer number");
                System.out.println("Enter again: ");
            }
        }
    }
    public static int inputLimit(int min,int max){
        while (true){
            int result=inputPositiveInteger();
            if (result>=min && result<=max){
                return result;
            }else{
                System.out.println("Enter a number in the range"+min+"-"+max);
            }
        }
    }
    public static boolean inputYN(){
        System.out.println("Do you want to continue (Y/N)");
        while (true){
            String inputString=inputString();
            if (inputString.equalsIgnoreCase("Y")) return true;
            else if(inputString.equalsIgnoreCase("N")) return false;
            else {
                System.out.println("Enter Y/y or N/n");
                System.out.println("Enter again: ");
            }
        }
    }
}
