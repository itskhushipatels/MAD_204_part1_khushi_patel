public abstract class Person {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void celebrateBirthday() {
        age++;
        System.out.println(name + " is now " + age + " years old. Happy Birthday!");
    }

    public abstract void introduce();

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d", id, name, age);
    }
}
