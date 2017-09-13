/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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