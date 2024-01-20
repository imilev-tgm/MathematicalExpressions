import java.util.List;

public class StringVisitor implements ExpressionVisitor {
    private StringBuilder result = new StringBuilder();

    @Override
    public void visit(Number number) {
        result.append(number.getValue());
    }

    @Override
    public void visit(BinaryExpression binaryOperation) {
        result.append("(");
        binaryOperation.getLeft().accept(this);
        result.append(" ");
        result.append(binaryOperation.getOperator());
        result.append(" ");
        binaryOperation.getRight().accept(this);
        result.append(")");
    }
    
    @Override
    public void visit(MinMaxExpression minMaxExpression) {
        result.append(minMaxExpression.getOperation()).append("(");
        List<Expression> expressions = minMaxExpression.getExpressions();
        for (int i = 0; i < expressions.size(); i++) {
            expressions.get(i).accept(this);
            if (i < expressions.size() - 1) {
                result.append(", ");
            }
        }
        result.append(")");
    }

    @Override
    public void visit(Negate negate) {
        result.append("-");
        result.append("(");
        negate.getExp().accept(this);
        result.append(")");
    }

    public String getResult() {
        return result.toString();
    }
}
