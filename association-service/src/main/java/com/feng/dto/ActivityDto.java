package com.feng.dto;

import com.feng.entity.*;
import com.feng.entity.Activity;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;

/**
 * Created by zhang.
 */
@Data
public class ActivityDto extends Activity{
    private ActivityType activityType;
    private User user;
    private Club club;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
