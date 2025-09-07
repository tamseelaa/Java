package week3.task1;

import java.io.*;
import java.time.LocalDate;

class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id; this.name = name; this.age = age;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String code, String name, String instructor) {
        this.courseCode = code; this.courseName = name; this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{code='" + courseCode + "', name='" + courseName + "', instructor='" + instructor + "'}";
    }
}

class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student; this.course = course; this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollment{" + student + ", " + course + ", date='" + enrollmentDate + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        String filename = "enrollments.ser";

        Student s1 = new Student(1, "Alia", 20);
        Course c1 = new Course("CS402", "Programming", "Finn hel");
        Enrollment e1 = new Enrollment(s1, c1, LocalDate.now().toString());

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(e1);
            System.out.println("Serialized Enrollment: " + e1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Enrollment readEnrollment = (Enrollment) ois.readObject();
            System.out.println("Deserialized Enrollment: " + readEnrollment);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}