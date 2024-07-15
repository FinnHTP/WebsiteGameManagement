package com.project.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.angus.mail.iap.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.dto.GameDto;
import com.project.backend.dto.GroupAccountDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.dto.JoinGroupDto;
import com.project.backend.entity.Group;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.GroupRepository;
import com.project.backend.service.GroupService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/group")
@SecurityRequirement(name = "bearerAuth")
public class GroupController {
private GroupService groupservice;



@PostMapping
public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto group){
    GroupDto savedGroup = groupservice.creategroup(group);
    return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
}
//
//@PostMapping("/{groupId}/addAccount/{accountId}")
//public ResponseEntity<GroupDto> addAccountToGroup(
//        @PathVariable ("groupId") Long groupId, 
//        @PathVariable("accountId") Long accountId) {
//    GroupDto updatedGroup = groupservice.addAccountToGroup(groupId, accountId);
//    return ResponseEntity.ok(updatedGroup);
//}

@PostMapping("joinGroup")
public ResponseEntity<String> accountJoinGroup(@RequestBody JoinGroupDto joinGroupDto){
	groupservice.AccountJoinGroup(joinGroupDto);
	return ResponseEntity.ok("Join Successfully");
	
}

//@GetMapping("/accountinlist")
//public ResponseEntity<GroupAccountDto> getAll2((@RequestParam("id") Long groupId , @RequestBody GroupAccountDto groupAccountDto))
//{
//	
//	}

@GetMapping("/{groupId}/isUserJoined")
public ResponseEntity<Boolean> isUserJoined(@PathVariable Long groupId, @RequestParam Long accountId) {
    boolean isUserJoined = groupservice.isUserJoinedGroup(groupId, accountId);
    return ResponseEntity.ok(isUserJoined);	
}

@GetMapping("{id}")
public ResponseEntity<GroupDto> getGroupById(@PathVariable("id") Long groupId){
    GroupDto groupDto = groupservice.getgroupById(groupId);
    return ResponseEntity.ok(groupDto);
}


@PostMapping("/leaveGroup")
public ResponseEntity<?> leaveGroup(@RequestBody JoinGroupDto joinGroupDto) {
    return groupservice.leaveGroup(joinGroupDto);
}


//@GetMapping("/groups/{groupId}/accounts")
//public List<Long> findAccountIdsByGroupId(@PathVariable Long groupId) {
//    return groupservice.findAccountIdsByGroupId(groupId);
//}


//@GetMapping("{id}/details")
//public Map<String, Object> getGroupDetails(@PathVariable Long id) {
//    List<Long> memberIds = groupservice.findAccountIdsByGroupId(id);
//    Map<String, Object> response = new HashMap<>();
//    response.put("groupId", id);
//    response.put("totalMembers", memberIds.size());
//    response.put("memberIds", memberIds);
//    return response;
//}

//@GetMapping("/details")
//public Map<String, Object> getGroupDetails(@RequestParam String groupName) {
//    List<Long> memberIds = groupservice.findAccountIdsByGroupName(groupName);
//    Map<String, Object> response = new HashMap<>();
//    response.put("groupName", groupName);
//    response.put("totalMembers", memberIds.size());
//    response.put("memberIds", memberIds);
//    return response;
//}


//@GetMapping("/detail/{id}")
//public List<Long> findAccountIdsByGroupId(@PathVariable Long id) {
//    return groupservice.findAccountIdsByGroupId(id);
//}



@GetMapping("")
public ResponseEntity<List<GroupDto>> getAll(){
    List<GroupDto> group = groupservice.getAll();
    return ResponseEntity.ok(group);
}

@PutMapping("{id}")
public ResponseEntity<GroupDto> updateGroup(@PathVariable("id") Long groupId, @RequestBody GroupDto updatedGroup){
    GroupDto group = groupservice.Update(groupId, updatedGroup);
    return ResponseEntity.ok(group);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteGroup(@PathVariable("id") Long groupId){
    groupservice.deleteGroup(groupId);
    return ResponseEntity.ok("Group deleted Successfully");
}
}
