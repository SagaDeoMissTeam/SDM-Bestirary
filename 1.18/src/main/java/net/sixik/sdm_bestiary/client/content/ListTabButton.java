package net.sixik.sdm_bestiary.client.content;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.ui.GuiHelper;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.Theme;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import dev.ftb.mods.ftblibrary.util.TooltipList;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.IInfoTabContent;
import net.sixik.sdm_bestiary.client.gui.BestiaryScreen;

public class ListTabButton extends ListButton{
    public final IInfoTabContent content;
    public ListTabButton(BestiaryScreen.InfoTabPanel panel, IInfoTabContent content) {
        super(panel, content.getComponent(), content.getIcon());
        this.content = content;
    }

    @Override
    public void onClicked(MouseButton mouseButton) {
        if(mouseButton.isLeft()){
            if(parent.getGui() instanceof BestiaryScreen screen){
                content.setComponent(content.getComponent().copy().withStyle(ChatFormatting.GOLD));
                screen.selectedContent = content.getInfoContent();
                screen.deselectAll(screen.selectedContent);
                screen.refreshWidgets();
            }
        }
    }

    @Override
    public void addMouseOverText(TooltipList list) {
    }
    
    @Override
    public void draw(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        GuiHelper.setupDrawing();
        if (isMouseOver()) {
            Color4I.WHITE.withAlpha(40).draw(graphics, x + 1, y, w - 2, h);
        }

        if(icon != null) icon.draw(graphics, x + 2, y + 1, 12, 12);

        theme.drawString(graphics, content.getComponent(), x + 16, y + 3);
        GuiHelper.setupDrawing();
    }


    @Override
    public int getActualWidth() {

        return super.getActualWidth() + 20;
    }
}
