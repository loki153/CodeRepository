package test;   
  
import java.sql.Connection;  
  
import java.sql.DriverManager;  

import java.sql.PreparedStatement; 
  
import java.sql.ResultSet;  
  
import java.sql.Statement;   
  
public class InsertDB {  
  
    private static final String user = "root";  
  
    private static final String pwd = "admin";  
  
    private static final String url = "jdbc:mysql://localhost:3306/data";  
  
    private static final String driver = "com.mysql.jdbc.Driver";  
  
    public static Connection getCon() {  
  
        Connection con = null;  
  
        try {  
  
            Class.forName(driver).newInstance();  
  
            con = DriverManager.getConnection(url, user, pwd);  
  
            if (con != null) {  
  
                System.out.println("你已连接到数据库：" + con.getCatalog());  
  
            }  
  
        } catch (Exception e) {  
  
            System.out.println("连接数据库失败！");  
  
            e.printStackTrace();  
  
        }  
  
        return con;  
  
    }   
  
    public boolean insertDB(String AUTO_ID, String STUDYINSTANCEUID, String HEARTE_RATE,  
  
            String PR, String QT, String QRSDZ, String QRS_WIDTH,  
  
            String P_WIDTH, String R_WIDTH,String T_WIDTH,String QTC,String P,String RV1,
            
            String SV5,String RV5,String SV1, String jielun1, String jielun2,  String jielun3,  String jielun4, String jielun5) {  
  
        Connection con = null;  
  
        Statement stm = null;  
  
        boolean flag = false;  
  
        String sql = "insert into output values('" + AUTO_ID + "','"  
  
                + STUDYINSTANCEUID + "','','', '" + HEARTE_RATE + "','" + PR + "','" + QT  
  
                + "','" + QRSDZ + "','" + QRS_WIDTH + "','" + P_WIDTH + "','"  
  
                + R_WIDTH + "','"+T_WIDTH+"','"+QTC+"','"+P+"','"+RV1+"','"+SV5+"','"+RV5+"','"+SV1+"','"+jielun1+"','"+jielun2+"','"+jielun3+"','"+jielun4+"','"+jielun5+"')";  
  
        try {  
  
            con = getCon();  
  
            stm = con.createStatement();  
  
            int i = stm.executeUpdate(sql);  
  
            if (i > 0) {  
  
                flag = true;  
  
                System.out.println(flag + "插入数据成功！");  
  
            }  
  
        } catch (Exception e) {  
  
            flag = false;  
  
            e.printStackTrace();  
  
        } finally {  
  
            close(null, stm, con);  
  
        }  
  
        return flag;  
  
    }  
  
    //关闭相关连接  
  
    public void close(ResultSet rs, Statement stm, Connection con) {  
  
        if (rs != null)  
  
            try {  
  
                rs.close();  
  
            } catch (Exception e) {  
  
                e.printStackTrace();  
  
            }  
  
        if (stm != null)  
  
            try {  
  
                stm.close();  
  
            } catch (Exception e) {  
  
                e.printStackTrace();  
  
            }  
  
        if (con != null)  
  
            try {  
  
                con.close();  
  
            } catch (Exception e) {  
  
                e.printStackTrace();  
  
            }  
  
    }  
  
}  
