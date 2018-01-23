package com.thailife.app.model;

import java.util.ArrayList;

/**
 * Created by PromptNow5 on 12/8/2017.
 */

public class MonthModel {
    String monthId = "";
    String monthName = "";
    ArrayList<ItemModel> itemModels = new ArrayList<>();

    public String getMonthId() {
        return monthId;
    }

    public MonthModel setMonthId(String monthId) {
        this.monthId = monthId;
        return this;
    }

    public String getMonthName() {
        return monthName;
    }

    public MonthModel setMonthName(String monthName) {
        this.monthName = monthName;
        return this;
    }

    public ArrayList<ItemModel> getItemModels() {
        return itemModels;
    }

    public MonthModel setItemModels(ArrayList<ItemModel> itemModels) {
        this.itemModels = itemModels;
        return this;
    }
}
