
package Controller;

import Modal.Doctor;
import View.Validate;
import java.util.ArrayList;
import java.util.HashMap;


public class Manager {
    Validate vl = new Validate();
    public int menu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        int choice = vl.checkInputIntLimit(1, 5);
        return choice;
    }
    
    public void addDoctor(ArrayList<Doctor> ld) {
        
        System.out.print("Enter code:");
        String code = vl.checkInputString();
        if(!vl.checkCodeExist(ld, code)) {
            System.err.println("Code exist");
            return;
        }
        System.out.print("Enter name: ");
        String name = vl.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = vl.checkInputString();
        System.out.print("Enter availability: ");
        int availability = vl.checkInputInt();
        if(!vl.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful");
        
    }
    
    public void updateDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = vl.checkInputString();
        if(vl.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        System.out.print("Enter code: ");
        String codeUpdate = vl.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("Enter name: ");
        String name = vl.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = vl.checkInputString();
        System.out.print("Enter availability: ");
        int availability = vl.checkInputInt();
        if(!vl.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.out.println("Update successful");
        
    }
    
    public void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = vl.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if(doctor == null) {
            System.err.println("Not found doctor");
            return;
        } else {
            ld.remove(doctor);
        }
        System.out.println("Delete successful");
    }
    
    public void searchDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter name: ");
        String nameSeach = vl.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSeach);
        if(listFoundByName.isEmpty()) {
            System.err.println("List Empty");
        } else {
            System.out.printf("%-15s%-20s%-30s%-25s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-15s%-20s%-30s%-25d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
        
        
    }
    
    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if(doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }
    
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if(doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
