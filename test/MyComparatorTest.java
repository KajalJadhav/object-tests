import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MyComparatorTest {
    MyComparator swamiji = new MyComparator("Swamiji", 3);
    MyComparator kunal = new MyComparator("Kunal", 50);
    MyComparator digvijay = new MyComparator("Digvijay", 35);

    public List addPeopleToList(MyComparator... persons) {
        List<MyComparator> people = new ArrayList<MyComparator>();
        for (MyComparator person : persons) {
            people.add(person);
        }
        return people;
    }

    @Test
    public void test_for_sorting_names() throws Exception {
        List<MyComparator> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people);
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 3; i++)
            data.append(people.get(i)).append("\n");
        String actual = data.toString();
        String expected = "Digvijay\nKunal\nSwamiji\n";
        assertEquals(expected, actual);
    }

    @Test
    public void test_for_compare_names_as_per_their_name_length() throws Exception {
        List<MyComparator> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people);
        Collections.sort(people, new Comparator<MyComparator>() {
            @Override
            public int compare(MyComparator p1, MyComparator p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 3; i++)
            data.append(people.get(i)).append("\n");
        String actual = data.toString();
        String expected = "Kunal\nSwamiji\nDigvijay\n";
        assertEquals(expected, actual);
    }

    @Test
    public void test_for_compare_person_by_age() throws Exception {
        List<MyComparator> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people);
        Collections.sort(people, new Comparator<MyComparator>() {
            @Override
            public int compare(MyComparator p1, MyComparator p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 3; i++)
            data.append(people.get(i)).append("\n");
        String actual = data.toString();
        String expected = "Swamiji\nDigvijay\nKunal\n";
        assertEquals(expected, actual);
    }

    @Test
    public void test_for_compare_person_as_per_their_names_descending_order() throws Exception {
        List<MyComparator> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people);
        Collections.sort(people, Collections.reverseOrder(new Comparator<MyComparator>() {
            @Override
            public int compare(MyComparator o1, MyComparator o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }));
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 3; i++)
            data.append(people.get(i)).append("\n");
        String actual = data.toString();
        String expected = "Swamiji\nKunal\nDigvijay\n";
        assertEquals(expected, actual);
    }

    @Test
    public void test_for_compare_person_as_per_their_age_descending_order() throws Exception {
        List<MyComparator> people = addPeopleToList(digvijay, kunal, swamiji);
        Collections.sort(people);
        Collections.sort(people, Collections.reverseOrder(new Comparator<MyComparator>() {
            @Override
            public int compare(MyComparator o1, MyComparator o2) {
                return o1.getAge() - (o2.getAge());
            }
        }));
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 3; i++)
            data.append(people.get(i)).append("\n");
        String actual = data.toString();
        String expected = "Kunal\nDigvijay\nSwamiji\n";
        assertEquals(expected, actual);
    }

    @Test(expected = ClassCastException.class)
    public void test_for_exception() throws Exception{
        Person p = new Person("Kajal",18);
    }

}
