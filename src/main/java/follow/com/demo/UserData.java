package follow.com.demo;

import java.util.List;

public class UserData {
    private List<User> users;
    private int findId;
    private int n;

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }

    public int getFindId() { return findId; }
    public void setFindId(int findId) { this.findId = findId; }

    public int getN() { return n; }
    public void setN(int n) { this.n = n; }
}
