package model;
import java.util.*;

public class Notebook {
    private final List<Note> notes=new ArrayList<>();

    public void addNote(Note note) {notes.add(note);}

    public List<Note> getNotes() { return notes; }
}
