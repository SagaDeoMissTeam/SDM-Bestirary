package net.sixik.sdm_bestiary.client.gui.widgets;

import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.icon.Icons;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.Theme;
import net.minecraft.client.gui.GuiGraphics;
import net.sixik.sdm_bestiary.api.content.IInfoContent;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import net.sixik.sdm_bestiary.api.content.info.ImageInfo;

import javax.annotation.Nullable;

public class ImagePanel extends Panel {

    public ISimpleInfoContent<?> content;
    public @Nullable Icon icon = null;
    public ImagePanel(Panel panel, ISimpleInfoContent<?> content) {
        super(panel);
        this.content = content;
        if(content instanceof ImageInfo info){
            this.icon = info.icon;
            setSize(info.weight, info.height);
        }
    }

    @Override
    public void addWidgets() {

    }

    @Override
    public void alignWidgets() {

    }

    @Override
    public void drawBackground(GuiGraphics graphics, Theme theme, int x, int y, int w, int h) {
        super.drawBackground(graphics, theme, x, y, w, h);
        if(content.isDrawBackground()){
            Color4I.rgb(20,20,20).draw(graphics,x,y,w,h);
        }
    }

    @Override
    public void draw(GuiGraphics graphics, Theme theme, int x, int y, int w, int h) {
        super.draw(graphics, theme, x, y, w, h);
        if(icon != null){
            icon.draw(graphics,(x), y , w, h);
        }
    }
}
