package musicapp.persistence.ormlite;


import java.util.ArrayList;
import java.util.List;

import musicapp.model.User;

/**
 * Created by ausias on 11/05/16.
 */
public class UserDaoImpl implements UserDao  {

    //list is working as a database
    List<User> Users;

    public UserDaoImpl(){
        Users = new ArrayList<User>();
        User u1 = new User();
        User u2 = new User();
        Users.add(u1);
        Users.add(u2);
    }
    @Override
    public void deleteUser(User User) {
        Users.remove(User.getId());
        System.out.println("User: Roll No " + User.getId() + ", deleted from database");
    }

    //retrive list of Users from the database
    @Override
    public List<User> getAllUsers() {
        return Users;
    }

    @Override
    public User getUser(int rollNo) {
        return Users.get(rollNo);
    }

    @Override
    public void updateUser(User User) {
        Users.get(User.getId()).setName(User.getName());
        System.out.println("User: Roll No " + User.getId() + ", updated in the database");
    }
}


