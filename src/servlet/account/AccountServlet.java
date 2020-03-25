package servlet.account;

import dao.StudentDao;
import dao.UserDao;
import entity.Student;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
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

        //判断要查哪个角色
        String role = req.getParameter("role");
        UserDao dao = new UserDao();
        List<User> userList = new ArrayList<>();
        switch (role){
            case "teacher":
                userList = dao.allT();
                req.getSession().setAttribute("userList",userList);
                resp.sendRedirect("admin/accTeacher.jsp");
                break;
            case "student":
                userList = dao.allS();
                req.getSession().setAttribute("userList",userList);
                resp.sendRedirect("admin/accStudent.jsp");
                break;
        }

    }
}
