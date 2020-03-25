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

@WebServlet("/ClassesAddSerlvet")
public class ClassesAddSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nianji = req.getParameter("nianji");
        String banji = req.getParameter("banji");

        //先判断该公告编号是否存在，若不存在才可添加
        Boolean flag = false;
        ClassesDao classesDao = new ClassesDao();
        List<Classes> classesList = classesDao.all();
        for (Classes classes : classesList) {
            if(classes.getId() == Integer.parseInt(id)){
                flag = true;
            }
        }

        //若不存在重复公告编号
        if (!flag){
            //添加新公告
            classesDao.add(id,nianji,banji);
            //获取最新公告数据
            classesList = classesDao.all();
            req.getSession().setAttribute("classesList",classesList);
            resp.sendRedirect("admin/classes.jsp");
        } else {
            req.getSession().setAttribute("flag","1");
            resp.sendRedirect("admin/classesAdd.jsp");
        }

    }
}
