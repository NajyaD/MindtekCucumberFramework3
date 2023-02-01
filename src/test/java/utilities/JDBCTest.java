package utilities;


import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {

        //connection
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );

        //statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //stt.execute("Select * from jobs");

        //read data
        // ResultSet resultSet = stt.executeQuery("Select * from jobs");
        // while (resultSet.next()) {
        //  System.out.println(resultSet.getString("job_title"));
        //  System.out.println(resultSet.getString("job_id"));
        // System.out.println(resultSet.getString("min_salary"));


        //  resultSet.next();
        // resultSet.next();

        // System.out.println(resultSet.getString("job_title"));

        // System.out.println(resultSet.getString(4));
//print the fullname of the parent and the fullanme of the child
        // ResultSet resultSet=stt.executeQuery("select concat(e.first_name, ' ', e.last_name) as p_full_name, concat(d.first_name, ' ', d.last_name) as d_full_name from employees e, dependents d\n" +
        //  "where e.employee_id = d.employee_id");
        // while (resultSet.next()) {

        // System.out.println(resultSet.getString("p_full_name") + " is the parent of "+
        //  resultSet.getString("d_full_name"));


        //Find out if we have any email is not end with @sqlutrial.org
        //1 we need to get all the emails and put them in rs
        //2 put them in arraylist
        //3 find if we have any not ending with @sqlutrial.org
        //4 if we have any print"found different email"
        // 5 if all emails end with @sqlutrial.org then print "all email "

        findDifferentEmail(cnn, stt);

    }

    private static void findDifferentEmail(Connection cnn, Statement stt) throws SQLException {


        ResultSet rs = stt.executeQuery("select email  as emails from employees");
        while (rs.next()) {
            System.out.println(rs.getString("emails"));


            ArrayList<String> emailList = new ArrayList<>();
            while (rs.next()) emailList.add((rs.getString("emails")));

            boolean isWrongEmail = false;

            for (String em : emailList) {
                if (!em.endsWith("@sqltutorial.org")) isWrongEmail = true;
            }
            if (isWrongEmail) {
                System.out.println("found differents email");
        }else{
                System.out.println("All emails are the same");
            }


        }
    }
}

