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

@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求体中的参数
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String birth = req.getParameter("birth");
        //按空格前后划分字符串
        String[] l = req.getParameter("banji").split("\\s+");
        String nianji = l[0];
        String banji = l[1];
        String birthPlace = req.getParameter("birthPlace");
        String address = req.getParameter("address");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String img = req.getParameter("img");

        //先判断该学号是否存在，若不存在才可添加
        Boolean flag = false;
        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.all();
        for (Student student : studentList) {
            if(student.getId() == Integer.parseInt(id)){
                flag = true;
            }
        }

        //如果未存在该学号
        if (!flag){
            //添加
            studentDao.add(id,name,gender,birth,nianji,banji,birthPlace,address,tel,email,img);
            //获取最新的所有学生信息
            studentList = studentDao.all();
            req.getSession().setAttribute("studentList",studentList);
            resp.sendRedirect("admin/student.jsp");
        } else {
            req.getSession().setAttribute("flag","1");
            resp.sendRedirect("admin/studentAdd.jsp");
        }

    }
}
