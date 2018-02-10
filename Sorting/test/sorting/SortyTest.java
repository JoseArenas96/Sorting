/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaming
 */
public class SortyTest 
{
    private int size = 10;
    private Integer[] oArray = null;
    private Integer[] oSortedArray = null;
    private Integer[] workArray = null;
    
    public SortyTest() 
    {
        oArray = new Integer[size];
        oSortedArray = new Integer[size];
        workArray = new Integer[size];
        Random r = new Random();
        for(int i = 0; i < size; i++)
        {
            oArray[i] = r.nextInt(Integer.MAX_VALUE);
            oSortedArray[i] = oArray[i];
        }
        Arrays.sort(oSortedArray);
    }

    /**
     * Test of gnomeSort method, of class Sorty.
     */
    @Test
    public void testGnomeSort() 
    {
        System.out.println("gnomeSort");
        workArray = oArray;
        Sorty.gnomeSort(workArray);
        Assert.assertArrayEquals(workArray , oSortedArray);
    }

    /**
     * Test of mergeSort method, of class Sorty.
     */
    @Test
    public void testMergeSort() 
    {
        System.out.println("mergeSort");
        workArray = oArray;
        Sorty.mergeSort(workArray);
        Assert.assertArrayEquals(workArray , oSortedArray);
    }

    /**
     * Test of quickSort method, of class Sorty.
     */
    @Test
    public void testQuickSort() 
    {
        System.out.println("quickSort");
        workArray = oArray;
        Sorty.quickSort(workArray);
        Assert.assertArrayEquals(workArray , oSortedArray);
    }

    /**
     * Test of radixSort method, of class Sorty.
     */
    @Test
    public void testRadixSort() 
    {
        System.out.println("radixSort");
        workArray = oArray;
        Sorty.radixSort(workArray);
        Assert.assertArrayEquals(workArray , oSortedArray);
    }

    /**
     * Test of selectionSort method, of class Sorty.
     */
    @Test
    public void testSelectionSort() 
    {
        System.out.println("selectionSort");
        workArray = oArray;
        Sorty.selectionSort(workArray);
        Assert.assertArrayEquals(workArray , oSortedArray);
    }
    
}
