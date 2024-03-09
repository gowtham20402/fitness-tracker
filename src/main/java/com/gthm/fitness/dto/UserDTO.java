package com.gthm.fitness.dto;

import com.gthm.fitness.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String userName;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private Double height;
    private Double weight;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.dateOfBirth = user.getDateOfBirth();
        this.gender = user.getGender();
        this.height = user.getHeight();
        this.weight = user.getWeight();
    }
}

