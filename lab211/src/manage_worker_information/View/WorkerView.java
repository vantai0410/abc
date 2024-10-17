package manage_worker_information.View;

import manage_worker_information.Model.SalaryHistory;
import manage_worker_information.Model.Worker;

import java.util.List;

public class WorkerView {
    public void displayMenu() {
        System.out.println("======== Worker Management =========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void displaySalaryInformation(List<Worker> workerList) {
        System.out.println("----------------Display Information Salary----------------");
        System.out.printf("%-5s %-10s %-5s %-10s %-7s %-15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");

        for (Worker worker : workerList) {
            for (SalaryHistory salaryHistory : worker.getSalaryHistoryList()) {

                System.out.printf("%-5s %-10s %-5d %-10.2f %-7s %-15s\n",
                        worker.getId(),
                        worker.getName(),
                        worker.getAge(),
                        salaryHistory.getAdjustedSalary(),
                        salaryHistory.getStatus(),
                        salaryHistory.getDate());
            }

        }
    }
        public void displayNotification (String notice){
            System.out.println(notice);
        }
    }

