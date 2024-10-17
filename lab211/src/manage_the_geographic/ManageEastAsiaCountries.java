package manage_the_geographic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManageEastAsiaCountries {
    private EastAsiaCountryList countryList = new EastAsiaCountryList();
    Scanner sc = new Scanner(System.in);
    private List<String> choices = Arrays.asList(
            "MANAGEMENT SYSTEM",
            "1. Enter the information of countries in East Asia",
            "2. Display the information of the last entered country",
            "3. Search the country by name",
            "4. Display the information sorted by country name",
            "5. Exit"
    );
    public int getChoices(){
        choices.forEach(s -> System.out.println(s));
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice < 1 || choice > choices.size()){
            System.out.println("Invalid choice, enter agian");
            return -1;
        }
        return choice;
    }

    public void execute() {
        while (true) {
            int choice = getChoices();
            switch (choice) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    displayLastCountry();
                    break;
                case 3:
                    searchCountry();
                    break;
                case 4:
                    displaySortedCountries();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void addCountry() {
        while (true) {
            System.out.println("Enter the code of the country: ");
            String countryCode = sc.nextLine();
            System.out.println("Enter the name of the country: ");
            String countryName = sc.nextLine();
            float area;
            do {
                System.out.println("Enter the area of the country: ");
                area = sc.nextFloat();
                sc.nextLine();
                if (area<=0){
                    System.out.println("Enter again(>0)");
                }
            } while (area<=0);
            System.out.println("Enter country terrain: ");
            String terrain = sc.nextLine();

            EastAsiaCountries country = new EastAsiaCountries(countryCode, countryName, area, terrain);
            countryList.addCountry(country);
            System.out.print("Do u want to add new country? (y/n): ");
            String answer = sc.nextLine();
            if (answer.equals("n")) {
                break;
            }

        }
    }
    private void displayLastCountry() {
        EastAsiaCountries lastCountry = countryList.getLastCountry();
        if (lastCountry != null){
            lastCountry.display();
        }
    }
    private void searchCountry() {
        System.out.println("Enter the name of the country: ");
        String countryName = sc.nextLine();
        EastAsiaCountries country = countryList.searchByName(countryName);
        if (country != null){
            country.display();
        } else {
            System.out.println("Country not found");
        }
    }
    private void displaySortedCountries() {
        for (EastAsiaCountries countries : countryList.sortByName()){
            countries.display();
        }
    }

    public static void main(String[] args) {
        ManageEastAsiaCountries menu = new ManageEastAsiaCountries();
        menu.execute();
    }

}
