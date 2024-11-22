package com.gestionSystem.models;

import com.gestionSystem.persistence.DAO.Client;
import com.gestionSystem.persistence.DAO.Rent;
import com.gestionSystem.persistence.database.CRUD;
import com.gestionSystem.persistence.database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientModel implements CRUD {

    public Object insert(Object object) {

        //1. Open connection
        Connection objConnection = ConfigDB.openConnection();

        //4. Initialize object
        Client objClient = (Client) object;

        try {

            //3. Create sql
            String sql = "INSERT INTO client(full_name,email,cellphone,direction) VALUES(?,?,?,?)";

            //4. Prepare the Statement
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Assign the ???
            objPreparedStatement.setString(1, objClient.getName());
            objPreparedStatement.setString(2, objClient.getEmail());
            objPreparedStatement.setInt(3, objClient.getCellphone());
            objPreparedStatement.setString(4, objClient.getDirection());

            //6. Execute the Query
            objPreparedStatement.execute();

            //7. Get the results
            ResultSet objResult = objPreparedStatement.getGeneratedKeys();

            while (objResult.next()) {
                objClient.setId(objResult.getInt(1));
            }

            objPreparedStatement.close();
            JOptionPane.showMessageDialog(null, "-- Client Insertion successful --");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "-- Error adding Client -- " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objClient;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> clientList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM client ORDER BY client.id ASC";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Client objClient = new Client();

                objClient.setId(objResult.getInt("client.id"));
                objClient.setName(objResult.getString("client.full_name"));
                objClient.setEmail(objResult.getString("client.email"));
                objClient.setCellphone(objResult.getInt("client.cellphone"));
                objClient.setDirection(objResult.getString("client.direction"));

                clientList.add(objClient);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return clientList;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
