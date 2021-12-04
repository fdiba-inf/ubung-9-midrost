package exercise9;

public class Ellipse {
    Point startPoint;
    double a;
    double b;

    public Ellipse() {
        this.startPoint = new Point(0, 0);
        this.a = 1;
        this.b = 1;
    }

    public Ellipse(Point point, int a, int b) {
        this.startPoint = new Point(point);
        this.a = a;
        this.b = b;
    }

    public Ellipse(Ellipse anotherEllipse) {
        this.startPoint = anotherEllipse.startPoint;
        ;
        this.a = anotherEllipse.a;
        this.b = anotherEllipse.b;
    }

    public boolean isValid() {
        return this.a > 0 && this.b > 0;
    }

    public void initialize() {
        do {
            System.out.println("Start point: ");
            this.startPoint.initialize();
            System.out.print("Enter a: ");
            this.a = Utils.INPUT.nextDouble();
            System.out.print("Enter b: ");
            this.b = Utils.INPUT.nextDouble();
        } while (!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI * (3 * (this.a + this.b) - Math.sqrt((3 * this.a + this.b) * (this.a + 3 * this.b)));
    }

    public double calculateArea() {
        return Math.PI * this.a * this.b;
    }

    public String getType() {
        return (this.a == this.b) ? "Circle" : "Ellipse";
    }

    public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", this.startPoint.toString(), this.a, this.b, getType(), calculatePerimeter(), calculateArea());
    }

    public boolean equals(Ellipse otherEllipse) {
        return Utils.equals(this.a, otherEllipse.a) && Utils.equals(this.b, otherEllipse.b);
    }
}
