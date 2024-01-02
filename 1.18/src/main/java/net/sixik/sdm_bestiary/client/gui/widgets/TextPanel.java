package net.sixik.sdm_bestiary.client.gui.widgets;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.Theme;
import net.sixik.sdm_bestiary.api.content.IInfoContent;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import net.sixik.sdm_bestiary.api.content.info.HeaderInfo;
import net.sixik.sdm_bestiary.api.content.info.TextInfo;

public class TextPanel extends Panel {

    public IInfoContent infoContent;
    public TextPanel(Panel panel, IInfoContent infoContent) {
        super(panel);
        this.infoContent = infoContent;
    }

    @Override
    public void addWidgets() {

    }

    @Override
    public void alignWidgets() {

    }

    @Override
    public void draw(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        super.draw(graphics, theme, x, y, w, h);
        if(infoContent instanceof HeaderInfo info) {
            theme.drawString(graphics, info.text, x, y);
        }
        if(infoContent instanceof TextInfo info){

            int lastY = 0;
            for (int i = 0; i < info.componentBooleanMap.size(); i++){
                theme.drawString(graphics, info.componentBooleanMap.get(i), x, y + lastY);
                lastY = lastY + info.space;
            }
        }
    }


    @Override
    public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        super.drawBackground(graphics, theme, x, y, w, h);
        if(infoContent instanceof ISimpleInfoContent<?> content && content.isDrawBackground()){
            Color4I.rgb(20,20,20).draw(graphics,x - 1,y,w,h);
        }


    }
}
