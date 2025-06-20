public class ComplexNumbersuse {

	public static void main(String[] args) {
	
		ComplexNumbers c1 = new ComplexNumbers(2, 3);
		c1.print();
		c1.setreal(4);
		c1.setimaginary(10);
		c1.print();
		
		ComplexNumbers c2 = new ComplexNumbers(2, 3);
		c1.plus(c2);
		c1.print();
		c2.print();
		
		ComplexNumbers c3 = new ComplexNumbers(2, 3);
		c3.Multiply(c2);
		c3.print();
		c2.print();
		
	}

}
