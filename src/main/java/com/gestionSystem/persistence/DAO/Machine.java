package com.gestionSystem.persistence.DAO;

import com.gestionSystem.utils.Status;

public class Machine {
    private int id;
    private String model;
    private int serialNumber;
    private Status status;

    public Machine() {
    }

    public Machine(int id, String model, int serialNumber, Status status) {
        this.id = id;
        this.model = model;
        this.serialNumber = serialNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Machines{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber=" + serialNumber +
                ", status=" + status +
                '}';
    }
}
