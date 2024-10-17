package manage_student_w5.controller;

import manage_student_w5.model.Student;
import manage_student_w5.model.StudentList;
import manage_student_w5.view.DataEntry;

import java.io.PrintStream;
import java.util.*;

public class ConsoleForm {private StudentList studentList=new StudentList();
    private List<String> choices= Arrays.asList("=====Student Management===",
            "1.Add student","2.FInd and sort","3. Update/Delete","4.Report","Input: ");

    public ConsoleForm() {
    }
    public int getChoices(){
        choices.forEach(s -> System.out.println(s));
        return DataEntry.inputLimit(1,5);
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public void setStudentList(StudentList studentList) {
        this.studentList = studentList;
    }
    public void inputInformation(){
        int count=0;
        boolean choice=false;
        while (count<3 || choice==true){
            System.out.println("Enter student id: ");
            String id=DataEntry.inputString();
            System.out.println("Enter student name: ");
            String name="";
            boolean isIdExist=false;
            for (Student s:studentList.getStudentArrayList()){
                if (s.getId().equals(id)){
                    name=s.getStudentName();
                    System.out.println(name);
                    isIdExist=true;
                    break;
                }
            }
            if (isIdExist==false) name=DataEntry.inputString();
            System.out.println("Enter semester: ");
            String semester=DataEntry.inputString();
            System.out.println("Enter course name: ");
            String course=DataEntry.inputCourseName();
            Student student=new Student(id,name,semester,course);
            studentList.addStudent(student);
            count+=1;
            if (count>2){
                choice=DataEntry.inputYN();
                if (!choice) break;
            }
        }
    }
    public void displayFindAndSort(){
        System.out.println("Enter name that you want to find: ");
        String id=DataEntry.inputString();
        ArrayList<Student> result=studentList.findAndSort(studentList.getStudentArrayList(),id);
        if (result.isEmpty()){
            System.out.println("Not Found");
        }
        System.out.printf("%-15s%-20s%-15s%-15s \n","ID","Student Name","Semester","Course");
        for (Student student:result){
            System.out.printf("%-15s%-20s%-15s%-15s \n",student.getId(),student.getStudentName(),student.getSemester(),student.getCourseName());       }
    }
    public void displayUpdateOrDelete(){
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Enter searched id: ");
        String id=DataEntry.inputString();
        ArrayList<Integer> indexOfFindStudent=studentList.findById(studentList.getStudentArrayList(),id);
        System.out.println("Results: ");
        if (!indexOfFindStudent.isEmpty()){
            System.out.printf("%-10s%-20s%-15s%-15s \n","Number","Name","Semester","Course");
            for (Integer i:indexOfFindStudent){
                System.out.printf("%-10s%-20s%-15s%-15s \n", i,
                        studentList.getStudentArrayList().get(i).getStudentName(),
                        studentList.getStudentArrayList().get(i).getSemester(),
                        studentList.getStudentArrayList().get(i).getCourseName());
            }
        }else{
            System.out.print("Not Found");
        }
        if (!indexOfFindStudent.isEmpty()){
            System.out.println("enter element's number you want to update or delete");
            int indexStudent=DataEntry.inputPositiveInteger();
            for(Integer i : indexOfFindStudent){
                if(i==indexStudent){
                    System.out.println("Do you want to update (U) or delete (D) this student: ");
                    String choice=DataEntry.inputString();

                    if (choice.equals("u") || choice.equals("U")){
                        System.out.println("Enter the new studentName: ");
                        String newName=scanner.nextLine();
                        if (!newName.isEmpty()){
                            studentList.updateName(newName,indexOfFindStudent);
                        }
                        System.out.println("Student name: "+studentList.getStudentArrayList().get(i).getStudentName());

                        System.out.println("Enter the new semester: ");
                        String newSemester=scanner.nextLine();
                        if(!newSemester.isEmpty()){
                            studentList.updateSemester(newSemester,indexOfFindStudent,i);
                        }
                        System.out.println("Semester: "+studentList.getStudentArrayList().get(i).getSemester());

                        System.out.println("Enter the new course: ");
                        String newCourse=scanner.nextLine();
                        if(!newCourse.isEmpty()){
                            studentList.updateCourse(newCourse,indexOfFindStudent,i);
                        }
                        System.out.println("Course: "+studentList.getStudentArrayList().get(i).getCourseName());
                        System.out.println("Just update information");
                    } else if ((choice.contentEquals("d")|| choice.contentEquals("D"))) {
                        studentList.deleteStudent(indexOfFindStudent,i);
                        System.out.println("Delete successfully");
                    }else{
                        System.out.println("Error: You should enter U or D.");
                    }
                }
            }
        }
    }
    public void displayReport(){
        HashMap<String,Integer> courseCount=new HashMap<>();
        HashSet<String> processedStudents=new HashSet<>();

        for (Student student: studentList.getStudentArrayList()){
            String key=student.getId()+"-"+student.getCourseName();
            courseCount.put(key,courseCount.getOrDefault(key,0)+1);
        }
        System.out.printf("%-10s%-20s%-15s%-15s \n", "ID","Name","Course","Total");

        for (Student student:studentList.getStudentArrayList()){
            String key =student.getId()+"-"+student.getCourseName();
            if (!processedStudents.contains(key)){
                System.out.printf("%-10s%-20s%-15s%-15s \n",student.getId(),student.getStudentName(),student.getSemester(),student.getCourseName(),courseCount.get(key));
                processedStudents.add(key);
            }
        }
    }
    public void execute(){
        Student s1=new Student("01","Ngo Van Tai","Fall21","Java");
        Student s2=new Student("02","Ngo Van Tuan","Fall21","Java");
        Student s3=new Student("03","Mai Van Khanh","Fall21",".Net");
        Student s4=new Student("04","Tai Van Ngo","Fall21","Java");
        Student s5=new Student("05","Bui Hong Quan","Fall21","Java");
        studentList.addStudent(s1);
        studentList.addStudent(s2);
        studentList.addStudent(s3);
        studentList.addStudent(s4);
        studentList.addStudent(s5);

        while (true){
            int choice=getChoices();
            switch (choice){
                case 1: inputInformation();break;
                case 2: displayFindAndSort();break;
                case 3: displayUpdateOrDelete();break;
                case 4: displayReport();break;
                case 5:System.exit(0);break;
            }
        }
    }
}
