import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
public class StudentMain {

    public static ArrayList<Student> Students = new ArrayList<Student>();

    public static void main(String[] args) {

        Student student1 = new Student("Bert Smith", "Computing", 21, 12345, true);
        Student student2 = new Student("Olivia Green", "Computing", 19, 23464, true);
        Student student3 = new Student("Eloise Jones", "Computing", 18, 34744, true);
        Student student4 = new Student("Ben Bird", "Computing", 42, 34834, false);
        Student student5 = new Student("Karen Brown", "Computing", 25, 45632, false);


        //Student 1 Grades
        student1.addGrade("Programming", 52.00);
        student1.addGrade("Web Dev", 63.00);
        student1.addGrade("Maths", 76.00);
        student1.addGrade("Algorithms", 68.00);

        //Student 2 Grades
        student2.addGrade("Programming", 73.00);
        student2.addGrade("Web Dev", 82.00);
        student2.addGrade("Maths", 72.00);
        student2.addGrade("Algorithms", 66.00);

        //Student 3 Grades
        student3.addGrade("Programming", 65.00);
        student3.addGrade("Web Dev", 63.00);
        student3.addGrade("Maths", 37.00);
        student3.addGrade("Algorithms", 40.00);

        //Student 4 Grades
        student4.addGrade("Programming", 55.00);
        student4.addGrade("Web Dev", 29.00);
        student4.addGrade("Maths", 56.00);
        student4.addGrade("Algorithms", 38.00);

        //Student 5 Grades
        student5.addGrade("Programming", 62.00);
        student5.addGrade("Web Dev", 51.00);
        student5.addGrade("Maths", 43.00);
        student5.addGrade("Algorithms", 43.00);

        //Manually adding Students
        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);

        menu();
    }

    public static void menu() {
        System.out.println("======Menu======");
        System.out.println("Press 1 for all student Grades");
        System.out.println("Press 2 for all students with fail");
        System.out.println("Press 3 for average of each student");
        System.out.println("Press 4 to create new student");
        System.out.println("Press 5 to quit the system");

        Scanner myScanner = new Scanner(System.in);
        int choice = myScanner.nextInt();

        switch (choice) {
            case 1:
                printStudentInfo();
                menu();
                break;
            case 2:
                studentFailed();
                menu();
                break;
            case 3:
                getStudentAverage();
                menu();
                break;
            case 4:
                addNewStudent();
                break;
            case 5:
                System.out.println("You have shut down the system");
                System.exit(1);

            default:
                System.out.println("Invalid input");
                menu();
                break;

        }

    }

    public static void printStudentInfo() {
        for (int i = 0; i < Students.size(); i++) {
            System.out.println(Students.get(i));
        }
    }

    public static void studentFailed() {
        for (int i = 0; i < Students.size(); i++) {
            for (int j = 0; j < Students.get(i).Grades.size(); j++) {
                if (Grade.getLetterGrade(Students.get(i).Grades.get(j).score) == 'F') {
                    System.out.println(Students.get(i).getName() + " has failed " + Students.get(i).Grades.get(j).subject);
                }
            }
        }

    }

    public static void addStudent(Student student) {
        Students.add(student);
    }

    public static void getStudentAverage(){
        for (int i = 0; i < Students.size(); i++) {
            double averageScore = 0;

            for (int j = 0; j < Students.get(i).Grades.size(); j++) {
                averageScore = averageScore + Students.get(i).Grades.get(j).score;
            }

            System.out.println(Students.get(i).getName()+ "'s average is: "+ averageScore / Students.get(i).Grades.size());
        }
    }

    public static void addNewStudent(){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter student First + Last Name. e.g: James Conway");

        String name="";

        name+=input.nextLine();

        System.out.println("Please enter the department the student belongs to");
        String department = input.next();

        System.out.println("Please enter the student's age");
        int age = input.nextInt();

        System.out.println("Please enter student number");
        int studentNumber = input.nextInt();

        System.out.println("Is student Full time?");
        System.out.println("Enter Y for yes and N for no");

        String fullTime = input.next();

        fullTime.toLowerCase(Locale.ROOT);
        boolean time = false;
        if(fullTime == "y"){
            time = true;
        }

        System.out.println("Please enter the students grades");
        System.out.println("Enter the Students grade for 'Programming'");
        double scoreProgramming = 0;
        scoreProgramming = input.nextDouble();

        System.out.println("Enter the Students grade for 'Web Dev'");
        double scoreWeb = 0;
        scoreWeb = input.nextDouble();

        System.out.println("Enter the Students grade for 'Maths'");
        double scoreMaths = 0;
        scoreMaths = input.nextDouble();

        System.out.println("Enter the Students grade for 'Algorithms'");
        double scoreAlgo = 0;
        scoreAlgo = input.nextDouble();

        Student newStudent = new Student(name,department,age, studentNumber, time);
        newStudent.addGrade("Programming", scoreProgramming);
        newStudent.addGrade("Web Dev", scoreWeb);
        newStudent.addGrade("Maths", scoreMaths);
        newStudent.addGrade("Algorithms", scoreAlgo);
        addStudent(newStudent);

        System.out.println("Student successfully added");
        menu();
    }
}

