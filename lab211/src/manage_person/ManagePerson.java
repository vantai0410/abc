package manage_person;

import java.util.Scanner;

public class ManagePerson {
    public static Person inputPersonInfo(){
        Scanner sc = new Scanner(System.in);
        double salary=0;
        boolean valid=false;
        System.out.println("please input name: ");
        String name = sc.nextLine();
        System.out.println("please input address: ");
        String address = sc.nextLine();
        while (!valid) {
            try {
                System.out.print("Please input salary: ");
                String sSalary = sc.nextLine();
                salary = Double.parseDouble(sSalary);

                if (salary <= 0) {
                    throw new Exception("Salary must be greater than zero");
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("You must input a valid number.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return new Person(name, address, salary);
    }

    public static void sortBySalary(Person[] persons) {
        int n = persons.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (persons[j].getSalary() > persons[j + 1].getSalary()) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] persons = new Person[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Input information for person " + (i + 1) + ":");
            persons[i] = inputPersonInfo();
        }
        sortBySalary(persons);
        System.out.println("Persons sorted by salary in ascending order:");
        for (Person person : persons) {
            person.display();
            System.out.println("--------------------");
        }

        scanner.close();
    }
    }

