package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*.jsp")
public class Loginfilter implements Filter {
    public static final String login_page = "/";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String currentUrl = request.getRequestURI();
        String ctxPath = request.getContextPath();
        //除掉项目名称是访问页面当前路径
        String targetUrl = currentUrl.substring(ctxPath.length());
        HttpSession session = request.getSession(false);
        //对当前页面进行判断，如果当前页面不为登陆页面
        if (!("/".equals(targetUrl))){
            //打印地址
            //System.out.println("1"+targetUrl+"ctxPath:"+ctxPath+"currentURL:"+currentUrl);
            //在不为登陆页面时，再进行判断，如果不是登陆页面也没有session则跳转到登录页面，
            if(session == null || session.getAttribute("username") == null){
                response.sendRedirect(login_page);
                return;
            }else{
                //这里表示正确，会去寻找下一个链，如果不存在，则进行正常的页面跳转
                filterChain.doFilter(request, response);
                return;
            }
        }else{
            //这里表示如果当前页面是登陆页面，跳转到登陆页面
            filterChain.doFilter(request, response);
            return;
        }

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
