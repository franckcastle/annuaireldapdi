package pfe.annuaireldap.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.annuaireldap.dto.StructureDto;
import pfe.annuaireldap.entities.Structure;
import pfe.annuaireldap.request.StructureRequest;

import pfe.annuaireldap.service.StructureService;


import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/Structure")

public class StructureController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    StructureService structureService;
    @GetMapping(path = "/find-all-structure")
    @ResponseBody
    public List<StructureDto> findAllUser () throws Exception{
        List<StructureDto> structureList = structureService.getAllStructure();
        return structureList;
    }
    @GetMapping(path = "/find-structure-by-ou/{ou}")
    public StructureDto findByOu(@PathVariable("ou") String ou) throws Exception{
        StructureDto structureDto = structureService.getStructureByOu(ou);
        return structureDto;
    }
    @PostMapping(path="/add-structure")
    public ResponseEntity<String> addStructure(@RequestBody StructureRequest structureRequest ) throws Exception{

        return new ResponseEntity<String>(structureService.addStructure(structureRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete-structure-by-ou/{ou}")
    public void deleteStructure(@PathVariable("ou") String ou) {

        structureService.deleteStructure(ou);
    }
}
