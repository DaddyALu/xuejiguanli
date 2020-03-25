package dao;

import entity.Student;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Student> all(){
        List<Student> students = new ArrayList<>();
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("select * from student");
            rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getInt("gender"));
                student.setBirth(rs.getString("birth"));
                student.setNianji(rs.getString("nianji"));
                student.setBanji(rs.getString("banji"));
                student.setBirthPlace(rs.getString("birthPlace"));
                student.setAddress(rs.getString("address"));
                student.setTel(rs.getString("tel"));
                student.setEmail(rs.getString("email"));
                student.setImg(rs.getInt("img"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
        return students;
    }

    public void del(String id){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("delete from student where id = ?");
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(String id, String name, String gender, String birth, String nianji, String banji,
                    String birthPlace, String address, String tel, String email, String img){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("insert into student value(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,gender);
            ps.setString(4,birth);
            ps.setString(5,nianji);
            ps.setString(6,banji);
            ps.setString(7,birthPlace);
            ps.setString(8,address);
            ps.setString(9,tel);
            ps.setString(10,email);
            ps.setString(11,img);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public void update(String id, String name, String gender, String birth, String nianji, String banji,
                    String birthPlace, String address, String tel, String email, String img){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("update student set name=?,gender=?,birth=?," +
                    "nianji=?,banji=?,birthPlace=?,address=?,tel=?,email=?,img=? where id = ?");
            ps.setString(1,name);
            ps.setString(2,gender);
            ps.setString(3,birth);
            ps.setString(4,nianji);
            ps.setString(5,banji);
            ps.setString(6,birthPlace);
            ps.setString(7,address);
            ps.setString(8,tel);
            ps.setString(9,email);
            ps.setString(10,img);
            ps.setString(11,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public void upGrade(){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("update student set nianji=? where nianji=?");
            //顺序要从最高开始升，否则会全都升到最高
            ps.setString(1,"已毕业");
            ps.setString(2,"三年级");
            ps.executeUpdate();
            ps.setString(1,"三年级");
            ps.setString(2,"二年级");
            ps.executeUpdate();
            ps.setString(1,"二年级");
            ps.setString(2,"一年级");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public void deGrade(){
        try {
            conn = DBConn.getConn();
            ps = conn.prepareStatement("update student set nianji=? where nianji=?");
            //顺序要从最低开始降，否则会全都降到最低
            ps.setString(1,"无年级");
            ps.setString(2,"一年级");
            ps.executeUpdate();
            ps.setString(1,"一年级");
            ps.setString(2,"二年级");
            ps.executeUpdate();
            ps.setString(1,"二年级");
            ps.setString(2,"三年级");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
    }

    public List<Student> search(String select, String keyword){
        List<Student> studentList = new ArrayList<>();
        try {
            conn = DBConn.getConn();
            switch (select){
                case "1":
                    ps = conn.prepareStatement("select * from student where id like ?");
                    break;
                case "2":
                    ps = conn.prepareStatement("select * from student where name like ?");
                    break;
                case "3":
                    ps = conn.prepareStatement("select * from student where nianji like ?");
                    break;
                case "4":
                    ps = conn.prepareStatement("select * from student where banji like ?");
                    break;
            }
            //模糊查询，表示包含keyword无论前后几个字符
            ps.setString(1,"%"+keyword+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getInt("gender"));
                student.setBirth(rs.getString("birth"));
                student.setNianji(rs.getString("nianji"));
                student.setBanji(rs.getString("banji"));
                student.setBirthPlace(rs.getString("birthPlace"));
                student.setAddress(rs.getString("address"));
                student.setTel(rs.getString("tel"));
                student.setEmail(rs.getString("email"));
                student.setImg(rs.getInt("img"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.release();
        }
        return studentList;
    }

}
