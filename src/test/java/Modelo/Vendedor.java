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

public class Vendedor
{
    int tamañoRg;
    boolean elExi = true;
    RandomAccessFile archivo;

    public void crearArchivo() throws FileNotFoundException
    {
        this.archivo = new RandomAccessFile("Vendedor.txt", "rw");
    }

    public void existe(int codigo) throws IOException
    {
        archivo.seek(codigo * 95);
        archivo.skipBytes(88);
        char estado = archivo.readChar();
        
        if ('A' == estado)
        {
            this.elExi = true;
            System.out.println("Elemento si existe");

        }
        else
        {
            this.elExi = false;
            System.out.println("Elemento no existe");
        }
    }

    public void crearVendedor(String cC, String nombre, String direccion, String telefono) throws IOException
    {
        if (archivo.length() == 0)
        {
            System.out.println("Tamano actual: " + 1);
            archivo.writeInt(1);
            archivo.writeUTF("\r\n");

            archivo.seek(95);
            archivo.writeInt(1);//4
            archivo.writeUTF(cC);//12

            archivo.seek(111);
            archivo.writeUTF(nombre);//30

            archivo.seek(141);
            archivo.writeUTF(direccion);//30

            archivo.seek(171);
            archivo.writeUTF(telefono);//

            archivo.seek(183);
            archivo.writeChar('A');
            archivo.writeUTF("\r\n");

        }
        else
        {
            archivo.seek(0);
            tamañoRg = (archivo.readInt() + 1);
            archivo.seek(0);
            archivo.writeInt(tamañoRg);

            System.out.println("Tamano actual: " + tamañoRg * 95);

            archivo.seek(tamañoRg * 95);
            archivo.writeInt(tamañoRg);
            archivo.writeUTF(cC);

            archivo.seek((tamañoRg * 95) + 16);
            archivo.writeUTF(nombre);

            archivo.seek((tamañoRg * 95) + 46);
            archivo.writeUTF(direccion);

            archivo.seek((tamañoRg * 95) + 76);
            archivo.writeUTF(telefono);

            archivo.seek((tamañoRg * 95) + 88);
            archivo.writeChar('A');
            archivo.writeUTF("\r\n");
        }
    }

    public String leerVendedor(int codigo) throws IOException
    {
        existe(codigo);
        int ID = 666;
        String CC = "Error";
        String Nom = "Error";
        String Dr = "Error";
        String Tel = "Error";
        int VL = 666;
        char Eac = 'G';

        if (elExi == true)
        {
            archivo.seek((codigo * 95));
            ID = archivo.readInt();
            CC = archivo.readUTF();

            archivo.seek((codigo * 95) + 16);
            Nom = archivo.readUTF();

            archivo.seek((codigo * 95) + 46);
            Dr = archivo.readUTF();

            archivo.seek((codigo * 95) + 76);
            Tel = archivo.readUTF();

            archivo.seek((codigo * 95) + 88);
            Eac = archivo.readChar();
        }
        return ID + " " + CC + " " + Nom + " " + Dr + " " + Tel;
    }

    public void actualizarVendedodr(int codigo, String Campo, String newDato) throws IOException
    {
        existe(codigo);
        if (elExi == true)
        {
            archivo.seek(codigo * 95);

            if ("Cedula".equals(Campo))
            {
                archivo.skipBytes(4);
                archivo.writeUTF(newDato);
            }
            
            if ("Nombre".equals(Campo))
            {
                archivo.skipBytes(16);
                archivo.writeUTF(newDato);
            }
            
            if ("Direccion".equals(Campo))
            {
                archivo.skipBytes(46);
                archivo.writeUTF(newDato);
            }
            
            if ("Telefono".equals(Campo))
            {
                archivo.skipBytes(76);
                archivo.writeUTF(newDato);
            }
        }
    }

    public void borrarVendedor(int codigo) throws IOException
    {
        existe(codigo);
        
        if (elExi == true)
        {
            archivo.seek(archivo.getFilePointer() - 2);
            archivo.writeChar('B');
            System.out.println("Elemento Eliminado");
        }
    }

    public ArrayList<String> listar() throws IOException
    {
        ArrayList resultado = new ArrayList();
        archivo.seek(0);
        tamañoRg = (archivo.readInt() + 1);

        for (int i = 0; i < tamañoRg; i++)
        {
            existe(i);
            
            if (elExi == true)
            {
                resultado.add(leerVendedor(i));
            }
        }
        return resultado;
    }
}