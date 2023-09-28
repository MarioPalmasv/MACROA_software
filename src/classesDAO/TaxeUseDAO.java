/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAO;

import classes.TaxeUse;
import db.DbConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melan
 */
public class TaxeUseDAO implements DML<TaxeUse>{
    private Connection con;

    public TaxeUseDAO() {
        con = new DbConexion().getCon();
    }
    
    public List<TaxeUse> listarTaxeUse() {
        List<TaxeUse> lista_taxUse = new ArrayList<>();
        try {
            String sql = "SELECT * FROM taxe_use";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TaxeUse taxe = new TaxeUse();
                taxe.setTaxe_id(resultSet.getInt("taxe_id"));
                taxe.setOrder_cost_id(resultSet.getInt("order_cost_id"));
                taxe.setTaxe_use(resultSet.getInt("taxe_use_id"));
                
                lista_taxUse.add(taxe);

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return lista_taxUse;
    }
   
    @Override
    public boolean insert(TaxeUse objeto) {
        try {
            String sql = "{CALL InsertTaxeUse(?, ?)}";

            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, objeto.getOrder_cost_id());
                valores.setInt(2, objeto.getTaxe_use());

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(TaxeUse objeto) {
        try {
            String sql = "{CALL UpdateTaxeUse(?, ?, ?)}";

            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, objeto.getTaxe_id());
                valores.setInt(2, objeto.getOrder_cost_id());
                valores.setInt(3, objeto.getTaxe_use());

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean activate(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
