package pfe.annuaireldap.service;

import pfe.annuaireldap.dto.UserDto;
import pfe.annuaireldap.request.UserRequest;

import javax.naming.InvalidNameException;
import java.util.List;

public interface UserService {
    public UserDto getUserByCnrps(String req);
    public UserDto getUserByUid(String uid);
    public void deleteByUserByUid(String uid);
    public String addUser(UserRequest uReq) throws InvalidNameException;
    public String updateUser(UserDto userDto) throws InvalidNameException;
    public List<UserDto> getAllUser();
}
