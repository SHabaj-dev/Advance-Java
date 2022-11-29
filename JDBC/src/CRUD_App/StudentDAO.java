package CRUD_App;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class StudentDAO {
    final String url = "jdbc:mysql://localhost:3306/org";
    final String userName = "root";
    final String password = "Shabaj@1452";

    Connection con;

    {
        try {
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Statement st;

    void print(ResultSet rs) throws SQLException {
        //                System.out.println(rs.getInt(1) + " \t " + rs.getString(2) + " \t " + rs.getString(3)
//                        + " \t " + rs.getString(4));

        System.out.printf("%d \t %s \t %s \t %s \n", rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4));

    }
    public void showTable(){
        final String query = "SELECT * FROM student";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                print(rs);
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showData(int student_id){
        final String query = "SELECT * FROM student WHERE student_id = ?";
        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, student_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                print(rs);
            }
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(int student_id, String first_name, String last_name, String branch){
        Student s = new Student();
        s.setStudent_id(student_id);
        s.setFirst_name(first_name);
        s.setLast_name(last_name);
        s.setBranch(branch);
        final String query = "INSERT INTO student VALUE (?, ?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, s.getStudent_id());
            ps.setString(2, s.getFirst_name());
            ps.setString(3, s.getLast_name());
            ps.setString(4, s.getBranch());
            int rowsAffected = ps.executeUpdate();
            ps.close();
            con.close();
            return rowsAffected;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int deleteData(int student_id){
        final String query = "DELETE FROM student WHERE student_id = ?";
        int rowsAffected = 0;
        try {
            Student s = new Student();
            s.setStudent_id(student_id);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, s.getStudent_id());
            rowsAffected = ps.executeUpdate();
            ps.close();
            con.close();
            return rowsAffected;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return rowsAffected;
    }


}
