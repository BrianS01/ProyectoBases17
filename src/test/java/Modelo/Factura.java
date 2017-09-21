/*
 *  PROYECTO PRIMER CORTE
 *   co-Author :::   Juan Albarracin
 *   co-Author :::  Mario Bolaños
 *   co-Author ::: Sergio Orozco
 *   co-Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
 */
package Modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Mario-Bx
 */
public class Factura {
    
    int tamañoRg;
    boolean elExi = true;
    RandomAccessFile archivo;
    
    public void crearArchivo() throws FileNotFoundException {
        this.archivo = new RandomAccessFile("Factura.txt", "rw");
    }
    
    public void existe(int codigo) throws IOException {
        archivo.seek(codigo * 40);
        archivo.skipBytes(32);
        char estado = archivo.readChar();
        if ('A' == estado) {
            this.elExi = true;
            System.out.println("Elemento si existe");
        } else {
            this.elExi = false;
            System.out.println("Elemento no existe");
        }
    }
    
    public void crearFactura(String fecha, int valor, int idVendedor, int idInventario, int idPedido) throws IOException {
        if (archivo.length() == 0) {
            System.out.println("Tamano actual: " + 1);
            archivo.writeInt(1);
            archivo.writeUTF("\r\n");

            ////movemos el puntero a la posicion 40, tamaño de cada registro
            archivo.seek(40);
            //// pk de Factura
            archivo.writeInt(1);//4
            archivo.writeUTF(fecha);//12
            
            archivo.seek(56);
            archivo.writeInt(valor);//4
            archivo.writeInt(idVendedor);//4
            archivo.writeInt(idInventario);//4
            archivo.writeInt(idPedido);//4
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4

        } else {
            archivo.seek(0);
            tamañoRg = (archivo.readInt() + 1);
            archivo.seek(0);
            archivo.writeInt(tamañoRg);

            System.out.println("Tamano actual: " + tamañoRg * 40);

            archivo.seek(tamañoRg * 40);
            archivo.writeInt(tamañoRg);//4
            archivo.writeUTF(fecha);//12
            
            archivo.seek((tamañoRg * 40) + 16);
            archivo.writeInt(valor);//4
            archivo.writeInt(idVendedor);//4
            archivo.writeInt(idInventario);//4
            archivo.writeInt(idPedido);//4
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4
        }
    }
    
    public String leerDactura(int codigo) throws IOException {
        existe(codigo);
        int ID = 666;
        String Fh = "Error";
        int IDV = 666;
        int IDI = 666;
        int IDP = 666;
        int VL = 666;
        char Eac = 'G';
        
        if (elExi == true) {
            archivo.seek((codigo * 40));
            ID = archivo.readInt();
            Fh = archivo.readUTF();
            
            archivo.seek((codigo * 40) + 16);
            VL = archivo.readInt();
            IDV = archivo.readInt();
            IDI = archivo.readInt();
            IDP = archivo.readInt();
            Eac = archivo.readChar();   
        }
        return ID + " " + Fh + " " + VL + " " + IDV + " " + IDI + " " + IDP;
    }

    public void actualizarFactura (int codigo, String Campo, String newDato) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(codigo * 40);

            if ("Fecha".equals(Campo)) {
                archivo.skipBytes(4);
                archivo.writeUTF(newDato);
            }
            if ("Valor".equals(Campo)) {
                archivo.skipBytes(16);
                 archivo.writeInt(Integer.parseInt(newDato));;
            }
            if ("Vendedor".equals(Campo)) {
                archivo.skipBytes(20);
                 archivo.writeInt(Integer.parseInt(newDato));
            }
            if ("Inventario".equals(Campo)) {
                archivo.skipBytes(24);
                archivo.writeInt(Integer.parseInt(newDato));
            }
            if ("Pedido".equals(Campo)) {
                archivo.skipBytes(28);
                archivo.writeInt(Integer.parseInt(newDato));
            }
        }
    }
    
    public void borrarFactura(int codigo) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(archivo.getFilePointer() - 2);
            archivo.writeChar('B');
            System.out.println("Elemento Eliminado");
        }
    }
    
    public ArrayList<String> listarFactura() throws IOException {
        ArrayList resultado = new ArrayList();
        archivo.seek(0);
        tamañoRg = (archivo.readInt() + 1);

        for (int i = 0; i < tamañoRg; i++) {
            existe(i);
            if (elExi == true) {
                resultado.add(leerDactura(i));
            }
        }

        return resultado;
    }
    
}
