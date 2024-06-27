package com.project.backend;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.controller.GameController;
import com.project.backend.dto.GameDto;
import com.project.backend.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GameControllerTest {
    private MockMvc mockMvc;
    @Mock
    private GameService gameService;
    @InjectMocks
    private GameController gameController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
    }
    @Test
    public void testCreateGame() throws Exception {
        // Dữ liệu mẫu cho trò chơi mới
        GameDto gameDto = new GameDto();
        gameDto.setName("Game 1");
        gameDto.setDescription("Description 1");
        gameDto.setPriceGame(19.99);
        gameDto.setStatus(true);
        gameDto.setReleaseDate(new Date());
        gameDto.setVersion("1.0");
        // Không cần dữ liệu mẫu cho gameType, để gameType là null
        gameDto.setGameType(null);

        // Dữ liệu mẫu cho game đã lưu
        GameDto savedGameDto = new GameDto();
        savedGameDto.setId(1L);
        savedGameDto.setName("Game 1");
        savedGameDto.setDescription("Description 1");
        savedGameDto.setPriceGame(19.99);
        savedGameDto.setStatus(true);
        savedGameDto.setReleaseDate(new Date());
        savedGameDto.setVersion("1.0");
        savedGameDto.setGameType(null);
        // Dữ liệu mẫu cho trò chơi mới
        String jsonContent = "{\"name\":\"Game 1\",\"description\":\"Description 1\",\"priceGame\":19.99,\"status\":true,\"releaseDate\":\"2024-06-10\",\"version\":\"1.0\",\"gameType\":null}";

        // Mock service để trả về dữ liệu mẫu khi được gọi
        // Mock service để trả về dữ liệu mẫu khi được gọi
        when(gameService.createGame(any(GameDto.class))).thenReturn(savedGameDto);

        // Gửi yêu cầu POST với dữ liệu trò chơi mẫu
        mockMvc.perform(post("/api/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Game 1"))
                .andExpect(jsonPath("$.description").value("Description 1"))
                .andExpect(jsonPath("$.priceGame").value(19.99))
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.releaseDate").exists())
                .andExpect(jsonPath("$.version").value("1.0"))
                .andExpect(jsonPath("$.gameType").doesNotExist());
    }

    @Test
    public void testGetGameById() throws Exception {
        // Dữ liệu mẫu cho trò chơi cần tìm
        GameDto gameDto = new GameDto();
        gameDto.setId(1L);
        gameDto.setName("Game 1");
        gameDto.setDescription("Description 1");
        gameDto.setPriceGame(19.99);
        gameDto.setStatus(true);
        gameDto.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-10"));
        gameDto.setVersion("1.0");
        gameDto.setGameType(null);
        // Mock service để trả về trò chơi mẫu khi được gọi
        when(gameService.getGameById(1L)).thenReturn(gameDto);

        // Gửi yêu cầu GET để lấy trò chơi với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.get("/api/games/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Game 1"))
                .andExpect(jsonPath("$.description").value("Description 1"))
                .andExpect(jsonPath("$.priceGame").value(19.99))
                .andExpect(jsonPath("$.status").value(true))
                .andExpect(jsonPath("$.releaseDate").exists())
                .andExpect(jsonPath("$.version").value("1.0"))
                .andExpect(jsonPath("$.gameType").doesNotExist());
    }

    @Test
    public void testGetAllGames() throws Exception {
        // Dữ liệu mẫu cho danh sách trò chơi
        GameDto gameDto1 = new GameDto();
        gameDto1.setId(1L);
        gameDto1.setName("Game 1");
        gameDto1.setDescription("Description 1");
        gameDto1.setPriceGame(19.99);
        gameDto1.setStatus(true);
        gameDto1.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-10"));
        gameDto1.setVersion("1.0");
        // Không cần dữ liệu mẫu cho gameType, để gameType là null
        gameDto1.setGameType(null);

        GameDto gameDto2 = new GameDto();
        gameDto2.setId(2L);
        gameDto2.setName("Game 2");
        gameDto2.setDescription("Description 2");
        gameDto2.setPriceGame(29.99);
        gameDto2.setStatus(false);
        gameDto2.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-11"));
        gameDto2.setVersion("2.0");
        // Không cần dữ liệu mẫu cho gameType, để gameType là null
        gameDto2.setGameType(null);

        // Mock service để trả về danh sách trò chơi mẫu khi được gọi
        when(gameService.getAllGame()).thenReturn(Arrays.asList(gameDto1, gameDto2));

        // Gửi yêu cầu GET tới endpoint "/api/games" và kiểm tra kết quả
        mockMvc.perform(MockMvcRequestBuilders.get("/api/games")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Game 1"))
                .andExpect(jsonPath("$[0].description").value("Description 1"))
                .andExpect(jsonPath("$[0].priceGame").value(19.99))
                .andExpect(jsonPath("$[0].status").value(true))
                .andExpect(jsonPath("$[0].releaseDate").exists())
                .andExpect(jsonPath("$[0].version").value("1.0"))
                .andExpect(jsonPath("$[0].gameType").doesNotExist())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Game 2"))
                .andExpect(jsonPath("$[1].description").value("Description 2"))
                .andExpect(jsonPath("$[1].priceGame").value(29.99))
                .andExpect(jsonPath("$[1].status").value(false))
                .andExpect(jsonPath("$[1].releaseDate").exists())
                .andExpect(jsonPath("$[1].version").value("2.0"))
                .andExpect(jsonPath("$[1].gameType").doesNotExist());
    }
    @Test
    public void testUpdateGame() throws Exception {
        // Dữ liệu mẫu của trò chơi đã cập nhật
        GameDto updatedGameDto = new GameDto();
        updatedGameDto.setId(1L);
        updatedGameDto.setName("NewName");
        updatedGameDto.setDescription("NewDescription");
        updatedGameDto.setPriceGame(29.99);
        updatedGameDto.setStatus(false);
        updatedGameDto.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-11"));
        updatedGameDto.setVersion("2.0");
        // Không cần dữ liệu mẫu cho gameType, để gameType là null
        updatedGameDto.setGameType(null);

        // Mock service để trả về trò chơi đã cập nhật khi được gọi
        when(gameService.updateGame(eq(1L), any(GameDto.class))).thenReturn(updatedGameDto);

        // Gửi yêu cầu PUT để cập nhật trò chơi với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.put("/api/games/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"NewName\",\"description\":\"NewDescription\",\"priceGame\":29.99,\"status\":false,\"releaseDate\":\"2024-06-11\",\"version\":\"2.0\",\"gameType\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("NewName"))
                .andExpect(jsonPath("$.description").value("NewDescription"))
                .andExpect(jsonPath("$.priceGame").value(29.99))
                .andExpect(jsonPath("$.status").value(false))
                .andExpect(jsonPath("$.releaseDate").exists())
                .andExpect(jsonPath("$.version").value("2.0"))
                .andExpect(jsonPath("$.gameType").doesNotExist());
    }

    @Test
    public void testDeleteGame() throws Exception {
        // Mock service để trả về thành công khi xóa trò chơi với ID là 1
        doNothing().when(gameService).deleteGame(1L);

        // Gửi yêu cầu DELETE để xóa trò chơi với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/games/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
