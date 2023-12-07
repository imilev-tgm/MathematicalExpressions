/**
 * 
 * @author Ivanm
 *
 */
public class Negate implements Expression {
	
	private Expression exp;
	
	public Negate(Expression exp) {
		this.exp = exp;
	}
	
	@Override
	public double evaluate() {
		return exp.evaluate() * -1;
	}
	
	public String toString() {
        return "(" +Double.toString(exp.evaluate()) + ")";
    }
}
