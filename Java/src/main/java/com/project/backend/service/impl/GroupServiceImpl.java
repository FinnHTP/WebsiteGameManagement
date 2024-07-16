package com.project.backend.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.backend.dto.GroupAccountDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.dto.JoinGroupDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Group;
import com.project.backend.entity.RankAccount;
import com.project.backend.entity.User;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.GroupMapper;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.GroupRepository;
import com.project.backend.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
@Autowired
private GroupRepository grouprepo;
@Autowired
private AccountRepository accountRepository;

@Override
public GroupDto getgroupById(Long groupId) throws ResourceNotFoundException {
    Group group = grouprepo.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group is not found with " + groupId));
    return GroupMapper.mapToDTO(group);
}
@Override
public List<GroupDto> getAll() {
    List<Group> groups = grouprepo.findAll();
    return groups.stream().map((group) -> GroupMapper.mapToDTO(group)).collect(Collectors.toList());
}

@Override
public GroupDto Update(Long groupId, GroupDto updatedDto) {
   Group group = grouprepo.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group is not found with " + groupId));
//   group.setId(updatedDto.getId());
    group.setNamegroup(updatedDto.getName());
    Group saved = grouprepo.save(group);
    return GroupMapper.mapToDTO(saved);
}


@Override
public void deleteGroup(Long groupId) {
    Group group = grouprepo.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group is not found with " + groupId));
    grouprepo.delete(group);
}
@Override
public GroupDto creategroup(GroupDto Dto) {
	   Group group = GroupMapper.mapToEntity(Dto);
	    Group savedGroup = grouprepo.save(group);
	    return GroupMapper.mapToDTO(savedGroup);
}

@Override
public void AccountJoinGroup(JoinGroupDto joinGroupDto) {
	RankAccount rankAccount = new RankAccount();
	rankAccount.setId(1L);
	var user = accountRepository.findById(joinGroupDto.getAccountId()).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + joinGroupDto.getAccountId()));
	Group groupById = grouprepo.findById(joinGroupDto.getGroupId()).orElseThrow(() -> new ResourceNotFoundException("Group is not found with " + joinGroupDto.getGroupId()));
	Set<Group> groups = user.getGroups();
	boolean groupExists = false;

    for (Group group : groups) {
        System.out.println("Existing group: " + group.getNamegroup());
        if (group.getId().equals(groupById.getId())) {
            groupExists = true;
            
            break;
        }
    }
    
    if (!groupExists) {
        groups.add(groupById);
    
    }
   
    
		user.setGroups(groups);
	    accountRepository.save(user);
}


@Override
public boolean isUserJoinedGroup(Long groupId, Long accountId) {
    var user = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + accountId));
    Group groupById = grouprepo.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group is not found with " + groupId));
    Set<Group> groups = user.getGroups();

    for (Group group : groups) {
        if (group.getId().equals(groupById.getId())) {
            return true;
        }
    }
    return false;
}


@Override
public ResponseEntity<?> leaveGroup(JoinGroupDto joinGroupDto) {
    Account user = accountRepository.findById(joinGroupDto.getAccountId())
            .orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + joinGroupDto.getAccountId()));
    Group groupById = grouprepo.findById(joinGroupDto.getGroupId())
            .orElseThrow(() -> new ResourceNotFoundException("Group is not found with id " + joinGroupDto.getGroupId()));
    Set<Group> groups = user.getGroups();

    if (groups.contains(groupById)) {
        groups.remove(groupById);
        accountRepository.save(user);
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not a member of this group");
    }
}

@Override
public void AccountOutGroup(JoinGroupDto joinGroupDto) {

	var user = accountRepository.findById(joinGroupDto.getAccountId()).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + joinGroupDto.getAccountId()));
	Group groupById = grouprepo.findById(joinGroupDto.getGroupId()).orElseThrow(() -> new ResourceNotFoundException("Group is not found with " + joinGroupDto.getGroupId()));
	Set<Group> groups = user.getGroups();

    for (Group group : groups) {
        if (group.getId().equals(groupById.getId())) {
        		((List<GroupDto>) group).remove(user);
            break;
        }
    }
    
}

@Override
public GroupDto addAccountToGroup(Long groupId, Long accountId) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<GroupAccountDto> getAll2(Long groupId, Long accountId) {
	List<GroupAccountDto> ls = grouprepo.getAllGroupAccount(accountId, groupId);
	return ls;
}

//@Override
//public List<Long> findAccountIdsByGroupId(Long groupId) {
//	
//	 return grouprepo.findAccountIdsByGroupId(groupId);
//}
//
//
//
//@Override
//public List<Long> findAccountIdsByGroupName(String groupName) {
//    return grouprepo.findAccountIdsByGroupName(groupName);
//}



//@Override
//public void uploadAvatar (Long id, MultipartFile file) throws IOException {
//    Optional<User> optionalUser = userRepository.findById(id);
//    if (optionalUser.isPresent())
//    {
//        User user = optionalUser.get();
//        user.setAvatar(file.getBytes());
//        userRepository.save(user);
//    } else
//    {
//        throw new RuntimeException("User not found");
//    }
//}
//
//@Override
//public byte[] getAvatar (Long id) {
//    Optional<User> optionalUser = userRepository.findById(id);
//    if (optionalUser.isPresent() && optionalUser.get().getAvatar() != null)
//    {
//        return optionalUser.get().getAvatar();
//    } else
//    {
//        throw new RuntimeException("Avatar not found");
//    }
//}
}
