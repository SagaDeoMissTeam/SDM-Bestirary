package net.sixik.sdm_bestiary.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.ftb.mods.ftblibrary.icon.ItemIcon;
import dev.ftb.mods.ftblibrary.ui.*;
import dev.ftb.mods.ftblibrary.ui.input.Key;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import dev.ftb.mods.ftblibrary.ui.misc.NordColors;
import dev.ftb.mods.ftblibrary.util.StringUtils;
import dev.ftb.mods.ftblibrary.util.TooltipList;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.sixik.sdm_bestiary.api.content.*;
import net.sixik.sdm_bestiary.api.content.graphics.DrawColor;
import net.sixik.sdm_bestiary.api.content.graphics.DrawReact;
import net.sixik.sdm_bestiary.api.content.info.*;
import net.sixik.sdm_bestiary.api.content.info.buttons.ButtonInfo;
import net.sixik.sdm_bestiary.api.content.info.buttons.ButtonItemInfo;
import net.sixik.sdm_bestiary.api.content.tab.Group;
import net.sixik.sdm_bestiary.api.content.tab.TextFieldTab;
import net.sixik.sdm_bestiary.client.SDMBestiaryClient;
import net.sixik.sdm_bestiary.client.content.ListTabButton;
import net.sixik.sdm_bestiary.client.gui.widgets.ImagePanel;
import net.sixik.sdm_bestiary.client.gui.widgets.SDMTextField;
import net.sixik.sdm_bestiary.client.gui.widgets.TablePanel;
import net.sixik.sdm_bestiary.client.gui.widgets.TextPanel;
import net.sixik.sdm_bestiary.client.utils.RenderHelper;
import net.sixik.sdm_bestiary.data.DataBase;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BestiaryScreen extends BaseScreen implements NordColors {

    public InfoTabPanel infoTabPanel;
    public InfoPanel infoPanel;

    public @Nullable InfoContent selectedContent = null;


    public TextBox search;
    public Button favorite;
    public List<String> listOfSearch = new ArrayList<>();



    public BestiaryScreen(){
        if(!DataBase.TABCONTENT.isEmpty() && selectedContent == null){
            for (Map.Entry<String, IInfoTabContent> entry : DataBase.TABCONTENT.entrySet()) {
                String f = entry.getKey();
                IInfoTabContent s = entry.getValue();
                s.setComponent(s.getComponent().copy().withStyle(ChatFormatting.GOLD));
                selectedContent = s.getInfoContent();
                deselectAll(selectedContent);
                break;
            }
        }
    }

    public void collapseGroup(Group group){
        if(DataBase.TABCONTENT.containsKey(group.id)){
            ((Group)DataBase.TABCONTENT.get(group.id)).collapse = !((Group)DataBase.TABCONTENT.get(group.id)).collapse;
        }
    }

    public void collapseGroup(){
        DataBase.TABCONTENT.forEach((s,k) -> {
            if(k instanceof Group group){
                group.collapse = false;
            }
        });
    }

    public void deselectAll(InfoContent selectedContent){
        if (selectedContent != null && !DataBase.TABCONTENT.isEmpty()){
            DataBase.TABCONTENT.forEach((f,s) -> {
                if(s.getInfoContent() != selectedContent)
                    s.setComponent(s.getComponent().copy().withStyle(ChatFormatting.WHITE));
            });
        }
    }

    @Override
    public boolean keyPressed(Key key) {
        if(key.keyCode != GLFW.GLFW_KEY_ESCAPE && !search.isFocused()) return true;
        return super.keyPressed(key);
    }



    public static void refreshIfOpen() {
        if (Minecraft.getInstance().screen instanceof ScreenWrapper w && w.getGui() instanceof BestiaryScreen mts) {
            mts.refreshWidgets();
        }
    }

    @Override
    public boolean onInit() {
        super.onInit();
        setWidth(getScreen().getGuiScaledWidth() * 4 / 5);
        setHeight(getScreen().getGuiScaledHeight() * 4 / 5);


        return true;
    }

    @Override
    public void addWidgets() {
        search = new TextBox(this) {
            @Override
            public void onEnterPressed() {

                if(!search.getText().isEmpty()) {
                    if(listOfSearch.size() > 10) listOfSearch.remove(0);
                    listOfSearch.remove(search.getText());
                    listOfSearch.add(search.getText());
                }
                infoTabPanel.refreshWidgets();
            }

            @Override
            public boolean mousePressed(MouseButton button) {
                if(button.isRight() && search.isMouseOver() && !listOfSearch.isEmpty()){
                    List<ContextMenuItem> contextMenuItems = new ArrayList<>();
                    listOfSearch.forEach(s -> {
                        contextMenuItems.add(new ContextMenuItem(new TextComponent(s), ItemIcon.getItemIcon(ItemStack.EMPTY), () -> {
                            search.setText(s);
                            infoTabPanel.refreshWidgets();
                        }));
                    });
                    ContextMenu contextMenu = new ContextMenu(BestiaryScreen.this, contextMenuItems);

                    BestiaryScreen.this.openContextMenu(contextMenu);
                }

                if(!button.isRight())
                    return super.mousePressed(button);
                return false;
            }


        };
        add(search);
        add(infoTabPanel = new InfoTabPanel());
        add(infoPanel = new InfoPanel());
    }

    @Override
    public void alignWidgets() {
        super.alignWidgets();
        search.setPosAndSize(1,5, 120, 12);
        infoTabPanel.setPosAndSize(1,22, Math.max(infoTabPanel.width, 120), height - 23);
        infoPanel.setPosAndSize(1 + Math.max(infoTabPanel.width, 120), 22, width - (2 + Math.max(infoTabPanel.width, 120)), height - 23);
    }

    @Override
    public void drawForeground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        super.drawForeground(graphics, theme, x, y, w, h);
        if(DataBase.isShowTittle){
            theme.drawString(graphics, DataBase.tittle, (x + w / 2) - (DataBase.tittle.getString().length() / 2),y + 8);
        }
    }

    @Override
    public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
        super.drawBackground(graphics, theme, x, y, w, h);
        SDMBestiaryClient.getTheme().getBackground().draw(graphics,x,y,w,h);
        GuiHelper.drawHollowRect(graphics,x,y,w,h,SDMBestiaryClient.getTheme().getReact(), false);
    }

    
    @Override
    public void onClosed() {
        super.onClosed();
    }

    public class InfoTabPanel extends Panel{
        public Button button;
        public List<Widget> buttons = new ArrayList<>();
        public InfoTabPanel() {
            super(BestiaryScreen.this);
        }



        @Override
        public void addWidgets() {
            DataBase.TABCONTENT.forEach((s,k) -> {
                if(k instanceof TextFieldTab panel){
                    TextField field = new TextField(this).setText(panel.text);
                    if(!buttons.contains(field))
                        buttons.add(field);
                    add(field);
                }
                else {
                    ListTabButton button = new ListTabButton(this, k);
                    if(!buttons.contains(button))
                        buttons.add(button);
                    add(button);
                }
            });
        }

        @Override
        public void add(Widget widget) {
            if(BestiaryScreen.this.search.getText().isEmpty() || widget.getTitle().getString().toLowerCase().contains(BestiaryScreen.this.search.getText().toLowerCase())){
                super.add(widget);
            }
        }


        @Override
        public void alignWidgets() {
            align(new WidgetLayout.Vertical(1, 2, 1));

            width = 120;
            for (Widget widget : widgets) {
                width = Math.max(width, widget.width);
            }

            for (Widget widget : widgets) {
                widget.setX(1);
                widget.setWidth(width - 2);
            }
        }

        @Override
        public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
            super.drawBackground(graphics, theme, x, y, w, h);

            GuiHelper.drawHollowRect(graphics, x,y,w,h,SDMBestiaryClient.getTheme().getReact(), false);
        }
    }

    public class InfoPanel extends BlankPanel{
        public List<IInfoContent> contentList = new ArrayList<>();
        public List<Widget> widgets = new ArrayList<>();
        public List<IInfoContent> contents = new ArrayList<>();
        public List<ISimpleGraphicsContent> graphicsContents = new ArrayList<>();
        public List<EntityInfo> entityInfos = new ArrayList<>();
        public int posY = 0;

        public InfoPanel() {
            super(BestiaryScreen.this);
            if(BestiaryScreen.this.selectedContent != null) {
                contentList = BestiaryScreen.this.selectedContent.content;
                BestiaryScreen.this.selectedContent.weight = parent.width - (2 + Math.max(infoTabPanel.width, 120));
            }
            else contentList = new ArrayList<>();
        }

        protected IInfoContent addThemeWidget(IInfoContent content){
            if(content instanceof HeaderInfo info){
                info.addPos(0, posY);
                this.contents.add(info);

                TextPanel header = new TextPanel(this, info);
                add(header);
                widgets.add(header);

            }
            if(content instanceof TextInfo info){
                info.addPos(0, posY);
                this.contents.add(info);
                TextPanel header = new TextPanel(this, info);
                add(header);
                widgets.add(header);
            }
//            if(content instanceof HeaderInfo info){
//                info.addPos(0,posY);
//                this.contents.add(info);
//
//                SDMTextField field = new SDMTextField(this, info);
//                add(field);
//                widgets.add(field);
//            }
//            if(content instanceof TextInfo info){
//                info.addPos(0, posY);
//                this.contents.add(info);
//                Component cmp = Component.empty();
//                for (Component component: info.componentBooleanMap) {
//                    cmp = cmp.copy().append(component);
//                }
//                SDMTextField field = new SDMTextField(this, info);
//                field.component = cmp;
//                add(field);
//                widgets.add(field);
//            }
            if(content instanceof ImageInfo info){
                info.addPos(0, posY);
                this.contents.add(info);
                ImagePanel image = new ImagePanel(this, info);
                add(image);
                widgets.add(image);
            }
            if(content instanceof ButtonInfo info){
                info.addPos(0,posY);
                this.contents.add(info);
                SimpleTextButton button = new SimpleTextButton(this, info.text, info.icon) {
                    @Override
                    public void onClicked(MouseButton mouseButton) {
                        if(mouseButton.isLeft()){
                            if(DataBase.TABCONTENT.containsKey(info.clickURL)){
                                DataBase.TABCONTENT.get(info.clickURL).setComponent(DataBase.TABCONTENT.get(info.clickURL).getComponent().copy().withStyle(ChatFormatting.GOLD));
                                BestiaryScreen.this.selectedContent = DataBase.TABCONTENT.get(info.clickURL).getInfoContent();
                                deselectAll(selectedContent);
                                BestiaryScreen.this.refreshWidgets();
                            }
                        }
                    }
                };
                button.setSize(info.w, info.h);
                button.setPos(info.x, info.y);
                add(button);
                widgets.add(button);
            }
            if(content instanceof ButtonItemInfo info){
                info.addPos(0,posY);
                this.contents.add(info);
                SimpleTextButton button = new SimpleTextButton(this, info.item.getHoverName(), ItemIcon.getItemIcon(info.item.getInternal())) {
                    @Override
                    public void onClicked(MouseButton mouseButton) {
                        if(mouseButton.isLeft()){
                            if(DataBase.TABCONTENT.containsKey(info.clickURL)){
                                DataBase.TABCONTENT.get(info.clickURL).setComponent(DataBase.TABCONTENT.get(info.clickURL).getComponent().copy().withStyle(ChatFormatting.GOLD));
                                BestiaryScreen.this.selectedContent = DataBase.TABCONTENT.get(info.clickURL).getInfoContent();
                                deselectAll(selectedContent);
                                BestiaryScreen.this.refreshWidgets();
                            }
                        }
                    }

                    @Override
                    public void addMouseOverText(TooltipList list) {
                        info.componentText.forEach(list::add);
                    }

                    @Override
                    public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {

                    }
                };
                button.setSize(info.w + info.item.getDisplayName().getString().length(), info.h);
                button.setPos(info.x, info.y);
                add(button);
                widgets.add(button);
            }
            if(content instanceof TableInfo info){
                info.addPos(0,posY);
                this.contents.add(info);
                TablePanel panel = new TablePanel(this, info);
                panel.setSize(info.sizeTittle + info.sizeContent, panel.height + info.h);
                panel.setPos(info.x, info.y);
                add(panel);
                widgets.add(panel);
            }
            if(content instanceof EntityInfo info){
                info.addPos(0,posY);
                this.contents.add(info);
                entityInfos.add(info);
            }
            return content;
        }


        @Override
        public void addWidgets() {
            if(!contentList.isEmpty())
                contentList.forEach(s -> {
                    if(s instanceof ISimpleInfoContent)
                        addThemeWidget(s);
                    if(s instanceof ISimpleGraphicsContent graphicsContent){
                        graphicsContents.add(graphicsContent);
                    }
                });
        }

        @Override
        public void alignWidgets() {
            widgets.forEach(s -> {
                if(s instanceof TextPanel panel){
                    if(panel.infoContent instanceof HeaderInfo info){
                        if (info.isCenter) {
                            panel.setPosAndSize((this.height / 2) + info.x, posY + info.y, info.w, info.h);
                            posY += BestiaryScreen.this.selectedContent.space;
                        } else {
                            panel.setPosAndSize(info.x, posY + info.y, info.w, info.h);
                            posY += BestiaryScreen.this.selectedContent.space;
                        }
                    } else if(panel.infoContent instanceof TextInfo info){
                        s.setPosAndSize(info.x, posY + info.y, info.w, info.h);
                        posY += BestiaryScreen.this.selectedContent.space + info.getEndY();
                    }
                }
                if(s instanceof SDMTextField panel){
                    if(panel.infoContent instanceof HeaderInfo info){
                        if (info.isCenter) {
                            panel.setPosAndSize((this.height / 2) + info.x, posY + info.y, info.w, info.h);
                            posY += BestiaryScreen.this.selectedContent.space;
                        } else {
                            panel.setPosAndSize(info.x, posY + info.y, info.w, info.h);
                            posY += BestiaryScreen.this.selectedContent.space;
                        }
                    } else if(panel.infoContent instanceof TextInfo info){
                        s.setPosAndSize(info.x, posY + info.y, info.w, info.h);
                        posY += BestiaryScreen.this.selectedContent.space + info.getEndY();
                    }
                }
                if(s instanceof ImagePanel panel){
                    panel.setPos(panel.content.getX(), panel.content.getY());
                    posY += BestiaryScreen.this.selectedContent.space;
                }
                if(s instanceof Button panel){
                    panel.setPos(panel.posX, panel.posY + posY);
                    posY+= panel.height + selectedContent.space;
                }
                if(s instanceof TablePanel panel){
                    panel.setPos(panel.posX, panel.posY + posY);
                    posY += panel.height + selectedContent.space;
                }
            });
        }

        @Override
        public void drawOffsetBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
            super.drawOffsetBackground(graphics, theme, x, y, w, h);
            for (ISimpleGraphicsContent d1: graphicsContents) {
                if(d1 instanceof DrawColor drawColor && drawColor.isOffset){
                    drawColor.color.draw(graphics,x + drawColor.x, y + drawColor.y, drawColor.weight, drawColor.height);
                }
                if(d1 instanceof DrawReact drawReact && drawReact.isOffset && !drawReact.isGradient){
                    GuiHelper.drawHollowRect(graphics,x + drawReact.x, y + drawReact.y, drawReact.weight, drawReact.height, drawReact.color, drawReact.roundEdges);
                } else if(d1 instanceof DrawReact drawReact && drawReact.isOffset){
                    GuiHelper.drawRectWithShade(graphics,x + drawReact.x, y + drawReact.y, drawReact.weight, drawReact.height,drawReact.color, drawReact.strangeGradient);
                }
            }

            entityInfos.forEach(s -> {
                LivingEntity entity = RenderHelper.getEntity(s.entityType);
                if(entity != null)
                    RenderHelper.renderEntity(graphics,x + s.x,y + s.y,s.size,s.yaw, 0, entity);
            });
        }

        @Override
        public void drawWidget(PoseStack graphics, Theme theme, Widget widget, int index, int x, int y, int w, int h) {
            super.drawWidget(graphics, theme, widget, index, x, y, w, h);
        }

        @Override
        public void draw(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
            super.draw(graphics,theme,x,y,w,h);
            for (ISimpleGraphicsContent d1: graphicsContents) {
                if(d1 instanceof DrawColor drawColor && !drawColor.isOffset){
                    drawColor.color.draw(graphics,x + drawColor.x, y + drawColor.y, drawColor.weight, drawColor.height);
                }
                if(d1 instanceof DrawReact drawReact && !drawReact.isOffset && !drawReact.isGradient){
                    GuiHelper.drawHollowRect(graphics,x + drawReact.x, y + drawReact.y, drawReact.weight, drawReact.height, drawReact.color, drawReact.roundEdges);
                } else if(d1 instanceof DrawReact drawReact && !drawReact.isOffset){
                    GuiHelper.drawRectWithShade(graphics,x + drawReact.x, y + drawReact.y, drawReact.weight, drawReact.height,drawReact.color, drawReact.strangeGradient);
                }
            }
        }

        @Override
        public void drawBackground(PoseStack graphics, Theme theme, int x, int y, int w, int h) {
            super.drawBackground(graphics, theme, x, y, w, h);

            GuiHelper.drawHollowRect(graphics, x,y,w,h,SDMBestiaryClient.getTheme().getReact(), false);
        }
    }
}
