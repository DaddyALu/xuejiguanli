package dao;

import entity.Notice;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoticeDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Notice> all(){
        //不能放在方法外，因为在执行添加公告时，该方法执行了两次，如果没有重新"new"一个noticeList，数据就会叠加，导致显示重复
        List<Notice> noticeList = new ArrayList<>();
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("select * from notice");
            rs = ps.executeQuery();
            while (rs.next()){
                Notice notice = new Notice();
                notice.setId(rs.getInt("id"));
                notice.setTitle(rs.getString("title"));
                notice.setContent(rs.getString("content"));
                notice.setTime(rs.getString("time"));
                noticeList.add(notice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
        return noticeList;
    }

    public void add(String id, String title, String content, String time){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("insert into notice value(?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,title);
            ps.setString(3,content);
            ps.setString(4,time);
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
            ps = conn.prepareStatement("delete from notice where id = ?");
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }
}
