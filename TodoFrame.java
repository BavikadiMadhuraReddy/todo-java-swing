import javax.swing.*;
import java.awt.*;

public class TodoFrame extends JFrame {

    private JPanel taskListPanel;
    private JTextField inputField;

    public TodoFrame() {

        setTitle("To-Do App");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TOP PANEL
        JPanel topPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        JButton addButton = new JButton("Add");

        topPanel.add(inputField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // TASK LIST PANEL
        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(taskListPanel);
        add(scrollPane, BorderLayout.CENTER);

        // ADD TASK
        addButton.addActionListener(e -> addTask());

        // ENTER KEY SUPPORT
        inputField.addActionListener(e -> addTask());

        setVisible(true);
    }

    private void addTask() {
        String text = inputField.getText().trim();

        if (!text.isEmpty()) {
            Task task = new Task(text);

            taskListPanel.add(new TaskPanel(task, taskListPanel));
            refresh(taskListPanel);

            inputField.setText("");
        }
    }

    private void refresh(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }
}
