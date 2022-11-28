import java.sql.*;  //Java SQL Package
import java.util.Scanner;

/*
Seven Steps To Connect with the database.
   1. import  --> java.sql
   2. load and register the drivers --> com.mysql.jdbc.Driver
   3. Create connection.
   4. create a statement
   5. execute the query
   6 process the result
   7 close
 */


public class ReadDataFromDB {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final String url = "jdbc:mysql://localhost:3306/org";
        final String uName = "root";
        final String password = "Shabaj@1452";
//        String student_id = sc.next();
        final String query = "SELECT * FROM student";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uName, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        String userData = "";
        while(rs.next()){
            userData = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) +
                    "\t" + rs.getString(4);

            System.out.println(userData);
        }




        st.close();
        con.close();
    }
}
