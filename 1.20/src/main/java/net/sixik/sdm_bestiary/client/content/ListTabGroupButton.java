package net.sixik.sdm_bestiary.client.content;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.ui.GuiHelper;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.SimpleTextButton;
import dev.ftb.mods.ftblibrary.ui.Theme;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.tab.Group;
import net.sixik.sdm_bestiary.client.gui.BestiaryScreen;

public class ListTabGroupButton extends SimpleTextButton {
    public Group content;
    public boolean collapsed = false;
    public ListTabGroupButton(Panel panel, Group content) {
        super(panel, Component.literal("Test"), content.getIcon());
        this.content = content;
    }

    @Override
    public void onClicked(MouseButton mouseButton) {
        collapsed = !collapsed;
        setTitle(Component.literal("FTH"));
        BestiaryScreen.refreshIfOpen();
    }
}
