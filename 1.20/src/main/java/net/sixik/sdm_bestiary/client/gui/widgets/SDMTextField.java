package net.sixik.sdm_bestiary.client.gui.widgets;

import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.TextField;
import net.sixik.sdm_bestiary.api.content.IInfoContent;

public class SDMTextField extends TextField {

    public IInfoContent infoContent;
    public SDMTextField(Panel panel,IInfoContent infoContent) {
        super(panel);
        this.infoContent = infoContent;
    }

}
