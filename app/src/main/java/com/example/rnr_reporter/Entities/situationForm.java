package com.example.rnr_reporter.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class situationForm {

    @PrimaryKey(autoGenerate = true)
    public int ID;

    public String type;
    public String description;
    public String time;
    public String location;
    public String reporter;
    private boolean selected;

    public situationForm() { selected = false; }

    public situationForm(String p_type, String p_description, String p_time, String p_location, String p_reporter){
        this.type = p_type;
        this.description = p_description;
        this.time = p_time;
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
