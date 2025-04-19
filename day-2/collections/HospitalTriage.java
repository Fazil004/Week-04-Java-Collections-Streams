import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

    public void addPatient(Patient patient) {
        triageQueue.offer(patient);
    }

    public Patient treatNextPatient() {
        return triageQueue.poll();
    }

    public boolean isEmpty() {
        return triageQueue.isEmpty();
    }

    public static void main(String[] args) {
        HospitalTriage triageSystem = new HospitalTriage();
        triageSystem.addPatient(new Patient("John", 3));
        triageSystem.addPatient(new Patient("Alice", 5));
        triageSystem.addPatient(new Patient("Bob", 2));
        triageSystem.addPatient(new Patient("Charlie", 4));

        System.out.println("Triage Order:");
        while (!triageSystem.isEmpty()) {
            System.out.println("Treating: " + triageSystem.treatNextPatient());
        }
    }
}