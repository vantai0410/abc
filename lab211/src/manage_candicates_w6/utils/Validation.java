//package manage_candicates_w6.utils;
//
//import java.util.Calendar;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Validation {
//    public static boolean isValidBirthYear(int year) {
//        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//        return String.valueOf(year).length() == 4 && year >= 1900 && year <= currentYear;
//    }
//
//    public static boolean isValidPhone(String phone) {
//        return phone.matches("\\d{10,}");
//    }
//
//    public static boolean isValidEmail(String email) {
//        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//        Pattern pattern = Pattern.compile(emailRegex);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
//
//    public static boolean isValidExperience(int expInYear) {
//        return expInYear >= 0 && expInYear <= 100;
//    }
//
//    public static boolean isValidGraduationRank(String rank) {
//        return rank.equalsIgnoreCase("Excellence") ||
//                rank.equalsIgnoreCase("Good") ||
//                rank.equalsIgnoreCase("Fair") ||
//                rank.equalsIgnoreCase("Poor");
//    }
//}
