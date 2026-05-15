public class Task {
    private String text;
    private boolean completed;

    public Task(String text) {
        this.text = text;
        this.completed = false;
    }

    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void toggle() {
        completed = !completed;
    }
}
