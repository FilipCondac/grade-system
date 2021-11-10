import java.util.ArrayList;

public class Student {

    String name = "";
    String department = "";
    int age = 0;
    String userName = "";
    int studentNumber = 0;
    boolean fullTime = false;

    public ArrayList<Grade> Grades = new ArrayList<Grade>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public Student(String name, String department, int age, int studentNumber, boolean fullTime) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.studentNumber = studentNumber;
        this.fullTime = fullTime;
        this.userName = userNameGenerator(name, studentNumber);
    }

    static String userNameGenerator(String name, int studentNumber){
        char[] username = new char[5];

        //First letter of first name + next 4 after space
        for (int i = 0; i < name.length(); i++) {
            username[0] = name.charAt(0);
            if(name.charAt(i) == ' '){
                username[1] = name.charAt(i+1);
                username[2] = name.charAt(i+2);
                username[3] = name.charAt(i+3);
                username[4] = name.charAt(i+4);
            }
        }
        //Get first 3 digits of studentNumber
        int firstDigit = Integer.parseInt(Integer.toString(studentNumber).substring(0, 3));
        String finalUsername = String.valueOf(username) + firstDigit;

        return finalUsername ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", studentNumber=" + studentNumber +
                ", fullTime=" + fullTime +
                '}';
    }
}
