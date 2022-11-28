import java.sql.*;

public class JdbcDaoDemo {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student s1 = dao.getStudent(10);
        Student s2 = dao.getStudent(2);
//        System.out.println("Student_Id \t First_Name \t Last_Name \t Branch");
        System.out.println(s1.student_id + " \t " + s1.first_name + " \t " + s1.last_name + " \t " + s1.branch);
        System.out.println(s2.student_id + " \t " + s2.first_name + " \t " + s2.last_name + " \t " + s2.branch);
    }
}
//DAO -> Data Access Object.
class StudentDAO{
    public Student getStudent(int student_id){
        Student s = new Student();
//        s.student_id = student_id;
        final String url = "jdbc:mysql://localhost:3306/org";
        final String password = "Shabaj@1452";
        final String userName = "root";
        final String query = "SELECT * FROM student WHERE student_id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, student_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            s.student_id = rs.getInt(1);
            s.first_name = rs.getString(2);
            s.last_name = rs.getString(3);
            s.branch = rs.getString(4);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return s;
    }
}

class Student{
    int student_id;
    String first_name;
    String last_name;
    String branch;
}
