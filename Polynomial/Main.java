public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.setCoefficient(0, 4);
        p1.setCoefficient(1, 3);
        p1.setCoefficient(2, 2);

        Polynomial p2 = new Polynomial();
        p2.setCoefficient(0, 6);
        p2.setCoefficient(2, 1);
        p2.setCoefficient(3, 5);

        System.out.print("P1: ");
        p1.print();

        System.out.print("P2: ");
        p2.print();

        Polynomial sum = p1.add(p2);
        System.out.print("Sum: ");
        sum.print();

        Polynomial diff = p1.substract(p2);
        System.out.print("Difference: ");
        diff.print();

        Polynomial product = p1.multiply(p2);
        System.out.print("Product: ");
        product.print();
    }
}
