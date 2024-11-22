package com.gestionSystem.views;

import com.gestionSystem.controllers.ClientController;
import com.gestionSystem.controllers.MachineController;

import javax.swing.*;
import java.util.Objects;

public class MachineView {
    MachineController objMachineController = new MachineController();
    public void menu(){
        String option;
        do {
            JOptionPane.showMessageDialog(null,"Machine Administrator");
            option = JOptionPane.showInputDialog("""
                                Chose an option
                                1. Add a new Machine.
                                2. List all Machines.
                                3. Exit.
                                """);
            switch (option){
                case "1":
                    objMachineController.create();
                case "2":
                    objMachineController.findAll();
            }
        }while(!Objects.equals(option, "3"));
    }
}
