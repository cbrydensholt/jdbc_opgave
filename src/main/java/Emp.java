import java.sql.*;
import java.util.HashMap;

public class Emp {
int empno;
String ename;
String job;
String mgr;
String hiredate;
int sal;
int comm;
int deptno;

    public Emp(int empno, String ename, String job, String mgr, String hiredate, int sal, int comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Emp() {

    }

    public void getAllEmployees() {

        HashMap<Integer, Emp> Employees = new HashMap<Integer, Emp>();
        Emp e;

        try {
            //skabe en forbindelse til mySQL
            DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
            Connection forbindelseTilMySQL = connectionManager.getDatabaseConnection();


            //opret et statement
            Statement myStatement = forbindelseTilMySQL.createStatement();

            String getAllEmployees = "SELECT * FROM emp" + " ORDER BY hiredate desc";


            //eksekver query
            ResultSet alleEmployees = myStatement.executeQuery(getAllEmployees);
            while(alleEmployees.next()) {
                Integer empno = alleEmployees.getInt("empno");
                String ename = alleEmployees.getString("ename");
                String job = alleEmployees.getString("job");
                String mgr = alleEmployees.getString("mgr");
                String hiredate = alleEmployees.getString("hiredate");
                Integer sal = alleEmployees.getInt("sal");
                Integer com = alleEmployees.getInt("sal");
                Integer deptno = alleEmployees.getInt("deptno");
                e = new Emp(empno, ename, job, mgr, hiredate, sal, com, deptno);
                Employees.put(empno, e);
            }

            } catch(SQLException s){
                System.out.println("We have a problem");
                System.out.println(s.getSQLState());
                System.out.println(s.getErrorCode());
            }

        /*for(Integer i : Employees.keySet()){
            Emp employees = Employees.get(i);
            System.out.println(employees.getEmpno() + " " + employees.getEname());*/
        for(Integer i : Employees.keySet()) {
            System.out.println("Printer hashmap");
            System.out.println("Key: " + i + "value:" + Employees.get(i));
        }


        }








    public int getEmpno() {
        return empno;
    }

    public void setEmpono(int empono) {
        this.empno = empono;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr='" + mgr + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }
}
