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

@WebServlet("/StudentDelServlet")
public class StudentDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();

        //获取要删除学生的id，删除该学生的数据
        String id = req.getParameter("id");
        studentDao.del(id);

        //获取最新的所有学生信息
        List<Student> studentList = studentDao.all();
        req.getSession().setAttribute("studentList",studentList);

        resp.sendRedirect("admin/student.jsp");
    }
}
