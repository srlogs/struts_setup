//import com.opensymphony.xwork2.Action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DatabaseMetaData;

// import com.mysql.cj.xdevapi.Statement;


public class HelloWorldAction {
   private String name;

   public String execute() throws Exception {
      Connection conn = null;
      Statement stmt = null;
      try {
         String url = "jdbc:mysql://localhost/test1";
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url, "root", "Logiwaran1999!");
         System.out.println("connected");
         String sql = "";
         DatabaseMetaData dbm = conn.getMetaData();
         stmt = conn.createStatement();
         ResultSet rs = dbm.getTables(null, null, "test1", null);
         if(!rs.next()) {
            sql = "CREATE TABLE struts(username VARCHAR(50), password VARCHAR(50))";
            stmt.executeUpdate(sql);
         }
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      finally {
         stmt.close();
         conn.close();
      }
      return "success";
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
