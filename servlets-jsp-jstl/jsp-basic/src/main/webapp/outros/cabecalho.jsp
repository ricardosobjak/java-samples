<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<div style="background-color: #FBBE56; height: 100px; text-align: center;" >
	<h1>UTFPR</h1>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	%>
	Hoje é <%= sdf.format(new Date()) %>
</div>

<br/>