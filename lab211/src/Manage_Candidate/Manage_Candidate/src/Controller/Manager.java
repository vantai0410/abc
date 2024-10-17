//package Controller;
//
//
//import Model.Candicate;
//import Model.Experience;
//import Model.Fresher;
//import Model.Internship;
//import View.Validation;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class Manager {
//
//    //display menu
//    public static int menu() {
//        System.out.println("1. Experience");
//        System.out.println("2. Fresher");
//        System.out.println("3. Internship");
//        System.out.println("4. Searching");
//        System.out.println("5. Exit");
//        System.out.print("Enter your choice: ");
//        int choice = Validation.checkInputIntLimit(1, 5);
//        return choice;
//    }
//
//    public static void createCandidate(ArrayList<Candicate> candidates,int type) {
//        while (true) {
//            System.out.print("Enter id: ");
//            String id = Validation.checkInputString();
//            System.out.print("Enter first name: ");
//            String firstName = Validation.checkInputString();
//            System.out.print("Enter last name: ");
//            String lastName = Validation.checkInputString();
//            System.out.print("Enter birth date: ");
//            int birthDate = Validation.checkInputIntLimit(1900,
//                    Calendar.getInstance().get(Calendar.YEAR));
//            System.out.print("Enter address: ");
//            String address = Validation.checkInputString();
//            System.out.print("Enter phone: ");
//            String phone = Validation.checkInputPhone();
//            System.out.print("Enter email: ");
//            String email = Validation.checkInputEmail();
//            Candicate candidate = new Candicate(id, firstName, lastName,
//                    birthDate, address, phone, email, type);
//            //check id exist or not
//            if (Validation.checkIdExist(candidates, id)) {
//                switch (type) {
//                    case 0:
//                        createExperience(candidates, candidate);
//                        break;
//                    case 1:
//                        createFresher(candidates, candidate);
//                        break;
//                    case 2:
//                        createInternship(candidates, candidate);
//                        break;
//                }
//            } else {
//                return;
//            }
//            System.out.print("Do you want to continue (Y/N): ");
//            if (!Validation.checkInputYN()) {
//                return;
//            }
//        }
//    }
//
//    public static void createExperience(ArrayList<Candicate> candidates,
//                                        Candicate candidate) {
//        System.out.print("Enter year of experience: ");
//        int yearExperience = Validation.checkInputExprience(candidate.getBirthDate());
//        System.out.print("Enter professional skill: ");
//        String professionalSkill = Validation.checkInputString();
//        candidates.add(new Experience(yearExperience, professionalSkill,
//                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
//                candidate.getBirthDate(), candidate.getAddress(),
//                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
//        System.err.println("Create success.");
//    }
//    public static void createFresher(ArrayList<Candicate> candidates,
//                                     Candicate candidate) {
//        System.out.print("Enter graduation date: ");
//        String graduationDate = Validation.checkInputString();
//        System.out.print("Enter graduation rank: ");
//        String graduationRank = Validation.checkInputGraduationRank();
//        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
//                candidate.getFirstName(), candidate.getLastName(),
//                candidate.getBirthDate(), candidate.getAddress(),
//                candidate.getPhone(), candidate.getEmail(),
//                candidate.getTypeCandidate()));
//        System.err.println("Create success.");
//    }
//
//    public static void createInternship(ArrayList<Candicate> candidates,
//                                        Candicate candidate) {
//        System.out.print("Enter major: ");
//        String major = Validation.checkInputString();
//        System.out.print("Enter semester: ");
//        String semester = Validation.checkInputString();
//        System.out.print("Enter university: ");
//        String university = Validation.checkInputString();
//        candidates.add(new Internship(major, semester, university, candidate.getId(),
//                candidate.getFirstName(), candidate.getLastName(),
//                candidate.getBirthDate(), candidate.getAddress(),
//                candidate.getPhone(), candidate.getEmail(),
//                candidate.getTypeCandidate()));
//        System.err.println("Create success.");
//    }
//
//    //allow user search candidate by name
//    public static void searchCandidate(ArrayList<Candicate> candidates) {
//        printListNameCandidate(candidates);
//        System.out.print("Enter andidate name (First name or Last name): ");
//        String nameSearch = Validation.checkInputString();
//        System.out.print("Enter type of candidate: ");
//        int typeCandidate = Validation.checkInputIntLimit(0, 2);
//        for (Candicate candidate : candidates) {
//            if (candidate.getTypeCandidate() == typeCandidate
//                    && candidate.getFirstName().contains(nameSearch)
//                    || candidate.getLastName().contains(nameSearch)) {
//                System.out.println(candidate.toString());
//            }
//        }
//    }
//
//    public static void printListNameCandidate(ArrayList<Candicate> candidates) {
//        System.err.println("Experience Candidate");
//        for (Candicate candidate : candidates) {
//            if (candidate instanceof Experience) {
//                System.out.println(candidate.getFirstName() + " "
//                        + candidate.getLastName());
//            }
//        }
//        System.err.println("Fresher Candidate");
//        for (Candicate candidate : candidates) {
//            if (candidate instanceof Fresher) {
//                System.out.println(candidate.getFirstName() + " "
//                        + candidate.getLastName());
//            }
//        }
//        System.err.println("Internship Candidate");
//        for (Candicate candidate : candidates) {
//            if (candidate instanceof Internship) {
//                System.out.println(candidate.getFirstName() + " "
//                        + candidate.getLastName());
//            }
//        }
//    }
//}
