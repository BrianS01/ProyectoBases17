<%-- 
    Document   : nivel
    Created on : 21/09/2017, 10:25:16 AM
    Author     : BRIAN
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="/src/java/Modelo/Cliente.java"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="ui/imagenes/logo.ico">
        <link rel="stylesheet" href="ui/css/Desplegable.css">
        <title>VLC Ltda!</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= Modelo.Cliente.com.example.MyUtility.getSomething() %>
        <%
                ArrayList<String> ListaCLax = (ArrayList) request.getAttribute("ListaClientes");
                if (ListaCLax != null) 
                {
                    for (String elemento : ListaCLax) 
                    {
            %>
            <h2><%=elemento%>
            <%
                    }
                }
            %>
        <footer>
            <font size="3" color="white">
                <p>Copyright © 2017 - VLC Ltda - Todos los derechos reservados.</p>
            </font>
        </footer> 
    </body>    
</html>