package pfe.annuaireldap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.annuaireldap.dto.GroupDto;
import pfe.annuaireldap.request.GroupRequest;
import pfe.annuaireldap.service.GroupService;

import javax.naming.InvalidNameException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Group")
public class GroupController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    GroupService groupService;

    @GetMapping(path="/find-all-group")
    public List <GroupDto> findAllUser () throws Exception{
        List<GroupDto> groupList =groupService.getAllGroup();
        return groupList;
    }
    @GetMapping (path="/find-group-by-cn/{cn}")
    public GroupDto findGroupByCn(@PathVariable("cn") String cn) throws Exception{
        GroupDto groupDto =groupService.getGroupByCn(cn);
        return groupDto;
    }
    @PostMapping(path = "/add-group")
    public ResponseEntity<String> addGroup(@RequestBody GroupRequest groupRequest) throws Exception{
       // Set<String> members = new HashSet<String>();
        //members.add("uid=006,ou=users,dc=cni,dc=tn");
        //groupRequest.setMembers(members);
        return new ResponseEntity<String>(groupService.addGroup(groupRequest), HttpStatus.CREATED);
    }

    @DeleteMapping (path="/delete-group-by-cn/{cn}")
    public void deleteGroupByCn(@PathVariable("cn") String cn){
     groupService.deleteByCn(cn);
    }

    @PutMapping (path="/affect-user-to-group/{cn}/{uid}")
    public void affectUserToGroup(@PathVariable("cn") String cn,@PathVariable("uid") String uid){
     try {
         groupService.affectUserToGroup(cn, uid);
     } catch (Exception e) {
         e.printStackTrace();
     } ;
     }
}
