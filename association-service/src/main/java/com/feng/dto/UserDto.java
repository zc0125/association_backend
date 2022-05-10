package com.feng.dto;

import com.feng.entity.User;
import lombok.Data;

@Data
public class UserDto extends User {

    private String sexName;
    private String clubName;
    private String roleName;

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
