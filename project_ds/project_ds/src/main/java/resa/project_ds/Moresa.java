/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resa.project_ds;
/**
 *
 * @author Num 1
 */
// File: Moresa.java
import java.io.Serializable;
import java.util.Arrays;

public class Moresa implements Serializable {
    private static final long serialVersionUID = 1L;
    public final int minimumCoins;
    public final int[] uniqueDigits;

    public Moresa(int minimumCoins, int[] uniqueDigits) {
        this.minimumCoins = minimumCoins;
        this.uniqueDigits = uniqueDigits;
    }

    @Override
    public String toString() {
        return "Minimum coins: " + minimumCoins + 
               "\nUnique digits: " + Arrays.toString(uniqueDigits);
    }
}
