//package manage_candicates_w6.view;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class CandicateView {
//    Scanner sc = new Scanner(System.in);
//    public int showMenu(){
//        List<String> menu = Arrays.asList(
//                "CANDIDATE MANAGEMENT SYSTEM",
//                "1. Add Experience",
//                "2. Add Fresher",
//                "3. Add Intern",
//                "4. Search Candidate",
//                "5. Exit"
//        );
//        for (String option : menu) {
//            System.out.println(option);
//        }
//        System.out.println("your choice: ");
//        return Integer.parseInt(sc.nextLine());
//    }
//    public String getInput(String prompt) {
//        System.out.print(prompt);
//        return sc.nextLine();
//    }
//
//    public void showMessage(String message) {
//        System.out.println(message);
//    }
//}
