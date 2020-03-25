package servlet.student;

import dao.ClassesDao;
import dao.StudentDao;
import entity.Classes;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有学生信息
        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.all();
        req.getSession().setAttribute("studentList",studentList);

        //获取所有班级信息
        ClassesDao classesDao = new ClassesDao();
        List<Classes> classesList = classesDao.all();
        req.getSession().setAttribute("classesList",classesList);

        //判断当前是什么角色登陆进系统
        String aaa = req.getParameter("aaa");
        if (aaa.equals("teacher")) {
            resp.sendRedirect("teacher/student.jsp");
        }else if(aaa.equals("student")) {
            resp.sendRedirect("student/student.jsp");
        }else {
            resp.sendRedirect("admin/student.jsp");
        }
    }
}
