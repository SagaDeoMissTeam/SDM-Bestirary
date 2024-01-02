package net.sixik.sdm_bestiary.client.content;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.Theme;
import dev.ftb.mods.ftblibrary.ui.Widget;
import net.minecraft.network.chat.Component;

public class Text extends Widget {
    public Component text;
    public Text(Panel p, Component text) {
        super(p);
        this.text = text;
    }
    public Text(Panel p, Component text, int x, int y) {
        super(p);
        this.text = text;
        setPos(x,y);
    }

    @Override
    public void draw(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        super.draw(graphics, theme, x, y, w, h);
        theme.drawString(graphics,text,x,y);
    }
}
