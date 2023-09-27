/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAO;

import classes.Taxe;
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
public class TaxeDAO {
    private Connection con;

    public TaxeDAO() {
        con = new DbConexion().getCon();
    }
    
    public List<Taxe> listarTaxe() {
        List<Taxe> lista_tax = new ArrayList<>();
        try {
            String sql = "SELECT * FROM taxe";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Taxe taxe = new Taxe();
                taxe.setTaxe_id(resultSet.getInt("taxe_id"));
                taxe.setNAME(resultSet.getString("NAME"));
                taxe.setPercentage(resultSet.getString("percentage"));
                taxe.setVALUE(resultSet.getDouble("VALUE"));
                
                lista_tax.add(taxe);

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return lista_tax;
    }
    
    public void InsertarImpuesto(Taxe taxe) {
        try {
            String sql = "{CALL InsertTaxe(?, ?, ?)}";

            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setString(1, taxe.getNAME());
                valores.setString(2, taxe.getPercentage());
                valores.setDouble(3, taxe.getVALUE());

                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarImpuesto(Taxe taxe, int id) {
        try {
            String sql = "{CALL UpdateTaxe(?, ?, ?, ?)}";

            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, id);
                valores.setString(2, taxe.getNAME());
                valores.setString(3, taxe.getPercentage());
                valores.setDouble(4, taxe.getVALUE());

                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
