package com.queueinterface.hospitaltriagesystem;

import java.util.PriorityQueue;
import java.util.Comparator;

// Patient class
class Patient {
    String name;
    int severity;
    int arrivalTime;

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ", Arrival: " + arrivalTime + ")";
    }
}

// Comparator to prioritize patients
class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        // Higher severity gets higher priority
        if (p1.severity != p2.severity) {
            return Integer.compare(p2.severity, p1.severity);
        }
        // If severity is the same, the earlier arrival gets priority
        return Integer.compare(p1.arrivalTime, p2.arrivalTime);
    }
}

// Hospital triage simulation
public class HospitalTriageSystem {
    public static void main(String[] args) {
        // PriorityQueue with custom comparator
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new PatientComparator());

        // Adding patients to the queue
        triageQueue.add(new Patient("Pradeep", 5, 1));
        triageQueue.add(new Patient("Dablu", 3, 2));
        triageQueue.add(new Patient("Shivraj", 5, 3));
        triageQueue.add(new Patient("Vivek", 2, 4));
        triageQueue.add(new Patient("Sujal", 4, 5));

        // Treat patients based on priority
        System.out.println("Patients treated in order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}

