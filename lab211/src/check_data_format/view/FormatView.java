package check_data_format.view;

import java.util.Scanner;

public class FormatView {
    Scanner sc = new Scanner(System.in);
    public String getNumber(){
        System.out.println("Enter phone number: ");
        return sc.nextLine();
    }
    public String getEmail(){
        System.out.println("Enter email: ");
        return sc.nextLine();
    }
    public String getDate(){
        System.out.println("Enter date (dd/MM/yyyy): ");
        return sc.nextLine();
    }
    public void showErrorMessage(String message){
        System.out.println(message);
    }
    public void showSuccessMessage() {
        System.out.println("All inputs are valid.");
    }

}
