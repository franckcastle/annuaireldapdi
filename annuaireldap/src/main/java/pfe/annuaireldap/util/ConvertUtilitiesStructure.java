package pfe.annuaireldap.util;


import pfe.annuaireldap.dto.StructureDto;

import pfe.annuaireldap.entities.Structure;
import pfe.annuaireldap.request.StructureRequest;

import javax.naming.InvalidNameException;
import javax.naming.Name;
import javax.naming.ldap.LdapName;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertUtilitiesStructure {
    public static StructureDto convertStructureToStructureDto(Structure s ){
        StructureDto structureDto= new StructureDto();
        structureDto.setId(s.getId().toString());
        structureDto.setOu(s.getOu());
        //structureDto.setDescriptionAr(s.getDescriptionAr());
        //structureDto.setDescriptionFr(s.getDescriptionFr());
        //structureDto.setStructurePath(s.getStructurePath());

        return structureDto;
    }
    public static List<StructureDto> convertListStructureToListStructureDto(List<Structure> listStructure){
        List<StructureDto> listStructureDto = new ArrayList<StructureDto>();
        for(Structure u:listStructure){
            listStructureDto.add(convertStructureToStructureDto(u));
        }
        return listStructureDto;
    }
    public static Structure convertStructureRequestToStructure(StructureRequest req) throws InvalidNameException {
        Structure structure = new Structure();
        structure.setId(new LdapName(req.getId()));
        structure.setOu(req.getOu());
        //structure.setDescriptionAr(req.getDescriptionAr());
        //structure.setDescriptionFr(req.getDescriptionFr());
        //structure.setStructurePath(req.getStructurePath());
        return structure;

    }
    public static Structure convertDtoToStructure(StructureDto dto) throws InvalidNameException{
        Structure structure = new Structure();
        structure.setId(new LdapName(dto.getId()));
        structure.setOu(dto.getOu());
        //structure.setDescriptionAr(dto.getDescriptionAr());
        //structure.setDescriptionFr(dto.getDescriptionFr());
        //structure.setStructurePath(dto.getStructurePath());
        return structure;
    }
    /*public static String convertNameToString(javax.lang.model.element.Name id) throws InvalidNameException {
        return id.toString();
    }
    public static Set<String> convertSetNameToSetString(Set<javax.lang.model.element.Name> setId) throws InvalidNameException{
        HashSet<String> setIds = new HashSet<String>();
        for(javax.lang.model.element.Name n:setId){
            setIds.add(convertNameToString(n));
        }
        return setIds;
    }*/

}
