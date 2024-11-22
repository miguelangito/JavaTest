package com.gestionSystem.controllers;

import com.gestionSystem.models.ClientModel;
import com.gestionSystem.models.MachineModel;
import com.gestionSystem.persistence.DAO.Client;
import com.gestionSystem.persistence.DAO.Machine;

import javax.swing.*;
import java.util.List;

public class MachineController {
    MachineModel objMachineModel= new MachineModel();

    public void create() {
        Machine objMachine = new Machine();
        String model = JOptionPane.showInputDialog("Insert Machine Model");
        String inputInt = JOptionPane.showInputDialog("Insert Machine Serial Number");

        int serial_number = Integer.parseInt(inputInt);

        objMachine.setModel(model);
        objMachine.setSerialNumber(serial_number);

        objMachineModel.insert(objMachine);

    }

    public static MachineModel instanceModel(){
        return new MachineModel();
    }

    public void findAll() {
        String list = findAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String findAll(List<Object> list) {
        String listString = " -- Machine List -- \n";

        for (Object temp : list) {
            Machine objMachine = (Machine) temp;
            listString += objMachine.toString() + "\n";
        }
        return listString;
    }

}
