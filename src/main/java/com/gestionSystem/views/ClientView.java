package com.gestionSystem.views;

import com.gestionSystem.controllers.ClientController;

import javax.swing.*;
import java.util.Objects;

public class ClientView {
    ClientController objClientController = new ClientController();
    public void menu(){
        String option;
        do {
            JOptionPane.showMessageDialog(null,"Client Administrator");
            option = JOptionPane.showInputDialog("""
                                Chose an option
                                1. Add a new Client.
                                2. List all Clients.
                                3. Exit.
                                """);
            switch (option){
                case "1":
                    objClientController.create();
                case "2":
                    objClientController.findAll();
            }
        }while(!Objects.equals(option, "3"));
    }
}
