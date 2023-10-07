
package View;

import Modal.Doctor;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Scanner;


public class Validate {
    public int checkInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
        int result = Integer.parseInt(sc.nextLine().trim());
        if(result < min || result > max) {
            throw new NumberFormatException();
        }
        return result;    
        } catch(NumberFormatException e) {
                System.err.println("Please check input in rage [" + min + ", " + max + "] ");
                System.out.print("Enter again");
            }
        }
            
    }
    public String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String result = sc.nextLine().trim();
            if(result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again");
            } else {
                return result;
            }
            
        }
    }
    
    public int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
            int result = Integer.parseInt(sc.nextLine().trim());
            return result;
        } catch(NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again");
        }
     } 
    
    }
    
    public boolean checkInputYN() {
        
        while(true) {
            String result = checkInputString();
             if(result.equalsIgnoreCase("Y")) {
                 return true;
            } if(result.equalsIgnoreCase("N")) {
                return false;
            }
            
            System.err.println("Please input y/Y or n/N");
            System.out.print("Enter again: ");
        }
    }
    
    public boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if(code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkDuplicate(ArrayList<Doctor> ld, String code, String name, String specialization, int availability) {
        for (Doctor doctor : ld) {
            if(code.equalsIgnoreCase(doctor.getCode()) && name.equalsIgnoreCase(doctor.getName()) && specialization.equalsIgnoreCase(doctor.getSpecialization()) && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkChangeInfo(Doctor doctor , String code, String name, String specialization, int availability) {
        if(doctor.getCode().equalsIgnoreCase(code) && doctor.getName().equalsIgnoreCase(name) && doctor.getSpecialization().equalsIgnoreCase(specialization) && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
    
    
}
