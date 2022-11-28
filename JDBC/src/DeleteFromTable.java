import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteFromTable {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306/org";
        final String userName = "root";
        final String password = "Shabaj@1452";
        final String query = "DELETE FROM student WHERE student_id = ?";
        int student_id = sc.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, password);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, student_id);

        int rowsAffected = st.executeUpdate();

        System.out.println(rowsAffected + " rows Affected");


    }
}
