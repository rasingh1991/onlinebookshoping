<%@taglib prefix="tag" uri="/WEB-INF/tlds/userdeftag.tld"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" method="post">
<table>

<tr><td align="center">
<font size="7"><b>Account Login</b></font></td></tr>

<tr><td align="center">
<font size="4" color="red"><b><tag:error property="loginError"/> </b></font></td></tr>

<tr><td><br/></td></tr>

<tr><td align="center">
<font size="5"><b>UserName</b></font>
<td>
<input type="text" name="username"/></td>
<td><font size="4" color="red"><b><tag:error property="username"/></b></font></td>
</tr>

<tr><td><br/></td></tr>

<tr><td align="center">
<font size="5"><b>Password</b></font>
<td> 
<input type="password" name="password"/> </td> 
<td><font size="4" color="red"><b><tag:error property="password"/></b></font></td>
</tr>

<tr><td> 
<input type="submit" value="Login Here.."/></td></tr>

<tr>
<td align="center">
<b>
<font size="5">New User</font> &nbsp;<a href="registerDef.jsp">
<font size="5"> SignUp Here</font></a></b></td></tr>

<tr>
<td align="center">
<b>
<font size="5">Forget Password</font> &nbsp;<a href="forgetPasswordDef.jsp">
<font size="5"> Click Here</font></a></b></td></tr>
</table>
</form>
</body>
</html>