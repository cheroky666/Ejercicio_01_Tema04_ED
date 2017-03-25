/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class Ejercicio_01_Tema04_ED 
{
    private static byte[] tamaño = new byte[1000];
    private static String nombrearchivo = "fichero.dat";
    private static FileInputStream meterarchivo = null;
    private static BufferedInputStream metertamaño = null;

    public static void inicializararchivos() throws FileNotFoundException
    {
        meterarchivo = new FileInputStream(nombrearchivo);
        metertamaño = new BufferedInputStream(meterarchivo);
    }
    
    public static int enseñartextodearchivo() throws IOException
    {
        int total = 0;
        int numeroleido = 0;
        while((numeroleido = meterarchivo.read(tamaño)) != -1) 
        {
            System.out.println(new String(tamaño));
            total += numeroleido;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializararchivos();
            
            int total = enseñartextodearchivo();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( metertamaño != null && meterarchivo != null )
                {
                    meterarchivo.close();
                    metertamaño.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
