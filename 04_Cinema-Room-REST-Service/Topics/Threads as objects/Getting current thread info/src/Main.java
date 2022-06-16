class Info {

    public static void printCurrentThreadInfo() {
        Thread thread = Thread.currentThread();

        thread.setName("my-thread");
        System.out.println("name: " + thread.getName());
        System.out.println("priority: " + thread.getPriority());
    }
}