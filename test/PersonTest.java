import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class PersonTest {
    // Test Cases for equals String literals
    @Test
    public void test_case_for_same_string_literels() throws Exception {
        String input = "Kajal";
        String object = new String("Kajal");
        boolean actual = input.equals(object);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void test_case_for_diffrent_string_literels() throws Exception {
        String input = "Kajal";
        String object = new String("Laxit");
        boolean actual = input.equals(object);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    //--------------  Test cases for the Equals of person  --------------------

    @Test
    public void test_case_for_different_objects_of_person() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        boolean actual = p1.equals(p2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void test_case_for_same_objects_of_person() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Kajal", 18);
        boolean actual = p1.equals(p2);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    // -------------- Test case for the hash code -----------------------

    @Test
    public void test_case_for_hash_code_of_same_object_values() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Kajal", 18);
        int p1HashCode = p1.hashCode();
        int p2HashCode = p2.hashCode();
        assertEquals(p1HashCode, p2HashCode);
    }

    @Test
    public void test_case_for_hash_code_different_object_values() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        int p1HashCode = p1.hashCode();
        int p2HashCode = p2.hashCode();
        assertNotSame(p1HashCode, p2HashCode);
    }

    // ----------------  Test cases for hash map ----------------------------------

    @Test
    public void test_case_for_hash_map_having_same_object_in_a_one_list() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Kajal", 18);
        List<Person> listOfPeople = new ArrayList<Person>();
        listOfPeople.add(p1);
        listOfPeople.add(p2);
        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("A", listOfPeople);
        List list = map.get("A");

        boolean actual = list.get(0).equals(list.get(1));
        boolean expected = true;
        assertEquals(expected, actual);

        int p1HashCode = list.get(0).hashCode();
        int p2HashCode = list.get(1).hashCode();
        assertEquals(p1HashCode, p2HashCode);
    }

    @Test
    public void test_case_for_hash_map_having_same_objects_in_different_list() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        List<Person> listOneOfPeople = new ArrayList<Person>();
        listOneOfPeople.add(p1);
        listOneOfPeople.add(p2);
        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("A", listOneOfPeople);

        Person p3 = new Person("Kajal", 18);
        Person p4 = new Person("Laxit", 14);
        List<Person> listTwoOfPeople = new ArrayList<Person>();
        listTwoOfPeople.add(p3);
        listTwoOfPeople.add(p4);
        map.put("B", listTwoOfPeople);

        List list1 = map.get("A");
        List list2 = map.get("B");

        boolean actual = list1.get(0).equals(list2.get(0));
        boolean expected = true;
        assertEquals(expected, actual);

        int p1HashCode = list1.get(0).hashCode();
        int p3HashCode = list2.get(0).hashCode();
        assertEquals(p1HashCode, p3HashCode);
    }

    @Test
    public void test_case_for_hash_map_having_different_objects_in_a_same_list() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        List<Person> listOfPeople = new ArrayList<Person>();
        listOfPeople.add(p1);
        listOfPeople.add(p2);
        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("A", listOfPeople);
        List list = map.get("A");

        boolean actual = list.get(0).equals(list.get(1));
        boolean expected = false;
        assertEquals(expected, actual);

        int p1HashCode = list.get(0).hashCode();
        int p2HashCode = list.get(1).hashCode();
        assertNotSame(p1HashCode, p2HashCode);
    }

    @Test
    public void test_case_for_hash_map_having_different_objects_in_different_list() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        List<Person> listOneOfPeople = new ArrayList<Person>();
        listOneOfPeople.add(p1);
        listOneOfPeople.add(p2);
        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("A", listOneOfPeople);

        Person p3 = new Person("Vaidehi", 10);
        Person p4 = new Person("Kajal", 18);
        List<Person> listTwoOfPeople = new ArrayList<Person>();
        listTwoOfPeople.add(p3);
        listTwoOfPeople.add(p4);
        map.put("B", listTwoOfPeople);

        List list1 = map.get("A");
        List list2 = map.get("B");

        boolean actual = list1.get(0).equals(list2.get(0));
        boolean expected = false;
        assertEquals(expected, actual);

        int p1HashCode = list1.get(0).hashCode();
        int p2HashCode = list2.get(0).hashCode();
        assertNotSame(p1HashCode, p2HashCode);
    }

// --------- Tests For ArrayList-----------

    @Test
    public void test_arraylists_are_equals() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        List<Person> list1 = new ArrayList<Person>();
        List<Person> list2 = new ArrayList<Person>();

        list1.add(p1);
        list1.add(p2);

        list2.add(p1);
        list2.add(p2);
        boolean[] actual = new boolean[2];
        for (int i = 0; i < 2; i++)
            actual[i] = list1.get(i).equals(list2.get(i));

        boolean[] expected = {true, true};

        for (int i = 0; i < 2; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_arraylists_are_not_equals() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        List<Person> list1 = new ArrayList<Person>();
        List<Person> list2 = new ArrayList<Person>();

        list1.add(p1);
        list1.add(p2);

        list2.add(p2);
        list2.add(p1);
        boolean[] actual = new boolean[2];
        for (int i = 0; i < 2; i++)
            actual[i] = list1.get(i).equals(list2.get(i));

        boolean[] expected = {false, false};

        for (int i = 0; i < 2; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test(expected = java.lang.ClassCastException.class)
    public void testGivesExceptionWhenIllegalCast() throws ClassCastException {
        ArrayList list = new ArrayList<String>();
        list.add(new Object());
        list.add(new Object());
        String a = (String) list.get(0);
    }

    @Test
    public void test_case_for_hash_set_with_same_values() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Kajal", 18);
        Set<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        assertEquals(1, set.size());
    }

    @Test
    public void test_case_for_hash_set_not_having_values() throws Exception {
        Person p1 = new Person("Kajal", 18);
        Person p2 = new Person("Laxit", 14);
        Person p3 = new Person("Vaidehi", 10);
        Set<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        assertEquals(3, set.size());
    }


}
