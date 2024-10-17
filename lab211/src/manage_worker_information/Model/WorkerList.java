package manage_worker_information.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WorkerList {
    private List<Worker> workerList ;
    Scanner scanner = new Scanner(System.in);
    public WorkerList() {
        this.workerList = new ArrayList<>();
    }
    public Worker findWorkerById(String id) {
        for (Worker worker : workerList) {
            if(worker.getId().equals(id)) {
                return worker;
            }
        }
            return null;
    }
    public boolean addWorker(Worker worker) {
        if(worker.getId() == null || findWorkerById(worker.getId()) != null) {
            return false;
        }
        if(worker.getAge() < 18 || worker.getAge() > 50 || worker.getSalary() <= 0) {
            return false;
        }
        workerList.add(worker);
        return true;
    }
    public List<Worker> getAllWorkers() {
        return workerList;
    }
    public boolean changeSalary(String id, double salary, String status) {
        Worker worker = findWorkerById(id);
        if(worker == null || salary <= 0) {
            return false;
        }
        double newSalary;
        if(status.equals("UP")){
            newSalary = worker.getSalary() + salary;
        } else {
            newSalary = worker.getSalary() - salary;
            if(newSalary < 0) {
                return false;
            }
        }
        worker.setSalary(newSalary);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        worker.addSalaryHistory(new SalaryHistory(newSalary,status, currentDate));
        return true;
    }
}
