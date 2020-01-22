/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread {
    private long  liminf;
    private long limsup;

    public CountThread(long liminf,long limsup){
        this.liminf=liminf;
        this.limsup=limsup;
    }

    @Override
    public void run() {
        for (long i =liminf;i<limsup;i++){
            System.out.println(i);
        }
    }
}
