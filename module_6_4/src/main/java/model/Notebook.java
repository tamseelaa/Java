package model;
import java.util.*;

public class Notebook {
    private final List<Notes> notes=new ArrayList<>();

    public void addNote(Notes note) {notes.add(note);}

    public List<Notes> getNotes() { return notes; }
}
