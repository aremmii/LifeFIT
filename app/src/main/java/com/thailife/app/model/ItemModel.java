package com.thailife.app.model;

/**
 * Created by PromptNow5 on 12/8/2017.
 */

public class ItemModel {
    String activityID = "";
    String activityName = "";
    String activityDetail = "";
    String activityTitle = "";
    String activityExpire = "";

    public String getActivityID() {
        return activityID;
    }

    public ItemModel setActivityID(String activityID) {
        this.activityID = activityID;
        return this;
    }

    public String getActivityName() {
        return activityName;
    }

    public ItemModel setActivityName(String activityName) {
        this.activityName = activityName;
        return this;
    }

    public String getActivityDetail() {
        return activityDetail;
    }

    public ItemModel setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
        return this;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public ItemModel setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
        return this;
    }

    public String getActivityExpire() {
        return activityExpire;
    }

    public ItemModel setActivityExpire(String activityExpire) {
        this.activityExpire = activityExpire;
        return this;
    }
}
