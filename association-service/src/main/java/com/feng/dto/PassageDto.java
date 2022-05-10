package com.feng.dto;

import com.feng.entity.Club;
import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import com.feng.entity.User;
import lombok.Data;

/**
 * Created by zhang.
 */
@Data
public class PassageDto extends Passage{
    private PassageType passageType;
    private Club club;
    private User user;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PassageType getPassageType() {
        return passageType;
    }

    public void setPassageType(PassageType passageType) {
        this.passageType = passageType;
    }
}
