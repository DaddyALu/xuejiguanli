package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConn {

    //获取配置信息
    static String driveClass = null;
    static String url = null;
    static String username = null;
    static String password = null;
    static{
        try {
            //创建属性配置对象
            Properties properties = new Properties();
            //通过类加载器，将配置文件转为输入流
            InputStream is = DBConn.class.getClassLoader().getResourceAsStream("properties/DBConn.properties");
            //导入输入流
            properties.load(is);
            //读取属性
            driveClass = properties.getProperty("driveClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //获取数据库连接对象
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public static Connection getConn(){
        try {
            Class.forName(driveClass);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }



    //释放资源，关闭连接
    public static void release(){
        closeConn(conn);
        closePs(ps);
        closeRs(rs);
    }
    private static void closeConn(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("数据库关闭异常");
            e.printStackTrace();
        }finally {
            conn = null;
        }
    }
    private static void closePs(PreparedStatement ps) {
        try {
            if(ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("ps释放异常");
            e.printStackTrace();
        }finally {
            ps = null;
        }
    }
    private static void closeRs(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("rs释放异常");
            e.printStackTrace();
        }finally {
            rs = null;
        }
    }
}
