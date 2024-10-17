package manage_worker_information.Controller;

import manage_worker_information.Model.SalaryHistory;
import manage_worker_information.Model.Worker;
import manage_worker_information.Model.WorkerList;
import manage_worker_information.View.WorkerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WorkerController {
    private WorkerList workerList;
    private WorkerView workerView;
    Scanner scanner = new Scanner(System.in);

    public WorkerController(WorkerList workerList, WorkerView workerView) {
        this.workerList = workerList;
        this.workerView = workerView;
    }



    public void run() {
        int choice;
        do {
            workerView.displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer vì sau nextInt có 1 daasu \n

            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    changeSalary("UP");
                    break;
                case 3:
                    changeSalary("DOWN");
                    break;
                case 4:
                    displaySalaryInformation();
                    break;
                case 5:
                    workerView.displayNotification("Exiting program...");
                    break;
                default:
                    workerView.displayNotification("Invalid option. Please choose a valid one.");
            }
        } while (choice != 5);
    }
    public void addWorker() {
        System.out.println("--------- Add Worker ----------");
        System.out.print("Enter Code: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Work Location: ");
        String workLocation = scanner.nextLine();
        Worker worker = new Worker(id,name,age,salary,workLocation);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        worker.addSalaryHistory(new SalaryHistory(salary, "_", currentDate));
        if(workerList.addWorker(worker)) {
            workerView.displayNotification("Added worker successfully!");
        } else {
            workerView.displayNotification("Failed to add worker.");
        }
    }
    public void changeSalary(String status) {
        System.out.println(status.equals("UP") ? "------- Increase Salary --------" : "------- Decrease Salary --------");
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter amount of money: ");
        double amount = scanner.nextDouble();
        if(workerList.changeSalary(code,amount,status)){
            workerView.displayNotification("Salary " + (status.equals("UP") ? "increased" : "decreased") + " successfully.");
        } else {
            workerView.displayNotification("Failed to change salary.");
        }
    }
    public void displaySalaryInformation() {
        workerView.displaySalaryInformation(workerList.getAllWorkers());
    }

    public static void main(String[] args) {
        WorkerList workerList = new WorkerList();
        WorkerView workerView = new WorkerView();
        WorkerController controller = new WorkerController(workerList,workerView);
        controller.run();;
    }
}
