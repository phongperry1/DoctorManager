
package View;

import Controller.Manager;
import Modal.Doctor;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        Manager mn = new Manager();
                
        while(true) {
            int choice = mn.menu();
            switch (choice) {
                case 1:
                    mn.addDoctor(ld);
                    break;
                case 2:
                    mn.updateDoctor(ld);
                    break;
                case 3:
                    mn.deleteDoctor(ld);
                    break;
                case 4:
                    mn.searchDoctor(ld);
                    break;
                case 5:
                    return;
                
            }
        }
    }
}
