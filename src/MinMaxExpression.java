import java.util.List;

class MinMaxExpression implements Expression {
    private String operation; // 'm' for min, 'M' for max
    private List<Expression> expressions;

    
    public String getOperation() {
		return operation;
	}
    
    public List<Expression> getExpressions() {
		return expressions;
	}
    
    public MinMaxExpression(String operation, List<Expression> expressions) {
        this.operation = operation;
        this.expressions = expressions;
    }

    @Override
    public double evaluate() {
        if (expressions.isEmpty()) {
            throw new IllegalArgumentException("List of expressions cannot be empty");
        }

        double result = expressions.get(0).evaluate();
        for (int i = 1; i < expressions.size(); i++) {
            double current = expressions.get(i).evaluate();
            if (operation.equalsIgnoreCase("Min")) {
                result = Math.min(result, current);
            } else if (operation.equalsIgnoreCase("Max")) {
                result = Math.max(result, current);
            } else {
                throw new UnsupportedOperationException("Unsupported operation: " + operation);
            }
        }
        return result;
    }
    
    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}