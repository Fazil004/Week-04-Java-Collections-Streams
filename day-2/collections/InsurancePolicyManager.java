import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
               "number='" + policyNumber + '\'' +
               ", holder='" + policyholderName + '\'' +
               ", expires=" + expiryDate +
               ", coverage='" + coverageType + '\'' +
               ", premium=" + premiumAmount +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
}

public class InsurancePolicyManager {
    private Set<InsurancePolicy> policySet = new HashSet<>();
    private Set<InsurancePolicy> orderedPolicySet = new LinkedHashSet<>();
    private Set<InsurancePolicy> sortedPolicySet = new TreeSet<>();

    public void addPolicyHashSet(InsurancePolicy policy) {
        policySet.add(policy);
    }

    public void addPolicyLinkedHashSet(InsurancePolicy policy) {
        orderedPolicySet.add(policy);
    }

    public void addPolicyTreeSet(InsurancePolicy policy) {
        sortedPolicySet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\n--- All Unique Policies (HashSet Order) ---");
        policySet.forEach(System.out::println);
    }

    public void displayAllPoliciesOrdered() {
        System.out.println("\n--- All Policies (Insertion Order - LinkedHashSet) ---");
        orderedPolicySet.forEach(System.out::println);
    }

    public void displayAllPoliciesSortedByExpiry() {
        System.out.println("\n--- All Policies (Sorted by Expiry Date - TreeSet) ---");
        sortedPolicySet.forEach(System.out::println);
    }

    public void displayPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now(java.time.ZoneId.of("Asia/Kolkata"));
        LocalDate expiryThreshold = today.plusDays(days);
        System.out.println("\n--- Policies Expiring within the Next " + days + " Days ---");
        sortedPolicySet.stream()
                       .filter(policy -> !policy.getExpiryDate().isBefore(today) && !policy.getExpiryDate().isAfter(expiryThreshold))
                       .forEach(System.out::println);
    }

    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\n--- Policies with Coverage Type: " + coverageType + " ---");
        policySet.stream()
                 .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                 .forEach(System.out::println);
    }

    public Set<InsurancePolicy> findDuplicatePolicies(List<InsurancePolicy> allPolicies) {
        Set<InsurancePolicy> uniquePolicies = new HashSet<>();
        Set<InsurancePolicy> duplicatePolicies = new HashSet<>();

        for (InsurancePolicy policy : allPolicies) {
            if (!uniquePolicies.add(policy)) {
                duplicatePolicies.add(policy);
            }
        }
        return duplicatePolicies;
    }

    public void comparePerformance(int numPolicies) {
        List<InsurancePolicy> policiesToAdd = generateRandomPolicies(numPolicies);

        long startTime = System.nanoTime();
        Set<InsurancePolicy> hashSetTest = new HashSet<>();
        policiesToAdd.forEach(hashSetTest::add);
        long endTime = System.nanoTime();
        long hashSetAddTime = endTime - startTime;

        startTime = System.nanoTime();
        policiesToAdd.forEach(hashSetTest::contains);
        endTime = System.nanoTime();
        long hashSetSearchTime = endTime - startTime;

        if (!hashSetTest.isEmpty()) {
            startTime = System.nanoTime();
            hashSetTest.remove(policiesToAdd.get(0));
            endTime = System.nanoTime();
            long hashSetRemoveTime = endTime - startTime;
            System.out.println("\n--- HashSet Performance (" + numPolicies + " Policies) ---");
            System.out.println("  Adding: " + hashSetAddTime + " ns");
            System.out.println("  Searching: " + hashSetSearchTime + " ns");
            System.out.println("  Removing: " + hashSetRemoveTime + " ns");
        } else {
            System.out.println("\n--- HashSet Performance (" + numPolicies + " Policies) ---");
            System.out.println("  Adding: " + hashSetAddTime + " ns");
            System.out.println("  Searching: " + hashSetSearchTime + " ns");
            System.out.println("  Removing: (Cannot test removal on empty set)");
        }


        startTime = System.nanoTime();
        Set<InsurancePolicy> linkedHashSetTest = new LinkedHashSet<>();
        policiesToAdd.forEach(linkedHashSetTest::add);
        endTime = System.nanoTime();
        long linkedHashSetAddTime = endTime - startTime;

        startTime = System.nanoTime();
        policiesToAdd.forEach(linkedHashSetTest::contains);
        endTime = System.nanoTime();
        long linkedHashSetSearchTime = endTime - startTime;

        if (!linkedHashSetTest.isEmpty()) {
            startTime = System.nanoTime();
            linkedHashSetTest.remove(policiesToAdd.get(0));
            endTime = System.nanoTime();
            long linkedHashSetRemoveTime = endTime - startTime;
            System.out.println("\n--- LinkedHashSet Performance (" + numPolicies + " Policies) ---");
            System.out.println("  Adding: " + linkedHashSetAddTime + " ns");
            System.out.println("  Searching: " + linkedHashSetSearchTime + " ns");
            System.out.println("  Removing: " + linkedHashSetRemoveTime + " ns");
        } else {
            System.out.println("\n--- LinkedHashSet Performance (" + numPolicies + " Policies) ---");
            System.out.println("  Adding: " + linkedHashSetAddTime + " ns");
            System.out.println("  Searching: " + linkedHashSetSearchTime + " ns");
            System.out.println("  Removing: (Cannot test removal on empty set)");
        }

        startTime = System.nanoTime();
        Set<InsurancePolicy> treeSetTest = new TreeSet<>();
        policiesToAdd.forEach(treeSetTest::add);
        endTime = System.nanoTime();
        long treeSetAddTime = endTime - startTime;

        startTime = System.nanoTime();
        policiesToAdd.forEach(treeSetTest::contains);
        endTime = System.nanoTime();
        long treeSetSearchTime = endTime - startTime;

        if (!treeSetTest.isEmpty()) {
            startTime = System.nanoTime();
            treeSetTest.remove(policiesToAdd.get(0));
            endTime = System.nanoTime();
            long treeSetRemoveTime = endTime - startTime;
            System.out.println("\n--- TreeSet Performance (" + numPolicies + " Policies) ---");
            System.out.println("  Adding: " + treeSetAddTime + " ns");
            System.out.println("  Searching: " + treeSetSearchTime + " ns");
            System.out.println("  Removing: " + treeSetRemoveTime + " ns");
        } else {
            System.out.println("\n--- TreeSet Performance (" + numPolicies + " Policies) ---");
            System.out.println("  Adding: " + treeSetAddTime + " ns");
            System.out.println("  Searching: " + treeSetSearchTime + " ns");
            System.out.println("  Removing: (Cannot test removal on empty set)");
        }
    }

    private List<InsurancePolicy> generateRandomPolicies(int numPolicies) {
        List<InsurancePolicy> policies = new ArrayList<>();
        Random random = new Random();
        String[] coverageTypes = {"Health", "Auto", "Home", "Life", "Travel"};

        for (int i = 0; i < numPolicies; i++) {
            String policyNumber = UUID.randomUUID().toString();
            String policyholderName = "Holder " + (i + 1);
            LocalDate expiryDate = LocalDate.now(java.time.ZoneId.of("Asia/Kolkata")).plusDays(random.nextInt(365 * 5));
            String coverageType = coverageTypes[random.nextInt(coverageTypes.length)];
            double premiumAmount = 1000 + random.nextDouble() * 5000;
            policies.add(new InsurancePolicy(policyNumber, policyholderName, expiryDate, coverageType, premiumAmount));
        }
        return policies;
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicyHashSet(new InsurancePolicy("POL001", "Alice Smith", LocalDate.of(2025, 6, 15), "Health", 1200.00));
        manager.addPolicyHashSet(new InsurancePolicy("POL002", "Bob Johnson", LocalDate.of(2025, 5, 20), "Auto", 850.50));
        manager.addPolicyHashSet(new InsurancePolicy("POL003", "Charlie Brown", LocalDate.of(2025, 7, 10), "Home", 1500.75));
        manager.addPolicyHashSet(new InsurancePolicy("POL001", "Alice Smith", LocalDate.of(2025, 6, 15), "Health", 1200.00)); // Duplicate

        manager.addPolicyLinkedHashSet(new InsurancePolicy("POL101", "David Lee", LocalDate.of(2025, 8, 1), "Life", 2000.00));
        manager.addPolicyLinkedHashSet(new InsurancePolicy("POL102", "Eve Williams", LocalDate.of(2025, 5, 25), "Travel", 350.25));
        manager.addPolicyLinkedHashSet(new InsurancePolicy("POL103", "Frank Miller", LocalDate.of(2025, 9, 12), "Health", 1350.50));
        manager.addPolicyLinkedHashSet(new InsurancePolicy("POL101", "David Lee", LocalDate.of(2025, 8, 1), "Life", 2000.00)); // Duplicate

        manager.addPolicyTreeSet(new InsurancePolicy("POL201", "Grace Taylor", LocalDate.of(2026, 1, 5), "Auto", 920.00));
        manager.addPolicyTreeSet(new InsurancePolicy("POL202", "Henry Wilson", LocalDate.of(2025, 5, 10), "Home", 1600.00));
        manager.addPolicyTreeSet(new InsurancePolicy("POL203", "Ivy Moore", LocalDate.of(2025, 12, 20), "Health", 1100.00));
        manager.addPolicyTreeSet(new InsurancePolicy("POL202", "Henry Wilson", LocalDate.of(2025, 5, 10), "Home", 1600.00)); // Duplicate

        manager.displayAllPolicies();
        manager.displayAllPoliciesOrdered();
        manager.displayAllPoliciesSortedByExpiry();
        manager.displayPoliciesExpiringSoon(30);
        manager.displayPoliciesByCoverageType("Health");

        List<InsurancePolicy> allPoliciesList = Arrays.asList(
                new InsurancePolicy("DUP001", "John Doe", LocalDate.of(2025, 6, 30), "Auto", 780.00),
                new InsurancePolicy("DUP002", "Jane Smith", LocalDate.of(2025, 7, 15), "Health", 1400.00),
                new InsurancePolicy("DUP001", "John Doe", LocalDate.of(2025, 6, 30), "Auto", 780.00) // Duplicate
        );
        Set<InsurancePolicy> duplicates = manager.findDuplicatePolicies(allPoliciesList);
        System.out.println("\n--- Duplicate Policies (Based on Policy Number) ---");
        duplicates.forEach(System.out::println);

        int numberOfPoliciesToTest = 10000;
        manager.comparePerformance(numberOfPoliciesToTest);
    }
}