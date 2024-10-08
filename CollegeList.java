package CollegeList;

import java.util.Scanner;

public class CollegeList {

    public void promptUser() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.print("Press E for Employee, F for Faculty, or S for Student: ");
            try {
                char userChoice = userInput.nextLine().toUpperCase().charAt(0);
                checkUserChoice(userChoice);
            } catch (Exception e) {

            }
        }
    }

    public void checkUserChoice(char userChoice) {
        switch(userChoice) {
            case 'E':
                promptEmployee();
                break;
            case 'F':
                promptFaculty();
                break;
            case 'S':
                promptStudent();
                break;
            default:
                System.out.println("Incorrect");
                promptUser();
        }
    }

    public void promptFaculty() {

    }

    public void promptEmployee() {

    }

    public void promptStudent() {

    }
}