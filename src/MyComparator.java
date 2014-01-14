
public class MyComparator implements Comparable<MyComparator> {
    private String name;
    private int age;

    public MyComparator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyComparator)) return false;

        MyComparator myComparator = (MyComparator) o;

        if (age != myComparator.age) return false;
        if (name != null ? !name.equals(myComparator.name) : myComparator.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;

    }

    @Override
    public int compareTo(MyComparator o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
