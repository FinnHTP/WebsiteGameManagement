package com.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.backend.dto.AccountDto;
import com.project.backend.dto.DepositDto;
import com.project.backend.dto.GroupAccountDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.dto.UserDto;
import com.project.backend.entity.Deposit;
import com.project.backend.entity.Group;
import com.project.backend.entity.User;
import com.project.backend.mapper.DepositMapper;

public interface GroupRepository extends JpaRepository<Group, Long>{

//    @Query("select o.account.id from GroupAccount o where o.group.id = ?1")
//    List<Long> findAccountIdsByGroupId(Long groupId);


	
//	  @Query("SELECT a.id FROM Account a WHERE a.id = :groupId")
//	    List<Long> findAccountIdsByGroupId(Long groupId);
	  
//	 @Query("SELECT ga.account.id FROM GroupAccount ga WHERE ga.group.id = :groupId")
//	    List<Long> findAccountIdsByGroupId(Long groupId);
//	
//	
//	   @Query("SELECT a.id FROM Account a WHERE a.group.namegroup = :groupName")
//	    List<Long> findAccountIdsByGroupName(String groupName);
	
	 @Query(value = "SELECT * FROM group_account WHERE account_id = :accountId AND group_id = :groupId", nativeQuery = true)
	    List<GroupAccountDto> getAllGroupAccount(@Param("accountId") Long accountId, @Param("groupId") Long groupId);
	 
//	 @Query(value = "SELECT a.* FROM accounts a INNER JOIN group_account ga ON a.id = ga.account_id WHERE ga.group_id = :groupId", nativeQuery = true)
//	 List<AccountDto> getAllAccountsInGroup(@Param("groupId") Long groupId);
	 
	 

	 @Query(value = "SELECT u.id " +
             "FROM accounts a " +
             "INNER JOIN group_account ga ON a.id = ga.account_id " +
             "INNER JOIN users u ON a.user_id = u.id " +
             "WHERE ga.group_id = :groupId", nativeQuery = true)
List<Integer> findAccountDetails(@Param("groupId") Long groupId);
	 
	  @Query(value = "SELECT * FROM groups WHERE name LIKE %:name%", nativeQuery = true)
	    List<Group> findByName(@Param("name") String name);

}
