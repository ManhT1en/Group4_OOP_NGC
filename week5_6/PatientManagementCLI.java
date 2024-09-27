import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;
    int id;
    String history;
    String status;

    public Patient(String name, int id, String history, String status) {
        this.name = name;
        this.id = id;
        this.history = history;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", History: " + history + ", Status: " + status;
    }
}

public class PatientManagementCLI {
    private static ArrayList<Patient> patients = new ArrayList<>();

    

    // 1. Search for a Patient
    private static void searchPatient(Scanner scanner) {
        System.out.print("Enter Patient Name or ID to search: ");
        String input = scanner.nextLine();
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.name.equalsIgnoreCase(input) || Integer.toString(patient.id).equals(input)) {
                System.out.println("Patient found: " + patient);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    // 2. Create a Patient Record
    private static void createPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient History: ");
        String history = scanner.nextLine();
        System.out.print("Enter Patient Status: ");
        String status = scanner.nextLine();

        Patient newPatient = new Patient(name, id, history, status);
        patients.add(newPatient);
        System.out.println("Patient record created: " + newPatient);
    }

    // 3. Delete a Patient Record
    private static void deletePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        boolean removed = false;

        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).id == id) {
                patients.remove(i);
                removed = true;
                System.out.println("Patient record deleted.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Patient not found with ID: " + id);
        }
    }
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
        
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an action: ");
            System.out.println("1. Search for a Patient");
            System.out.println("2. Create a Patient Record");
            System.out.println("3. Delete a Patient Record");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    searchPatient(scanner);
                    break;
                case 2:
                    createPatient(scanner);
                    break;
                case 3:
                    deletePatient(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } 
    } finally {
        scanner.close();
    }
}
}

