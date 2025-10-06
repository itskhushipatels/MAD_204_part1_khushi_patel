public class Student extends Person implements Evaluable {
    protected String program;
    protected int year;
    protected double gpa;

    public Student(int id, String name, int age, String program, int year, double gpa) {
        super(id, name, age);
        this.program = program;
        this.year = year;
        this.gpa = gpa;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm student " + name + " studying " + program + " in year " + year + ".");
    }

    @Override
    public void evaluatePerformance() {
        String grade;
        if (gpa >= 3.7) grade = "Excellent";
        else if (gpa >= 3.0) grade = "Good";
        else if (gpa >= 2.0) grade = "Average";
        else grade = "Poor";
        System.out.println(name + "'s performance: " + grade + " (GPA: " + gpa + ")");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Program: %s | Year: %d | GPA: %.2f", program, year, gpa);
    }
}
