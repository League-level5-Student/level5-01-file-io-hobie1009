package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileDecryptor {

	/*
	 * 
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		decrypt();
	}

	static void decrypt() {
		String e = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/Encrypted file"));

			String line = br.readLine();
			while (line != null) {
				e = e + line;
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		char replacedChar;
		char currentChar;
		int a = 0;
		for (int i = 0; i < e.length(); i++) {
			currentChar = e.charAt(i);
			a = (int) currentChar;
			replacedChar = (char) (a - 5);
			if (i==e.length()-1) {
				e = e.substring(0, i) + replacedChar;
			}
			else {
				e = e.substring(0, i) + replacedChar + e.substring(i + 1, e.length());
			}
		}
		JOptionPane.showMessageDialog(null, "" + e );
	}

}
