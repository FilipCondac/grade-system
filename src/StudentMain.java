import java.util.ArrayList;

public class StudentMain {
    private static ArrayList<Grade> Grades = new ArrayList<Grade>();

    public static void main(String[] args) {
        //System.out.println(Student.userNameGenerator("Filip Condac", 12345));
        //Student first = new Student("Filip Condac", "Computing", 22, 12345,true);
        //System.out.println(first);
       //System.out.println(Grade.getLetterGrade(75));

        //Contacts.add(new Data(name, address, contact)); // Creating a new object and adding it to list - single step
        Student student1 = new Student("Bert Smith", "Computing", 21,12345, true);
        student1.Grades
        Student student2 = new Student("Olivia Green", "Computing", 19, 23464, true);
        Student student3 = new Student("Eloise Jones", "Computing", 18, 34744,true);
        Student student4 = new Student("Ben Bird", "Computing",42,34834, false);
        Student student5 = new Student("Karen Brown", "Computing", 25,45632, false);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
    }
}

