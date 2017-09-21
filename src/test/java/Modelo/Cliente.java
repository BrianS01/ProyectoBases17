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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Cliente 
{
    int tamañoRg;
    boolean elExi = true;
    RandomAccessFile archivo;
    
    public void crearArchio() throws FileNotFoundException 
    {
        this.archivo = new RandomAccessFile("Clientes.txt", "rw");
        File file = new File("Clientes.txt");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Aca ESTA ##$$%%&&"+file.getAbsolutePath()+"%%&&$$$");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    public void existe(int codigo) throws IOException 
    {
        archivo.seek(codigo * 105);
        archivo.skipBytes(96);
        char estado = archivo.readChar();
        if ('A' == estado) {
            this.elExi = true;
            System.out.println("Elemento si existe");
        } else {
            this.elExi = false;
            System.out.println("Elemento no existe");
        }
    }
    
    public void crearCliente(String nombre, String direcion, String telefono, int nievel, String ultimaCompra, int valor) throws IOException
    {
        if (archivo.length() == 0)
        {
            System.out.println("Tamano actual: " + 1);
            archivo.writeInt(1);
            archivo.writeUTF("\r\n");

            ////movemos el puntero a la posicion 105, tamaño de cada registro
            archivo.seek(105);
            //// pk de cliente
            archivo.writeInt(1);//4
            archivo.writeUTF(nombre);//30
            
            archivo.seek(139);
            archivo.writeUTF(direcion);//30

            archivo.seek(169);
            archivo.writeUTF(telefono);//12
            
            archivo.seek(181);
            archivo.writeInt(nievel);//4
            archivo.writeUTF(ultimaCompra);//12
            
            archivo.seek(197);
            archivo.writeInt(valor);//4
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4

        } 
        else
        {
            archivo.seek(0);
            tamañoRg = (archivo.readInt() + 1);
            archivo.seek(0);
            archivo.writeInt(tamañoRg);

            System.out.println("Tamano actual: " + tamañoRg * 105);

            archivo.seek(tamañoRg * 105);
            archivo.writeInt(tamañoRg);//4
            archivo.writeUTF(nombre);//30
            
            archivo.seek((tamañoRg * 105) + 34);
            archivo.writeUTF(direcion);//30
            
            archivo.seek((tamañoRg * 105) + 64);
            archivo.writeUTF(telefono);//12
            
            archivo.seek((tamañoRg * 105) + 76);
            archivo.writeInt(nievel);//4
            archivo.writeUTF(ultimaCompra);//12
            
            archivo.seek((tamañoRg * 105) + 92);
            archivo.writeInt(valor);//4
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4
        }
    }
    
    public String leerCliente(int codigo) throws IOException
    {
        existe(codigo);
        int ID = 666;
        String Nom = "Error";
        String Dr = "Error";
        String Tel = "Error";
        int NL = 666;
        String Uc = "Error";
        int VL = 666;
        char Eac = 'G';
        
        if (elExi == true)
        {
            archivo.seek((codigo * 105));
            ID = archivo.readInt();
            Nom = archivo.readUTF();
            
            archivo.seek((codigo * 105) + 34);
            Dr = archivo.readUTF();
            
            archivo.seek((codigo * 105) + 64);
            Tel = archivo.readUTF();
            
            archivo.seek((codigo * 105) + 76);
            NL = archivo.readInt();
            Uc = archivo.readUTF();
            
            archivo.seek((codigo * 105) + 92);
            VL = archivo.readInt();
            Eac = archivo.readChar();   
        }
        return ID + " " + Nom + " " + Dr + " " + Tel + " " + NL + " " + Uc + " " +VL;
    }
    
    public void actualizarCliente (int codigo, String Campo, String newDato) throws IOException
    {
        existe(codigo);
        if (elExi == true)
        {
            archivo.seek(codigo * 105);

            if ("Nombre".equals(Campo))
            {
                archivo.skipBytes(4);
                archivo.writeUTF(newDato);
            }
            if ("Direccion".equals(Campo))
            {
                archivo.skipBytes(34);
                archivo.writeUTF(newDato);
            }
            if ("Telefono".equals(Campo))
            {
                archivo.skipBytes(64);
                archivo.writeUTF(newDato);
            }
            if ("Nivel".equals(Campo))
            {
                archivo.skipBytes(76);
                archivo.writeInt(Integer.parseInt(newDato));
            }
            if ("UltimaC".equals(Campo))
            {
                archivo.skipBytes(80);
                archivo.writeUTF(newDato);
            }
            
            if ("Valor".equals(Campo))
            {
                archivo.skipBytes(92);
                archivo.writeInt(Integer.parseInt(newDato));
            }
        }
    }
    
    public void borrarCliente(int codigo) throws IOException
    {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(archivo.getFilePointer() - 2);
            archivo.writeChar('B');
            System.out.println("Elemento Eliminado");
        }
    }
    
    public ArrayList<String> listarCliente() throws IOException
    {
        ArrayList resultado = new ArrayList();
        archivo.seek(0);
        tamañoRg = (archivo.readInt() + 1);

        for (int i = 0; i < tamañoRg; i++) 
        {
            existe(i);
            if (elExi == true) {
                resultado.add(leerCliente(i));
            }
        }
        return resultado;
    }
    
    
    public String leerNivel(int codigo) throws IOException
    {
        existe(codigo);
        int ID = 666;
        String Nom = "Error";
        String Dr = "Error";
        String Tel = "Error";
        int NL = 666;
        String Uc = "Error";
        int VL = 666;
        char Eac = 'G';
        
        if (elExi == true)
        {
            archivo.seek((codigo * 105) + 76);
            NL = archivo.readInt();  
        }
        return " Nivel = " + NL;
    }
}