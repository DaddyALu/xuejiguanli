package servlet.account;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AccountDelServlet")
public class AccountDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String role = req.getParameter("role");
        UserDao dao = new UserDao();
        dao.del(id,role);


        List<User> userList = new ArrayList<>();
        switch (role){
            case "teacher":
                //获取最新公告数据
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
