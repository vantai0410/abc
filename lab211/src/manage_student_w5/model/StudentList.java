package manage_student_w5.model;

import java.util.ArrayList;
import java.util.Collections;

public class StudentList {
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    public StudentList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public StudentList() {
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }
    public void addStudent(Student student) {
        studentArrayList.add(student);
    }
    public ArrayList<Student> findAndSort(ArrayList<Student> arrayList, String name){
        ArrayList<Student> result = new ArrayList<>();
        for(Student student : arrayList){
            if (student.getStudentName().contains(name)){
                result.add(student);
            }
        }
        Collections.sort(result,(c1,c2) -> c1.getStudentName().compareTo(c2.getStudentName()));
        return result;
    }
    public ArrayList<Integer> findById(ArrayList<Student> studentList, String id){
        ArrayList<Integer> result = new ArrayList<>();
        for(Student student : studentList){
            if(student.getId().equals(id)){
                result.add(studentList.indexOf(student));
            }
        }
        return result;
    }
    public void updateName(String newName,ArrayList<Integer> indexList){
        for(Integer i:indexList){
            this.studentArrayList.get(i).setStudentName(newName);
        }
    }
    public void updateSemester(String newSemester,ArrayList<Integer> indexList,int index){
        this.studentArrayList.get(indexList.get(index)).setSemester(newSemester);
    }
    public void updateCourse(String newCourse,ArrayList<Integer> indexList,int index){
        this.studentArrayList.get(indexList.get(index)).setCourseName(newCourse);
    }
    public void deleteStudent(ArrayList<Integer> indexList,int index){
        this.studentArrayList.remove(this.studentArrayList.get(indexList.get(index)));
    }
}
