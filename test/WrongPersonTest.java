import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class WrongPersonTest {
    @Test
    public void test_case_for_equals_with_same_objects() throws Exception {
        WrongPerson p1 = new WrongPerson("Kajal", 18);
        WrongPerson p2 = new WrongPerson("Kajal", 18);
        boolean actual = p1.equals(p2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void test_case_for_equals_with_different_objects() throws Exception {
        WrongPerson p1 = new WrongPerson("Kajal", 18);
        WrongPerson p2 = new WrongPerson("Laxit", 14);
        boolean actual = p1.equals(p2);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void test_case_for_hashcode_with_same_objects() throws Exception {
        WrongPerson p1 = new WrongPerson("Kajal",18);
        WrongPerson p2 = new WrongPerson("Kajal",18);
        int p1HashCode = p1.hashCode();
        int p2HashCode = p2.hashCode();
        assertNotSame(p2HashCode,p1HashCode);
    }

    @Test
    public void test_case_for_hashcode_with_diffeerent_objects() throws Exception {
        WrongPerson p1 = new WrongPerson("Kajal",18);
        WrongPerson p2 = new WrongPerson("Laxit",14);
        int p1HashCode = p1.hashCode();
        int p2HashCode = p2.hashCode();
        assertNotSame(p2HashCode,p1HashCode);
    }
}
