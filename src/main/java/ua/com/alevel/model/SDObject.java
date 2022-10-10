package ua.com.alevel.model;

public record SDObject(String name, Double mark) implements Comparable<SDObject> {
    @Override
    public int compareTo(SDObject o) {
        return this.mark.compareTo(o.mark());
    }
}
