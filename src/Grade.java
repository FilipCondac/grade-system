import java.util.ArrayList;
public class Grade {


    String subject = "";
    double score = 0;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public static char getLetterGrade(double score){
        if(score > 100 || score < 0){
            return 'E';
        }

        if(score >= 70 && score <= 100){
            return 'A';
        } else if(score >= 60){
            return 'B';
        }else if(score >= 50){
            return 'C';
        }else if(score >= 40){
            return 'D';
        }else if(score < 40){
            return 'F';
        }

        return 'E';
    }


    @Override
    public String toString() {
        return
                "Subject: " + subject + "  " +
                "Score: " + score + "  " +
                "Grade: " + getLetterGrade(score) +  " || ";

    }
}
