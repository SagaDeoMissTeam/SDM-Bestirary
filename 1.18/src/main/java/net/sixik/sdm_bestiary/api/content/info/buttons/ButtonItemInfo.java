package net.sixik.sdm_bestiary.api.content.info.buttons;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.ui.Button;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@ZenRegister
@Document("mods/sdm/bestiary/api/content/info/buttons/ButtonItemInfo")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.ButtonItemInfo")
public class ButtonItemInfo implements ISimpleInfoContent<ButtonItemInfo> {
    @ZenCodeType.Field
    public IItemStack item;

    /**
     * A link to a tab by their ID or page link on the site.
     */
    @ZenCodeType.Field
    public String clickURL = "";

    @ZenCodeType.Field
    public int x = 0;
    @ZenCodeType.Field
    public int y = 0;

    /**
     * Weight
     */
    @ZenCodeType.Field
    public int w = 80;

    /**
     * Height
     */
    @ZenCodeType.Field
    public int h = 16;

    @ZenCodeType.Field
    public List<Component> componentText = new ArrayList<>();

    public Consumer<ButtonItemInfo> consumer = s -> {};

    @ZenCodeType.Constructor
    public ButtonItemInfo(Consumer<ButtonItemInfo> consumer){
        this.consumer = consumer;
        apply();
    }

    /**
     * @param url - A link to a tab or page on the site.
     */
    @ZenCodeType.Method
    public ButtonItemInfo setURL(String url){
        this.clickURL = url;
        return this;
    }

    @Override
    public ISimpleInfoContent<ButtonItemInfo> setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public ISimpleInfoContent<ButtonItemInfo> addPos(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Consumer<ButtonItemInfo> getConsumer() {
        return consumer;
    }

    @Override
    public void apply() {
        consumer.accept(this);
    }


    @Override
    public void setSize(int w, int h) {
        this.w = w;
        this.h = h;
    }


    @Override
    public boolean isDrawBackground() {
        return false;
    }
}
