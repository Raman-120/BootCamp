public class Student {

    int studentID;
    String name;
    String email;
    int age;
    String course;

    Student(int studentID, String name, String email, int age, String course){
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;

    }

    public String toString(){
        return studentID + " " + name + " " + email + " " + age + " " + course;
    }

}
