package com.thailife.app.model;

import java.util.ArrayList;

/**
 * Created by PromptNow5 on 12/8/2017.
 */

public class MonthListModel {

    ArrayList<MonthModel> monthModels = new ArrayList<>();

    public ArrayList<MonthModel> getMonthModels() {
        return monthModels;
    }

    public MonthListModel setMonthModels(ArrayList<MonthModel> monthModels) {
        this.monthModels = monthModels;
        return this;
    }
}
