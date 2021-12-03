package com.example.rnr_reporter.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class propertyForm {

    @PrimaryKey
    public int ID;

    public String propertyDamaged;
    public String type;
    public String description;
    public String time;
    public String location;
    public String reporter;
    private boolean selected;

    public propertyForm() { selected = false; }

    public void setPropertyDamaged(String p_propertyDamaged) { this.propertyDamaged = p_propertyDamaged; }

    public String getPropertyDamaged() { return this.propertyDamaged; }

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
