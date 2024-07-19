/**
 * @author Omoniyi Tomjones
 * Project1
 * Date 27th August 2023
 * This class contains the main class for the program. It contains the program that generates the GUI.
 */

package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton prefixToPostfixButton;
    private JButton postfixToPrefixButton;

    public Main() {
        frame = new JFrame("Expression Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        frame.setVisible(true);
    }

    private void initComponents() {
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        inputTextArea = new JTextArea(5, 20);
        outputTextArea = new JTextArea(5, 20);
        outputTextArea.setEditable(false);

        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

        JPanel buttonPanel = new JPanel();
        prefixToPostfixButton = new JButton("Prefix to Postfix");
        postfixToPrefixButton = new JButton("Postfix to Prefix");

        buttonPanel.add(prefixToPostfixButton);
        buttonPanel.add(postfixToPrefixButton);

        container.add(inputScrollPane, BorderLayout.NORTH);
        container.add(outputScrollPane, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        prefixToPostfixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					convertPrefixToPostfix();
				} catch (SyntaxError e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        postfixToPrefixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					convertPostfixToPrefix();
				} catch (SyntaxError e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
    
    private void convertPrefixToPostfix() throws SyntaxError {
        String prefixExpression = inputTextArea.getText();
        String postfixExpression = ExpressionConverter.prefixToPostfix(prefixExpression);
		outputTextArea.setText(postfixExpression);
    }


    private void convertPostfixToPrefix() throws SyntaxError {
        String postfixExpression = inputTextArea.getText();
        String prefixExpression = ExpressionConverter.postfixToPrefix(postfixExpression);
		outputTextArea.setText(prefixExpression);
    }

    
    @SuppressWarnings("unused")
	private void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
    
	class Stack<T> {

	    private T[] elements;
	    private int top;

	    @SuppressWarnings("unchecked")
		public Stack() {
	        elements = (T[]) new Object[10];
	        top = -1;
	    }

	    public void push(T element) {
	        if (top == elements.length - 1) {
	            resize();
	        }

	        elements[++top] = element;
	    }

	    public T pop() {
	        if (top < 0) {
	            throw new RuntimeException("Stack is empty");
	        }

	        return elements[top--];
	    }

	    private void resize() {
	        @SuppressWarnings("unchecked")
			T[] newElements = (T[]) new Object[elements.length * 2];
	        for (int i = 0; i < elements.length; i++) {
	            newElements[i] = elements[i];
	        }

	        elements = newElements;
	    }

	    public boolean isEmpty() {
	        return top < 0;
	    }
	}


	}
