class BinaryExpression implements Expression {
    private char operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(char operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        switch (operator) {
            case '+':
                return left.evaluate() + right.evaluate();
            case '-':
                return left.evaluate() - right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            case '/':
                return left.evaluate() / right.evaluate();
            case '^':
                return Math.pow(left.evaluate(), right.evaluate());
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }
    
    public Expression getLeft() {
		return left;
	}
    public char getOperator() {
		return operator;
	}
    public Expression getRight() {
		return right;
	}
    
    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
    
}