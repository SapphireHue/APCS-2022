public class StudentRunner {
    public static void main(String[] args) {
        StudentId student0 = new StudentId();
        System.out.println(student0);
        System.out.println(student0.getPassword());

        student0.setStudentFirstName("Ada");
        student0.setStudentLastName("Lovelace");
        System.out.println(student0);
        System.out.println(student0.getPassword());

        StudentId student1 = new StudentId("Buzz", "Lightyear", 123456);
        System.out.println(student1);
        System.out.println(student1.getPassword());
    }
    
}
