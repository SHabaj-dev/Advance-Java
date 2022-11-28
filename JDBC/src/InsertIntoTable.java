import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertIntoTable {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String url = "jdbc:mysql:// localhost:3306/org";
        final String password = "Shabaj@1452";
        final String userName = "root";
        final String query = "INSERT INTO student values (?, ?, ?, ?)";
        int student_id = sc.nextInt();
        String first_name = sc.next();
        String last_name = sc.next();
        String branch = sc.next();

        Connection con = DriverManager.getConnection(url, userName, password);
//        Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, student_id);
        st.setString(2, first_name);
        st.setString(3, last_name);
        st.setString(4, branch);
        int rowAffected = st.executeUpdate();

        System.out.println(rowAffected + " row/s Affected");

    }
}
