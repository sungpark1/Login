package Login.Dao;

import Login.Entity.ERole;
import Login.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

//public interface RoleRepository extends MongoRepository<Role, String> {
//    Optional<Role> findByName(ERole name);
//}

@Component
public class RoleRepository extends AbstractMongoDao {

    private static String COLLECTION_NAME = "roles";

    @Autowired
    public RoleRepository(BaseMongoConnector mongoConnector) {
        super(COLLECTION_NAME, mongoConnector);
    }

    public void insertData(ERole role){
        collection().save(role);
    }

    public Optional<Role> findByName(ERole name){
        return Optional.ofNullable(collection().findOne("{name: #}", name).as(Role.class));
    }
}