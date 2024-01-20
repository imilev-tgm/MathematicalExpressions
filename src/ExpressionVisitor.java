/**
 * EKV Visitor Pattern
 * @author Ivanm
 *
 */
public interface ExpressionVisitor {
	void visit(Number number);
    void visit(BinaryExpression binaryOperation);
    void visit(MinMaxExpression minMaxExpression);
   void visit(Negate negate);
}
