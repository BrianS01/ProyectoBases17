/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Cliente;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Mario-Bx
 */
public class ClienteCont extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ///Cereamos variables Para los Textos
        String NombreCont = request.getParameter("Nombre");
        String DireccionCont = request.getParameter("Direccion");
        String TelefonoCont = request.getParameter("Telefono");
        String NivelCont = request.getParameter("Nivel");
        String UCompraCont = request.getParameter("Ucompra");
        String ValorCont = request.getParameter("Valor");

        if (NombreCont.trim().length() > 0 && DireccionCont.trim().length() > 0 && TelefonoCont.trim().length() > 0 && UCompraCont.trim().length() > 0
                && NivelCont.trim().length() > 0 && ValorCont.trim().length() > 0) {

            //se crea un objero de la clase (Metodos),  no olvidar importar antes 
            Cliente Cl = new Cliente();
            // se crea el archivo
            Cl.crearArchio();
            // se introducen los parametros al metodo con el "request.getParameter("")" dentro de las comilla va el nombre del imput del cual se tae los datos
            Cl.crearCliente(NombreCont, DireccionCont, TelefonoCont, Integer.parseInt(NivelCont), UCompraCont,Integer.parseInt(ValorCont));

            ///se captura el objeo para reridreccionar al index
            ArrayList<String> ListaCL = Cl.listarCliente();
            RequestDispatcher aREspuesta = request.getRequestDispatcher("Cliente.jsp");
            request.setAttribute("ListaClientes", ListaCL);
            aREspuesta.forward(request, response);
            
        }else {
            //Mandar Mensaje de Error
            response.sendRedirect("hola.jsp");
        }
    }
}