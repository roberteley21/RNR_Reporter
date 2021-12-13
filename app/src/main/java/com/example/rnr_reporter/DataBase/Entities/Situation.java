package com.example.rnr_reporter.DataBase.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Situation {

    @PrimaryKey(autoGenerate = true)
    public int ID;

    public String type;
    public String description;
    public String time;
    public String date;
    public String location;
    public String reporter;
    private boolean selected;

    public Situation() { selected = false; }

    public Situation(String p_type, String p_description, String p_time, String p_date, String p_location, String p_reporter){
        this.type = p_type;
        this.description = p_description;
        this.time = p_time;
        this.date = p_date;
        this.location = p_location;
        this.reporter = p_reporter;
        this.selected = false;
    }

    public void setType(String p_type) { this.type = p_type; }

    public String getType() { return this.type; }

    public void setDescription(String p_description) { this.description = p_description; }

    public String getDescription() { return this.description; }

    public void setTime(String p_time) { this.time = p_time; }

    public String getTime() { return this.time; }

    public void setDate(String p_date) { this.date = p_date; }

    public String getDate() { return this.date; }

    public void setLocation(String p_location) { this.location = p_location; }

    public String getLocation() { return this.location; }

    public void setReporter(String p_reporter) { this.reporter = p_reporter; }

    public String getReporter() { return this.reporter; }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void toggleSelection() {
        this.selected = !this.selected;
    }
}
