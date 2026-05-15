import java.awt.*;
import javax.swing.*;

public class TaskPanel extends JPanel {

    private Task task;
    private JLabel label;

    public TaskPanel(Task task, JPanel parent) {

        this.task = task;

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JCheckBox checkBox = new JCheckBox();
        label = new JLabel(task.getText());

        JButton deleteBtn = new JButton("X");

        // CHECK / UNCHECK
        checkBox.addActionListener(e -> {
            task.toggle();

            if (task.isCompleted()) {
                label.setText("<html><s>" + task.getText() + "</s></html>");
            } else {
                label.setText(task.getText());
            }
        });

        // DELETE TASK
        deleteBtn.addActionListener(e -> {
            parent.remove(this);
            parent.revalidate();
            parent.repaint();
        });

        add(checkBox);
        add(label);
        add(deleteBtn);
    }
}
