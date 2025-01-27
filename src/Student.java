import java.util.ArrayList;

public class Student {
    int id;
    String name;
    private ArrayList<Integer> grades;

    public ArrayList<Integer> getGrades() {
        return (ArrayList)this.grades.clone();
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    //Copy constructor
    public Student(Student original) {
        if (original == null) {
            System.out.println("invalid input, cant copy a null object");
            return;
        }
        this.id = original.id;
        this.name = original.name;

        //wrong way of making copy in array list
        //this.grades = original.grades;

        //correct way of making a copy using deep copy
        this.grades = (ArrayList)original.grades.clone();

        //a better way of doing it
        this.grades = new ArrayList<>();
        this.grades.addAll(original.grades);
    }

    public String toString() {
        return this.id + " : " + this.name + " : " + this.grades;
    }
}
