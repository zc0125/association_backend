package com.feng.dto;

import com.feng.entity.*;

public class FileDto extends File {
    private FileType fileType;
    private Passage passage;
    private Activity activity;
    private User user;


    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        if(fileType.getType() == null){
            fileType.setType("无");
        }
        this.fileType = fileType;
    }

    public Passage getPassage() {
        return passage;
    }

    public void setPassage(Passage passage) {
        if(passage.getTitle() == null){
            passage.setTitle("无");
        }
        this.passage = passage;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        if(activity.getActivityName() == null){
            activity.setActivityName("无");
        }
        this.activity = activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if(user.getName() == null){
            user.setName("未知");
        }
        this.user = user;
    }
}
