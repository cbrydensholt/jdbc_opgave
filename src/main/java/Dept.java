import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;

public class Dept {

    int deptno;
    String dname;
    String loc;
    Dept d;
    HashSet<Dept> departments = new HashSet<Dept>();

    public Dept() {

    }


    public void getSetOfDepartments() {


        try {
            //skabe en forbindelse til mySQL
            DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
            Connection forbindelseTilMySQL = connectionManager.getDatabaseConnection();


            //opret et statement
            Statement myStatement = forbindelseTilMySQL.createStatement();

            String getAllDepartments = "SELECT * FROM dept";
            ResultSet alleDepartments = myStatement.executeQuery(getAllDepartments);
            //alleDepartments.next();
            while(alleDepartments.next()) {
                Integer deptno = alleDepartments.getInt("deptno");
                String dname = alleDepartments.getString("dname");
                String loc = alleDepartments.getString("loc");
                d = new Dept(deptno, dname, loc);

                departments.add(d);
            }

        } catch(SQLException e){
            System.out.println("There is a problem: ");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }

        System.out.println("Printer settet");
        Iterator<Dept> i = departments.iterator();
        while(i.hasNext())
            System.out.println(i.next());

    }


    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", d=" + d +
                ", departments=" + departments +
                '}';
    }
}
