package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message. Use any key you want (1 - 25) to shift
	 * each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Write Your Message here");
		String output = encrypt(input);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/Encrypted file");
			fw.write(output);
			fw.close();
		}
		catch(IOException e){
		e.printStackTrace();	
		}
		JOptionPane.showMessageDialog(null, "You encryped sentence is " + output);

	}

	static String encrypt(String e) {
		char replacedChar;
		char currentChar;
		int a = 0;
		for (int i = 0; i < e.length(); i++) {
			currentChar = e.charAt(i);
			a = (int) currentChar;
			replacedChar = (char) (a + 5);
			if (i==e.length()-1) {
				e = e.substring(0, i) + replacedChar;
			}
			else {
				e = e.substring(0, i) + replacedChar + e.substring(i + 1, e.length());
			}
		}
		return e;
	}

}
