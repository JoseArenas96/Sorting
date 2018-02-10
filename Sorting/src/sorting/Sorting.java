/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jose Arenas 14470
 * @author Fernando Figueroa 14175
 * @author Sebastian Arriola 11463
 */
public class Sorting 
{
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) 
    {   
        Integer numberOfElements = 10;
        try
        {
            System.out.println("Introducir numero de elementos: ");
            numberOfElements = new Scanner(System.in).nextInt();
        } catch(Exception e){ }
        
        try
        {
            System.out.println("Press key to start loop.");
            System.in.read();
        } catch(Exception e){}
            
            Comparable[] numbers = null;
            Comparable[] workArray = null;
            try
            {
                writeRandomIntegersToFile("src/file.txt", numberOfElements);
                numbers = readIntegersFromFile("src/file.txt");
            }
            catch(IOException e) 
            {
                System.out.println(e.getMessage());
            }
            
//            workArray = numbers;
//            Sorty.gnomeSort(workArray);
            
//            workArray = numbers;
//            Arrays.sort(workArray);
//            Sorty.quickSort(workArray);

            workArray = numbers;
            Arrays.sort(workArray);
            Sorty.selectionSort(workArray);
}    
    
    // write random integers to file, one per line
    public static void writeRandomIntegersToFile(String path, int amount)
            throws IOException
    {
        FileWriter writer = null;
        try
        {
            Random r = new Random();
            File f = new File(path);
            f.createNewFile();
            writer = new FileWriter(path);
            for(int i = 0; i < amount; i++)
                writer.write(String.valueOf(r.nextInt()) + "\n");
        }
        finally
        {
            if(writer != null)
            {
                writer.flush();
                writer.close();
            }
        }
    }
    
    public static Comparable[] readIntegersFromFile(String path)
            throws IOException
    {
        Comparable[] array = null;
        try
        {
            List<String> list = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
            array = new Comparable[list.size()];
            array = list.toArray(array);
        }
        catch(IOException e) {}
        
        return array;
    }
}
