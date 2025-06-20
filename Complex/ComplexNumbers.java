public class ComplexNumbers {
	private int real;
	private int imaginary;
	
	public ComplexNumbers(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public int getimaginary() {
		return imaginary;
	}
	
	public int getreal() {
		return real;
	}
	
	public void setimaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	
	public void setreal(int real) {
		this.real = real;
	}
	
	public void print() {
		System.out.println(this.real + "+i" + this.imaginary);
	}
    
	public void plus(ComplexNumbers c) {
		real = this.real + c.real;
		imaginary = this.imaginary + c.imaginary;
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public void Multiply(ComplexNumbers c) {
		int newreal = (this.real*c.real)-(this.imaginary*c.imaginary);
		int newimaginary = (this.real*c.imaginary) + (this.imaginary*c.real);
		this.real = newreal;
		this.imaginary = newimaginary;
		
	}
}
