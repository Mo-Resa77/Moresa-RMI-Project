/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resa.project_ds;
/**
 *
 * @author Num 1
 */
// File: MoresaClient.java
import java.rmi.Naming;
import java.util.Scanner;

public class MoresaClient {
    public static void main(String[] args) {
        try {
            RemoteMoresa service = (RemoteMoresa) Naming.lookup(
                "//localhost:" + RemoteMoresa.PORT + "/" + RemoteMoresa.SERVICE_NAME);
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter registration number: ");
            int regNumber = scanner.nextInt();
            System.out.print("Enter target amount: ");
            int target = scanner.nextInt();
            
            Moresa result = service.calculate(regNumber, target);
            System.out.println(result);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
