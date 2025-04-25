package follow.com.demo;

import java.util.*;

public class MutualFollowerSolver {

    public List<List<Integer>> findMutualFollowers(List<User> users) {
        List<List<Integer>> mutuals = new ArrayList<>();
        Map<Integer, Set<Integer>> followsMap = new HashMap<>();

        for (User user : users) {
            followsMap.put(user.getId(), new HashSet<>(user.getFollows()));
        }

        Set<String> seen = new HashSet<>();

        for (User user : users) {
            int id1 = user.getId();
            for (int id2 : user.getFollows()) {
                if (followsMap.containsKey(id2) && followsMap.get(id2).contains(id1)) {
                    int min = Math.min(id1, id2);
                    int max = Math.max(id1, id2);
                    String key = min + "," + max;

                    if (!seen.contains(key)) {
                        mutuals.add(Arrays.asList(min, max));
                        seen.add(key);
                    }
                }
            }
        }

        return mutuals;
    }
}

