package com.feng.dto;

import com.feng.entity.Activity;
import com.feng.entity.File;
import com.feng.entity.Passage;
import lombok.Data;

import java.util.List;

/**
 * Created by zhang.
 */
@Data
public class ActivityFileDto extends Activity{
    private List<File> fileList;

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
