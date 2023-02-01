package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest3 {

    public static void main(String[] args) throws SQLException {

        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );
//        //statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from employees";
        ResultSet rs = stt.executeQuery(query);
        ResultSetMetaData rsMeta = rs.getMetaData();


        List<Map<String, Object>> tableData = new ArrayList<>();
        while (rs.next()) {

                Map<String, Object> rowData = new HashMap<>();
                for (int order = 1; order <= rsMeta.getColumnCount(); order++) {
                    rowData.put(rsMeta.getColumnName(order), rs.getString(rsMeta.getColumnName(order)));
                }
                // System.out.println(rowData);
                tableData.add(rowData);

            }
        System.out.println(tableData);

        // find employee fName with emp_id 100
        //findEmployeeWithEmpID(tableData,100);
        findEmployeeEmailWithEmpFname(tableData,"Irene");

        }

    private static void findEmployeeEmailWithEmpFname(List<Map<String, Object>> tableData, String name) {
        for(Map el:tableData){
            if(el.get("first_name").toString().equals(name)){
                System.out.println(el.get("email"));
                break;
            }
        }
        System.out.println("Finished");


    }

//    private static void findEmployeeWithEmpID(List<Map<String, Object>> tableData, int id) {
//        for(Map row: tableData){

//            if(parsrow.get(id) ){
//                System.out.println(row.get("first_name"));
//                break;
//            }
//
//        }
//        System.out.println("Finished");

    }

