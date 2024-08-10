package com.project.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.project.backend.dto.AccountDto;
import com.project.backend.dto.GroupAccountDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.dto.JoinGroupDto;
import com.project.backend.dto.UserDto;
import com.project.backend.entity.User;

public interface GroupService {
GroupDto creategroup(GroupDto Dto);
GroupDto getgroupById(Long groupId);
List<GroupDto> getAll();
GroupDto Update(Long groupId ,GroupDto updatedDto);
void deleteGroup(Long groupId);

GroupDto addAccountToGroup(Long groupId ,Long accountId);
void AccountJoinGroup(JoinGroupDto joinGroupDto);
void AccountOutGroup(JoinGroupDto joinGroupDto);
boolean  isUserJoinedGroup(Long groupId, Long accountId);
ResponseEntity<?> leaveGroup(JoinGroupDto joinGroupDto);
List<GroupAccountDto> getAll2(Long groupId ,Long accountId );

List<Integer> findAccountDetails(Long groupId);

//void uploadAvatar (Long id, MultipartFile file) throws IOException;
//byte[] getAvatar (Long id);

//List<Long> findAccountIdsByGroupId(Long groupId);
//
//List<Long> findAccountIdsByGroupName(String groupName);

}
