package com.designvotingsystem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class DesignVotingSystem {
    HashMap<String, Integer> voteCount = new HashMap<>(); // stores candidate
    LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(); // maintains vote order

    // Method to cast a vote
    public void castVote(String candidate){
        voteCount.put(candidate,voteCount.getOrDefault(candidate,0)+1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    // Method to display results sorted by candidate name using TreeMap
    public void displaySortedResults(){
        TreeMap<String, Integer> sortedResult = new TreeMap<>(voteCount);
        System.out.println("Voting Results (Sorted by Candidate Name):");
        for(HashMap.Entry<String, Integer> entry : sortedResult.entrySet()){
            System.out.println(entry.getKey()+" = " + entry.getValue());
        }
    }

    // Method to display results in the order votes were cast using LinkedHashMap
    public void displayVoteOrder() {
        System.out.println("Vote Order (Based on Vote Entry):");
        for (HashMap.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        DesignVotingSystem votingSystem = new DesignVotingSystem();
        // Casting votes
        votingSystem.castVote("Aman");
        votingSystem.castVote("Aman");
        votingSystem.castVote("Chamam");
        votingSystem.castVote("Boman");


        // Display sorted results
        votingSystem.displaySortedResults();

        // Display vote order
        votingSystem.displayVoteOrder();
    }
}
