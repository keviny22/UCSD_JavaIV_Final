package com.adv.java.iostream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;

public class Lesson1IOStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String cmdSwitch = args[0];
        Employee employee = null;
        switch (cmdSwitch) {
            case "--help":
                displayHelp();
                break;
            case "--text":
                writeText();
                employee = readText();
                printEmployee(employee);

                break;
            case "--binary":
                writeBinary();
                employee = readBinary();
                printEmployee(employee);

                break;
            case "--object":
                writeObject();
                employee = readObject();
                printEmployee(employee);


                break;
            default:
                break;
        }
    }



    private static Employee readBinary() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("employee.bin")));
        Employee employee = null;
        while (dataInputStream.available() > 0)  {
            String name = dataInputStream.readUTF();
            double salary = dataInputStream.readDouble();
            String hireDay = dataInputStream.readUTF();
            LocalDate hireDate = LocalDate.parse(hireDay);
            int year = hireDate.getYear();
            int month = hireDate.getMonthValue();
            int day = hireDate.getDayOfMonth();
            employee = new Employee(name, salary, year, month, day);
        }

        dataInputStream.close();
        return employee;
    }

    private static void writeBinary() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("employee.bin")));
        Employee e = new Employee("John Doe", 123, 1980, 9, 10);

        dataOutputStream.writeUTF(e.getName());
        dataOutputStream.writeDouble(e.getSalary());
        dataOutputStream.writeUTF(e.getHireDay());
        dataOutputStream.close();

    }

    public static void printEmployee(Employee employee) {

        System.out.printf("Name: %s\n", employee.getName());
        System.out.printf("Salary: %s\n", employee.getSalary());
        System.out.printf("Hire Day: %s\n", employee.getHireDay());

    }

    public static void displayHelp() {
        System.out.println("--help (displays help info)");
        System.out.println("--text (writes/reads as text file and displays results on console)");
        System.out.println("--binary (writes/reads as binary file and displays results on console)");
        System.out.println("--object (writes/reads as object file and displays results on console)");
    }

    public static Employee readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myfile.dat"));
        return (Employee) ois.readObject();
    }

    public static void writeObject() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myfile.dat"));
        Employee e = new Employee("John Doe", 123, 1980, 9, 10);
        oos.writeObject(e);
    }

    public static Employee readText() throws IOException {
        String filename = "myfile.txt";
        System.out.println("Getting file: " + filename);
        Path path = Paths.get(filename);
        String s = new String(Files.readAllBytes(path), "UTF-8");
        String[] tokens = s.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);

    }

    public static void writeText() throws IOException {
        String filename = "myfile.txt";
        System.out.println("Writing to file: " + filename);
        PrintWriter printWriter = new PrintWriter(filename,"UTF-8");
        Employee employee= new Employee("John Doe", 123, 1980, 9, 10);
        printWriter.printf("%s|%s|%s", employee.getName(),employee.getSalary(),employee.getHireDay());
        printWriter.close();
    }

}
