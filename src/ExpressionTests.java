import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ExpressionsTest {

    @Test
    void testNumberExpression() {
        Expression numberExpression = new Number(5.5);
        assertEquals(5.5, numberExpression.evaluate(), 0.0001);
        assertEquals("5.5", numberExpression.toString());
    }

    @Test
    void testBinaryOperationExpression() {
        Expression operand1 = new Number(3);
        Expression operand2 = new Number(4);
        Expression binaryExpression = new BinaryExpression('+', operand1, operand2);

        assertEquals(7, binaryExpression.evaluate(), 0.0001);
        assertEquals("(3.0 + 4.0)", binaryExpression.toString());
    }

    @Test
    void testMinMaxExpression() {
        Expression operand1 = new Number(2);
        Expression operand2 = new Number(3.1415);
        Expression operand3 = new Number(5);

        // Test Minimum
        Expression minExpression = new MinMaxExpression("min", Arrays.asList(operand1, operand2, operand3));
        assertEquals(2, minExpression.evaluate(), 0.0001);
        assertEquals("min(2.0, 3.1415, 5.0)", minExpression.toString());

        // Test Maximum
        Expression maxExpression = new MinMaxExpression("max", Arrays.asList(operand1, operand2, operand3));
        assertEquals(5, maxExpression.evaluate(), 0.0001);
        assertEquals("max(2.0, 3.1415, 5.0)", maxExpression.toString());
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
        assertEquals("min((2.0 + 3.0), (4.0 - 5.0))", nestedExpression.toString());
    }
}
