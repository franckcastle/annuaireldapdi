package pfe.annuaireldap.repo;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;
import pfe.annuaireldap.entities.User;

@Repository
public interface UserRepo extends LdapRepository<User> {
    User findByGovCNRPS(String username);
    User findById(String id);
    User findByUid(String uid);

    User findByCnLangFr(String cn);

}
