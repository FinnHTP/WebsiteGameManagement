package com.project.backend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.angus.mail.iap.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.backend.dto.AccountDto;
import com.project.backend.dto.GameDto;
import com.project.backend.dto.GroupAccountDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.dto.JoinGroupDto;
import com.project.backend.dto.UserDto;
import com.project.backend.entity.Group;
import com.project.backend.entity.User;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.GroupRepository;
import com.project.backend.service.GroupService;
import com.project.backend.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/group")
@SecurityRequirement(name = "bearerAuth")
public class GroupController {
private GroupService groupservice;
private UserService userservice;



//@PostMapping("")
//public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto group){
//    GroupDto savedGroup = groupservice.creategroup(group);
//    return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
//}


//@PostMapping("")
//public ResponseEntity<GroupDto> createGroup(@ModelAttribute GroupDto group, @RequestParam("image") MultipartFile image) {
//    // Tạo nhóm
//    GroupDto savedGroup = groupservice.creategroup(group);
//
//    // Lưu hình ảnh
//    try {
//        groupservice.saveGroupImage(savedGroup.getId(), image);
//    } catch (IOException e) {
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
//}


@PostMapping("")
public ResponseEntity<GroupDto> createGroup(
        @RequestParam("name") String name,
        @RequestParam("status") boolean status,
        @RequestParam("image") MultipartFile image,
        @RequestParam("createDate") String createDate) {

    GroupDto groupDto = new GroupDto();
    groupDto.setName(name);
    groupDto.setStatus(status);
    groupDto.setCreateDate(LocalDate.parse(createDate));

    try {
        // Chuyển đổi MultipartFile sang byte[]
        groupDto.setImage(image.getBytes());
    } catch (IOException e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Lưu group
    GroupDto savedGroup = groupservice.creategroup(groupDto);
    return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
}


@CrossOrigin(origins = "http://localhost:3000")
@PostMapping ("/{groupId}/image")
public ResponseEntity<String> uploadAvatar (@PathVariable Long groupId,  @RequestParam ("image") MultipartFile file) {
    try
    {
        groupservice.uploadAvatar(groupId, file);
        return ResponseEntity.ok("Avatar uploaded successfully");
    } catch (IOException e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload avatar");
    } catch (RuntimeException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}



@CrossOrigin(origins = "http://localhost:3000")
@GetMapping ("/{groupId}/image")
public ResponseEntity<byte[]> getAvatar (@PathVariable Long groupId) {
    try
    {
        byte[] avatar = groupservice.getAvatar(groupId);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG) 
                .body(avatar);
    } catch (RuntimeException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

    
    

//@PostMapping("")
//public ResponseEntity<GroupDto> createGroup(
//        @RequestPart("name") String name,
//        @RequestPart("image") MultipartFile image,
//        @RequestPart("status") boolean status,
//        @RequestPart("createDate") String createDate) {
//
//  
//    String imagePath = saveImage(image);
//    GroupDto groupDto = new GroupDto();
//    groupDto.setName(name);
//    groupDto.setImage(imagePath);
//    groupDto.setStatus(status);
//    groupDto.setCreateDate(LocalDate.parse(createDate));
//
// 
//    GroupDto savedGroup = groupservice.creategroup(groupDto);
//    return ResponseEntity.status(HttpStatus.CREATED).body(savedGroup);
//}
//
//
//private String saveImage(MultipartFile image) {
//    String directory = "uploads/";
//    
//
//    File directoryFile = new File(directory);
//    if (!directoryFile.exists()) {
//        directoryFile.mkdirs();
//    }
//
//    String filePath = directory + image.getOriginalFilename();
//    File file = new File(filePath);
//    
//    try {
//        image.transferTo(file);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    
//    return filePath;
//}
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

@GetMapping("/member/{id}") 
public ResponseEntity<List<User>> getAccountByGroup(@PathVariable("id") Long groupId){
	List<Integer> myList = groupservice.findAccountDetails(groupId);
    List <User> accountDto = userservice.getListUserById(myList);
    return ResponseEntity.ok(accountDto);
}


@PostMapping("/leaveGroup")
public ResponseEntity<?> leaveGroup(@RequestBody JoinGroupDto joinGroupDto) {
    return groupservice.leaveGroup(joinGroupDto);
}

@GetMapping("/search")
public ResponseEntity<List<Group>> findByName(@RequestParam String name) {
    List<Group> groups = groupservice.findByName(name);
    return ResponseEntity.ok(groups);
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
