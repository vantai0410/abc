package manage_the_geographic;

import java.util.Collections;
import java.util.ArrayList;

public class EastAsiaCountryList {
    private ArrayList<EastAsiaCountries> countryList;

    public EastAsiaCountryList() {
        countryList = new ArrayList<>();
    }

    public void addCountry(EastAsiaCountries country) {
        countryList.add(country);
        System.out.println("country add to the list");
    }
    public EastAsiaCountries getLastCountry() {
        if (countryList.isEmpty()) {
            System.out.println("No countries in the list.");
            return null;
        }
        return countryList.get(countryList.size() - 1);
    }
    public EastAsiaCountries searchByName(String name) {
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                return country;
            }
        }
        return null;
    }

    public ArrayList<EastAsiaCountries> sortByName() {
        ArrayList<EastAsiaCountries> sortedList = new ArrayList<>(countryList);
        Collections.sort(sortedList, (c1, c2) -> c1.getCountryName().compareTo(c2.getCountryName()));
        return sortedList;
    }
}
