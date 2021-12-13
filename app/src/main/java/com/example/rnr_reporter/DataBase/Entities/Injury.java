package com.example.rnr_reporter.DataBase.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Injury {

    @PrimaryKey(autoGenerate = true)
    public int ID;

    private String name;
    private String type;
    private String description;
    private String time;
    private String date;
    private String location;
    private String reporter;
    private boolean selected;

    public Injury() { this.selected = false; }

    public Injury(String p_name, String p_type, String p_description, String p_time, String p_date, String p_location, String p_reporter){
        this.name = p_name;
        this.type = p_type;
        this.description = p_description;
        this.time = p_time;
        this.date = p_date;
        this.location = p_location;this.reporter = p_reporter;
        this.selected = false;
    }

    public void setName(String p_name) { this.name = p_name; }

    public String getName() { return this.name; }

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
