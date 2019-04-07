package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;

@Entity
@Table(name = "Venue")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "venueId")
    private Integer venueId;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "category")
    private Integer category;

    @Column(name = "availableSeat")
    private Integer availableSeat;

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(Integer availableSeat) {
        this.availableSeat = availableSeat;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + venueId +
                ", capacity=" + capacity +
                ", category=" + category +
                ", availableSeat=" + availableSeat +
                '}';
    }
}
