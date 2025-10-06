public class TeachingAssistant extends Student {
    private String assignedCourse;

    public TeachingAssistant(int id, String name, int age, String program, int year, double gpa, String assignedCourse) {
        super(id, name, age, program, year, gpa);
        this.assignedCourse = assignedCourse;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm TA " + name + " for course " + assignedCourse + ".");
    }

    @Override
    public void evaluatePerformance() {
        double score = gpa + 0.5; // TA bonus
        String performance = (score >= 3.7) ? "Excellent" :
                (score >= 3.0) ? "Good" : "Needs Improvement";
        System.out.println(name + "'s TA performance: " + performance + " (GPA: " + gpa + ")");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Assigned Course: %s", assignedCourse);
    }
}
