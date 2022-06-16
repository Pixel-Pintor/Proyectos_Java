class SomeClass {

    int val = 50;
    String str = "default";

    public SomeClass() {
        this(100); // asigna el valor de 100
    }

    public SomeClass(int val) {
        val = val;
    }

    public SomeClass(String str) {
        this(); // llama al primer constructor
        this.str = "some-value"; // asigna el valor "some-value"
    }

    // crea la instancia usando el cuarto constructor
    public SomeClass(int val, String str) {
        this(str); // este llama al tercer constructor
    }
}

class Main {
    public static void main(String[] args) {
        SomeClass instance = new SomeClass(300, "another-value");
        System.out.println(instance.str);
        System.out.println(instance.val);
    }
}