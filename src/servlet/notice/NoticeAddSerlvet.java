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

@WebServlet("/NoticeAddSerlvet")
public class NoticeAddSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String time = ""+System.currentTimeMillis();

        //先判断该公告编号是否存在，若不存在才可添加
        Boolean flag = false;
        NoticeDao noticeDao = new NoticeDao();
        List<Notice> noticeList = noticeDao.all();
        for (Notice notice : noticeList) {
            if(notice.getId() == Integer.parseInt(id)){
                flag = true;
            }
        }

        //若不存在重复公告编号
        if (!flag){
            //添加新公告
            noticeDao.add(id,title,content,time);
            //获取最新公告数据
            noticeList = noticeDao.all();
            req.getSession().setAttribute("notices",noticeList);
            resp.sendRedirect("admin/notice.jsp");
        } else {
            req.getSession().setAttribute("flag","1");
            resp.sendRedirect("admin/noticeAdd.jsp");
        }

    }
}
