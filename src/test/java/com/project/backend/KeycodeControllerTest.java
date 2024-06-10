package com.project.backend;

import com.project.backend.controller.KeycodeController;
import com.project.backend.dto.KeyCodeDto;
import com.project.backend.entity.Game;
import com.project.backend.service.KeycodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KeycodeControllerTest {

    @Mock
    private KeycodeService service;

    @InjectMocks
    private KeycodeController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateKeycode() {
        KeyCodeDto inputDto = new KeyCodeDto();
        inputDto.setKeycode("ABCD1234"); // Giá trị của keycode
        inputDto.setGame(new Game()); // Đối tượng Game liên kết
        inputDto.setCreateDate(new Date()); // Ngày tạo
        inputDto.setIsActive(true); // Trạng thái hoạt động

        KeyCodeDto outputDto = new KeyCodeDto();
        outputDto.setKeycodeId(1L); // ID của keycode
        outputDto.setKeycode("ABCD1234"); // Giá trị của keycode
        outputDto.setGame(new Game()); // Đối tượng Game liên kết
        outputDto.setCreateDate(new Date()); // Ngày tạo
        outputDto.setIsActive(true); // Trạng thái hoạt động

        when(service.createkeycode(inputDto)).thenReturn(outputDto);

        ResponseEntity<KeyCodeDto> response = controller.createkeycode(inputDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(outputDto, response.getBody());
    }

    @Test
    public void testGetKeycodeById() {
        Long id = 1L;
        KeyCodeDto outputDto = new KeyCodeDto();

        when(service.getkeycodeById(id)).thenReturn(outputDto);

        ResponseEntity<KeyCodeDto> response = controller.getkeycodeById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(outputDto, response.getBody());
    }

    @Test
    public void testGetAllKeycode() {
        List<KeyCodeDto> outputDtos = new ArrayList<>(); // Add some sample data

        when(service.getAllkeycode()).thenReturn(outputDtos);

        ResponseEntity<List<KeyCodeDto>> response = controller.getAllkeycode();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(outputDtos, response.getBody());
    }

    @Test
    public void testUpdateKeycode() {
// Dữ liệu đầu vào
        Long id = 1L; // ID của keycode cần cập nhật
        KeyCodeDto inputDto = new KeyCodeDto();
        inputDto.setKeycodeId(id); // Đặt ID của keycode
        inputDto.setKeycode("Dung123456"); // Giá trị của keycode
        inputDto.setGame(new Game()); // Đối tượng Game  liên kết
        inputDto.setCreateDate(new Date()); // Ngày tạo
        inputDto.setIsActive(false); // Trạng thái

// Kết quả mong đợi
        KeyCodeDto outputDto = new KeyCodeDto();
        outputDto.setKeycodeId(id); // ID của keycode
        outputDto.setKeycode("D123456"); // Giá trị mới của keycode
        outputDto.setGame(new Game()); // Đối tượng Game mới liên kết
        outputDto.setCreateDate(new Date()); // Ngày tạo mới
        outputDto.setIsActive(false); // Trạng thái mới

        when(service.Updatekeycode(id, inputDto)).thenReturn(outputDto);

        ResponseEntity<KeyCodeDto> response = controller.updateKeycode(id, inputDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(outputDto, response.getBody());
    }

    @Test
    public void testDeleteKeycode() {
        Long id = 1L;

        ResponseEntity<String> response = controller.deleteKeycode(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Game deleted Successfully", response.getBody());
        verify(service, times(1)).deleteGamekeycode(id);
    }
}
