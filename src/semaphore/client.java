package semaphore;

import java.util.concurrent.Semaphore;

public class client extends Thread {
    public static int nbrplace = 1;
    public static Semaphore semaphore = new Semaphore(1);
    public void reserver() {
        if (nbrplace > 0)
            nbrplace--;
        System.out.println(nbrplace);
    }
    public void run () {
        try {
            semaphore.acquire(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        reserver();
        semaphore.release();


    }
}
