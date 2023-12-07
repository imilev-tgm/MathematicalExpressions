/**
 * 
 * @author Ivanm
 *
 */
public class Number implements Expression{
	
	private double value;
	
	public Number(double value) {
		this.value = value;
	}
	
	@Override
	public double evaluate() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return Double.toString(value);
	}
	
}
