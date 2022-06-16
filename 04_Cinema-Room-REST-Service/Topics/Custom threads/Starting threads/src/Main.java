public class Main {

    public static void main(String[] args) {
        final int THREADS = 3;
        for (int i = 1; i <= THREADS; i++) {
            new Thread(new RunnableWorker(), "worker-" + (i)).start();
        }
    }
}

// Don't change the code below       
class RunnableWorker implements Runnable {

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (name.startsWith("worker-")) {
            System.out.println("too hard calculations...");
        } else {
            return;
        }
    }
}