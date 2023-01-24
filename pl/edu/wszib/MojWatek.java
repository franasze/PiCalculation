package pl.edu.wszib;

public class MojWatek implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 2000000; i++) {

            double x2 = Math.pow(App.x.get(i), 2);
            double y2 = Math.pow(App.y.get(i), 2);
            double r2 = x2 + y2;
            double r = Math.sqrt(r2);

            synchronized (App.lock) {
                App.total++;
                if (r <= 1)
                    App.kolo++;
            }
        }
    }
}
