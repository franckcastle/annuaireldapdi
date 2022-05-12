package pfe.annuaireldap.repo;

import org.springframework.data.ldap.repository.LdapRepository;
import pfe.annuaireldap.entities.Structure;

public interface StructureRepo extends LdapRepository<Structure> {
    Structure findByOu(String ou);
}
