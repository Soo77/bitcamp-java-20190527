package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext appCtx = 
        (ApplicationContext) getServletContext().getAttribute("iocContainer");
    memberDao = appCtx.getBean(MemberDao.class);
  }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    
    response.setContentType("text/html;charset=UTF-8");
    try {
      List<Member> members = memberDao.findAll();
      
      request.setAttribute("members", members);
      request.getRequestDispatcher("/jsp/member/list.jsp").include(request, response);
      
    } catch (Exception e) {
      request.setAttribute("message", "데이터 목록을 가져오는데 실패했습니다!");
      request.setAttribute("error", e);
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}
