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

@WebServlet("/AccountAddServlet")
public class AccountAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        Boolean flag = false;
        UserDao dao = new UserDao();
        List<User> userList = new ArrayList<>();
        switch (role){
            case "teacher":
                userList = dao.allT();
                for (User user : userList) {
                    //字符串比较要用 .equal() ， 否则不会相同
                    if (user.getUsername().equals(username)){
                        flag = true;
                    }
                }
                if (!flag){
                    dao.addT(username,password);
                    userList = dao.allT();
                    req.getSession().setAttribute("userList",userList);
                    resp.sendRedirect("admin/accTeacher.jsp");
                } else {
                    req.getSession().setAttribute("flag","1");
                    resp.sendRedirect("admin/accTeacherAdd.jsp");
                }
                break;
            case "student":
                String sno = req.getParameter("sno");
                userList = dao.allS();
                for (User user : userList) {
                    //用户名和学号不可重复，其实这里的学号判断没有必要，因为页面上的设计，使得不可能出现学号重复
                    if (user.getUsername().equals(username) || user.getSno().equals(sno)){
                        flag = true;
                    }
                }
                if (!flag){
                    dao.addS(username,password,sno);
                    userList = dao.allS();
                    req.getSession().setAttribute("userList",userList);
                    resp.sendRedirect("admin/accStudent.jsp");
                } else {
                    req.getSession().setAttribute("flag","1");
                    resp.sendRedirect("admin/accStudentAdd.jsp");
                }
                break;
        }


    }
}
