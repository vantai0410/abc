package doctor_management;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
    private List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        for (Doctor doc : doctors) {
            if (doc.getCode().equals(doctor.getCode())) {
                System.out.println("Doctor already exists");
                return;
            }
        }
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    public void updateDoctor(String code, String name, String specialization, String availabilityStr) {
        boolean found = false;
        for (Doctor doc : doctors) {
            if (doc.getCode().equals(code)) {
                found = true;
                if (!name.isEmpty()) {
                    doc.setName(name);
                }
                if (!specialization.isEmpty()) {
                    doc.setSpecialization(specialization);
                }
                if (!availabilityStr.isEmpty()) {
                    int availability = Integer.parseInt(availabilityStr);
                    doc.setAvailability(availability);
                }
                System.out.println("Doctor updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Doctor not found.");
        }
    }

    public void deleteDoctor(String code) {
        boolean found = false;
        for (Doctor doc : doctors) {
            if (doc.getCode().equals(code)) {
                doctors.remove(doc);
                found = true;
                System.out.println("Doctor deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Doctor not found.");
        }
    }

    public void viewAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor doc : doctors) {
                System.out.println(doc);
            }
        }
    }
}
