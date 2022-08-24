package com.example.demo.model;

import javax.persistence.*;

@Entity(name="Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "nights")
    private int nightStayedNum;
    @Column(name = "personNum")
    private int personNum;

    public Reservation() {
    }

    public Reservation(long id, String name, int nightStayedNum, int personNum) {
        this.id = id;
        this.name = name;
        this.nightStayedNum = nightStayedNum;
        this.personNum = personNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNightStayedNum() {
        return nightStayedNum;
    }

    public void setNightStayedNum(int nightStayedNum) {
        this.nightStayedNum = nightStayedNum;
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }
}
