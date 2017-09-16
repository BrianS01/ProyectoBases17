<%-- 
    Document   : facturar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="Style01.css" />
        <title>VLC Ltda!</title>
    </head>
    <body>
        <div class="form-style-5">
            <form>
                <fieldset>
                    <legend><span class="number">1</span> Factura</legend>
                    <input type="text" name="field1" placeholder="Codigo Empleado *">
                    <input type="text" name="field3" placeholder="Cedula Cliente *">
                </fieldset>
                <fieldset>
                    <legend><span class="number">2</span> Informacion Productos</legend>
                    <input type="text" name="field1" placeholder="Codigo Producto *">
                    <input type="text" name="field2" placeholder="Precio Producto *">
                    <textarea name="field3" placeholder="Adicional"></textarea>
                </fieldset>
                <input type="submit" value="Generar Recibo"/>
            </form>
        </div>
    </body>
</html>