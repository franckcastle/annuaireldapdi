package pfe.annuaireldap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.annuaireldap.dto.UserDto;
import pfe.annuaireldap.entities.User;
import pfe.annuaireldap.request.UserRequest;
import pfe.annuaireldap.service.UserService;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.util.List;

@RestController
@RequestMapping("/User")

public class UserController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    UserService userService;
    @GetMapping(path="/find-user-by-govcnrps/{govCNRPS}")
    public UserDto findUserByGovCnrps(@PathVariable("govCNRPS") String govCNRPS) throws Exception{
        UserDto user =userService.getUserByCnrps(govCNRPS);
        return user;
    }

    @GetMapping (path="/find-all-user")
    public List <UserDto> findAllUser () throws Exception{
        List <UserDto> userList =userService.getAllUser();
        return userList;
    }
    @PostMapping (path ="/add-user")
    public ResponseEntity<String> adduser(@RequestBody UserRequest userRequest) throws InvalidNameException, NamingException {
        return new ResponseEntity<String>(userService.addUser(userRequest),HttpStatus.CREATED);
    }
    //localhost:8080/Group/delete-all-group/

    @GetMapping(path="/find-user-by-uid/{uid}")
    public UserDto findUserByGovuid(@PathVariable("uid") String uid) throws Exception{
        UserDto user =userService.getUserByCnrps(uid);
        return user;
    }
    //localhost:8080/Group/delete-all-group/
    @DeleteMapping(path="/delete-user-by-uid/{uid}")
    public void deleteUserByUid(@PathVariable("uid") String uid) {
    userService.deleteByUserByUid(uid);
    }

}
