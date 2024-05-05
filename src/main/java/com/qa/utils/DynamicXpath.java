package com.qa.utils;

import com.qa.enums.Panel;

public class DynamicXpath {


    public static String getLeftPanelXpath(Panel panel){
        return "//span[normalize-space()='replace']"
                .replace("replace",panel.getPanelOptionText());
    }
}
