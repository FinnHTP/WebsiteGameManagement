package com.project.backend.entity;


import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "keycodes")
public class KeyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "keyCode")
    private String keycode;
    @ManyToOne @JoinColumn(name = "gameId")
    private Game game;
    @Column(name = "createDate")
    private LocalDate createDate;
    @Column(name = "isActive")
    private Boolean isActive;
    @JsonIgnore
    @OneToOne (mappedBy = "keycode")
    private OrderDetail orderDetail;

    public void generateKeyCode() {
    	
        // Tạo chuỗi keycode ngẫu nhiên
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) { // Độ dài mặc định là 12 ký tự
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        this.keycode = sb.toString();
    }
}
