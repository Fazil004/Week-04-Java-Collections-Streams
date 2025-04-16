
import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Job Role: " + roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String applicantName;
    private T jobRole;
    private String content;

    public Resume(String applicantName, T jobRole, String content) {
        this.applicantName = applicantName;
        this.jobRole = jobRole;
        this.content = content;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getContent() {
        return content;
    }

    public void process() {
        System.out.println("Processing resume for " + applicantName + " (" + jobRole.getRoleName() + ")");
        if (content.contains(jobRole.getRoleName().toLowerCase()) || content.contains("skills")) {
            System.out.println("Resume flagged as relevant.");
        } else {
            System.out.println("Resume may not be relevant.");
        }
    }

    @Override
    public String toString() {
        return "Resume of " + applicantName + " for " + jobRole.getRoleName();
    }
}

class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public void processAllResumes() {
        System.out.println("--- Resume Screening Pipeline ---");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Processing: " + resume);
            resume.process();
            System.out.println("-------------------------------");
        }
    }

    public <T extends JobRole> List<Resume<T>> filterByJobRole(Class<T> roleType) {
        List<Resume<T>> filteredResumes = new ArrayList<>();
        for (Resume<? extends JobRole> resume : resumes) {
            if (roleType.isInstance(resume.getJobRole())) {
                filteredResumes.add((Resume<T>) resume);
            }
        }
        return filteredResumes;
    }
}

public class AIScreeningSystem {
    public static void main(String[] args) {
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();

        screeningSystem.addResume(new Resume<>("Alice", new SoftwareEngineer(), "Experienced in Java and Spring. Seeking a software engineer role."));
        screeningSystem.addResume(new Resume<>("Bob", new DataScientist(), "Proficient in Python and machine learning skills. Applying for a data scientist position."));
        screeningSystem.addResume(new Resume<>("Charlie", new ProductManager(), "Strong background in product strategy and market analysis. Interested in a product manager role."));
        screeningSystem.addResume(new Resume<>("David", new SoftwareEngineer(), "Familiar with C++ and algorithms. Looking for software engineering opportunities."));

        screeningSystem.processAllResumes();

        System.out.println("\n--- Software Engineer Resumes ---");
        List<Resume<SoftwareEngineer>> softwareEngineerResumes = screeningSystem.filterByJobRole(SoftwareEngineer.class);
        for (Resume<SoftwareEngineer> resume : softwareEngineerResumes) {
            System.out.println(resume);
        }
    }
}

