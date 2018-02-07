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
     * Precondicion: arreglo L tiene al menos 2 elementos
     * Postcondicion: arreglo L esta ordenado.
     * Ordena los elementos Comparable del arreglo utilizando el algoritmo
     * gnomeSort. O(n^2). Empieza considerando el segundo elemento del arreglo
     * y lo compara con el elemento a su izquierda, intercambiandolos si el 
     * elemento a la izquierda es mayor al elemento a su derecha. Si sucede esto,
     * se regresa a verificar que todos los elementos a la izquierda del recien
     * cambiado sean menores a el, intercambiandolos de lo contrario.
     * @param L Arreglo de Comparable que se desea ordenar
     */
    public static void gnomeSort(Comparable[] L)
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
    }
    
   
    /**
     * 
     * @param L
     * @return 
     */
    public static Comparable[] mergeSort(Comparable[] L)
    {
        return null;
    }
    
    
    /**
     * Ordena los elementos del arreglo utilizando el algoritmo quickSort.
     * O(nlog(n)) - mejor caso
     * @param L El arreglo de elementos Comparable que se desea ordenar
     * @return 
     */
    public static void quickSort(Comparable[] L)
    {
        quickSortRecursive(L, 0, L.length - 1);
    }
    
    
    /**
     * 
     * @param L
     * @return 
     */
    public static Comparable[] radixSort(Comparable[] L)
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
    
    /**
     * Metodo "helper" para el algoritmo quickSort.
     * @param data
     * @param left
     * @param right 
     */
    private static void quickSortRecursive(Comparable[] data, int left, int right)
    {
        // base case
        if(left >= right) return;
        // encontrar indice del pivote
        int pivot = quickSortPartition(data, left, right);
        // ordenar la parte izquierda del arreglo recursivamente
        quickSortRecursive(data, left, pivot - 1);
        // ordenar la parte derecha del arreglo recursivamente
        quickSortRecursive(data, pivot + 1, right);
    }
    
    /**
     * Metodo "helper" para el algoritmo quickSort. Toma el elemento que esta
     * en el indice left, y lo considera el pivote. Este metodo posiciona el
     * pivote en su posicion final en el arreglo.
     * Precondicion: left es menor o igual a right
     * Postcondicion: data[left] esta en su posicion final.
     * @param data Arreglo de elementos Comparable que se desea ordenar.
     * @param left indice del pivote
     * @param right indice del ultimo elemento en data.
     * @return 
     */
    private static int quickSortPartition(Comparable[] data, int left, int right)
    {
        while(true)
        {
            // buscar un elemento a la derecha del pivote que sea menor al
            // pivote
            while(left < right && data[left].compareTo(data[right]) < 0) right--;
            // si left es menor a right, cambiamos los elementos para que ahora
            // el menor este a la izquierda del pivote.
            if(left < right) swap(data, left++, right);
            else return left; // retornamos left, la posicion final del pivote
            // buscar un elemento mayor al pivote a su izquierda
            while(left < right && data[left].compareTo(data[right]) < 0) left++;
            /* si left es menor a right, cambiamos los elementos para que ahora
               el mayor este a la derecha del pivote, y reducimos en uno el
               valor de right para no volver a considerar ese elemento */
            if(left < right) swap(data, left, right--);
            else return left; // retornamos left, la posicion final del pivote
        }
    }
}
