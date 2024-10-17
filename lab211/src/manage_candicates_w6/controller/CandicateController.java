//package manage_candicates_w6.controller;
//
//import manage_candicates_w6.model.Candicate;
//import manage_candicates_w6.model.Fresher;
//import manage_candicates_w6.model.Intern;
//import manage_candicates_w6.utils.Validation;
//import manage_candicates_w6.view.CandicateView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CandicateController {
//    private CandicateView view;
//    List<Candicate> candicateList = new ArrayList<>();
//
//    public CandicateController(CandicateView view, List<Candicate> candicateList) {
//        this.view = view;
//        this.candicateList = candicateList;
//    }
//
//    public void start() {
//        while (true) {
//            int choice = view.showMenu();
//            switch (choice) {
//                case 1:
//                case 2:
//                case 3:
//                    addCandidate(choice);
//                    break;
//                case 4:
//                    searchCandidate();
//                    break;
//                case 5:
//                    view.showMessage("Exiting program...");
//                    return;
//                default:
//                    view.showMessage("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private void addCandidate(int candivateType) {
//        String id = view.getInput("Enter Candidate ID: ");
//        String firstName = view.getInput("Enter First Name: ");
//        String lastName = view.getInput("Enter Last Name: ");
//
//        int birthDate = getValidBirthYear();
//        String address = view.getInput("Enter Address: ");
//        String phone = getValidPhone();
//        String email = getValidEmail();
//        switch (candivateType) {
//            case 1:
//                int explnYear = getValidExperience();
//                String skill = view.getInput("Enter Skill: ");
//                candicateList.add(new Candicate(id, firstName, lastName, birthDate, address, phone, email, explnYear, skill));
//                break;
//            case 2:
//                String graduationDate = view.getInput("Enter Graduation Date: ");
//                String graduationRank = getValidGraduationRank();
//                String education = view.getInput("Enter Education: ");
//                //candicateList.addC(new Fresher(id, firstName, lastName, birthDate, address, phone, email, graduationDate, graduationRank, education));
//                break;
//            case 3:
//                String major = view.getInput("Enter Major: ");
//                int semester = Integer.parseInt(view.getInput("Enter Semester: "));
//                String universityName = view.getInput("Enter University Name: ");
//                //candidateList.addCandidate(new Intern(id, firstName, lastName, birthDate, address, phone, email, major, semester, universityName));
//                break;
//        }
//        view.showMessage("Candidate added successfully!");
//
//    }
//}
//
//public int getValidBirthYear() {
//    int year;
//    year = Integer.parseInt(view.getInput("Enter Birth Year (1900 to current year): "));
//    if (Validation.isValidBirthYear(year)) {
//        break;
//    } else {
//        view.showMessage("Invalid birth year. Please enter a valid 4-digit year.");
//    }
//    return year;
//}
//
//public String getValidPhone() {
//    String phone;
//    while (true) {
//        phone = view.getInput("Enter Phone Number: ");
//        if (Validation.isValidPhone(phone)) {
//            break;
//        } else {
//            view.showMessage("Invalid phone number. Please enter a valid phone number.");
//        }
//    }
//    return phone;
//}
//
//public String getValidEmail() {
//    String email;
//    while (true) {
//        email = view.getInput("Enter Email: ");
//        if (Validation.isValidEmail(email)) {
//            break;
//        } else {
//            view.showMessage("Invalid email address. Please enter a valid email address.");
//        }
//    }
//    return email;
//}
//
//public int getValidExperience() {
//    int expInYear;
//    while (true) {
//        expInYear = Integer.parseInt(view.getInput(" enter year 0 to 100: "));
//        if (Validation.isValidExperience(expInYear)) {
//            break;
//        } else {
//            view.showMessage("Invalid year. Please enter a valid year.");
//        }
//    }
//    return expInYear;
//}
//
//public String getValidGraduationRank() {
//    String rank;
//    while (true) {
//        rank = view.getInput("Enter Graduation Rank (Excellence, Good, Fair, Poor): ");
//        if (Validation.isValidGraduationRank(rank)) {
//            break;
//        } else {
//            view.showMessage("Invalid rank. Please enter one of the following: Excellence, Good, Fair, Poor.");
//        }
//    }
//    return rank;
//}
//
//
