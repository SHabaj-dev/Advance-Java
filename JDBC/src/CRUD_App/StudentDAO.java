package CRUD_App;

import java.sql.*;

public class StudentDAO {
    final String url = "jdbc:mysql://localhost:3306/org";
    final String userName = "root";
    final String password = "Shabaj@1452";

    Connection con;


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
            con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                print(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showData(int student_id){
        final String query = "SELECT * FROM student WHERE student_id = ?";
        try {
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, student_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                print(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
