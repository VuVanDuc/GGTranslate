/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ggtranslate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VuDuc
 */
public class LanguageDAO {
    DatabaseHelper databaseHelper;
    Connection con;

    public LanguageDAO() {
        try {
            databaseHelper = new DatabaseHelper();
            con = databaseHelper.openConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Language> getLanguageList(){
        ArrayList<Language> list = new ArrayList<>();
        if(con != null){
            try {
                String querry = "SELECT * FROM language_acronym";
                PreparedStatement ps = con.prepareStatement(querry);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String acronym = rs.getString(1);
                    String language = rs.getString(2);
                    Language l = new Language(language, acronym);
                    list.add(l);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            databaseHelper.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
