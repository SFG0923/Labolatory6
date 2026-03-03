package Lab6;

import java.util.*;

public class CollectionsDemo {

    // ========== ЗАДАНИЕ 1 ==========
    public static int countStringsStartingWith(List<String> strings, char firstChar) {
        int count = 0;
        for (String s : strings) {
            if (s != null && !s.isEmpty() && s.charAt(0) == firstChar) {
                count++;
            }
        }
        return count;
    }

    // ========== ЗАДАНИЕ 2 ==========
    public static List<Human> getNamesakes(List<Human> humans, Human target) {
        List<Human> result = new ArrayList<>();
        for (Human h : humans) {
            if (h != target && h.getLastName().equals(target.getLastName())) {
                result.add(h);
            }
        }
        return result;
    }

    // ========== ЗАДАНИЕ 3 ==========
    public static List<Human> copyWithoutHuman(List<Human> humans, Human toExclude) {
        List<Human> copy = new ArrayList<>();
        for (Human h : humans) {
            if (!h.equals(toExclude)) {
                copy.add(new Human(h.getLastName(), h.getFirstName(), h.getPatronymic(), h.getAge()));
            }
        }
        return copy;
    }

    // ========== ЗАДАНИЕ 4 ==========
    public static List<Set<Integer>> disjointSets(List<Set<Integer>> sets, Set<Integer> target) {
        List<Set<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : sets) {
            if (Collections.disjoint(set, target)) {
                result.add(new HashSet<>(set));
            }
        }
        return result;
    }

    // ========== ЗАДАНИЕ 5 ==========
    public static Set<Human> maxAgePeople(List<? extends Human> people) {
        if (people.isEmpty()) return Collections.emptySet();
        int maxAge = people.stream().mapToInt(Human::getAge).max().getAsInt();
        Set<Human> result = new HashSet<>();
        for (Human h : people) {
            if (h.getAge() == maxAge) {
                result.add(h);
            }
        }
        return result;
    }

    // ========== ЗАДАНИЕ 6 ==========
    public static List<Human> sortedByFullName(List<? extends Human> people) {
        TreeSet<Human> sortedSet = new TreeSet<>(
                Comparator.comparing(Human::getLastName)
                        .thenComparing(Human::getFirstName)
                        .thenComparing(Human::getPatronymic)
        );
        sortedSet.addAll(people);
        return new ArrayList<>(sortedSet);
    }

    // ========== ЗАДАНИЕ 7 ==========
    public static Set<Human> getByIds(Map<Integer, Human> map, Set<Integer> ids) {
        Set<Human> result = new HashSet<>();
        for (Integer id : ids) {
            if (map.containsKey(id)) {
                result.add(map.get(id));
            }
        }
        return result;
    }

    // ========== ЗАДАНИЕ 8 ==========
    public static List<Integer> adultIds(Map<Integer, Human> map) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Human> entry : map.entrySet()) {
            if (entry.getValue().getAge() >= 18) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    // ========== ЗАДАНИЕ 9 ==========
    public static Map<Integer, Integer> idToAge(Map<Integer, Human> map) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Human> entry : map.entrySet()) {
            result.put(entry.getKey(), entry.getValue().getAge());
        }
        return result;
    }

    // ========== ЗАДАНИЕ 10 ==========
    public static Map<Integer, List<Human>> ageToHumans(Set<Human> humans) {
        Map<Integer, List<Human>> result = new HashMap<>();
        for (Human h : humans) {
            if (!result.containsKey(h.getAge())) {
                result.put(h.getAge(), new ArrayList<>());
            }
            result.get(h.getAge()).add(h);
        }
        return result;
    }

    // ========== ЗАДАНИЕ 11 ==========
    public static Map<Integer, Map<Character, List<Human>>> ageToLetterToHumans(Set<Human> humans) {
        Map<Integer, Map<Character, List<Human>>> result = new HashMap<>();

        for (Human h : humans) {
            int age = h.getAge();
            char firstLetter = h.getLastName().charAt(0);

            if (!result.containsKey(age)) {
                result.put(age, new HashMap<>());
            }

            Map<Character, List<Human>> letterMap = result.get(age);
            if (!letterMap.containsKey(firstLetter)) {
                letterMap.put(firstLetter, new ArrayList<>());
            }
            letterMap.get(firstLetter).add(h);
        }

        // Сортировка по убыванию ФИО
        Comparator<Human> byFullNameDesc = (h1, h2) -> {
            String fullName1 = h1.getLastName() + h1.getFirstName() + h1.getPatronymic();
            String fullName2 = h2.getLastName() + h2.getFirstName() + h2.getPatronymic();
            return fullName2.compareTo(fullName1);
        };

        for (Map<Character, List<Human>> letterMap : result.values()) {
            for (List<Human> list : letterMap.values()) {
                list.sort(byFullNameDesc);
            }
        }
        return result;
    }

    // ========== ЗАДАНИЕ 13 (часть 3-4) ==========
    public static List<Integer> getAllNumbers(Data data) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : data) {
            result.add(num);
        }
        return result;
    }
}