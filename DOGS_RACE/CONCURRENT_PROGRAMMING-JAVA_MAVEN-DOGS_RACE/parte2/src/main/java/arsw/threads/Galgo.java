package arsw.threads;

import java.awt.peer.ListPeer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Un galgo que puede correr en un carril
 *
 * @author rlopez
 */
public class Galgo extends Thread {
    private int paso;
    private Carril carril;
    RegistroLlegada regl;
    private boolean isPaused;

    public Galgo(Carril carril, String name, RegistroLlegada reg) {
        super(name);
        this.carril = carril;
        paso = 0;
        this.regl = reg;
    }

    public void corra() throws InterruptedException {
        while (paso < carril.size()) {
            Thread.sleep(100);
            carril.setPasoOn(paso++);
            carril.displayPasos(paso);

            if (paso == carril.size()) {
                carril.finish();
                int ubicacion = regl.getUltimaPosicionAlcanzada().getAndIncrement();
                System.out.println("El galgo " + this.getName() + " llego en la posicion " + ubicacion);
                if (ubicacion == 1) {
                    regl.setGanador(this.getName());
                }
            }
            synchronized (this) {
                while (isPaused) {
                    wait();
                }
            }


        }
    }


    @Override
    public void run() {

        try {
            corra();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    synchronized void pause() {
        isPaused = true;
        notifyAll();
    }

    synchronized void reactivate() {
        isPaused = false;
        notifyAll();
    }

}
