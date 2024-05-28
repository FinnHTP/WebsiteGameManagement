package com.project.backend.service.impl;

import com.project.backend.dto.KeyCodeDto;
import com.project.backend.entity.KeyCode;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.KeycodeMapper;
import com.project.backend.repository.KeycodeRepository;
import com.project.backend.service.KeycodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KeycodeServiceImpl implements KeycodeService {
    private KeycodeRepository repository;

    @Override
    public KeyCodeDto createkeycode(KeyCodeDto Dto) {
        KeyCode keyCode = KeycodeMapper.mapToKeycode(Dto);
        KeyCode saveKeycode = repository.save(keyCode);
        return KeycodeMapper.mapToKeycodeDto(saveKeycode);
    }

    @Override
    public KeyCodeDto getkeycodeById(Long KeycodeId) {
        KeyCode keyCode = repository.findById(KeycodeId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id " + KeycodeId));
        return KeycodeMapper.mapToKeycodeDto(keyCode);
    }

    @Override
    public List<KeyCodeDto> getAllkeycode() {
        List<KeyCode> keyCodes = repository.findAll();
        return keyCodes.stream().map((keyCode) -> KeycodeMapper.mapToKeycodeDto(keyCode)).collect(Collectors.toList());
    }

    @Override
    public KeyCodeDto Updatekeycode(Long KeycodeId, KeyCodeDto updatedKeyCodeDto) {
        KeyCode keyCode = repository.findById(KeycodeId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id :" + KeycodeId));
        keyCode.setKeyCodeId(updatedKeyCodeDto.getKeycodeId());
        keyCode.setKeyCode(updatedKeyCodeDto.getKeycode());
        keyCode.setGame(updatedKeyCodeDto.getGame());
        keyCode.setCreateDate(updatedKeyCodeDto.getCreateDate());
        keyCode.setIsActive(updatedKeyCodeDto.getIsActive());
        KeyCode updatedKeycodeObj = repository.save(keyCode);
        return KeycodeMapper.mapToKeycodeDto(updatedKeycodeObj);
    }

    @Override
    public void deleteGamekeycode(Long keycodeId) {
        KeyCode keyCode = repository.findById(keycodeId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id + " + keycodeId));
        repository.delete(keyCode);
    }
}
