package DBDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
   Connection conn;
   PreparedStatement pstmt;

   public DB() {
      this("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "root", "qwe123!@#");
   }

   public DB(String url, String user, String pw) {

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url, user, pw);

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @SuppressWarnings("static-access")
   public static void main(String[] args) throws SQLException{
      // TODO Auto-generated method stub
      DB exam = new DB();
      
      String []str = {"AAA","BBB","CCC"};
      System.out.println("success");

     // exam.createDb();
     // exam.dbInput3(str);
      exam.update("DDD");
     // exam.delete("DDD");
      exam.result();
   }

   private void delete(String str) {
      try {
         String sql = "delete from student2 where username = ?";
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, str);
         pstmt.executeUpdate();
         
      }catch(SQLException e) {
         e.printStackTrace();
      }
      
   }
      

   private void update(String str) {
      try {
         String sql = "update student2 set username=? where id = 1"; //물음표가 1개니까
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, str); // 앞에 숫자 1
         pstmt.executeUpdate();
      }catch(SQLException e) {
         e.printStackTrace();
      }
      
   }

   private void result() throws SQLException{
      String sql = "select * from student2";
      pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
         int deptNO = rs.getInt(1);
         String deptName = rs.getString(2);
         
         System.out.println(deptName+ " "+ deptNO );
      }
      
   }

   private void dbInput() {
      try {
         String sql = "insert into student2 values(7,'superman')";
         pstmt = conn.prepareStatement(sql); //prepareStatement 인자를 받을 수 있다.
         pstmt.executeUpdate();
      }catch(SQLException e) {
         e.printStackTrace();
      }
      
   }
   
   private void dbInput2() { //()여기에 매개변수 넣어서 입력값 받을 수도 있어.
      try {
         String sql = "insert into student2 values(?,?)"; // 첫번째값란,두번째값란(영번째 아님.)
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, 8); //첫번째 값에 8을 넣을꺼야.
         pstmt.setString(2, "superman"); // 두번째 값에 슈퍼맨을 넣을꺼야.
         pstmt.executeUpdate();
      }catch(SQLException e) {
         e.printStackTrace();
      }
      
   }
   
   private void dbInput3(String[] str) {
      try {
         String sql = "insert into student2 values(?,?)";
         pstmt = conn.prepareStatement(sql);
         for (int i=0; i<str.length; i++) {
            pstmt.setInt(1, i+1); //첫번째 값에 8을 넣을꺼야.
            pstmt.setString(2, str[i]); // 두번째 값에 슈퍼맨을 넣을꺼야.
            pstmt.executeUpdate(); // 얘 값들어가게 만드는 애
         }
      }catch(SQLException e) {
         e.printStackTrace();
      }
      
   }
   
    private void dbInput4(int id, String name) {
         try {
            String sql = "insert into student2 values(?,?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.executeUpdate();
         } catch(SQLException e) {
            e.printStackTrace();
         }
      }

   private void createDb() {
      try {
         String s = "drop table if exists student3";
         String sql = "create table student3(\r\n" + "id int, \r\n" + "username varchar(20), \r\n"
               + "primary key(id)\r\n" + ")\r\n";

         pstmt = conn.prepareStatement(s);
         pstmt.executeUpdate();

         pstmt = conn.prepareStatement(sql);
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

}