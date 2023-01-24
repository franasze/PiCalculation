package pl.edu.wszib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static double kolo=0;
    public static double total=0;
    public static List<Double> x = new ArrayList<>();
    public static List<Double> y = new ArrayList<>();
    public static final Object lock = new Object();

    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 0; i < 6000000; i++)
            x.add(random.nextDouble());

        for (int i = 0; i < 6000000; i++)
            y.add(random.nextDouble());

        Thread thread1 = new Thread(new MojWatek());
        Thread thread2 = new Thread(new MojWatek());
        Thread thread3 = new Thread(new MojWatek());
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        }catch(InterruptedException e){}


        System.out.println("Ilosc punktow w kole: "+kolo);
        System.out.println("Ilosc punktow: "+total);

        double Pi; //szukana
        int a = 2;
        double poleKwadratu = a*a;// P=a*a
        int R = 1;
        double R2 = Math.pow(R,2);
        //poleKola - P=Pi*R^2
        // wzor - total/kolo == poleKwadratu/poleKola;
        Pi = kolo*(poleKwadratu)/(R2*total);
        System.out.println(Pi);
    }
}