import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class ExpressionsTest {

    @Test
    void testNumberExpression() {
        Expression numberExpression = new Number(5.5);
        assertEquals(5.5, numberExpression.evaluate(), 0.0001);

        StringVisitor stringVisitor = new StringVisitor();
        numberExpression.accept(stringVisitor);
        assertEquals("5.5", stringVisitor.getResult());
    }

    @Test
    void testBinaryOperationExpression() {
        Expression operand1 = new Number(3);
        Expression operand2 = new Number(4);
        Expression binaryExpression = new BinaryExpression('+', operand1, operand2);

        assertEquals(7, binaryExpression.evaluate(), 0.0001);

        StringVisitor stringVisitor = new StringVisitor();
        binaryExpression.accept(stringVisitor);
        assertEquals("(3.0 + 4.0)", stringVisitor.getResult());
    }

    @Test
    void testMinMaxExpression() {
        Expression operand1 = new Number(2);
        Expression operand2 = new Number(3.1415);
        Expression operand3 = new Number(5);

        // Test Minimum
        Expression minExpression = new MinMaxExpression("min", Arrays.asList(operand1, operand2, operand3));
        assertEquals(2, minExpression.evaluate(), 0.0001);

        StringVisitor stringVisitorMin = new StringVisitor();
        minExpression.accept(stringVisitorMin);
        assertEquals("min(2.0, 3.1415, 5.0)", stringVisitorMin.getResult());  // Add this line

        // Test Maximum
        Expression maxExpression = new MinMaxExpression("max", Arrays.asList(operand1, operand2, operand3));
        assertEquals(5, maxExpression.evaluate(), 0.0001);

        StringVisitor stringVisitorMax = new StringVisitor();
        maxExpression.accept(stringVisitorMax);
        assertEquals("max(2.0, 3.1415, 5.0)", stringVisitorMax.getResult());
    }


    @Test
    void testNestedExpressions() {
        Expression operand1 = new Number(2);
        Expression operand2 = new Number(3);
        Expression operand3 = new Number(4);
        Expression operand4 = new Number(5);

        // Test nested expressions: min(2 + 3, 4 - 5)
        Expression nestedExpression = new MinMaxExpression("min",
                Arrays.asList(new BinaryExpression('+', operand1, operand2),
                        new BinaryExpression('-', operand3, operand4)));

        assertEquals(-1, nestedExpression.evaluate(), 0.0001);

        StringVisitor stringVisitorNested = new StringVisitor();
        nestedExpression.accept(stringVisitorNested);
        assertEquals("min((2.0 + 3.0), (4.0 - 5.0))", stringVisitorNested.getResult());
    }
    
    @Test
    void NegateExpressions( ) {
    	Expression numberExpression = new Number(5.5);
    	
    	Expression negate = new Negate(numberExpression);
    	
    	StringVisitor stringVisitor = new StringVisitor();
    	negate.accept(stringVisitor);
    	
    	assertEquals("-(5.5)", stringVisitor.getResult());
    }
    
}
