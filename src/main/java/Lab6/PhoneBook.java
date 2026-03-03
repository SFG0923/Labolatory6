package Lab6;

import java.util.*;

public class PhoneBook {
    private Map<Human, List<String>> phoneBook = new HashMap<>();

    public void addPhone(Human human, String phone) {
        if (!phoneBook.containsKey(human)) {
            phoneBook.put(human, new ArrayList<>());
        }
        phoneBook.get(human).add(phone);
    }

    public void removePhone(Human human, String phone) {
        if (phoneBook.containsKey(human)) {
            phoneBook.get(human).remove(phone);
            if (phoneBook.get(human).isEmpty()) {
                phoneBook.remove(human);
            }
        }
    }

    public List<String> getPhones(Human human) {
        return phoneBook.containsKey(human) ?
                new ArrayList<>(phoneBook.get(human)) :
                Collections.emptyList();
    }

    public Human findByPhone(String phone) {
        for (Map.Entry<Human, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Map<Human, List<String>> findByLastNamePrefix(String prefix) {
        Map<Human, List<String>> result = new HashMap<>();
        for (Map.Entry<Human, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getKey().getLastName().startsWith(prefix)) {
                result.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
        }
        return result;
    }

    public Map<Human, List<String>> getAll() {
        Map<Human, List<String>> copy = new HashMap<>();
        for (Map.Entry<Human, List<String>> entry : phoneBook.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }
}