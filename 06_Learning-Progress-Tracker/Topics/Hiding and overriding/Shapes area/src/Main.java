class Shape {
    public double area() {
        return 0;
    }
}

class Triangle extends Shape {
    double height;
    double base;

    // override the method here
    public double area() {
        return (base * height) / 2;
    }
}

class Circle extends Shape {
    double radius;

    // override the method here
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Square extends Shape {
    double side;

    // override the method here
    public double area() {
        return Math.pow(side, 2);
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    // override the method here
    public double area() {
        return width * height;
    }
}

// ----------------------
class Notification {

    protected String msg;

    public Notification(String msg) {
        this.msg = msg;
    }

    public void show() {
        System.out.println(getMsg());
    }

    public String getMsg() {
        return msg;
    }
}

class Warning extends Notification {

    public Warning(String msg) {
        super(msg);
    }
    @Override
    public String getMsg() {
        return "WARN: " + msg;
    }
}

class Alarm extends Notification {

    public Alarm(String msg) {
        super(msg);
    }
    @Override
    public void show() {
        System.out.println("ALARM: " + msg);
    }
}

class Main {
    public static void main(String[] args) {

        // hay tres objetos
        Notification notif = new Notification("No problems");
        Notification warn = new Warning("Money ends");
        Notification alarm = new Alarm("The ship sank");

        warn.show(); // Money ends
        warn.getMsg(); // WARN: Money ends
        alarm.show(); // ALARM: The ship sank
        alarm.getMsg(); // The ship sank
        notif.show(); // No problems
    }
}