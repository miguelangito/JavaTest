package com.gestionSystem.persistence.DAO;

import java.util.Date;

public class Rent {
    private int id;
    private Date rent_start_date;
    private Date rent_finish_date;
    private int client_id;
    private Client objClient;
    private int machine_id;
    private Machine objMachine;
    private boolean is_active;

    public Rent() {
    }

    public Rent(int id, Date rent_start_date, Date rent_finish_date, int client_id, Client objClient, int machine_id, Machine objMachine, boolean is_active) {
        this.id = id;
        this.rent_start_date = rent_start_date;
        this.rent_finish_date = rent_finish_date;
        this.client_id = client_id;
        this.objClient = objClient;
        this.machine_id = machine_id;
        this.objMachine = objMachine;
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getRent_start_date() {
        return (java.sql.Date) rent_start_date;
    }

    public void setRent_start_date(Date rent_start_date) {
        this.rent_start_date = rent_start_date;
    }

    public java.sql.Date getRent_finish_date() {
        return (java.sql.Date) rent_finish_date;
    }

    public void setRent_finish_date(Date rent_finish_date) {
        this.rent_start_date = rent_finish_date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Client getObjClient() {
        return objClient;
    }

    public void setObjClient(Client objClient) {
        this.objClient = objClient;
    }

    public int getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(int machine_id) {
        this.machine_id = machine_id;
    }

    public Machine getObjMachine() {
        return objMachine;
    }

    public void setObjMachine(Machine objMachine) {
        this.objMachine = objMachine;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", rent_start_date=" + rent_start_date +
                ", rent_finish_date=" + rent_finish_date +
                ", client_id=" + client_id +
                ", objClient=" + objClient +
                ", machine_id=" + machine_id +
                ", objMachines=" + objMachine +
                ", isActive=" + is_active +
                '}';
    }
}
