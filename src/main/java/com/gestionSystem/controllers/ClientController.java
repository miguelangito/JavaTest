package com.gestionSystem.controllers;

import com.gestionSystem.models.ClientModel;
import com.gestionSystem.persistence.DAO.Client;

import javax.swing.*;
import java.util.List;

public class ClientController {
    ClientModel objClientModel = new ClientModel();

    public void create(){
        Client objClient = new Client();
        String fullName = JOptionPane.showInputDialog("Insert client full name");
        String email = JOptionPane.showInputDialog("Insert client email");
        String inputNumber = (JOptionPane.showInputDialog("Insert client cellphone"));
        String direction = JOptionPane.showInputDialog("Insert client direction");

        int cellphone = Integer.parseInt(inputNumber);

        objClient.setName(fullName);
        objClient.setEmail(email);
        objClient.setCellphone(cellphone);
        objClient.setDirection(direction);

        objClientModel.insert(objClient);
    }

    public static ClientModel instanceModel(){
        return new ClientModel();
    }

    public void findAll() {
        String list = findAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String findAll(List<Object> list) {
        String listString = " -- Client List -- \n";

        for (Object temp : list) {
            Client objClient = (Client) temp;
            listString += objClient.toString() + "\n";
        }
        return listString;
    }

}
