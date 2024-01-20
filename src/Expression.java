/**
 * @author Ivan
 * @version 8.11.2023
 */
public interface Expression {
	double evaluate();
	void accept(ExpressionVisitor expressionVisitor);
}
