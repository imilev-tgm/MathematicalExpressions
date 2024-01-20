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

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
	
	public Expression getExp() {
		return exp;
	}

}
