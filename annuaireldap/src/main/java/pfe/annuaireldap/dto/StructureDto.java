package pfe.annuaireldap.dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StructureDto {
    private String id;
    private String ou;
    private String descriptionAr;
    private String  descriptionFr;
    private String  structurePath;

}
