class MessageNotifier extends Thread {

    String message;
    int reps;

    public MessageNotifier(String msg, int repeats) {
        this.message = msg;
        this.reps = repeats;
    }

    @Override
    public void run() {
        for (int i = 0; i < reps; i++) {
            System.out.println(message);
        }
    }
}