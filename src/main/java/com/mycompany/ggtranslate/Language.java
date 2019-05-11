/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ggtranslate;

/**
 *
 * @author VuDuc
 */
public class Language {
    String language;
    String acronym;

    public Language(String language, String acronym) {
        this.language = language;
        this.acronym = acronym;
    }

    public String getLanguage() {
        return language;
    }

    public String getAcronym() {
        return acronym;
    }
    
}
