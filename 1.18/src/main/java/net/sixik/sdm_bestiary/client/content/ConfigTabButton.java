package net.sixik.sdm_bestiary.client.content;

import dev.ftb.mods.ftblibrary.ui.Button;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import net.sixik.sdm_bestiary.api.content.IInfoTabContent;
import net.sixik.sdm_bestiary.api.content.tab.Group;

public class ConfigTabButton extends Button {
    public IInfoTabContent content;
    public Group group;
    public ConfigTabButton(Panel panel, IInfoTabContent content) {
        super(panel, content.getComponent(), content.getIcon());
        this.content = content;
        this.group = content.getGroup();
    }

    @Override
    public void onClicked(MouseButton mouseButton) {

    }
}