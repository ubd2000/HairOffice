package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

@WebServlet("/*.brh")
public class BranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BranchController() {
    	
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlCommand = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = new ActionForward();
    	
      	if(urlCommand.equals("/Branch.brh")) { // 로그인
    		try {
    			System.out.println("/Branch.brh");
    			forward.setRedirect(false);
    			forward.setPath("/WEB-INF/branch/seoul_office.jsp");
			}catch(Exception e) {
					e.printStackTrace();
			}
    	}
      	
      	
      	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}



    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
