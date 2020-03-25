package dao;

import entity.Classes;
import entity.Notice;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassesDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Classes> all(){
        //不能放在方法外，因为在执行添加公告时，该方法执行了两次，如果没有重新"new"一个noticeList，数据就会叠加，导致显示重复
        List<Classes> classesList = new ArrayList<>();
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("select * from classes");
            rs = ps.executeQuery();
            while (rs.next()){
                Classes classes = new Classes();
                classes.setId(rs.getInt("id"));
                classes.setNianji(rs.getString("nianji"));
                classes.setBanji(rs.getString("banji"));
                classesList.add(classes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
        return classesList;
    }

    public void add(String id, String nianji, String banji){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("insert into classes value(?,?,?)");
            ps.setString(1,id);
            ps.setString(2,nianji);
            ps.setString(3,banji);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public void del(String id){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("delete from classes where id = ?");
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }


}
