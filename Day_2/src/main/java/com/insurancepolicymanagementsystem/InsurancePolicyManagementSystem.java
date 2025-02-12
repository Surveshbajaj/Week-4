package com.insurancepolicymanagementsystem;

import java.time.LocalDate;
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

    public String getCoverageType() {
        return coverageType;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=₹" + premiumAmount + '}';
    }
}

class InsurancePolicyManager {
    private Set<InsurancePolicy> policySet = new HashSet<>();
    private Set<InsurancePolicy> orderedPolicySet = new LinkedHashSet<>(); // Maintain insertion order
    private Set<InsurancePolicy> sortedByExpiry = new TreeSet<>(); // Sort policies by expiry date

    // Add a new policy
    public void addPolicy(InsurancePolicy policy) {
        policySet.add(policy);
        orderedPolicySet.add(policy);
        sortedByExpiry.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("\n All Unique Policies:");
        for (InsurancePolicy policy : policySet) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring in the next 30 days
    public void displayExpiringPolicies() {
        System.out.println("\n Policies Expiring Soon (Next 30 Days):");
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        for (InsurancePolicy policy : sortedByExpiry) {
            if (!policy.getExpiryDate().isBefore(today) && policy.getExpiryDate().isBefore(threshold)) {
                System.out.println(policy);
            }
        }
    }

    // Retrieve policies with a specific coverage type
    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\n Policies with Coverage Type: " + coverageType);
        for (InsurancePolicy policy : policySet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Find duplicate policies based on policy number
    public void displayDuplicatePolicies() {
        System.out.println("\n Duplicate Policies:");
        Set<String> uniquePolicyNumbers = new HashSet<>();
        for (InsurancePolicy policy : policySet) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Performance comparison
    public void comparePerformance() {
        int size = 100000;
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();

        List<InsurancePolicy> testPolicies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            testPolicies.add(new InsurancePolicy("P" + i, "Holder " + i, LocalDate.now().plusDays(i), "Auto", 5000 + i));
        }

        // Measure HashSet Performance
        long startTime = System.nanoTime();
        hashSet.addAll(testPolicies);
        long endTime = System.nanoTime();
        System.out.println("\n HashSet Add Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure LinkedHashSet Performance
        startTime = System.nanoTime();
        linkedHashSet.addAll(testPolicies);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure TreeSet Performance
        startTime = System.nanoTime();
        treeSet.addAll(testPolicies);
        endTime = System.nanoTime();
        System.out.println(" TreeSet Add Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}

public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding some policies
        manager.addPolicy(new InsurancePolicy("P001", "Deep", LocalDate.now().plusDays(20), "Health", 10000));
        manager.addPolicy(new InsurancePolicy("P002", "Sunil", LocalDate.now().plusDays(40), "Auto", 15000));
        manager.addPolicy(new InsurancePolicy("P003", "Rakesh", LocalDate.now().minusDays(5), "Home", 20000));
        manager.addPolicy(new InsurancePolicy("P004", "Salam", LocalDate.now().plusDays(10), "Auto", 12000));
        manager.addPolicy(new InsurancePolicy("P005", "sidd", LocalDate.now().plusDays(25), "Health", 11000));

        // Display all unique policies
        manager.displayAllPolicies();

        // Display policies expiring soon
        manager.displayExpiringPolicies();

        // Display policies by coverage type
        manager.displayPoliciesByCoverage("Auto");

        // Display duplicate policies
        manager.displayDuplicatePolicies();

        // Compare performance of HashSet, LinkedHashSet, and TreeSet
        manager.comparePerformance();
    }
}
