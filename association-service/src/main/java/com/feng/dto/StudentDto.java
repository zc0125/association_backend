package com.feng.dto;

import com.feng.entity.Club;
import com.feng.entity.Student;
import com.feng.entity.UserClub;
import lombok.Data;

@Data
public class StudentDto extends Student {

    private int clubId;

    private String sexName;

    private UserClub userClub;

    private Club club;


    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public UserClub getUserClub() {
        return userClub;
    }

    public void setUserClub(UserClub userClub) {
        this.userClub = userClub;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
