package follow.com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        List<User> users = Arrays.asList(
            createUser(1, "Alice", Arrays.asList(2, 3)),
            createUser(2, "Bob", Arrays.asList(1)),
            createUser(3, "Charlie", Arrays.asList(4, 5)),
            createUser(4, "David", Arrays.asList(3, 6)),
            createUser(5, "Eva", Arrays.asList(6)),
            createUser(6, "Frank", Arrays.asList())
        );

        // ✅ Question 1: Mutual Followers
        System.out.println("✅ Solving Question 1 (Mutual Followers)");
        MutualFollowerSolver mutualSolver = new MutualFollowerSolver();
        List<List<Integer>> mutualResult = mutualSolver.findMutualFollowers(users);
        System.out.println("✅ Mutual follower pairs: " + mutualResult);

        // ✅ Question 2: Nth-Level Followers
        int findId = 1;
        int n = 2;

        System.out.println("\n✅ Solving Question 2 (Nth-Level Followers)");
        NthLevelFollowerSolver nthSolver = new NthLevelFollowerSolver();
        List<Integer> nthResult = nthSolver.findNthLevelFollowers(users, findId, n);
        System.out.println("✅ Nth-level followers of user " + findId + " at level " + n + ": " + nthResult);
    }

    private User createUser(int id, String name, List<Integer> follows) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setFollows(follows);
        return user;
    }
}

