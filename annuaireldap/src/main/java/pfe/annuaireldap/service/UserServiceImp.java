package pfe.annuaireldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;
import pfe.annuaireldap.dto.UserDto;
import pfe.annuaireldap.entities.User;
import pfe.annuaireldap.repo.UserRepo;
import pfe.annuaireldap.request.UserRequest;
import pfe.annuaireldap.util.ConvertUtilitiesUser;

import javax.naming.InvalidNameException;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private LdapTemplate ldapTemplate;

    public UserDto getUserByCnrps(String req) {
        User u = userRepo.findByGovCNRPS(req);
        UserDto userDto= ConvertUtilitiesUser.convertUserToUserDto(u);
        return userDto;
    }

    @Override
    public UserDto getUserByUid(String uid) {
        User u = userRepo.findByUid(uid);
        UserDto userDto= ConvertUtilitiesUser.convertUserToUserDto(u);
        return userDto;
    }

    @Override
    public void deleteByUserByUid(String uid) {
        User u = userRepo.findByUid(uid);
        userRepo.delete(u);
    }

    @Override
    public String  addUser (UserRequest uReq) throws InvalidNameException {
        User newUser = ConvertUtilitiesUser.convertUserRequestToUser(uReq);
        ldapTemplate.create(newUser);
        return newUser.getId().toString();
    }

    @Override



    public String updateUser(UserDto userDto) throws InvalidNameException {
        User getUSerToUpdate = userRepo.findByGovCNRPS(userDto.getGovCNRPS());
        userDto.setUid(getUSerToUpdate.getUid());
        userDto.setGovCNRPS(getUSerToUpdate.getGovCNRPS());
        User userUpdate=ConvertUtilitiesUser.convertUserDtoToUser(userDto);
        User updateUser=userRepo.save(userUpdate);
        return updateUser.getId().toString();
    }
    public List<UserDto> getAllUser() {
        List<User> usersList=userRepo.findAll();
        List<UserDto> listUserDto = ConvertUtilitiesUser.convertListUserToListUserDto(usersList) ;
        return listUserDto;
    }


}
