package com.uns.template.model.localization.gui;

import com.uns.template.model.localization.Locale;
import com.uns.template.model.utils.Base;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * created by kmluns
 **/
@Document
@Accessors(chain = true)
public class GuiComponent extends Base {

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private GuiElement guiElement;

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    @Indexed
    private Locale locale;


    public GuiComponent(){

    }

    public GuiComponent(String code, GuiElement guiElement, String text, Locale locale){
        this.code = code;
        this.guiElement = guiElement;
        this.text = text;
        this.locale = locale;
    }


}
