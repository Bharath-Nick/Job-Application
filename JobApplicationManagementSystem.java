import java.util.ArrayList;
import java.util.Scanner;

class JobApplication {
    int id;
    String name;
    String company;
    String role;
    String status;

    JobApplication(int id, String name, String company, String role) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.role = role;
        this.status = "Applied";
    }

    void display() {
        System.out.println("\nApplication ID : " + id);
        System.out.println("Candidate Name : " + name);
        System.out.println("Company        : " + company);
        System.out.println("Job Role       : " + role);
        System.out.println("Status         : " + status);
    }
}

public class JobApplicationManagementSystem {

    static ArrayList<JobApplication> applications = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Job Application Management System ===");
            System.out.println("1. Add Application");
            System.out.println("2. View Applications");
            System.out.println("3. Search Application");
            System.out.println("4. Update Status");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addApplication();
                    break;

                case 2:
                    viewApplications();
                    break;

                case 3:
                    searchApplication();
                    break;

                case 4:
                    updateStatus();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addApplication() {

        System.out.print("Enter Application ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Candidate Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Company Name: ");
        String company = sc.nextLine();

        System.out.print("Enter Job Role: ");
        String role = sc.nextLine();

        applications.add(new JobApplication(id, name, company, role));

        System.out.println("Application added successfully!");
    }

    static void viewApplications() {

        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (JobApplication app : applications) {
            app.display();
        }
    }

    static void searchApplication() {

        System.out.print("Enter Application ID: ");
        int id = sc.nextInt();

        for (JobApplication app : applications) {

            if (app.id == id) {
                app.display();
                return;
            }
        }

        System.out.println("Application not found.");
    }

    static void updateStatus() {

        System.out.print("Enter Application ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (JobApplication app : applications) {

            if (app.id == id) {

                System.out.print("Enter new status: ");
                app.status = sc.nextLine();

                System.out.println("Status updated successfully!");
                return;
            }
        }

        System.out.println("Application not found.");
    }
}