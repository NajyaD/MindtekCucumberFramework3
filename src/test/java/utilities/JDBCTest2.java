package utilities;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;


public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {

        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );
//        //statement
       Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        String query = "select * from employees";
//        ResultSet rs = stt.executeQuery(query);
//        // rs.next();
//        // System.out.println(rs.getString("first_name"));
//        ResultSetMetaData rsMata = rs.getMetaData();
//
//        System.out.println("column #1: " + rsMata.getColumnName(1));
//        System.out.println("column count:" + rsMata.getColumnCount());
//        System.out.println("table name :" + rsMata.getTableName(1));
//        System.out.println(rsMata.getColumnTypeName(1));
//        System.out.println(rsMata.isNullable(8)); //if we have null value
//
//        //print all the column name
//
//        for (int i = 1; i <= rsMata.getColumnCount(); i++) {
//            System.out.println("column # " + i + ":" + rsMata.getColumnName(i));
 //           System.out.println(rsMata.getColumnName(i));
  //      }
        Map<Integer,String> map=new HashMap<>();
        System.out.println(map);

        map.put(5,"Chicago");
        map.put(6,"Park Ridge");
        map.put(7,"Lincoln Park");

        Map<Integer,String> map1=new HashMap<>();

        map1.put(5,"Des Plaines");
        map1.put(6,"Mundane");
        map1.put(7,"Chambersburg");

        Map<Integer,String> map2=new HashMap<>();
        System.out.println(map2);

        map2.put(5,"Evanston");
        map2.put(6,"Smokies");
        map2.put(7,"BridgeView");

       List<Map<Integer,String>> list=new ArrayList<>();
       list.add(map);
       list.add(map1);
       list.add(map2);
        System.out.println(list);

        for(int i=0;i<list.size();i++){
            System.out.println("map # " + (i +1) );
          for(int j=5;j<8;j++){
              System.out.println(list.get(i).get(j));
          }
            System.out.println("===========");
        }







    }
}