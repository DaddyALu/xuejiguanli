package servlet.login_logout;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取登陆信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        UserDao userdao = new UserDao();
        User user = userdao.login(username,password,role);
        //如果用户名密码正确
        if (user != null){
            req.getSession().setAttribute("username",username);
            switch (role){
                case "admin":
                    resp.sendRedirect("admin/home.jsp");
                    break;
                case "teacher":
                    resp.sendRedirect("teacher/home.jsp");
                    break;
                case "student":
                    String sno = user.getSno();
                    System.out.println(sno);
                    req.getSession().setAttribute("sno",sno);
                    resp.sendRedirect("student/home.jsp");
                    break;
            }
        }
        //如果错误
        else {
            Cookie cookie = new Cookie("error","1");
            resp.addCookie(cookie);
            resp.sendRedirect("login.jsp");
        }

//        System.out.println("进行登陆校验。。。");
    }
}
