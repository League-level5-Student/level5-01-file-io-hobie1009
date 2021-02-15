package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public static void main(String[] args) {
		new ToDoList().Start();
	}

	public void Start() {
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(null);
		save.addActionListener(null);
		load.addActionListener(null);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			String addhold = JOptionPane.showInputDialog("What task do you want to add to the list?");
			list.add(addhold);
		}
		if (e.getSource() == load) {
			JOptionPane.showMessageDialog(null, "" + list);
		}
		if (e.getSource() == remove) {

		}
		if (e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("src/_00_ToDoList/ToDoList");
				fw.write("/n" + list);
			} catch (IOException e1) {
			e.printStackTrace();
			}
		}
		if(e.getSource() == load) {
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
