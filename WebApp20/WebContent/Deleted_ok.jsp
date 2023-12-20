<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	
	int result = dao.deleteDate(num);
	
	// result 결과값에 따른 분기처리 코드 삽입 가능
	
	DBConn.close();
	
	response.sendRedirect(cp + "/List.jsp?pageNum=" + pageNum);
%>