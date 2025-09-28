package model;

public class Notes {
    private String title;
    private String content;

    public Notes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        // show title in the ListView; keep content out to avoid clutter
        return (title == null || title.isEmpty()) ? "(no title)" : title;
    }
}