/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ggtranslate;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

/**
 *
 * @author VuDuc
 */
public class TranslateAPI {
    
    public String translate(String text, String source, String target){
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate(
                        text,
                        TranslateOption.sourceLanguage(source),
                        TranslateOption.targetLanguage(target));
        return translation.getTranslatedText();
    }
}
