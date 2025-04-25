package follow.com.demo;

import java.util.*;

public class NthLevelFollowerSolver {

    public List<Integer> findNthLevelFollowers(List<User> users, int startId, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (User user : users) {
            graph.put(user.getId(), user.getFollows());
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startId);
        visited.add(startId);

        int level = 0;

        while (!queue.isEmpty() && level < n) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                List<Integer> follows = graph.getOrDefault(current, new ArrayList<>());

                for (int f : follows) {
                    if (!visited.contains(f)) {
                        queue.add(f);
                        visited.add(f);
                    }
                }
            }

            level++;
        }

        List<Integer> result = new ArrayList<>(queue);
        Collections.sort(result);
        return result;
    }
}


