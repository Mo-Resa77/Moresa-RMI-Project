/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resa.project_ds;
/**
 *
 * @author Num 1
 */
// File: RemoteMoresa.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMoresa extends Remote {
    String SERVICE_NAME = "MoresaService";
    int PORT = 1099;
    Moresa calculate(int regNumber, int target) throws RemoteException;
}
