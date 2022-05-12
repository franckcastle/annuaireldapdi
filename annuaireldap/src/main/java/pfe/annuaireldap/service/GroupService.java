package pfe.annuaireldap.service;

import pfe.annuaireldap.dto.GroupDto;
import pfe.annuaireldap.request.GroupRequest;

import javax.naming.InvalidNameException;
import java.util.List;

public interface GroupService {
    public GroupDto getGroupByCn(String req);
    public String addGroup(GroupRequest groupReq) throws InvalidNameException;
    public String updateGroupWithoutDeleteMembers(GroupDto dto) throws InvalidNameException;
    public List<GroupDto> getAllGroup();
    public String updateGroupWithDeleteMembers(GroupDto dto) throws InvalidNameException;
    // khedmet lyoum
    public void affectUserToGroup(String req,String uid)  throws InvalidNameException;
    public void deleteByCn(String req);

}
