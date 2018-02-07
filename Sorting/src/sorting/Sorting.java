/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Jose Arenas 14...
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
        try
        {
            System.in.read();
        }
        catch(Exception e) {System.out.println(e.getMessage());}
        
        Comparable[] originalN = {123,41,46,25,73,46,24,51,324,123,62,547,36,8,245,143,69};
        Comparable[] workArray = null;
        // probar gnomeSort
        workArray = originalN;
        Sorty.gnomeSort(workArray);
        System.out.println("Arreglo ordenado con gnomeSort...");
        for(Comparable n : workArray)
            System.out.print(n + ",");
        System.out.println();
        
        try
        {
            System.in.read();
        }
        catch(Exception e) {System.out.println(e.getMessage());}
        // probar quickSort
        workArray = originalN;
        Sorty.quickSort(workArray);
        System.out.println("Arreglo ordenado con quickSort...");
        for(Comparable n : workArray)
            System.out.print(n + ",");
        System.out.println();
    }
}
