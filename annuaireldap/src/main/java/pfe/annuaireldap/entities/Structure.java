package pfe.annuaireldap.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;


import javax.naming.Name;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entry(base="ou=structures" ,objectClasses = { "linidStructure", "govStructure", "organizationalUnit","top"})
final public class Structure {
    @Id
    @JsonIgnore
    private Name id;

    private @Attribute(name = "ou") String ou;
    private @Attribute(name = "description;lang-ar") String descriptionAr;
    private @Attribute(name = "description;lang-fr") String descriptionFr;
    private @Attribute(name = "linidStructurePath") String structurePath;








}
