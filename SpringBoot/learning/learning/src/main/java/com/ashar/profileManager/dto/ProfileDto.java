package com.ashar.profileManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private String username;
    private String password;
    private String profilePicUrl;
    private String bio;
    private int userId;
}
