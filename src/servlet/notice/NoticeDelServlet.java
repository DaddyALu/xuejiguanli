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

@WebServlet("/NoticeDelServlet")
public class NoticeDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        NoticeDao noticeDao = new NoticeDao();
        noticeDao.del(id);

        //获取最新公告数据
        List<Notice> noticeList = noticeDao.all();
        req.getSession().setAttribute("notices",noticeList);

        resp.sendRedirect("admin/notice.jsp");
    }
}
