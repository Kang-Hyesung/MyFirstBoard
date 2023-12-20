<%@page import="com.test.BoardDTO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String pageNum = request.getParameter("pageNum");
	int num = Integer.parseInt(request.getParameter("num"));
	
	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	
	BoardDTO dto = dao.getReadDate(num);
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function sendIt()
	{
		var f = document.myForm;
		
		str = f.pwd.value;
		str = str.trim();
		var pwdSource = document.getElementById("pwdSource").value;

		if(str != pwdSource)
		{
			alert("\n패스워드가 맞지 않습니다.");
			f.pwd.focus();
			return;
		}
		
		f.action = "<%=cp%>/Deleted_ok.jsp";
		
		f.submit();
	}
</script>

<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>


<form action="" name="myForm" method="post">
	비밀번호를 입력하세요
	<input type="password" name="pwd" size="35" maxlength="10" class="boxTF" id="pwd"/>
	<input type="hidden" name="pwdSource" size="35" maxlength="10" class="boxTF" id="pwdSource" value="<%=dto.getPwd()%>"/>
	
<div id="bbsCreated_footer">
	<input type="hidden" name="num" value="<%=num %>">
	
	<input type="button" value="삭제하기" class="btn2" onclick="sendIt()"/>
	<input type="reset" value="다시입력" class="btn2"
	onclick="document.myForm.pwd.focus()"/>
	<input type="button" value="작성취소" class="btn2"
	onclick="javascript:location.href='<%=cp%>/List.jsp?pageNum=<%=pageNum%>&num=<%=num%>'"/>
</div><!-- #bbsCreated_footer -->
</form>
</body>
</html>