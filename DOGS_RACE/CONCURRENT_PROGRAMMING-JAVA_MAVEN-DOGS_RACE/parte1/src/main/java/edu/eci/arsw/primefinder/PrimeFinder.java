package edu.eci.arsw.primefinder;

import java.util.Scanner;

public class PrimeFinder {
    private PrimeFinderThread pft1;
    private PrimeFinderThread pft2;
    private PrimeFinderThread pft3;
    private int cantidadPrimos;

    public PrimeFinder(){
        pft1=new PrimeFinderThread(0, 10000000);
        pft2=new PrimeFinderThread(10000001, 20000000);
        pft3=new PrimeFinderThread(20000001, 30000000);
        cantidadPrimos = 0;
    }

    public void comenzar(){
        long start = System.currentTimeMillis();
        pft1.start();
        pft2.start();
        pft3.start();
        long aux = System.currentTimeMillis() - start;
        while(aux < 5000){
            aux = System.currentTimeMillis() - start;
        }
        pft1.suspend();
        pft2.suspend();
        pft3.suspend();
        resultado();

        System.out.println("Para continuar presione ENTER");
        Scanner scanner = new Scanner(System.in);
        String in = "";
        do {
            in = scanner.nextLine();
            System.out.println(in);
        } while (!in.equals(""));
        terminar();
    }

    public void mostrar(){
        pft1.getPrimes().forEach((e) -> {
            System.out.println(e);
        });
        pft2.getPrimes().forEach((e) -> {
            System.out.println(e);
        });
        pft3.getPrimes().forEach((e) -> {
            System.out.println(e);
        });
    }
    public void resultado(){
        mostrar();
        cantidadPrimos += pft1.getPrimes().size() + pft2.getPrimes().size() + pft3.getPrimes().size();
        System.out.println("Numero Total De Primos calculados en 5s es: " + cantidadPrimos);
    }
    private void terminar() {
        pft1.resume();pft2.resume();pft3.resume();
        try {
            pft1.join();
        } catch (InterruptedException e) {
            System.err.println("ERROR EN LA CONTINUACION DEL THREAD 1");
            System.exit(1);
        }
        try {
            pft2.join();
        } catch (InterruptedException e) {
            System.err.println("ERROR EN LA CONTINUACION DEL THREAD 2");
            System.exit(1);
        }
        try {
            pft3.join();
        } catch (InterruptedException e) {
            System.err.println("ERROR EN LA CONTINUACION DEL THREAD 3");
            System.exit(1);
        }
        mostrar();
        System.exit(0);
    }

}
