/*
 *  PROYECTO PRIMER CORTE
 *   co-Author :::   Juan Albarracin
 *   co-Author :::  Mario Bolaños
 *   co-Author ::: Sergio Orozco
 *   co-Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
 */
package vista;


import java.util.Date;


public class facturaWeb 
{
    public static String idPersona;
    public static String idEmpleado;
    public static Integer facturaId;
    public static String idEmpleadoCorte;
    public Date fecha;

    public String getIdPersona() 
    {
        return idPersona;
    }

    public void setIdPersona(String idPersona) 
    {
        facturaWeb.idPersona = idPersona;
    }

    public String getIdEmpleado() 
    {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) 
    {
        facturaWeb.idEmpleado = idEmpleado;
    }

    public Integer getFacturaId() 
    {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) 
    {
        facturaWeb.facturaId = facturaId;
    }

    public String getIdEmpleadoCorte() 
    {
        return idEmpleadoCorte;
    }

    public void setIdEmpleadoCorte(String idEmpleadoCorte) 
    {
        facturaWeb.idEmpleadoCorte = idEmpleadoCorte;
    }

    public Date getFecha() 
    {
        return fecha;
    }

    public void setFecha(Date fecha) 
    {
        this.fecha = fecha;
    }
}

















18
19
20
21
22
23
24
25
26
27
28
29
30