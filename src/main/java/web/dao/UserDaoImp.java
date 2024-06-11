package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImp {
    private List<User> users;
    private static int USER_COUNT;

    {   users = new ArrayList<>();
        users.add(new User(++USER_COUNT,"Tom"));
        users.add(new User(++USER_COUNT,"Tok"));
        users.add(new User(++USER_COUNT,"Bob"));
        users.add(new User(++USER_COUNT,"Tom"));
    }
    public List<User> index(){
        return users;
    }
    public User show(int id){
        return users.stream().filter(user -> user.getId() == id)
                .findAny().orElse(null);
    }
}
