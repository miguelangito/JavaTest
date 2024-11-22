package com.gestionSystem.models;

import com.gestionSystem.persistence.DAO.Client;
import com.gestionSystem.persistence.DAO.Machine;
import com.gestionSystem.persistence.DAO.Rent;
import com.gestionSystem.persistence.database.CRUD;
import com.gestionSystem.persistence.database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentModel implements CRUD {


    public Object insert(Object object) {

        //1. Open connection
        Connection objConnection = ConfigDB.openConnection();

        //2. Initialize object
        Rent objRent = (Rent) object;

        try {

            //3. Create sql
            String sql = "INSERT INTO rent(rent_start_date,rent_finish_date,client_id,machine_id,is_active) VALUES(?,?,?,?,?)";

            //4. Prepare the Statement
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Assign the ???
            objPreparedStatement.setDate(1, objRent.getRent_start_date());
            objPreparedStatement.setDate(2, objRent.getRent_finish_date());
            objPreparedStatement.setInt(3, objRent.getClient_id());
            objPreparedStatement.setInt(4, objRent.getMachine_id());
            objPreparedStatement.setBoolean(5, true);

            int machineId = objRent.getMachine_id();

            String updateSql = "UPDATE machine SET status = 'RENTED' WHERE machine_id = ?";

            try (PreparedStatement updateStatement = objConnection.prepareStatement(updateSql)) {
                updateStatement.setInt(1, machineId);
                updateStatement.executeUpdate();
            }

            objConnection.commit();

            //6. Execute the Query
            objPreparedStatement.execute();

            //7. Get the results
            ResultSet objResult = objPreparedStatement.getGeneratedKeys();

            while (objResult.next()) {
                objRent.setId(objResult.getInt(1));
            }

            objPreparedStatement.close();
            JOptionPane.showMessageDialog(null, "-- Rent Insertion successful --");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "-- Error adding rent -- " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objRent;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> rentList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM rent INNER JOIN client on client.id = rent.client_id WHERE rent.is_active = true;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Client objClient = new Client();
                Rent objRent = new Rent();

                objRent.setRent_start_date(objResult.getDate("rent.rent_start_date"));
                objRent.setRent_finish_date(objResult.getDate("rent.rent_finish_date"));
                objRent.setIs_active(objResult.getBoolean("rent.is_active"));

                objClient.setName(objResult.getString("client.name"));
                objClient.setEmail(objResult.getString("client.email"));

                objRent.setObjClient(objClient);

                rentList.add(objRent);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return rentList;
    }

    public List<Object> findAllWithAllStatus() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> rentList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM rent INNER JOIN client on client.id = rent.client_id;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Client objClient = new Client();
                Rent objRent = new Rent();

                objRent.setRent_start_date(objResult.getDate("rent.rent_start_date"));
                objRent.setRent_finish_date(objResult.getDate("rent.rent_finish_date"));
                objRent.setIs_active(objResult.getBoolean("rent.is_active"));

                objClient.setName(objResult.getString("client.name"));
                objClient.setEmail(objResult.getString("client.email"));

                objRent.setObjClient(objClient);

                rentList.add(objRent);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return rentList;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        Rent objRent = (Rent) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE rent SET is_active = ?, ";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setBoolean(1,false);

            int totalRowsAffected = objPrepare.executeUpdate();

            if (totalRowsAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"The Rent was Updated successfully");
            }
            int machineId = objRent.getMachine_id();

            String updateSql = "UPDATE machine SET status = 'AVAILABLE' WHERE machine_id = ?";

            try (PreparedStatement updateStatement = objConnection.prepareStatement(updateSql)) {
                updateStatement.setInt(1, machineId);
                updateStatement.executeUpdate();
            }

            objConnection.commit();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return isUpdated;
    }

    @Override
    public void delete(Object object) {

    }


    @Override
    public Object findById(int id) {
        return null;
    }
}
