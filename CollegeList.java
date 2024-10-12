package CollegeList;

import java.util.Scanner;

public class CollegeList implements Runnable {

    public void promptUser() {
        clearScreen();
        Scanner userInput = new Scanner(System.in);
        System.out.print("Press E for Employee, F for Faculty, or S for Student: ");
        try {
            char userChoice = userInput.nextLine().toUpperCase().trim().charAt(0);
            checkUserType(userChoice, userInput);
        } catch (Exception e) {
            System.out.println("Invalid characters! Please try again!");
            promptUser();
        }
    }

    private void checkUserType(char userChoice, Scanner userInput) {
        switch(userChoice) {
            case 'E':
                getEmployeeInformation(userInput);
                break;
            case 'F':
                getFacultyType(userInput);
                break;
            case 'S':
                getStudentInformation(userInput);
                break;
            default: 
                System.out.println("Invalid choice! Please try again.");
                promptUser();
        }
    }

    private void printFacultyInformation(Scanner userInput, Faculty facultyObject) {
            System.out.println("Name: " + facultyObject.getName());
            System.out.println("Contact Number: " + facultyObject.getContactNum());
            System.out.println("Salary: " + facultyObject.getSalary());
            System.out.println("Department: " + facultyObject.getDepartment());
            if (facultyObject.isRegular()) {
                System.out.println("Status: Regular");
            } else {
                System.out.println("Status: Not regular");
            }
    }

    private void getFacultyType(Scanner userInput) {
        Faculty facultyObject = new Faculty();
        while (true) {
            System.out.print("Press Y if the faculty member is a regular, otherwise press N if not: ");
            String choice = userInput.nextLine().toUpperCase().trim();
            if (choice.equals("Y")) {
                facultyObject.setRegular(true);
                getFacultyInformation(userInput);
                break;
            } else if (choice.equals("N")) {
                facultyObject.setRegular(false);
                getFacultyInformation(userInput);
                break;
            } else {
                printErrorInvalidInput();
            }
        }
    }

    private void getFacultyInformation(Scanner userInput) {
        Faculty facultyObject = new Faculty();
        while (true) {
            try {
                System.out.println("Type employee's name, contact number, salary, and department.");
                System.out.println("Press Enter after every input.");
                facultyObject.setName(userInput.nextLine());
                facultyObject.setContactNum(userInput.nextLine());
                facultyObject.setSalary(userInput.nextDouble());
                facultyObject.setDepartment(userInput.next());
                printFacultyInformation(userInput, facultyObject);
            } catch (Exception e) {
                printErrorInvalidInput();
                continue;
            }
        }
    }

    private void printEmployeeInformation(Scanner userInput) {
        Employee employeeObject = new Employee();
        getEmployeeInformation(userInput, employeeObject);
        System.out.println("Name: " + employeeObject.getName());
        System.out.println("Contact Number: " + employeeObject.getContactNum());
        System.out.println("Salary: " + employeeObject.getSalary());
        System.out.println("Department: " + employeeObject.getDepartment());
    }

    private void getEmployeeInformation(Scanner userInput, Employee employeeObject) { 
        while (true){
            try {
                System.out.println("Type employee's name, contact number, salary, and department.");
                System.out.println("Press Enter after every input.");
                employeeObject.setName(userInput.nextLine());
                employeeObject.setContactNum(userInput.nextLine());
                employeeObject.setSalary(userInput.nextDouble());
                employeeObject.setDepartment(userInput.next());
            } catch (Exception e) {
                printErrorInvalidInput();
                continue;
            }
        }
        
    }



    private void promptStudent(Scanner userInput) {
        System.out.println("Type student's name, contact number, enrolled program, and year level.");
        System.out.println("Press Enter after every input.");
        Student studentObject = new Student();


        studentObject.setName(userInput.nextLine());
        studentObject.setContactNum(userInput.nextLine());
        studentObject.setProgram(userInput.nextLine());
        studentObject.setYearLevel(userInput.nextInt());


        System.out.println("Name: " + studentObject.getName());
        System.out.println("Contact Number: " + studentObject.getContactNum());
        System.out.println("Enrolled Program: " + studentObject.getProgram());
        System.out.println("Year level: " + studentObject.getYearLevel());
    }

    /*
     * EXTERNAL METHODS
     */


    void printErrorInvalidInput() {
        clearScreen();
        System.out.print("Invalid input, please try again. ");
        char[] characters = {'.',' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            pause(300);
        }
    }

    void printErrorInvalidUserType() {
        clearScreen();
        System.out.print("Invalid user type! E for Employee, F for Faculty, or S for Student. Please try again. ");
        char[] characters = {'.', ' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            pause(300);
        }
    }

    void printErrorInvalidFacultyType() {
        clearScreen();
        System.out.print("Enter 'y' or 'n' only. Please try again. ");
        char[] characters = {'.', ' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            pause(300);
        }
    }

    @Override
    public void run() {
        pause(0);
    }

    void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}