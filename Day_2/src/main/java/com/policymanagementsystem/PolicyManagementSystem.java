package com.policymanagementsystem;

import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
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

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate + '}';
    }
}

class InsurancePolicyManager {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>(); // Stores policies by policy number
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>(); // Maintains insertion order
    private TreeMap<LocalDate, List<InsurancePolicy>> sortedByExpiry = new TreeMap<>(); // Sorts policies by expiry date

    // Add a new policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);

        sortedByExpiry.putIfAbsent(policy.getExpiryDate(), new ArrayList<>());
        sortedByExpiry.get(policy.getExpiryDate()).add(policy);
    }

    // Retrieve policy by number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring in the next 30 days
    public List<InsurancePolicy> getExpiringPolicies() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);

        for (Map.Entry<LocalDate, List<InsurancePolicy>> entry : sortedByExpiry.subMap(today, true, thresholdDate, true).entrySet()) {
            expiringPolicies.addAll(entry.getValue());
        }
        return expiringPolicies;
    }

    // List policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<InsurancePolicy>>> iterator = sortedByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<InsurancePolicy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (InsurancePolicy policy : entry.getValue()) {
                    policyMap.remove(policy.getPolicyNumber());
                    orderedPolicyMap.remove(policy.getPolicyNumber());
                }
                iterator.remove();
            }
        }
    }
}

public class PolicyManagementSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding some policies
        manager.addPolicy(new InsurancePolicy("P001", "Shivraj", LocalDate.now().plusDays(20)));
        manager.addPolicy(new InsurancePolicy("P002", "shikhar", LocalDate.now().plusDays(40)));
        manager.addPolicy(new InsurancePolicy("P003", "rohan", LocalDate.now().minusDays(5)));
        manager.addPolicy(new InsurancePolicy("P004", "aman", LocalDate.now().plusDays(10)));

        // Retrieve policy by number
        System.out.println("Policy P001: " + manager.getPolicyByNumber("P001"));

        // List policies expiring in the next 30 days
        System.out.println("Expiring Policies: " + manager.getExpiringPolicies());

        // List policies for a specific policyholder
        System.out.println("Policies for aman: " + manager.getPoliciesByHolder("aman"));

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + manager.getExpiringPolicies());
    }
}

