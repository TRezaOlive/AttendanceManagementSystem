import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private boolean isPresent;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.isPresent = false;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void markAttendance(boolean present) {
        this.isPresent = present;
    }
}

class AttendanceManagementSystem {
    private ArrayList<Student> students;
    private HashMap<Integer, Boolean> attendance;

    public AttendanceManagementSystem() {
        students = new ArrayList<>();
        attendance = new HashMap<>();
    }

    public void addStudent(String name, int rollNumber) {
        Student student = new Student(name, rollNumber);
        students.add(student);
        attendance.put(rollNumber, false);
        System.out.println("Student added: " + student.getName() + " (Roll Number: " + student.getRollNumber() + ")");
    }

    public void markAttendance(int rollNumber, boolean present) {
        if (attendance.containsKey(rollNumber)) {
            attendance.put(rollNumber, present);
            System.out.println("Attendance marked for student with Roll Number " + rollNumber);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public void displayAttendanceReport() {
        System.out.println("Attendance Report:");
        for (Student student : students) {
            String attendanceStatus = student.isPresent() ? "Present" : "Absent";
            System.out.println("Student: " + student.getName() + " (Roll Number: " + student.getRollNumber() +
                    ") - Attendance: " + attendanceStatus);
        }
    }
}

public class AMS {
    public static void main(String[] args) {
        AttendanceManagementSystem attendanceSystem = new AttendanceManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Attendance Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Student Attendance");
            System.out.println("3. Display Attendance Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    attendanceSystem.addStudent(name, rollNumber);
                    break;
                case 2:
                    System.out.print("Enter student roll number: ");
                    int rollNum = scanner.nextInt();
                    System.out.print("Is the student present? (true/false): ");
                    boolean isPresent = scanner.nextBoolean();
                    attendanceSystem.markAttendance(rollNum, isPresent);
                    break;
                case 3:
                    attendanceSystem.displayAttendanceReport();
                    break;
                case 4:
                    System.out.println("Exiting the Attendance Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
