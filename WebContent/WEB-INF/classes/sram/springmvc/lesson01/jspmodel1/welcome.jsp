<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
  </head>
  
  <body> 
    <br>登录成功！恭喜你！<%=request.getParameter("user") %>
    <a href="login.jsp">返回重新登录</a>
    <hr>
    <h1>用户信息列表</h1>
    <%
    	//定义四个分页会用到的变量
    	int pageSize=3;
    	int pageNow=1;//默认显示第一页
    	int rowCount=0;//该值从数据库查询
    	int pageCount=0;//该值是通过计算得来
    	
    	//接收用户希望显示的页数（pageNow）
    	String s_pageNow=request.getParameter("pageNow");
    	
    	//当用户是从初始登录进去的话就可能为空
    	if(s_pageNow!=null){
    		//确实接收到pageNow
    		pageNow=Integer.parseInt(s_pageNow);
    	}
    	
    	//查询到rowCount
    	 //到数据库中验证
       Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
       //得到链接
       Connection ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=spdb","sa","123456");
       //创建Statement
       Statement sm=ct.createStatement();
       
       //查询数据库
       ResultSet rs=sm.executeQuery("select count(*) from users");
       if(rs.next())//r.next()指向指标所指的记录
       {
          rowCount=rs.getInt(1);
       }
       //计算pageCount
       if(rowCount%pageSize==0){
       		pageCount=rowCount/pageSize;
       }else{
       		pageCount=rowCount/pageSize+1;
       }
       
       //查询出需要显示的记录
       rs=sm.executeQuery("select top "+pageSize+
       " * from users where userId not in (select top "
       +pageSize*(pageNow-1)+" userId from users)");
       %>
       <table border="1">
       		<tr><td>用户id</td><td>用户名字</td><td>密码</td><td>电邮</td><td>级别</td></tr>
       		<%
       			while(rs.next()){
       				%>
       				<tr>
       					<td><%=rs.getInt(1) %></td>
       					<td><%=rs.getString(2)%></td>
       					<td><%=rs.getString(3) %></td>
       					<td><%=rs.getString(4) %></td>
       					<td><%=rs.getInt(5) %></td>
       				</tr>
       				<%
       			}
       		 %>
       </table>
       <%
       //上一页
       if(pageNow!=1){
       		out.println("<a href=wel.jsp?pageNow="+(pageNow-1)+">上一页</a>");
       }
       //显示超链接
       for(int i=pageNow;i<=pageNow+4;i++){
       	  out.println("<a href=wel.jsp?pageNow="+i+">["+i+"]</a>");
       }
       //下一页
       if(pageNow!=pageCount)
       out.println("<a href=wel.jsp?pageNow="+(pageNow+1)+">下一页</a>");
     %>
  </body>
</html>