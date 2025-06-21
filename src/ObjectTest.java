public class ObjectTest {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        change(person);
        System.out.println(person);

    }

    public static void change(Person p) {
        p = new Person();
        System.out.println(p);
    }
}
