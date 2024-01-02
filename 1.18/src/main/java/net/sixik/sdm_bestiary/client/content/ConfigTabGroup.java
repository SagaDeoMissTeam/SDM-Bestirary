package net.sixik.sdm_bestiary.client.content;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.ui.Button;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.SimpleTextButton;
import dev.ftb.mods.ftblibrary.ui.Theme;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import dev.ftb.mods.ftblibrary.util.TooltipList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.sixik.sdm_bestiary.api.content.tab.Group;
import net.sixik.sdm_bestiary.client.gui.BestiaryScreen;

import static dev.ftb.mods.ftblibrary.config.ui.EditConfigScreen.COLOR_BACKGROUND;

public class ConfigTabGroup extends SimpleTextButton {
    public Group content;
    public boolean collapsed = false;
    public ConfigTabGroup(Panel panel, Group content) {
        super(panel, content.getComponent(), content.getIcon());
        title = content.getComponent();
        this.content = content;
        setSize(60,20);
        setCollapsed(collapsed);
    }

    @Override
    public void onClicked(MouseButton button) {
        setCollapsed(!collapsed);
        if(parent instanceof BestiaryScreen.InfoTabPanel infoTabPanel){
            setTitle(new TextComponent("Test"));
            infoTabPanel.parent.refreshWidgets();
        }
    }

    public void setCollapsed(boolean v) {
        collapsed = v;
        setTitle(new TextComponent("").append(new TextComponent(collapsed ? "[-] " : "[v] ").withStyle(collapsed ? ChatFormatting.RED : ChatFormatting.GREEN)).append(title));
    }

//    @Override
//    public void draw(GuiGraphics matrixStack, Theme theme, int x, int y, int w, int h) {
//        COLOR_BACKGROUND.draw(matrixStack, x, y, w, h);
//        theme.drawString(matrixStack, getTitle(), x + 3, y + 2);
//        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
//
//        Color4I.GRAY.withAlpha(80).draw(matrixStack, 0, y, width, 1);
//        Color4I.GRAY.withAlpha(80).draw(matrixStack, 0, y, 1, height);
//        if (isMouseOver()) {
//            Color4I.WHITE.withAlpha(33).draw(matrixStack, x, y, w, h);
//        }
//    }


    @Override
    public void addMouseOverText(TooltipList list) {
        if (title != null) {
            list.add(title);
        }
    }
}
