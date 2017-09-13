<%-- 
    Document   : facturar
--%>

<%@page import="vista.facturaWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="http://www.free-css.com/assets/files/free-css-templates/preview/page217/aurora.css"/>
        <title>Facturar</title>
    </head>
    <body>
        <h1>Inicio Operaicones</h1>
        <f:view>
            <h:form>
                <table border="1">
                    <head>
                        
                        <tr>
                            <th>Empleado:</th>
                        </tr> 
                    </head>
                    <td>
                        <td>Id:</td>
                        <td><h:inputText value="<%=facturaWeb.idPersona%>"
                                     required="true"></h:inputText>
                    </td>
                    <tr>
                        <td>Empleado:</td>
                        <td><h:inputText value="<%=facturaWeb.idEmpleado%>"
                                     required="true"></h:inputText></td>
                    </tr>
                    <tr>
                        <td>Corte:</td>
                        <td><h:inputText value="<%=facturaWeb.facturaId%>"
                                     required="true"></h:inputText></td>
                    </tr>
            </h:form>
        </f:view>
    </body>
</html>