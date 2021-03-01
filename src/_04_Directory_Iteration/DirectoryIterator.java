package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
//		JFileChooser jfc = new JFileChooser();
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		int returnVal = jfc.showOpenDialog(null);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File Directory = jfc.getSelectedFile();
//			File[] Files = Directory.listFiles();
//			if (Files != null) {
//				for (File F : Files) {
//					System.out.println(F.getAbsolutePath());
//				}
//			}
//		}

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
		String hold = "";
		File directory = new File("src/_04_Directory_Iteration");
		File[] files = directory.listFiles();
		if (files != null) {
			for (File f : files) {
				System.out.println("The for loop is running");
				hold = f.getAbsolutePath();
				if (hold.contains(".java")) {
					try {
						FileWriter fw = new FileWriter("" + hold, true);
						fw.write("//Copyright © 2021 Hobie ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
//Copyright © 2021 Hobie //Copyright © 2021 Hobie 