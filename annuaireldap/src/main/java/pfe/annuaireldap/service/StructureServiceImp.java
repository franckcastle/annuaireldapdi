package pfe.annuaireldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;
import pfe.annuaireldap.dto.StructureDto;
import pfe.annuaireldap.entities.Structure;
import pfe.annuaireldap.repo.StructureRepo;
import pfe.annuaireldap.request.StructureRequest;
import pfe.annuaireldap.util.ConvertUtilitiesStructure;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.util.List;

@Service
public class StructureServiceImp implements StructureService {
    @Autowired
    StructureRepo structureRepo;
    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public StructureDto getStructureByOu(String req) {
       Structure s = structureRepo.findByOu(req);
       StructureDto structureDto = ConvertUtilitiesStructure.convertStructureToStructureDto(s);
       return structureDto;
    }

    @Override
    public String addStructure(StructureRequest structureReq) throws InvalidNameException, NamingException {
        Structure newStructure = ConvertUtilitiesStructure.convertStructureRequestToStructure(structureReq);
        ldapTemplate.create(newStructure);

        return newStructure.getId().toString();

    }

    @Override
    public List<StructureDto> getAllStructure() {
        List<Structure> structureList = structureRepo.findAll();
        System.out.println(structureList);
        List<StructureDto> structureDtoList  = ConvertUtilitiesStructure.convertListStructureToListStructureDto(structureList);
        return structureDtoList;


    }

    @Override
    public String updateStructureWithoutDeleteEmployeeList(StructureDto dto) throws InvalidNameException {
        return null;
    }

    @Override
    public String updateStructureWithDeleteEmployeeList(StructureDto dto) throws InvalidNameException {
        return null;
    }

    @Override
    public void deleteStructure(String req) {
       Structure s = structureRepo.findByOu(req);
        structureRepo.delete(s);
        //StructureDto structureDto = ConvertUtilitiesStructure.convertStructureToStructureDto(s);


    }
}
