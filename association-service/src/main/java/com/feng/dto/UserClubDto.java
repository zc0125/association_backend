package com.feng.dto;

import com.feng.entity.Club;
import com.feng.entity.UserClub;
import lombok.Data;

@Data
public class UserClubDto extends UserClub {

    private Club club;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
