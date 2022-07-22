abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    double a;
    double b;
    double c;

    Triangle(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return 0;
    }

    @Override
    double getArea() {
        return 0;
    }
}

class Rectangle extends Shape {

    @Override
    double getPerimeter() {
        return 0;
    }

    @Override
    double getArea() {
        return 0;
    }
}

class Circle extends Shape {

    @Override
    double getPerimeter() {
        return 0;
    }

    @Override
    double getArea() {
        return 0;
    }
}