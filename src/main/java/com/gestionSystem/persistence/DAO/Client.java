package com.gestionSystem.persistence.DAO;

public class Client {
    private int id;
    private String name;
    private String email;
    private int cellphone;
    private String direction;

    public Client() {
    }

    public Client(int id, String name, String email, int cellphone, String direction) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.direction = direction;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cellphone=" + cellphone +
                ", direction='" + direction + '\'' +
                '}';
    }
}
