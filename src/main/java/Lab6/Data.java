package Lab6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Data implements Iterable<Integer> {
    private String name;
    private Group[] groups;

    public Data(String name, Group... groups) {
        this.name = name;
        this.groups = Arrays.copyOf(groups, groups.length);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Group[] getGroups() { return Arrays.copyOf(groups, groups.length); }
    public void setGroups(Group[] groups) { this.groups = Arrays.copyOf(groups, groups.length); }
    public int length() { return groups.length; }

    @Override
    public Iterator<Integer> iterator() {
        return new DataIterator();
    }

    private class DataIterator implements Iterator<Integer> {
        private int groupIndex = 0;
        private int dataIndex = 0;

        @Override
        public boolean hasNext() {
            return groupIndex < groups.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            int value = groups[groupIndex].getData()[dataIndex++];
            if (dataIndex >= groups[groupIndex].length()) {
                dataIndex = 0;
                groupIndex++;
            }
            return value;
        }
    }
}