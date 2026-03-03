import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import Lab6.*;

public class CollectionsDemoTest {

    @Test
    void testTask1_countStringsStartingWith() {
        List<String> list = Arrays.asList("apple", "banana", "apricot", "cherry", "");
        assertEquals(2, CollectionsDemo.countStringsStartingWith(list, 'a'));
        assertEquals(1, CollectionsDemo.countStringsStartingWith(list, 'b'));
        assertEquals(0, CollectionsDemo.countStringsStartingWith(list, 'z'));
        assertEquals(0, CollectionsDemo.countStringsStartingWith(new ArrayList<>(), 'a'));
    }

    @Test
    void testTask2_getNamesakes() {
        Human h1 = new Human("Иванов", "Иван", "Иванович", 25);
        Human h2 = new Human("Петров", "Петр", "Петрович", 30);
        Human h3 = new Human("Иванов", "Сидор", "Сидорович", 35);
        Human h4 = new Human("Иванов", "Иван", "Иванович", 25);

        List<Human> list = Arrays.asList(h1, h2, h3, h4);
        List<Human> namesakes = CollectionsDemo.getNamesakes(list, h1);

        assertEquals(1, namesakes.size());
        assertEquals("Сидор", namesakes.get(0).getFirstName());
    }

    @Test
    void testTask3_copyWithoutHuman() {
        Human h1 = new Human("Иванов", "Иван", "Иванович", 25);
        Human h2 = new Human("Петров", "Петр", "Петрович", 30);
        List<Human> original = new ArrayList<>(Arrays.asList(h1, h2));
        List<Human> copy = CollectionsDemo.copyWithoutHuman(original, h1);

        assertEquals(1, copy.size());
        assertFalse(copy.contains(h1));

        original.get(0).setLastName("Сидоров");
        assertNotEquals("Сидоров", copy.get(0).getLastName());
    }

    @Test
    void testTask4_disjointSets() {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6));
        Set<Integer> s3 = new HashSet<>(Arrays.asList(7, 8, 9));
        Set<Integer> target = new HashSet<>(Arrays.asList(2, 4, 6));

        List<Set<Integer>> sets = Arrays.asList(s1, s2, s3);
        List<Set<Integer>> disjoint = CollectionsDemo.disjointSets(sets, target);

        assertEquals(1, disjoint.size());
        assertTrue(disjoint.get(0).containsAll(Arrays.asList(7, 8, 9)));
    }

    @Test
    void testTask5_maxAgePeople() {
        List<Human> list = new ArrayList<>();
        list.add(new Human("A", "A", "A", 20));
        list.add(new Student("B", "B", "B", 30, "IT"));
        list.add(new Human("C", "C", "C", 30));
        list.add(new Human("D", "D", "D", 25));

        Set<Human> maxAge = CollectionsDemo.maxAgePeople(list);

        assertEquals(2, maxAge.size());
        assertTrue(maxAge.stream().allMatch(h -> h.getAge() == 30));
        assertTrue(CollectionsDemo.maxAgePeople(new ArrayList<>()).isEmpty());
    }

    @Test
    void testTask6_sortedByFullName() {
        List<Human> list = new ArrayList<>();
        Human h1 = new Human("Smith", "John", "A", 20);
        Human h2 = new Human("Adams", "Bob", "C", 30);
        Human h3 = new Human("Brown", "Charlie", "B", 25);
        list.add(h1); list.add(h2); list.add(h3);

        List<Human> sorted = CollectionsDemo.sortedByFullName(list);

        assertEquals("Adams", sorted.get(0).getLastName());
        assertEquals("Brown", sorted.get(1).getLastName());
        assertEquals("Smith", sorted.get(2).getLastName());
    }

    @Test
    void testTask7_getByIds() {
        Map<Integer, Human> map = new HashMap<>();
        Human h1 = new Human("Ivanov", "Ivan", "I", 20);
        Human h2 = new Human("Petrov", "Petr", "P", 30);
        map.put(1, h1);
        map.put(2, h2);

        Set<Integer> ids = new HashSet<>(Arrays.asList(1, 3));
        Set<Human> result = CollectionsDemo.getByIds(map, ids);

        assertEquals(1, result.size());
        assertTrue(result.contains(h1));
    }

    @Test
    void testTask8_adultIds() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("A", "A", "A", 17));
        map.put(2, new Human("B", "B", "B", 18));
        map.put(3, new Human("C", "C", "C", 19));

        List<Integer> adultIds = CollectionsDemo.adultIds(map);

        assertEquals(2, adultIds.size());
        assertTrue(adultIds.containsAll(Arrays.asList(2, 3)));
    }

    @Test
    void testTask9_idToAge() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, new Human("A", "A", "A", 17));
        map.put(2, new Human("B", "B", "B", 18));

        Map<Integer, Integer> ageMap = CollectionsDemo.idToAge(map);

        assertEquals(17, ageMap.get(1));
        assertEquals(18, ageMap.get(2));
        assertEquals(2, ageMap.size());
    }

    @Test
    void testTask10_ageToHumans() {
        Set<Human> humans = new HashSet<>();
        humans.add(new Human("A", "A", "A", 20));
        humans.add(new Human("B", "B", "B", 20));
        humans.add(new Human("C", "C", "C", 25));

        Map<Integer, List<Human>> result = CollectionsDemo.ageToHumans(humans);

        assertEquals(2, result.get(20).size());
        assertEquals(1, result.get(25).size());
    }

    @Test
    void testTask11_ageToLetterToHumans() {
        Set<Human> humans = new HashSet<>();
        humans.add(new Human("Smith", "John", "A", 20));
        humans.add(new Human("Adams", "Bob", "C", 20));
        humans.add(new Human("Smith", "Anna", "B", 20));
        humans.add(new Human("Brown", "Charlie", "D", 25));

        Map<Integer, Map<Character, List<Human>>> result = CollectionsDemo.ageToLetterToHumans(humans);

        assertTrue(result.containsKey(20));
        assertTrue(result.get(20).containsKey('S'));
        assertEquals(2, result.get(20).get('S').size());
    }

    @Test
    void testTask12_phoneBook() {
        PhoneBook pb = new PhoneBook();
        Human h1 = new Human("Ivanov", "Ivan", "I", 25);
        Human h2 = new Human("Petrov", "Petr", "P", 30);

        pb.addPhone(h1, "123-45-67");
        pb.addPhone(h1, "111-22-33");
        pb.addPhone(h2, "987-65-43");

        assertEquals(2, pb.getPhones(h1).size());
        assertEquals(h1, pb.findByPhone("123-45-67"));
        assertNull(pb.findByPhone("000"));

        pb.removePhone(h1, "123-45-67");
        assertEquals(1, pb.getPhones(h1).size());

        Map<Human, List<String>> found = pb.findByLastNamePrefix("Iva");
        assertEquals(1, found.size());
        assertTrue(found.containsKey(h1));
    }

    @Test
    void testTask13_dataIterator() {
        Group g1 = new Group(100, 1, 2, 3);
        Group g2 = new Group(200, 4, 5);
        Data data = new Data("Test", g1, g2);

        List<Integer> all = CollectionsDemo.getAllNumbers(data);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), all);

        Iterator<Integer> it = data.iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertEquals(4, it.next());
        assertEquals(5, it.next());
        assertFalse(it.hasNext());
    }
}