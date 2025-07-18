/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resa.project_ds;
/**
 *
 * @author Num 1
 */
// File: MoresaServer.java
//هنا الكود باختصار في اللوجيك زز انا اللي كتبه بايدي بالمعني الحرفي مستحيل حد يعمل احسن منه ومتاكد  
//استغليتبشتغل مع 10 عشان بتجبلي اخر رقم  cbc المهم الخلاصه  بحط الارقام اللي مش بتتكرر في اراي وبقارن معاه 
//تاني واحده بستبعد الصفر وعاوز ديما اكبر ارقام وهكدا  وبرتبهم ببل سورت عادي وبعمل جريدي الجورثم عشان الاقي الاماكن عترتيب 
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MoresaServer extends UnicastRemoteObject implements RemoteMoresa {
    
    protected MoresaServer() throws RemoteException {
        super();
    }

    @Override
    public Moresa calculate(int regNumber, int target) throws RemoteException {
        int[] uniqueDigits = getUniqueDigits(regNumber);
        int minCoins = countCoins(uniqueDigits, target);
        return new Moresa(minCoins, uniqueDigits);
    }

    private int[] getUniqueDigits(int regNumber) {
        boolean[] exists = new boolean[10];
        int uniqueCount = 0;
        
        while (regNumber > 0) {
            int digit = regNumber % 10;
            if (!exists[digit]) {
                exists[digit] = true;
                uniqueCount++;
            }
            regNumber /= 10;
        }
        
        int[] result = new int[uniqueCount];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (exists[i]) {
                result[index++] = i;
            }
        }
        return result;
    }

    private int countCoins(int[] uniqueDigits, int target) {
        int validCoinsCount = 0;
        for (int d : uniqueDigits) if (d != 0) validCoinsCount++;
        
        int[] coins = new int[validCoinsCount];
        int index = 0;
        for (int d : uniqueDigits) if (d != 0) coins[index++] = d;
        
        for (int i = 0; i < coins.length; i++) {
            for (int j = i+1; j < coins.length; j++) {
                if (coins[i] < coins[j]) {
                    int temp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = temp;
                }
            }
        }
        
        int coinCount = 0;
        int remaining = target;
        for (int coin : coins) {
            while (remaining >= coin) {
                remaining -= coin;
                coinCount++;
                System.out.println("Used moresa coins: " + coin + " → Remained: " + remaining);
            }
        }
        if (remaining == 0) {
            return coinCount;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        MoresaServer server = new MoresaServer();
        java.rmi.registry.LocateRegistry.createRegistry(RemoteMoresa.PORT);
        java.rmi.Naming.rebind("//localhost:" + RemoteMoresa.PORT + "/" + RemoteMoresa.SERVICE_NAME, server);
        System.out.println("Moresa Server ready");
    }
}
