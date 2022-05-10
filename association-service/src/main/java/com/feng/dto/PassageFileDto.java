package com.feng.dto;

import com.feng.entity.File;
import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import lombok.Data;

import java.util.List;

/**
 * Created by zhang.
 */
@Data
public class PassageFileDto extends Passage{
    private List<File> fileList;

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
