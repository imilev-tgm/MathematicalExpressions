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

	public double getValue() {
		return value;
	}
	
	@Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
	
}
