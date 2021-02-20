package Login.Dao;


import Login.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

//public interface UserRepository extends MongoRepository<User, String> {
//    Optional<User> findByUsername(String username);
//
//    Boolean existsByUsername(String username);
//
//    Boolean existsByEmail(String email);
//}

@Component
public class UserRepository extends AbstractMongoDao{

    private static String COLLECTION_NAME = "users";

    @Autowired
    public UserRepository(BaseMongoConnector mongoConnector){
        super(COLLECTION_NAME, mongoConnector);
    }

    public Optional<User> findByUsername(String username){
        return Optional.ofNullable(collection().findOne("{user: #}", username).as(User.class));
    }

    public void save(User user) {
        collection().save(user);
    }
//
//    public boolean existsByUsername(String username){
//
//    }
}

