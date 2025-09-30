package swing.TodoApp;

import javax.swing.*;
import java.awt.*;

public class TodoApps {
	public static void main(String[] args) {
		// Create JFrame
		JFrame frame = new JFrame("To-Do List App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLayout(new BorderLayout());

		// Task input field
		JTextField taskField = new JTextField();
		frame.add(taskField, BorderLayout.NORTH);

		// Task list model and JList
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList<String> taskList = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(taskList);
		frame.add(scrollPane, BorderLayout.CENTER);

		// Buttons panel
		JPanel buttonPanel = new JPanel();
		JButton addButton = new JButton("Add Task");
		JButton deleteButton = new JButton("Delete Task");
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		// Add task action
		addButton.addActionListener(e -> {
			String task = taskField.getText().trim();
			if (!task.isEmpty()) {
				listModel.addElement(task);
				taskField.setText("");
			}
		});

		// Delete task action
		deleteButton.addActionListener(e -> {
			int selectedIndex = taskList.getSelectedIndex();
			if (selectedIndex != -1) {
				listModel.remove(selectedIndex);
			}
		});

		// Show frame
		frame.setVisible(true);
	}
}
