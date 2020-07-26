package ui;

import java.util.ArrayList;

import ui.std.Drawable;

public class DrawBuffer {
    
    private final ArrayList<Drawable> list;

    public DrawBuffer() {
        list = new ArrayList<>();
    }

    public void add(Drawable item) {
        list.add(item);
    }

    public Drawable[] get() {
        final Drawable[] array = list.toArray(new Drawable[0]);
        list.clear();
        return array;
    }
}