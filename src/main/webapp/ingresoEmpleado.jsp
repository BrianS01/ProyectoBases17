<%-- 
    Document   : ingresoEmpleado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="Style01.css" />
        <title>INGRESO EMPLEADO</title>
        <style type="text/css">
        
        </style>
    </head>
    <body>
        <div class="form-style-5">
            <form>
                <fieldset>
                    <legend><span class="number">1</span> Información Nuevo Empleado</legend>
                    <input type="text" name="field1" placeholder="Nombre *">
                    <input type="email" name="field2" placeholder="Cedula *">
                    <input type="email" name="field3" placeholder="Correo *">
                    <label for="job">Contrato:</label>
                    <select id="job" name="field4">
                        <option value="administrativo">Administrativo</option>
                        <option value="tecnico">Tecnico</option>
                    </select>      
                </fieldset>
                <input type="submit" value="Apply" />
            </form>
        </div>
    </body>
</html>