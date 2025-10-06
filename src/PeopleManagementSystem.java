import java.util.*;
import java.io.*;

public class PeopleManagementSystem {
    private static final String FILE_NAME = "people.txt";
    private static ArrayList<Person> people = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();

        int choice;
        do {
            showMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> listPeople();
                case 3 -> searchById();
                case 4 -> searchByName();
                case 5 -> removePerson();
                case 6 -> celebrateBirthday();
                case 7 -> evaluateAll();
                case 8 -> recursionDemo();
                case 9 -> { saveData(); System.out.println("Data saved. Exiting program..."); }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);
    }

    private static void showMenu() {
        System.out.println("\n=== People Management System ===");
        System.out.println("1. Add Person");
        System.out.println("2. List People");
        System.out.println("3. Search Person by ID");
        System.out.println("4. Search Person by Name");
        System.out.println("5. Remove Person");
        System.out.println("6. Celebrate Birthday");
        System.out.println("7. Show Performance Evaluation");
        System.out.println("8. Run Countdown (Recursion Demo)");
        System.out.println("9. Save & Exit");
    }

    private static int readInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double readDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static void addPerson() {
        System.out.println("1. Student  2. Professor  3. Teaching Assistant");
        int type = readInt("Choose type: ");

        int id = readInt("Enter ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        int age = readInt("Enter Age: ");

        switch (type) {
            case 1 -> {
                System.out.print("Enter Program: ");
                String program = sc.nextLine();
                int year = readInt("Enter Year: ");
                double gpa = readDouble("Enter GPA (0.0–4.0): ");
                people.add(new Student(id, name, age, program, year, gpa));
            }
            case 2 -> {
                System.out.print("Enter Department: ");
                String dept = sc.nextLine();
                System.out.print("Enter Title: ");
                String title = sc.nextLine();
                int courses = readInt("Enter Courses Taught: ");
                people.add(new Professor(id, name, age, dept, title, courses));
            }
            case 3 -> {
                System.out.print("Enter Program: ");
                String program = sc.nextLine();
                int year = readInt("Enter Year: ");
                double gpa = readDouble("Enter GPA: ");
                System.out.print("Enter Assigned Course: ");
                String course = sc.nextLine();
                people.add(new TeachingAssistant(id, name, age, program, year, gpa, course));
            }
            default -> System.out.println("Invalid type!");
        }
    }

    private static void listPeople() {
        if (people.isEmpty()) {
            System.out.println("No people found.");
            return;
        }
        people.forEach(System.out::println);
    }

    private static void searchById() {
        int id = readInt("Enter ID: ");
        for (Person p : people) {
            if (p.getId() == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("No person found with that ID.");
    }

    private static void searchByName() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        for (Person p : people) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("No person found with that name.");
    }

    private static void removePerson() {
        int id = readInt("Enter ID to remove: ");
        people.removeIf(p -> p.getId() == id);
        System.out.println("If person existed, they have been removed.");
    }

    private static void celebrateBirthday() {
        int id = readInt("Enter ID: ");
        for (Person p : people) {
            if (p.getId() == id) {
                p.celebrateBirthday();
                return;
            }
        }
        System.out.println("Person not found.");
    }

    private static void evaluateAll() {
        for (Person p : people) {
            if (p instanceof Evaluable eval) eval.evaluatePerformance();
        }
    }

    // === RECURSION DEMO ===
    private static void recursionDemo() {
        int n = readInt("Enter number for countdown: ");
        countdown(n);
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }

    private static void countdown(int n) {
        if (n <= 0) {
            System.out.println("Blast off!");
            return;
        }
        System.out.println(n);
        countdown(n - 1);
    }

    private static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // === FILE I/O ===
    private static void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Person p : people) pw.println(p.toString());
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        System.out.println("Loaded existing people data (display only; full reload not implemented).");
    }
}
