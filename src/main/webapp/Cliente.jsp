<!-- 
 *  PROYECTO PRIMER CORTE
 *   co-Author :::   Juan Albarracin
 *   co-Author :::  Mario Bolaños
 *   co-Author ::: Sergio Orozco
 *   co-Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
-->
<%@page import="java.util.ArrayList"%>
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
        <div id="MenuDes">
            <nav>
                <ul>
                    <li><a href=""><span class=""><img class="icon" src="ui/imagenes/icon1.png" /></span>Inicio</a>
                        <ul>
                            <li><a href="index.jsp">INICIO</a></li>
                        </ul>
                    </li>
                    <li><a href=""><span class=""><img class="icon" src="ui/imagenes/icon2.png" /> </span>Cliente</a>
                        <ul>
                            <li><a href="Cliente.jsp">Crear</a></li>
                            <li><a href="clienteActua.jsp">Actualizar</a></li>
                            <li><a href="clienteConsulta.jsp">Consultar</a></li>
                            <li><a href="clienteBorrar.jsp">Borrar</a></li>
                        </ul>
                    </li>
                    <li><a href=""><span class=""><img class="icon" src="ui/imagenes/icon3.png" /> </span>Empleado</a>
                        <ul>
                            <li><a href="empleadoCrear.jsp">Crear</a></li>
                            <li><a href="empleadoActua.jsp">Actualizar</a></li>
                            <li><a href="empleadoConsu.jsp">Consultar</a></li>
                            <li><a href="empleadoBorra.jsp">Borrar</a></li>
                        </ul>
                    </li>
                    <li><a href=""><span class=""><img class="icon" src="ui/imagenes/icon4.png"/></span>Factura</a>
                        <ul>
                            <li><a href="index.jsp">FACTURA</a></li>
                        </ul>
                    </li>
                    <li><a href=""><span class=""><img class="icon" src="ui/imagenes/icon5.png"/></span>Sustentación</a>
                        <ul>
                            <li><a href="consultaValor.jsp">Sergio Orozco</a></li>
                            <li><a href="consultaNivel.jsp">Particular</a></li>
                        </ul>
                    </li>
                    <li><a href=""><span class=""><img class="icon" src="ui/imagenes/icon6.png"/></span>Contacto</a>
                        <ul>
                            <li><a href="contacto.jsp">CONTACTO</a></li>
                        </ul>
                    </li>
                </ul>				
            </nav>
        </div>
        <form action="ClienteCont"  method="POST">
            <div class="form-style-5">
                <form>
                    <fieldset>
                        <legend><span class="number"></span>Información Nuevo Cliente</legend>
                        <td>Nombre</td><td><input type="text" placeholder="Nombre" name="Nombre" maxlength="28"/>  </td>
                        <td>Direccion</td><td><input type="text" placeholder="Direccion" name="Direccion" maxlength="28"/>  </td>
                        <td>Telefono</td><td><input type="text" placeholder="Telefono" name="Telefono" maxlength="10"/>  </td>
                        <td>Nivel</td><td><input type="text" placeholder="Nivel" name="Nivel" maxlength=""/>  </td>
                        <td>Ultima Compra</td><td><input type="date" placeholder="DD/MM/AA" name="Ucompra" maxlength="10"/>  </td>
                        <td>Valor</td><td><input type="text" placeholder="Valor" name="Valor" maxlength="8"/>  </td>
                    </fieldset>
                    <input type="submit" value="INGRESAR"/>
                </form>
            </div>
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
        </form>
    </body>
</html>