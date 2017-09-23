<!-- 
 *  PROYECTO PRIMER CORTE
 *   co-Author :::   Juan Albarracin
 *   co-Author :::  Mario Bolaños
 *   co-Author ::: Sergio Orozco
 *   co-Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
-->

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
                            <li><a href="">Crear</a></li>
                            <li><a href="">Actualizar</a></li>
                            <li><a href="">Consultar</a></li>
                            <li><a href="">Borrar</a></li>
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
                            <li><a href="index.jsp">CONTACTO</a></li>
                        </ul>
                    </li>
                </ul>				
            </nav>
        </div>
        <label class="custom-select">
            <select>
                <option selected="true" disabled="true" >Seleccione Cliente</option>
                <option>Juan</option>
                <option>Mario</option>
                <option>Sergio</option>
            </select>
        </label>
        <button><a href="#">Borrar</a></button>
        <footer>
            <font size="3" color="white">
            <p>Copyright © 2017 - VLC Ltda - Todos los derechos reservados.</p>
            </font>
        </footer>  
    </body>
</html>