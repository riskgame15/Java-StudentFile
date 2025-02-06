
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Mains {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));

        writeDataToFile("students.txt", students);

        List<Student> students2 = readDataFromFile("students.txt");
        for (Student student : students2) {
            System.out.println(student);
        }
    }

    public static void writeDataToFile(String filePath, List<Student> students) {
        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(students);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error when writing to file");
        }
    }

    public static List<Student> readDataFromFile(String filePath) {
        List<Student> students = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            students = (List<Student>) ois.readObject();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error when reading from file");
        }
        return students;
    }
}
