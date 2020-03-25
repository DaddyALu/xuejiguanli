package servlet.account;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AccountUpServlet")
public class AccountUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录时已经放入session
        String username = (String) req.getSession().getAttribute("username");

        //获取表单信息
        String passwordOld = req.getParameter("passwordOld");
        String passwordNew = req.getParameter("passwordNew");
        String role = req.getParameter("role");

        //先验证旧密码是否正确，正确时才可以修改
        UserDao userdao = new UserDao();
        User user = userdao.login(username,passwordOld,role);

        switch (role){
            case "teacher":
                if (user != null){
                    userdao.update(passwordNew,username,role);
                    resp.sendRedirect("teacher/accUpdateSuccess.jsp");
                } else {
                    req.getSession().setAttribute("flag","1");
                    resp.sendRedirect("teacher/accUpdate.jsp");
                }
                break;
            case "student":
                if (user != null){
                    userdao.update(passwordNew,username,role);
                    resp.sendRedirect("student/accUpdateSuccess.jsp");
                } else {
                    req.getSession().setAttribute("flag","1");
                    resp.sendRedirect("student/accUpdate.jsp");
                }
                break;

        }



    }
}
