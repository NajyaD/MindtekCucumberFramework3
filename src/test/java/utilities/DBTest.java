package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class  DBTest  {
    public static void main(String[] args) throws SQLException {

        DB db = new DB();

        //String query = "select * from dependents";

       // ResultSet rs=db.executeSelectQuery(query);

      //  while (rs.next()) System.out.println(rs.getString("first_name")+" " + rs.getString("last_name"));

        //===============
        //overloading methode

        //db.runSelectQuery(['first_name,"last_name,"email"],"jobs");

        ArrayList<String>table=new ArrayList<>();
        table.add("first_name");
        table.add("last_name");

        table.add("phone_number");



        ResultSet rs=db.runSelectQuery(table,"employees");

        while (rs.next()) System.out.println(rs.getString("first_name") + " " + rs.getString("phone_number"));

        //select first_name,last_name,phone_number from employees
       // query=query.trim().substring(0,query.length());

       // List<Map<String, Object>> list = db.getTableForQuery(q);

      //  System.out.println(list);

        //update

//        String query="Update employees Set email='test@gmail.com' where employee_id = 100";
//        db.runUpdateQuery(query);

        //delete
       // String query="delete from countries where country_id='BR'";
        //db.runDeleteQuery(query);

       // insert
       // String query="insert into countries values ('NK', 'North Korea', 3)";
       // db.runInsertQuery(query);

    }

}