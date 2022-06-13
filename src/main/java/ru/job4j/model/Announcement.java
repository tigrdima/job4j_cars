package ru.job4j.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "announcement ")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean saleStatus;
    private Date created;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Car car;

    public Announcement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(boolean saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Announcement that = (Announcement) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
