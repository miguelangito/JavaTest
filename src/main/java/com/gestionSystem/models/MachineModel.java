package com.gestionSystem.models;

import com.gestionSystem.persistence.DAO.Machine;
import com.gestionSystem.persistence.database.CRUD;
import com.gestionSystem.persistence.database.ConfigDB;
import com.gestionSystem.utils.Status;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MachineModel implements CRUD {
    @Override
    public Object insert(Object object) {

        //1. Open connection
        Connection objConnection = ConfigDB.openConnection();

        //2. Initialize object
        Machine objMachine = (Machine) object;

        try {

            //3. Create sql
            String sql = "INSERT INTO machine(model,serial_number,status) VALUES(?,?,?)";

            //4. Prepare the Statement
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Assign the ???
            objPreparedStatement.setString(1, objMachine.getModel());
            objPreparedStatement.setInt(2, objMachine.getSerialNumber());
            objPreparedStatement.setString(3, Status.AVAILABLE.name());

            //6. Execute the Query
            objPreparedStatement.execute();

            //7. Get the results
            ResultSet objResult = objPreparedStatement.getGeneratedKeys();

            while (objResult.next()) {
                objMachine.setId(objResult.getInt(1));
            }

            objPreparedStatement.close();
            JOptionPane.showMessageDialog(null, "-- Machine Insertion successful --");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "-- Error adding Client -- " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objMachine;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> machineList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM machine ORDER BY machine.id ASC";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Machine objMachine = new Machine();

                objMachine.setModel(objResult.getString("machine.model"));
                objMachine.setSerialNumber(objResult.getInt("machine.serial_number"));

                machineList.add(objMachine);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return machineList;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
