package com.project.backend;

import com.project.backend.controller.GameTypeController;
import com.project.backend.dto.GameTypeDto;
import com.project.backend.service.GameTypeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GameTypeControllerTest {
    private MockMvc mockMvc;

    @Mock
    private GameTypeService gameTypeService;

    @InjectMocks
    private GameTypeController gameTypeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(gameTypeController).build();
    }
    @Test
    public void testGetAllGameTypes() throws Exception {
        // Danh sách mẫu các game type
        GameTypeDto gameType1 = new GameTypeDto(1L, "Dũng");
        GameTypeDto gameType2 = new GameTypeDto(2L, "Nam");

        // Mock service trả về danh sách các game type mẫu khi được gọi
        when(gameTypeService.getAllGameType()).thenReturn(Arrays.asList(gameType1, gameType2));

        // Khởi tạo mockMvc với controller cần test

        mockMvc = MockMvcBuilders.standaloneSetup(gameTypeController).build();
        // Gửi yêu cầu GET tới endpoint "/api/game-types" và kiểm tra kết quả
        mockMvc.perform(MockMvcRequestBuilders.get("/api/gametypes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Dũng"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Nam"));
    }
    @Test
    public void testGetGameTypeById() throws Exception {
        // Dữ liệu mẫu
        GameTypeDto gameTypeDto = new GameTypeDto();
        gameTypeDto.setId(1L);
        gameTypeDto.setName("Dung");

        // Mock service để trả về dữ liệu mẫu khi được gọi
        when(gameTypeService.getGameTypeById(1L)).thenReturn(gameTypeDto);

        // Gửi yêu cầu GET để lấy GameType với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.get("/api/gametypes/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Dung"))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2))) // Kiểm tra rằng phản hồi chỉ có 2 trường
                .andExpect(jsonPath("$.error").doesNotExist()); // Kiểm tra rằng không có trường error trong phản hồi
    }
    @Test
    public void testCreateGameType() throws Exception {
        // Dữ liệu mẫu
        GameTypeDto gameTypeDto = new GameTypeDto();
        gameTypeDto.setId(1L);
        gameTypeDto.setName("Dung");

        // Mock service để trả về dữ liệu mẫu khi được gọi
        when(gameTypeService.createGameType(Mockito.any(GameTypeDto.class))).thenReturn(gameTypeDto);

        // Gửi yêu cầu POST với dữ liệu mẫu
        mockMvc.perform(MockMvcRequestBuilders.post("/api/gametypes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Dung\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Dung"));
    }
    @Test
    public void testUpdateGameType() throws Exception {
        // Dữ liệu mẫu của GameType mới
        GameTypeDto updatedGameTypeDto = new GameTypeDto();
        updatedGameTypeDto.setId(1L);
        updatedGameTypeDto.setName("NewName");
        // Mock service để trả về dữ liệu mẫu khi được gọi
        when(gameTypeService.updatedGameType(eq(1L), Mockito.any(GameTypeDto.class))).thenReturn(updatedGameTypeDto);

        // Gửi yêu cầu PUT để cập nhật GameType với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.put("/api/gametypes/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"NewName\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NewName"))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2))) // Kiểm tra rằng phản hồi chỉ có 2 trường
                .andExpect(jsonPath("$.error").doesNotExist()); // Kiểm tra rằng không có trường error trong phản hồi
    }

    @Test
    public void testDeleteKeycode() throws Exception {
        // Gửi yêu cầu DELETE để xóa Keycode với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/gametypes/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

