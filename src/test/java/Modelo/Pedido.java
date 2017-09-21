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

public class Pedido
{
    int tamañoRg;
    boolean elExi = true;
    RandomAccessFile archivo;

    public void crearArchivo() throws FileNotFoundException
    {
        this.archivo = new RandomAccessFile("Pedidos.txt", "rw");
    }

    public void existe(int codigo) throws IOException
    {
        archivo.seek(codigo * 85);
        archivo.skipBytes(76);
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

    public void crearPedido(String medioP, double ancho, double alto, double espesor, String Tipo, int cantidad, int idCliente) throws IOException
    {
        if (archivo.length() == 0)
        {
            System.out.println("Tamano actual: " + 1);
            archivo.writeInt(1);
            archivo.writeUTF("\r\n");
            ////movemos el puntero a la posicion 85, tamaño de cada registro
            archivo.seek(85);
            //// pk de Pedido
            archivo.writeInt(1);//4
            archivo.writeUTF(medioP);//20
            archivo.seek(109);
            archivo.writeDouble(ancho);//8
            archivo.writeDouble(alto);//8
            archivo.writeDouble(espesor);//8
            archivo.writeUTF(Tipo);//20
            archivo.seek(153);
            archivo.writeInt(cantidad);//4
            archivo.writeInt(idCliente);//4            
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4
        }
        else
        {
            archivo.seek(0);
            tamañoRg = (archivo.readInt() + 1);
            archivo.seek(0);
            archivo.writeInt(tamañoRg);

            System.out.println("Tamano actual: " + tamañoRg * 85);

            archivo.seek(tamañoRg * 85);
            archivo.writeInt(tamañoRg);//4
            archivo.writeUTF(medioP);//20

            archivo.seek((tamañoRg * 85) + 24);
            archivo.writeDouble(ancho);//8
            archivo.writeDouble(alto);//8
            archivo.writeDouble(espesor);//8
            archivo.writeUTF(Tipo);//20

            archivo.seek((tamañoRg * 85) + 68);
            archivo.writeInt(cantidad);//4
            archivo.writeInt(idCliente);//4
            archivo.writeChar('A');//2
            archivo.writeUTF("\r\n");//4
        }
    }

    public String leerPedido(int codigo) throws IOException
    {
        existe(codigo);
        int ID = 666;
        String MP = "Error";
        double AN = 66.99;
        double AL = 66.99;
        double ES = 66.99;
        int CN = 666;
        int IDC = 666;
        char Eac = 'G';

        if (elExi == true)
        {
            archivo.seek((codigo * 85));
            ID = archivo.readInt();
            MP = archivo.readUTF();

            archivo.seek((codigo * 85) + 24);
            AN = archivo.readDouble();
            AL = archivo.readDouble();
            ES = archivo.readDouble();
            MP = archivo.readUTF();

            archivo.seek((codigo * 85) + 68);
            CN = archivo.readInt();
            IDC = archivo.readInt();
            Eac = archivo.readChar();
        }
        return ID + " " + MP + " " + AN + " " + AL + " " + ES + " " + CN + " " + IDC;
    }

    public void actualizarPedido(int codigo, String Campo, String newDato) throws IOException
    {
        existe(codigo);
        
        if (elExi == true)
        {
            archivo.seek(codigo * 85);

            if ("Medio".equals(Campo))
            {
                archivo.skipBytes(4);
                archivo.writeUTF(newDato);
            }

            if ("Ancho".equals(Campo))
            {
                archivo.skipBytes(24);
                archivo.writeDouble(Double.parseDouble(newDato));
            }

            if ("Alto".equals(Campo))
            {
                archivo.skipBytes(32);
                archivo.writeDouble(Double.parseDouble(newDato));
            }

            if ("Espesor".equals(Campo))
            {
                archivo.skipBytes(40);
                archivo.writeDouble(Double.parseDouble(newDato));
            }

            if ("Tipo".equals(Campo))
            {
                archivo.skipBytes(48);
                archivo.writeUTF(newDato);
            }

            if ("Cantidad".equals(Campo))
            {
                archivo.skipBytes(68);
                archivo.writeInt(Integer.parseInt(newDato));
            }

            if ("Cliente".equals(Campo))
            {
                archivo.skipBytes(72);
                archivo.writeInt(Integer.parseInt(newDato));
            }
        }
    }

    public void borrarPedido(int codigo) throws IOException
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
                resultado.add(leerPedido(i));
            }
        }
        return resultado;
    }
}