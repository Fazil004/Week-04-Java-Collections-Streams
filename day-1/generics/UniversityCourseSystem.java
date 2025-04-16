
import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    @Override
    public String toString() {
        return "Evaluation: " + evaluationMethod;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }

    @Override
    public String toString() {
        return "Exam Course (" + super.toString() + ")";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }

    @Override
    public String toString() {
        return "Assignment Course (" + super.toString() + ")";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }

    @Override
    public String toString() {
        return "Research Course (" + super.toString() + ")";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private String courseCode;
    private T courseType;

    public Course(String courseName, String courseCode, T courseType) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " (" + courseCode + "), Type: " + courseType;
    }
}

class Department {
    private String departmentName;
    private List<Course<? extends CourseType>> coursesOffered = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addCourse(Course<? extends CourseType> course) {
        coursesOffered.add(course);
    }

    public void displayAllCourses() {
        System.out.println("--- Courses in " + departmentName + " Department ---");
        for (Course<? extends CourseType> course : coursesOffered) {
            System.out.println(course);
        }
        System.out.println("--------------------------------------------------");
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        Department computerScience = new Department("Computer Science");
        computerScience.addCourse(new Course<>("Introduction to Programming", "CS101", new ExamCourse()));
        computerScience.addCourse(new Course<>("Data Structures and Algorithms", "CS201", new ExamCourse()));
        computerScience.addCourse(new Course<>("Software Engineering", "CS305", new AssignmentCourse()));

        Department literature = new Department("English Literature");
        literature.addCourse(new Course<>("Classical Literature", "EN101", new ResearchCourse()));
        literature.addCourse(new Course<>("Modern Poetry", "EN203", new AssignmentCourse()));

        computerScience.displayAllCourses();
        literature.displayAllCourses();
    }
}

