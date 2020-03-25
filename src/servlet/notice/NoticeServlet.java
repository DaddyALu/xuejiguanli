package servlet.notice;

import dao.NoticeDao;
import entity.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据库公告表的数据
        NoticeDao noticeDao = new NoticeDao();
        List<Notice> noticeList = noticeDao.all();

        //放入session
        req.getSession().setAttribute("notices",noticeList);

        //判断当前是什么角色登陆进系统
        String aaa = req.getParameter("aaa");
        if (aaa.equals("teacher")) {
            resp.sendRedirect("teacher/notice.jsp");
        }else if (aaa.equals("student")){
            //Servlet处于web根目录，需要进入admin文件夹
            resp.sendRedirect("student/notice.jsp");
        }else {
            //Servlet处于web根目录，需要进入admin文件夹
            resp.sendRedirect("admin/notice.jsp");
        }



    }
}
