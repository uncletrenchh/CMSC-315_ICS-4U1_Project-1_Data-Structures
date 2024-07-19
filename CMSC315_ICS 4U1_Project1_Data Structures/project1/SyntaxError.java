/**
 * @author Omoniyi Tomjones
 * Project1
 * Date 25th August 2023
 * This class contains the last class for the program. It code contains that program that throws the exceptions when an error occurs.
 */

package project1;

@SuppressWarnings("serial")
public class SyntaxError extends Exception {
    public SyntaxError(String message) {
        super(message);
    }
}