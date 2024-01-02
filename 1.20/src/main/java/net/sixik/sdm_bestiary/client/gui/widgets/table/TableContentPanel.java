package net.sixik.sdm_bestiary.client.gui.widgets.table;

import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.icon.Icons;
import dev.ftb.mods.ftblibrary.ui.Button;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.Theme;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.info.HeaderInfo;
import net.sixik.sdm_bestiary.api.content.info.TextInfo;
import net.sixik.sdm_bestiary.api.content.info.table.TableCategory;
import net.sixik.sdm_bestiary.api.content.info.table.TableContent;
import net.sixik.sdm_bestiary.client.gui.widgets.TablePanel;
import net.sixik.sdm_bestiary.client.gui.widgets.TextPanel;

import java.util.ArrayList;
import java.util.List;

public class TableContentPanel extends Panel {
    public TableCategory tableCategory;
    public TablePanel tablePanel;
    public TableContentPanel(TablePanel panel, TableCategory contentList) {
        super(panel);
        this.tableCategory = contentList;
        this.tablePanel = panel;
        setSize(panel.width, 20);
    }

    @Override
    public void addWidgets() {
        for(TableContent d1 : tableCategory.contentList){
//            Button b = new Button(this, d1.text, Icons.ACCEPT) {
//                @Override
//                public void onClicked(MouseButton mouseButton) {
//
//                }
//            };
//            b.setSize(20,20);
            TextPanel text = new TextPanel(this, new HeaderInfo(s -> {s.text = Component.literal("BLAT RABOTAI"); s.setSize(10,10);
                s.isDrawBackGround = true;
            }));
//            add(b);
            add(text);
        }
    }

    @Override
    public void alignWidgets() {
        widgets.forEach(s -> {
            if(s instanceof Button button){
                button.setPos(0, 0);
            }
            if(s instanceof TextPanel panel){
                panel.setPos(0,0);
            }
        });
    }

    @Override
    public void drawOffsetBackground(GuiGraphics graphics, Theme theme, int x, int y, int w, int h) {
        super.drawOffsetBackground(graphics, theme, x, y, w, h);
        if(h > Minecraft.getInstance().font.lineHeight)
            theme.drawString(graphics, tableCategory.text, x,y + ((h / 2) / 2));
        else
            theme.drawString(graphics, tableCategory.text, x,y);
    }

    @Override
    public void drawBackground(GuiGraphics graphics, Theme theme, int x, int y, int w, int h) {
        super.drawBackground(graphics, theme, x, y, w, h);
        Color4I.rgb(60,60,60).draw(graphics,x,y,w,h);
    }
}
