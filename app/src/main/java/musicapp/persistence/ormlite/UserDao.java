package musicapp.persistence.ormlite;

import java.util.List;

import musicapp.model.User;

/**
 * Created by ausias on 11/05/16.
 */
public interface UserDao {
    public List<User> getAllUsers();
    public User getUser(int id);
    public void updateUser(User usr);
    public void deleteUser(User usr);
}
