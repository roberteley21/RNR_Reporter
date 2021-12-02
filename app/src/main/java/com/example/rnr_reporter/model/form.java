package com.example.rnr_reporter.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class form {

    @PrimaryKey
    public int ID;

    private String name;
    private String type;
    private String description;
    private String time;
    private String location;
    private String reporter;
    private boolean selected;

    public form() { this.selected = false; }

    public void setName(String p_name) { this.name = p_name; }

    public String getName() { return this.name; }

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
