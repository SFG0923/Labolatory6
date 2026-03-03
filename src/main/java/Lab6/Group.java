package Lab6;

import java.util.Arrays;

public class Group {
    private int id;
    private int[] data;

    public Group(int id, int... data) {
        this.id = id;
        this.data = Arrays.copyOf(data, data.length);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int[] getData() { return Arrays.copyOf(data, data.length); }
    public void setData(int[] data) { this.data = Arrays.copyOf(data, data.length); }
    public int length() { return data.length; }
}