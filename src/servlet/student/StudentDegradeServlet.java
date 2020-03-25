package servlet.student;

import dao.StudentDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentDegradeServlet")
public class StudentDegradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //全体升级
        StudentDao studentDao = new StudentDao();
        studentDao.deGrade();

        //获取最新的所有学生信息
        List<Student> studentList = studentDao.all();
        req.getSession().setAttribute("studentList",studentList);

        resp.sendRedirect("admin/student.jsp");
    }
}
