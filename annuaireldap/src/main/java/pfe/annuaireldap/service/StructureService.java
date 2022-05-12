package pfe.annuaireldap.service;

import pfe.annuaireldap.dto.StructureDto;
import pfe.annuaireldap.entities.Structure;
import pfe.annuaireldap.request.StructureRequest;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.util.List;

public interface StructureService {
    public StructureDto getStructureByOu(String req);
    public String addStructure(StructureRequest structureReq) throws InvalidNameException, NamingException;
    public List<StructureDto> getAllStructure();
    public String updateStructureWithoutDeleteEmployeeList(StructureDto dto) throws InvalidNameException;
    public String updateStructureWithDeleteEmployeeList(StructureDto dto) throws InvalidNameException;
    public void deleteStructure(String req);

}
