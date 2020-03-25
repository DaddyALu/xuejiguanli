package servlet.classes;

import dao.ClassesDao;
import entity.Classes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ClassesServlet")
public class ClassesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有班级信息
        ClassesDao classesDao = new ClassesDao();
        List<Classes> classesList = classesDao.all();
        req.getSession().setAttribute("classesList",classesList);
        resp.sendRedirect("admin/classes.jsp");
    }
}
