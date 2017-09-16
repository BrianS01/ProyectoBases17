<%-- 
 *  PROYECTO PRIMER CORTE
 *   co-Author :::   Juan Albarracin
 *   co-Author :::  Mario Bolaños
 *   co-Author ::: Sergio Orozco
 *   co-Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="Style01.css" />
        <link rel="shortcut icon" href="ui/imagenes/logo.ico">
        <title>VLC Ltda!</title>
    </head>
    <body>
        <div class="form-style-5">
            <form>
                <fieldset>
                    <legend><span class="number">1</span>Información Nuevo Empleado</legend>
                    <input type="text" name="field1" placeholder="Nombre *">
                    <input type="email" name="field2" placeholder="Cedula *">
                    <input type="email" name="field3" placeholder="Correo *">
                    <label for="job">Contrato:</label>
                    <select id="job" name="field4">
                        <option value="administrativo">Administrativo</option>
                        <option value="tecnico">Tecnico</option>
                    </select>      
                </fieldset>
                <input type="submit" value="INGRESAR" />
            </form>
        </div>
        <div style="position: absolute; bottom: 5px;">
            Copyright © 2017 - VLC Ltda - Todos los derechos reservados.
        </div>  
    </body>
</html>