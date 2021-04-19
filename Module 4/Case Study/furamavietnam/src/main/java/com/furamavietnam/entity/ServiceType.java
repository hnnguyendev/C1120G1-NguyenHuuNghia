package com.furamavietnam.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_types")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String name;

    private double cost;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ResortService> resortServiceList;

    public ServiceType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<ResortService> getResortServiceList() {
        return resortServiceList;
    }

    public void setResortServiceList(List<ResortService> resortServiceList) {
        this.resortServiceList = resortServiceList;
    }
}
