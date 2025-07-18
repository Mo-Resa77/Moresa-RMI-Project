/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resa.project_ds;
/**
 *
 * @author Num 1
 */
// File: RemoteMoresa.java  #اهلا يا هندسه ازيك ده الانترفيس اللي فيه الميثودز اللي هستخدمها 
//طبعا لازم يبقي فيه بورت اللي هبيند عليه ززز ملحوظه هنا الفنكشن من كلاس اللي هاخد منه الكوبي لكل كلاينت لوحده local copy for each client 
// وطبعا اسم السيرفيس اللي الكلاينتت هيبند عليها 
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMoresa extends Remote {
    String SERVICE_NAME = "MoresaService";
    int PORT = 1099;
    Moresa calculate(int regNumber, int target) throws RemoteException;
}
