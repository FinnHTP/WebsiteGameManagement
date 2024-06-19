package com.project.backend;

import com.project.backend.controller.GameSystemRequirementController;
import com.project.backend.dto.GameSystemRequirementDto;
import com.project.backend.service.GameSystemRequirementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GameSystemRequirementTest {

    private MockMvc mockMvc;

    @Mock
    private GameSystemRequirementService gameSystemRequirementService;

    @InjectMocks
    private GameSystemRequirementController gameSystemRequirementController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(gameSystemRequirementController).build();
    }

    @Test
    public void testCreateGameSystemRequirement() throws Exception {
        // Dữ liệu mẫu
        GameSystemRequirementDto gameSystemRequirementDto = new GameSystemRequirementDto();
        gameSystemRequirementDto.setOs("Windows 10");
        gameSystemRequirementDto.setMemory("8GB");
        gameSystemRequirementDto.setCard("Nvidia GTX 1060");
        gameSystemRequirementDto.setProccessor(4L);
        gameSystemRequirementDto.setStorage(512.0);

        // ID được trả về từ service
        Long id = 1L;
        gameSystemRequirementDto.setId(id);

        when(gameSystemRequirementService.createGameSystemRequirement(any(GameSystemRequirementDto.class))).thenReturn(gameSystemRequirementDto);

        mockMvc.perform(post("/api/gameSystemRequirement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"os\":\"Windows 10\",\"memory\":\"8GB\",\"card\":\"Nvidia GTX 1060\",\"proccessor\":4,\"storage\":512.0}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.os").value("Windows 10"))
                .andExpect(jsonPath("$.memory").value("8GB"))
                .andExpect(jsonPath("$.card").value("Nvidia GTX 1060"))
                .andExpect(jsonPath("$.proccessor").value(4))
                .andExpect(jsonPath("$.storage").value(512.0));
    }


    @Test
    public void testGetGameSystemRequirementById() throws Exception {
        // Dữ liệu mẫu
        Long id = 1L;
        GameSystemRequirementDto gameSystemRequirementDto = new GameSystemRequirementDto();
        gameSystemRequirementDto.setId(id);
        gameSystemRequirementDto.setOs("Windows 10");
        gameSystemRequirementDto.setMemory("8GB");
        gameSystemRequirementDto.setCard("Nvidia GTX 1060");
        gameSystemRequirementDto.setProccessor(4L);
        gameSystemRequirementDto.setStorage(512.0);

        when(gameSystemRequirementService.getGameSystemRequirementById(id)).thenReturn(gameSystemRequirementDto);

        mockMvc.perform(get("/api/gameSystemRequirement/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.os").value("Windows 10"))
                .andExpect(jsonPath("$.memory").value("8GB"))
                .andExpect(jsonPath("$.card").value("Nvidia GTX 1060"))
                .andExpect(jsonPath("$.proccessor").value(4))
                .andExpect(jsonPath("$.storage").value(512.0));
    }

    @Test
    public void testGetAllGameSystemRequirement() throws Exception {
        // Dữ liệu mẫu
        GameSystemRequirementDto gameSystemRequirementDto1 = new GameSystemRequirementDto();
        gameSystemRequirementDto1.setId(1L);
        gameSystemRequirementDto1.setOs("Windows 10");
        gameSystemRequirementDto1.setMemory("8GB");
        gameSystemRequirementDto1.setCard("Nvidia GTX 1060");
        gameSystemRequirementDto1.setProccessor(4L);
        gameSystemRequirementDto1.setStorage(512.0);

        GameSystemRequirementDto gameSystemRequirementDto2 = new GameSystemRequirementDto();
        gameSystemRequirementDto2.setId(2L);
        gameSystemRequirementDto2.setOs("Linux");
        gameSystemRequirementDto2.setMemory("16GB");
        gameSystemRequirementDto2.setCard("AMD Radeon RX 5700");
        gameSystemRequirementDto2.setProccessor(8L);
        gameSystemRequirementDto2.setStorage(1024.0);

        when(gameSystemRequirementService.getAllGameSystemRequirement()).thenReturn(Arrays.asList(gameSystemRequirementDto1, gameSystemRequirementDto2));

        mockMvc.perform(get("/api/gameSystemRequirement")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].os").value("Windows 10"))
                .andExpect(jsonPath("$[0].memory").value("8GB"))
                .andExpect(jsonPath("$[0].card").value("Nvidia GTX 1060"))
                .andExpect(jsonPath("$[0].proccessor").value(4))
                .andExpect(jsonPath("$[0].storage").value(512.0))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].os").value("Linux"))
                .andExpect(jsonPath("$[1].memory").value("16GB"))
                .andExpect(jsonPath("$[1].card").value("AMD Radeon RX 5700"))
                .andExpect(jsonPath("$[1].proccessor").value(8))
                .andExpect(jsonPath("$[1].storage").value(1024.0));
    }

    @Test
    public void testUpdateGameSystemRequirement() throws Exception {
        // Dữ liệu mẫu
        Long id = 1L;
        GameSystemRequirementDto updatedGameSystemRequirementDto = new GameSystemRequirementDto();
        updatedGameSystemRequirementDto.setId(id);
        updatedGameSystemRequirementDto.setOs("Updated OS");
        updatedGameSystemRequirementDto.setMemory("Updated Memory");
        updatedGameSystemRequirementDto.setCard("Updated Card");
        updatedGameSystemRequirementDto.setProccessor(8L);
        updatedGameSystemRequirementDto.setStorage(1024.0);

        when(gameSystemRequirementService.UpdateGameSystemRequirement(eq(id), any(GameSystemRequirementDto.class))).thenReturn(updatedGameSystemRequirementDto);

        mockMvc.perform(put("/api/gameSystemRequirement/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"os\":\"Updated OS\",\"memory\":\"Updated Memory\",\"card\":\"Updated Card\",\"proccessor\":8,\"storage\":1024.0}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.os").value("Updated OS"))
                .andExpect(jsonPath("$.memory").value("Updated Memory"))
                .andExpect(jsonPath("$.card").value("Updated Card"))
                .andExpect(jsonPath("$.proccessor").value(8))
                .andExpect(jsonPath("$.storage").value(1024.0));
    }
    @Test
    public void testDeleteGameSystemRequirement() throws Exception {
        // Dữ liệu mẫu
        Long id = 1L;

        mockMvc.perform(delete("/api/gameSystemRequirement/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(gameSystemRequirementService).deleteGameSystemRequirement(id);
    }
}
