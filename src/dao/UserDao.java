package dao;

import entity.User;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //管理员、教师登陆校验
    public User login(String username, String password, String role){
        User user = new User();
        try {
            conn = DBConn.getConn();
            switch (role){
                case "admin":
                    ps = conn.prepareStatement("select * from userAdmin where username=? and password=?");
                    break;
                case "teacher":
                    ps = conn.prepareStatement("select * from userTeacher where username=? and password=?");
                    break;
                case "student":
                    ps = conn.prepareStatement("select * from userStudent where username=? and password=?");
                    break;
            }
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                if (role.equals("student")){
                    user.setSno(rs.getString("sno"));
                }
            }else {
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
        return user;
    }

    public void update(String passwordNew, String username, String role){
        try {
            conn = DBConn.getConn();
            switch (role){
                case "teacher":
                    ps = conn.prepareStatement("update userTeacher set password = ? where username = ?");
                    break;
                case "student":
                    ps = conn.prepareStatement("update userStudent set password = ? where username = ?");
                    break;
            }
            ps.setString(1,passwordNew);
            ps.setString(2,username);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public List<User> allT(){
        //不能放在方法外，因为在执行添加公告时，该方法执行了两次，如果没有重新"new"一个noticeList，数据就会叠加，导致显示重复
        List<User> userList = new ArrayList<>();
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("select * from userTeacher");
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
        return userList;
    }

    public List<User> allS(){
        List<User> userList = new ArrayList<>();
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("select * from userStudent");
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSno(rs.getString("sno"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
        return userList;
    }

    public void addT(String username, String password){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("insert into userTeacher value(null,?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public void addS(String username, String password, String sno){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("insert into userStudent value(null,?,?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,sno);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public void del(String id, String role){
        try {
            conn = DBConn.getConn();
            switch (role){
                case "teacher":
                    ps = conn.prepareStatement("delete from userTeacher where id = ?");
                    break;
                case "student":
                    ps = conn.prepareStatement("delete from userStudent where id = ?");
                    break;
            }
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

}
