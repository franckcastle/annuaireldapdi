package pfe.annuaireldap.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class StructureRequest {
    private String id;
    private String ou;
    private String descriptionAr;
    private String  descriptionFr;
    private String  structurePath;
}
