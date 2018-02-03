/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.List;

/**
 *
 * @author Jose Arenas
 */
public class Sorty 
{    
    /**
     * 
     * @param L
     * @return 
     */
    public static Comparable[] gnomeSort(Comparable[] L)
            throws IllegalArgumentException
    {
        // revisar que se tenga un arreglo valido
        if(L.length < 2) throw new IllegalArgumentException("Invalid array.");
        int i = 1; // comenzamos en el segundo elemento del arreglo
        while(i < L.length)
        {
            if(L[i].compareTo(L[i-1]) >= 0) i++;
            else
            {
                // el elemento [i-1] es mayor al elemento [i], intercambiarlos
                swap(L, i, i-1);
                // debemos regresar a comparar si el elemento que acabamos de
                // intercambiar es menor al elemento a su izquierda.
                if(i > 1) i--;
            }
        }
        return L;
    }
    
   
    /**
     * 
     * @param L
     * @return 
     */
    public List<Comparable> mergeSort(List<Comparable> L)
    {
        return null;
    }
    
    
    /**
     * 
     * @param L
     * @return 
     */
    public List<Comparable> quickSort(List<Comparable> L)
    {
        return null;
    }
    
    
    /**
     * 
     * @param L
     * @return 
     */
    public List<Comparable> radixSort(List<Comparable> L)
    {
        return null;
    }
    
    // TODO: implementar otro algoritmo de sorting.
    
    /**
     * Metodo utilizado por los algoritmos de ordenamiento para intercambiar
     * 2 elementos de un arreglo.
     * @param array el arreglo del cual se desea intercambiar los elementos.
     * @param i Un indice valido del arreglo.
     * @param j Un indice valido del arreglo.
     */
    private static void swap(Comparable[] array, int i, int j)
            throws IndexOutOfBoundsException
    {
        if(i < 0 || i >= array.length || j < 0 || j >= array.length)
            throw new IndexOutOfBoundsException();
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
