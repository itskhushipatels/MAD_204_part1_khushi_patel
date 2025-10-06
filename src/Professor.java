public class Professor extends Person implements Evaluable {
    private String department;
    private String title;
    private int coursesTaught;

    public Professor(int id, String name, int age, String department, String title, int coursesTaught) {
        super(id, name, age);
        this.department = department;
        this.title = title;
        this.coursesTaught = coursesTaught;
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I'm Professor " + name + " from " + department + " department.");
    }

    @Override
    public void evaluatePerformance() {
        String performance = (coursesTaught >= 3) ? "Excellent" :
                (coursesTaught == 2) ? "Good" : "Needs Improvement";
        System.out.println(name + "'s performance: " + performance + " (Courses: " + coursesTaught + ")");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Department: %s | Title: %s | Courses: %d",
                department, title, coursesTaught);
    }
}
