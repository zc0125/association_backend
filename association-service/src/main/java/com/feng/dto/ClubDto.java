package com.feng.dto;

import com.feng.entity.Club;
import lombok.Data;

@Data
public class ClubDto extends Club {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
