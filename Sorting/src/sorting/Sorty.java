/**
 *
 * @author Jose Arenas 14470
 * @author Fernando Figueroa 14175
 * @author Sebastian Arriola 11463
 */
package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public static void mergeSort(Comparable[] L)
    {
        mergeSortRecursivo(L, new Comparable[L.length], 0, L.length - 1);
    }
    
    /**
     * 
     * @param data
     * @param aux
     * @param low
     * @param high 
     */
    private static void mergeSortRecursivo(Comparable[] data, Comparable[] aux,
            int low, int high)
    {
        // caso base, se trata de un unico elemento 
        int n = high - low + 1;
        int mid = low + n/2;
        if(n < 2) return;
        // computar el indice que parte a la mitad esta particion del arreglo
        // copiar la mitad inferior de data al arreglo auxiliar
        for(int i = low; i < mid; i++) aux[i] = data[i];
        // llamada recursiva para la mitad inferior del arreglo
        mergeSortRecursivo(aux, data, low, mid-1);
        // llamada recursiva para la mitad superior del arreglo
        mergeSortRecursivo(data, aux, mid, high);
        // juntar ambas mitades
        merge(data, aux, low, mid, high);
    }
    
    /**
     * Se asume que la mitad superior de data esta en orden ascendente y la
     * mitad inferior del arreglo auxiliar esta en orden ascendente.
     * @param data
     * @param aux
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(Comparable[] data, Comparable[] aux, int low, 
            int mid, int high)
    {
        int resIndex = low;
        int auxIndex = low;
        int desIndex = mid;
        while(auxIndex < mid && desIndex <= high)
        {
            // el valor menor esta ubicado en data
            if(data[desIndex].compareTo(aux[auxIndex]) < 0)
                data[resIndex++] = data[desIndex++];
            // el valor menor esta ubicado en aux
            else data[resIndex++] = aux[auxIndex++];
        }
        // copiar lo que resta del arreglo auxiliar al arreglo data
        while(auxIndex < mid)
            data[resIndex++] = aux[auxIndex++];
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
     * Ordena el arreglo utilizando el algoritmo radixSort. Debido a que limitamos
     * el input a un arreglo de Integer, un numero puede tener como maximo 10
     * digitos. Es por eso que el loop for corre 10 veces, una vez por digito.
     * @param L
     * @return 
     */
    public static void radixSort(Integer[] L)
    {
        for(int i = 0; i < 10; i++)
        {
            arrayACubetas(L, i);
        }
    }
    
    /**
     * Toma el arreglo proveido y lo distribuye en 10 cubetas, dependiendo del
     * valor de pos, que indica que digito de cada numero se esta analizando.
     * @param datos
     * @param pos 
     */
    private static void arrayACubetas(Integer[] datos, int pos)
    {
        ArrayList<ArrayList<Integer>> cubeta = new ArrayList<ArrayList<Integer>>(10);
        for(int i = 0; i < 10; i++)
        {
            cubeta.add(new ArrayList<Integer>(10));
        }
        // agregar a la cubeta correcta el numero que estamos evaluando
        for(Integer i : datos)
        {
            int digit = digitAtPos(i, pos);
            cubeta.get(digit).add(i);
        }
        int n = datos.length - 1;
        // vaciar cubetas en el arreglo
        for(int i = 9; i >= 0; i--)
        {
            while(!cubeta.get(i).isEmpty())
            {
                datos[n] = cubeta.get(i).remove(cubeta.get(i).size()-1);
                n--;
            }
        }
    }
    
    /**
     * Devuelve el digito en la posicion especificada del numero especificado.
     * @param number
     * @param position
     * @return 
     */
    private static int digitAtPos(int number, int position)
    {
        /* si se requiere el ultimo digito, se obtiene al realizar la operacion
           number mod 10 */
        if(position == 0) return number % 10;
        /* si se requiere otro digito que no es el ultimo, realizamos una llamada
           recursiva quitandole el ultimo digito al numero con la operacion
           number / 10 */
        else return digitAtPos(number / 10, position - 1);
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
   public static void selectionSort(Comparable[] miArray){
       for (int i = 0; i<miArray.length-1; i++){
           int minimo = i;
           for(int j = i+1; j < miArray.length;j++){
               if (miArray[j].compareTo (miArray[minimo])<0){
                   minimo = j;
                }
           }
           
           swap(miArray,i,minimo);
           
          
       }   
   }
}

