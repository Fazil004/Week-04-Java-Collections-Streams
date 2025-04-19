import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, orderedVotes.getOrDefault(candidate, 0) + 1);
    }

    public void displayResultsSorted() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votes);
        System.out.println("\n--- Voting Results (Sorted by Candidate Name) ---");
        sortedResults.forEach((candidate, voteCount) ->
                System.out.println(candidate + ": " + voteCount + " votes"));
    }

    public void displayResultsByVoteOrder() {
        System.out.println("\n--- Voting Results (Order of Votes Cast) ---");
        orderedVotes.forEach((candidate, voteCount) ->
                System.out.println(candidate + ": " + voteCount + " votes"));
    }

    public Map<String, Integer> getVoteCounts() {
        return new HashMap<>(votes);     }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        System.out.println("Current Vote Counts (HashMap Order): " + votingSystem.getVoteCounts());
        votingSystem.displayResultsSorted();
        votingSystem.displayResultsByVoteOrder();
    }
}