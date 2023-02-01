package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest1 {

    public static void main(String[] args) throws SQLException {

        //connection
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );

        //statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        stt.executeUpdate("update employees set email='asd@gmail.com'\n" +
                "where employees.employee_id=102\n" +
                "\n");
//        rs.next();
//        System.out.println(rs.getString("job_title"));

        upDateAllEmail(stt);

   }

    private static void upDateAllEmail(Statement stt) throws SQLException {

        // ResultSet rs=stt.executeQuery("select email from employees");


        // ArrayList<String> emails=new ArrayList<>();
        //   while(rs.next()) emails.add(rs.getString("select email from employees"));
        //  System.out.println(rs.getString("email"));

//        String tem="";
//        for(int i=0;i< emails.size();i++){
//            tem=  emails.get(i).substring(0,emails.indexOf('@'))+ " @mindtek.edu";
//            stt.executeQuery(emails.get(i).substring(0,emails.indexOf('@'))+ " @mindtek.edu");
//           // System.out.println(tem);
        String emailQuery = "select email from employees";
        ResultSet rs = stt.executeQuery(emailQuery);
        ArrayList<String> emailList = new ArrayList<>();
        while (rs.next()) {
            emailList.add(rs.getString("email"));
    }
    ArrayList<String >newEmailList=new ArrayList<>();
        for(String email:emailList){
            email=email.substring(0,email.indexOf('@'))+ " @mindtek.edu";
            newEmailList.add(email);
        }
        System.out.println(newEmailList);

        String updateQuery="update employees set email=newEmail where employees.email=oldEmail ";
        int i=0;
        for(String email:emailList){
            updateQuery="update employees set email='"+newEmailList.get(i)+ "' where employees.email='"+emailList.get(i)+"'";
            stt.executeUpdate(updateQuery);
            i++;
        }

        }


    private static void printDepartmentsByCountries(Statement stt) {
    }

    public static void  printCountries(Statement stt) throws SQLException {
//        ResultSet rs=stt.executeQuery("select * from countries");
//
//        int i=1;
//        while(rs.next()){
//
//            System.out.println(i+ " -> "+ rs.getString("country_name"));
//            i++;
//       ResultSet rs=stt.executeQuery("select l.country_id,count(d.department_name)\n" +
//               "from locations l,departments d\n" +
//               "where l.location_id=d.location_id\n" +
//               "group by l.country_id;");
//       while (rs.next()){
//           System.out.println(rs.getString("country_id") + " -> " + rs.getString("count"));


       }
            }





