public class TestCopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student(125, "Steve");
        s1.grades.add(95);
        s1.grades.add(85);
        s1.grades.add(75);
        System.out.println(s1);

        //create copy of student object in application
        Student s2 = new Student(s1);
        System.out.println(s2);

        s1.id = 654;
        s1.name = "Sbeve";
        s1.grades.add(42);
        System.out.println(s1);
        System.out.println(s2);
    }
}
