package com.project.backend;

import com.project.backend.controller.GameController;
import com.project.backend.controller.GameImageController;
import com.project.backend.dto.GameImageDto;
import com.project.backend.service.GameImageService;
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
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GameImageControllerTest {
    private MockMvc mockMvc;
    @Mock
    private GameImageService Service;
    @InjectMocks
    private GameImageController gameImageController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(gameImageController).build();
    }


    @Test
    public void testUpdateGameImage() throws Exception {
        // Dữ liệu mẫu của GameImage đã cập nhật
        GameImageDto updatedImageDto = new GameImageDto();
        updatedImageDto.setId(1L);
        updatedImageDto.setNameImage("NewImageName");
        updatedImageDto.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-11"));
        // Không cần dữ liệu mẫu cho game, để game là null
        updatedImageDto.setGame(null);

        // Mock service để trả về GameImage đã cập nhật khi được gọi
        when(Service.updateGameImage(eq(1L), any(GameImageDto.class))).thenReturn(updatedImageDto);

        // Gửi yêu cầu PUT để cập nhật GameImage với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.put("/api/GameImages/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"nameImage\":\"NewImageName\",\"date\":\"2024-06-11\",\"game\":null}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nameImage").value("NewImageName"))
                .andExpect(jsonPath("$.date").exists()) // Kiểm tra ngày tồn tại
                .andExpect(jsonPath("$.game").doesNotExist()); // Kiểm tra gameType không tồn tại
    }

    @Test
    public void testCreateGameImage() throws Exception {
        // Dữ liệu mẫu cho GameImageDto
        GameImageDto imageDto = new GameImageDto();
        imageDto.setNameImage("image1.jpg");
        imageDto.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-11")); // Sử dụng ngày cụ thể

        // Mock service để trả về GameImageDto đã tạo mới khi được gọi
        when(Service.createGameimage(any(GameImageDto.class))).thenReturn(imageDto);

        // Gửi yêu cầu POST với dữ liệu mẫu
        mockMvc.perform(MockMvcRequestBuilders.post("/api/GameImages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nameImage\":\"image1.jpg\",\"date\":\"2024-06-11\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").doesNotExist()) // Kiểm tra id không tồn tại
                .andExpect(jsonPath("$.nameImage").value("image1.jpg"))
                .andExpect(jsonPath("$.date").exists()); // Kiểm tra ngày tồn tại
    }


    @Test
    public void testGetAllGameImage() throws Exception {
        // Dữ liệu mẫu cho danh sách GameImageDto
        List<GameImageDto> imageDtoList = new ArrayList<>();
        GameImageDto imageDto1 = new GameImageDto();
        imageDto1.setId(1L);
        imageDto1.setNameImage("image1.jpg");
        imageDto1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-11"));
        imageDtoList.add(imageDto1);

        GameImageDto imageDto2 = new GameImageDto();
        imageDto2.setId(2L);
        imageDto2.setNameImage("image2.jpg");
        imageDto2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-12"));
        imageDtoList.add(imageDto2);

        // Mock service để trả về danh sách GameImageDto khi được gọi
        when(Service.getAllGameImage()).thenReturn(imageDtoList);

        // Gửi yêu cầu GET để lấy tất cả GameImage
        mockMvc.perform(MockMvcRequestBuilders.get("/api/GameImages")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))) // Kiểm tra số lượng phần tử là 2
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nameImage").value("image1.jpg"))
                .andExpect(jsonPath("$[0].date").exists()) // Kiểm tra ngày tồn tại
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nameImage").value("image2.jpg"))
                .andExpect(jsonPath("$[1].date").exists()); // Kiểm tra ngày tồn tại
    }
    @Test
    public void testGetImageById() throws Exception {
        // Dữ liệu mẫu cho GameImageDto
        GameImageDto imageDto = new GameImageDto();
        imageDto.setId(1L);
        imageDto.setNameImage("image1.jpg");
        imageDto.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-06-11"));

        // Mock service để trả về GameImageDto khi được gọi với ID là 1
        when(Service.getGameImageById(1L)).thenReturn(imageDto);

        // Gửi yêu cầu GET để lấy GameImage với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.get("/api/GameImages/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nameImage").value("image1.jpg"))
                .andExpect(jsonPath("$.date").exists()); // Kiểm tra ngày tồn tại
    }

    @Test
    public void testDeleteGameImage() throws Exception {
        // Gửi yêu cầu DELETE để xóa GameImage với ID là 1
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/GameImages/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
