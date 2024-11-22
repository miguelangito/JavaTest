package com.gestionSystem;

import com.gestionSystem.persistence.database.ConfigDB;
import com.gestionSystem.views.ClientView;
import com.gestionSystem.views.MachineView;
import com.gestionSystem.views.RentView;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ClientView objClientView = new ClientView();
        MachineView objMachineView = new MachineView();
        RentView objRentView = new RentView();

        String option;
        do {
            option = JOptionPane.showInputDialog("""
                    Chose an option:
                    1. Client Administration
                    2. Machine Administration
                    3. Rent Administration
                    4. Exit
                    """);
            switch (option){
                case "1":
                    objClientView.menu();
                case "2":
                    objMachineView.menu();
                case "3":
//                    objRentView.menu();
            }
        }while (!Objects.equals(option, "4"));
    }
}