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

    @Override
    public String toString() {
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }
}