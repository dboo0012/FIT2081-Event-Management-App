package com.fit2081.fit2081_assignment_1.providers;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = EventCategory.TABLE_NAME)
public class EventCategory {
    public static final String TABLE_NAME = "eventCategories";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "categoryId")
    private String categoryId;

    @ColumnInfo(name = "categoryName")
    private String categoryName;

    @ColumnInfo(name = "eventCount")
    private int eventCount;

    @ColumnInfo(name = "isCategoryActive")
    private boolean isCategoryActive;

    @ColumnInfo(name = "eventLocation")
    private String eventLocation;

    public EventCategory(String categoryId, String categoryName, int eventCount, boolean isCategoryActive, String eventLocation) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.eventCount = eventCount;
        this.isCategoryActive = isCategoryActive;
        this.eventLocation = eventLocation;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isCategoryActive() {
        return isCategoryActive;
    }

    public void setCategoryActive(boolean categoryActive) {
        isCategoryActive = categoryActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
}
