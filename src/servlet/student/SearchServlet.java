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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取搜索类型
        String select = req.getParameter("select");
        //获取关键字
        String keyword = req.getParameter("keyword");

        //搜索相关内容
        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.search(select,keyword);
        req.getSession().setAttribute("studentList",studentList);

        //判断当前是什么角色登陆进系统
        String aaa = req.getParameter("aaa");
        if (aaa.equals("teacher")) {
            resp.sendRedirect("teacher/student.jsp");
        }else {
            //Servlet处于web根目录，需要进入admin文件夹
            resp.sendRedirect("admin/student.jsp");
        }

    }
}
