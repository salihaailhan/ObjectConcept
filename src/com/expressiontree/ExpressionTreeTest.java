package com.expressiontree;

public class ExpressionTreeTest {

	// https://www.geeksforgeeks.org/evaluation-of-expression-tree/
	public static void main(String[] args) {
		testCase1Elegant();
		testCase2Elegant();
		testCase3Elegant();
		testCase4Elegant();
	}

	static void testCase1Elegant() {
		ExpressionNode node1 = new ValueExpressionNode(5.0);
		ExpressionNode node2 = new ValueExpressionNode(4.0);
		ExpressionNode node3 = new ValueExpressionNode(100.0);
		ExpressionNode node4 = new ValueExpressionNode(20.0);
		ExpressionNode node5 = new MultiplicationExpressionNode(node1, node2);
		ExpressionNode node6 = new SubtractionExpressionNode(node3, node4);
		ExpressionNode node7 = new AdditionExpressionNode(node5, node6);

		System.out.println("Result of the first expression tree is " + node7.evaluate());
	}

	static void testCase2Elegant() {
		ExpressionNode node1 = new ValueExpressionNode(5.0);
		ExpressionNode node2 = new ValueExpressionNode(4.0);
		ExpressionNode node3 = new ValueExpressionNode(100.0);
		ExpressionNode node4 = new ValueExpressionNode(20.0);
		ExpressionNode node5 = new ValueExpressionNode(2.0);
		ExpressionNode node6 = new MultiplicationExpressionNode(node1, node2);
		ExpressionNode node7 = new DivisionExpressionNode(node4, node5);
		ExpressionNode node8 = new SubtractionExpressionNode(node3, node7);
		ExpressionNode node9 = new AdditionExpressionNode(node6, node8);

		System.out.println("Result of the second expression tree is " + node9.evaluate());
	}

	static void testCase3Elegant() {
		ExpressionNode node1 = new ValueExpressionNode(5.0);
		ExpressionNode node2 = new ValueExpressionNode(4.0);
		ExpressionNode node3 = new ValueExpressionNode(100.0);
		ExpressionNode node4 = new ValueExpressionNode(20.0);
		ExpressionNode node5 = new MultiplicationExpressionNode(node1, node2);
		ExpressionNode node6 = new SubtractionExpressionNode(node3, node4);
		ExpressionNode node7 = new AdditionExpressionNode(node5, node6);
		ExpressionNode node8 = new SqrtExpressionNode(node7);

		System.out.println("Result of the second expression tree is " + node8.evaluate());
	}

	static void testCase4Elegant() {
		ExpressionNode node1 = new ValueExpressionNode(5.0);
		ExpressionNode node2 = new ValueExpressionNode(4.0);
		ExpressionNode node3 = new MinExpressionNode(new double[] { 30, 15, 60, 4, 14 });
		ExpressionNode node4 = new ValueExpressionNode(20.0);
		ExpressionNode node5 = new MultiplicationExpressionNode(node1, node2);
		ExpressionNode node6 = new SubtractionExpressionNode(node3, node4);
		ExpressionNode node7 = new AdditionExpressionNode(node5, node6);
		ExpressionNode node8 = new SqrtExpressionNode(node7);

		System.out.println("Result of the second expression tree is " + node8.evaluate());
	}
}
