package com.project.backend.service;

import com.project.backend.dto.KeyCodeDto;
import com.project.backend.entity.KeyCode;
import com.project.backend.repository.KeycodeRepository;

import java.util.List;

public interface KeycodeService {
    KeyCodeDto createkeycode(KeyCodeDto Dto);
    KeyCodeDto getkeycodeById(Long KeycodeId);
    List<KeyCodeDto> getAllkeycode();
    KeyCodeDto Updatekeycode(Long KeycodeId ,KeyCodeDto updatedKeyCodeDto);
    void deleteGamekeycode(Long keycodeId);
   List<KeyCode> findByStatusDisable();
   List<KeyCode> findByStatusEnable();

    
}
