/**
 * @author Omoniyi Tomjones
 * Project1
 * Date 27th August 2023
 * This class contains the expression converter class for the program. It contains the program that converts the expressions to either prefix or postfix.
 */

package project1;

import java.util.Stack;

	public class ExpressionConverter {

	    private static final String OPERATORS = "+-*/";

	    public static String prefixToPostfix(String prefixExpression) {
	        Stack<String> reversalStack = new Stack<>();
	        Stack<String> operandStack = new Stack<>();

	        for (char token : prefixExpression.toCharArray()) {
	            if (!Character.isWhitespace(token)) {
	                reversalStack.push(Character.toString(token));
	            }
	        }

	        while (!reversalStack.isEmpty()) {
	            String token = reversalStack.pop();
	            if (!OPERATORS.contains(token)) {
	                operandStack.push(token);
	            } else {
	                String operand2 = operandStack.pop();
	                String operand1 = operandStack.pop();
	                operandStack.push(token + operand1 + operand2);
	            }
	        }

	        return operandStack.pop();
	    }

	    public static String postfixToPrefix(String postfixExpression) {
	        Stack<String> operandStack = new Stack<>();

	        for (char token : postfixExpression.toCharArray()) {
	            if (!Character.isWhitespace(token)) {
	                operandStack.push(Character.toString(token));
	            }
	        }

	        String prefixExpression = "";
	        while (!operandStack.isEmpty()) {
	            String token = operandStack.pop();
	            prefixExpression += token + " ";
	        }

	        return prefixExpression.trim();
	    }
	}
