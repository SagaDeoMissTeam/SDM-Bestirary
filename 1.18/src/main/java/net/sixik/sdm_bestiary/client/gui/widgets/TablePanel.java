package net.sixik.sdm_bestiary.client.gui.widgets;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.Theme;
import dev.ftb.mods.ftblibrary.ui.Widget;
import dev.ftb.mods.ftblibrary.util.StringUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.info.TableInfo;
import net.sixik.sdm_bestiary.api.content.info.table.TableCategory;
import net.sixik.sdm_bestiary.client.gui.widgets.table.TableContentPanel;

import java.util.ArrayList;
import java.util.List;

public class TablePanel extends Panel {
    public TableInfo tableInfo;
    public int posY = 0;
    public Panel mainPanel;

    public List<Widget> widgetList = new ArrayList<>();
    public TablePanel(Panel panel, TableInfo tableInfo) {
        super(panel);
        this.tableInfo = tableInfo;
    }

    @Override
    public void addWidgets() {
        for(TableCategory category : tableInfo.categoryList){
            TableContentPanel tableContentPanel = new TableContentPanel(this, category);
            add(tableContentPanel);
            widgetList.add(tableContentPanel);
        }
    }

    @Override
    public void alignWidgets() {
        widgetList.forEach(s -> {
            s.setPos(0, posY);
            posY += s.height;
        });
    }

    @Override
    public void draw(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        super.draw(graphics, theme, x, y, w, h);
    }

    @Override
    public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        super.drawBackground(graphics, theme, x, y, w, h);
        Color4I.rgb(20,20,20).draw(graphics, x, y, w, h);
    }
}


//        for(TableCategory s : tableInfo.categoryList){
//
//            mainPanel = new Panel(this) {
//                int posYP = 0;
//                @Override
//                public void addWidgets() {
//                    s.contentList.forEach(content -> {
//                        Panel contentPanel = new Panel(this) {
//                            @Override
//                            public void addWidgets() {
//                                Panel contentPanel = new Panel(this) {
//                                    @Override
//                                    public void addWidgets() {
//
//                                    }
//
//                                    @Override
//                                    public void alignWidgets() {
//
//                                    }
//
//                                    @Override
//                                    public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
//                                        super.drawBackground(graphics, theme, x, y, w, h);
//                                        Color4I.rgb(80,80,80).draw(graphics,x,y, w,h);
//                                    }
//                                };
//                                contentPanel.setSize(tableInfo.sizeContent, 20);
//                                TablePanel.this.mainPanel.setHeight(TablePanel.this.mainPanel.height + 400);
//                                add(contentPanel);
//                            }
//
//                            @Override
//                            public void alignWidgets() {
//                                widgets.forEach(s -> {
//                                    s.setPos(tableInfo.sizeTittle,0);
//                                });
//                            }
//
//                            @Override
//                            public void drawOffsetBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
//                                super.drawOffsetBackground(graphics, theme, x, y, w, h);
//                                theme.drawString(graphics, content.text, x + tableInfo.sizeTittle,y);
//                            }
//                        };
//                        contentPanel.setSize(parent.width, Minecraft.getInstance().font.lineHeight);
//                        add(contentPanel);
//                    });
//                }
//
//                @Override
//                public void alignWidgets() {
//                    for (Widget s : widgets){
//                        s.setPos(0,posYP);
//                        posYP += Minecraft.getInstance().font.lineHeight;
//                        int size = 0;
//                        if(s instanceof Panel panel1){
//                            size = panel1.getWidgets().stream().mapToInt(f -> f.height).sum();
//                        }
//                        setHeight(getHeight() + size);
//                    }
//                }
//
//                @Override
//                public void drawOffsetBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
//                    super.drawOffsetBackground(graphics, theme, x, y, w, h);
//                    if(h > Minecraft.getInstance().font.lineHeight)
//                        theme.drawString(graphics, s.text, x,y + ((h / 2) / 2));
//                    else
//                        theme.drawString(graphics, s.text, x,y);
//                }
//
//                @Override
//                public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
//                    super.drawBackground(graphics, theme, x, y, w, h);
//                    Color4I.rgb(60,60,60).draw(graphics,x,y,w,h);
//                }
//            };
//            mainPanel.setSize(tableInfo.sizeTittle + tableInfo.sizeContent, mainPanel.getHeight());
//            mainPanel.setPos(TablePanel.this.tableInfo.sizeTittle + 20, 0);
//            add(mainPanel);
//            widgetList.add(mainPanel);
//        };