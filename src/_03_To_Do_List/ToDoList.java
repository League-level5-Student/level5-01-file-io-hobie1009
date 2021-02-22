package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Tasks");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	ArrayList<String> list = new ArrayList<String>();
	int removecheck = 0;

	public static void main(String[] args) {
		new ToDoList().Start();
	}

	public void Start() {
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList"));
			
			String line = br.readLine();
			while(line != null){
				list.add(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Start of program list:"+list);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			String addhold = JOptionPane.showInputDialog("What task do you want to add to the list?");
			list.add(addhold);
			System.out.println("List after added:" + list);
		}
		if (e.getSource() == view) {
			JOptionPane.showMessageDialog(null, "" + list);
		}
		if (e.getSource() == remove) {
			removecheck = 0;
			String removeobject = JOptionPane.showInputDialog("What task do you want to remove?");
			System.out.println("List before removal" + list + "\n" + "Item needed to be removed:" + removeobject);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(removeobject)) {
					list.remove(i);
				} else {
					removecheck += 1;
				}
			}
			if (removecheck == 1) {
				JOptionPane.showMessageDialog(null, "The item you want to remove is not present within the list");
			}
			if (removecheck == 0) {
				JOptionPane.showMessageDialog(null, "The item has been removed, you list now is:"+list);
			}
		}
		if (e.getSource() == save) {
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/ToDoList");
			fw.write("\n" + list);
			fw.close();
			JOptionPane.showMessageDialog(null, "Your list has been successfully saved");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	if (e.getSource() == load) {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {	 
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
	}

	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
}
