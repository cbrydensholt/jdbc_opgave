import java.sql.Connection;
import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        Dept dept = new Dept();
        Emp emp = new Emp();
        dept.getSetOfDepartments();
        emp.getAllEmployees();

        try {
            //skabe en forbindelse til mySQL
             DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
             Connection forbindelseTilMySQL = connectionManager.getDatabaseConnection();


            //opret et statement
            Statement myStatement = forbindelseTilMySQL.createStatement();

            String getAllDepartments = "SELECT * FROM dept";


            //eksekver query
            ResultSet alleDepartments = myStatement.executeQuery(getAllDepartments);
            ResultSetMetaData MetaAlleDepartments = alleDepartments.getMetaData();
            int columncount = MetaAlleDepartments.getColumnCount();

            for(int i = 1; i <= columncount; i++){
                String name = MetaAlleDepartments.getColumnName(i);
                System.out.println(name);
            }




            //printer resultatset
          /*  while(alleDepartments.next()){
                System.out.println(alleDepartments.getInt("deptno"));
                System.out.println(alleDepartments.getString("dname"));
                System.out.println(alleDepartments.getString("loc"));
                //System.out.println(alleDepartments.getString("ename"));
            } */




        } catch (SQLException e) {
            System.out.println("We have a problem");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }
}