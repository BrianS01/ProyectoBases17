/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte.pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Mario-Bx
 */
public class Producto {
    int tamañoRg;
    boolean elExi = true;
    RandomAccessFile archivo;
    
    public void crearArchivo() throws FileNotFoundException {
        this.archivo = new RandomAccessFile("Productos.txt", "rw");
    }
    
    public void existe(int codigo) throws IOException {
        archivo.seek(codigo * 80);
        archivo.skipBytes(68);
        char estado = archivo.readChar();
        if ('A' == estado) {
            this.elExi = true;
            System.out.println("Elemento si existe");
        } else {
            this.elExi = false;
            System.out.println("Elemento no existe");
        }
    }
    
    public void crearProducto( double ancho, double alto, double espesor, String calidad, String Tipo) throws IOException {
        if (archivo.length() == 0) {
            System.out.println("Tamano actual: " + 1);
            archivo.writeInt(1);
            archivo.writeUTF("\r\n");

            ////movemos el puntero a la posicion 80, tamaño de cada registro
            archivo.seek(80);
            //// pk de Pedido
            archivo.writeInt(1);//4
            archivo.writeDouble(ancho);//8
            archivo.writeDouble(alto);//8
            archivo.writeDouble(espesor);//8
            archivo.writeUTF(calidad);//20
            
            archivo.seek(128);
            archivo.writeUTF(Tipo);//20
            
            archivo.seek(148);
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4

        } else {
            archivo.seek(0);
            tamañoRg = (archivo.readInt() + 1);
            archivo.seek(0);
            archivo.writeInt(tamañoRg);

            System.out.println("Tamano actual: " + tamañoRg * 80);

            archivo.seek(tamañoRg * 80);
            archivo.writeInt(tamañoRg);//4
            archivo.writeDouble(ancho);//8
            archivo.writeDouble(alto);//8
            archivo.writeDouble(espesor);//8
            archivo.writeUTF(calidad);//20
            
            archivo.seek((tamañoRg * 80) + 48);
            archivo.writeUTF(Tipo);//20
            
            archivo.seek((tamañoRg * 80) + 68);
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4
        }
    }
    
    public String leerProducto(int codigo) throws IOException {
        existe(codigo);
        int ID = 666;
        double AN = 66.99;
        double AL = 66.99;
        double ES = 66.99;
        String CL = "Error";
        String TP = "Error";
        char Eac = 'G';
        
        if (elExi == true) {
            archivo.seek((codigo * 80));
            ID = archivo.readInt();
            AN = archivo.readDouble();
            AL = archivo.readDouble();
            ES = archivo.readDouble();
            CL = archivo.readUTF();

            
            archivo.seek((codigo * 80) + 48);
            TP = archivo.readUTF();
            
            archivo.seek((codigo * 80) + 68);
            Eac = archivo.readChar();   
        }
        return ID + " " + AN + " " + AL + " " + ES + " " + CL + " " +TP;
    }
    
    public void actualizarProducto (int codigo, String Campo, String newDato) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(codigo * 80);

            if ("Ancho".equals(Campo)) {
                archivo.skipBytes(4);
                archivo.writeDouble(Double.parseDouble(newDato));
            }
            if ("Alto".equals(Campo)) {
                archivo.skipBytes(12);
                archivo.writeDouble(Double.parseDouble(newDato));
            }
            if ("Espesor".equals(Campo)) {
                archivo.skipBytes(20);
                archivo.writeDouble(Double.parseDouble(newDato));
            }
            if ("Calidad".equals(Campo)) {
                archivo.skipBytes(28);
                archivo.writeUTF(newDato);
            }
            
            if ("Tipo".equals(Campo)) {
                archivo.skipBytes(48);
                archivo.writeUTF(newDato);
            }
        }
    }
    
    public void borrarProducto(int codigo) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(archivo.getFilePointer() - 2);
            archivo.writeChar('B');
            System.out.println("Elemento Eliminado");
        }
    }
    
    public ArrayList<String> listarProducto() throws IOException {
        ArrayList resultado = new ArrayList();
        archivo.seek(0);
        tamañoRg = (archivo.readInt() + 1);

        for (int i = 0; i < tamañoRg; i++) {
            existe(i);
            if (elExi == true) {
                resultado.add(leerProducto(i));
            }
        }

        return resultado;
    }
}
