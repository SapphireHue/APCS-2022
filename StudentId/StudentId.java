public class StudentId{
    private String studentFirstName;
    private String studentLastName;
    private int studentId;

    public StudentId(){
        studentFirstName = "First";
        studentLastName = "Last";
        studentId = 111111;
    }

    public StudentId(String first, String last, int id){
        studentFirstName = first;
        studentLastName = last;
        studentId = id;
    }

    public String getStudentFirstName(){
        return studentFirstName;
    }

    public String getStudentLastName(){
        return studentLastName;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setStudentFirstName(String first){
        studentFirstName = first;
    }

    public void setStudentLastName(String last){
        studentLastName = last;
    }

    public void setStudentId(int id){
        studentId = id;
    }

    public String getPassword(){
        return "" + studentLastName.charAt(0) + studentId + studentLastName.charAt(studentLastName.length()-1);
    }

    public String toString(){
        return "Name = " + studentFirstName + " " + studentLastName + "\nStudent Id = " + studentId;
    }
}