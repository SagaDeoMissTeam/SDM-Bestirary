package net.sixik.sdm_bestiary.api.content.info.buttons;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import org.openzen.zencode.java.ZenCodeType;


import java.util.function.Consumer;

@ZenRegister
@Document("mods/sdm/bestiary/api/content/info/buttons/ButtonInfo")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.ButtonInfo")
public class ButtonInfo implements ISimpleInfoContent<ButtonInfo> {
    @ZenCodeType.Field
    public Component text;
    @ZenCodeType.Field
    public Icon icon;

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
     * Width
     */
    @ZenCodeType.Field
    public int w = 80;
    /**
     * Height
     */
    @ZenCodeType.Field
    public int h = 16;

    public Consumer<ButtonInfo> consumer = s -> {};
    @ZenCodeType.Constructor
    public ButtonInfo(Consumer<ButtonInfo> consumer){
        this.consumer = consumer;
        apply();
    }
    @ZenCodeType.Constructor
    public ButtonInfo(Component text){
        this.text = text;
    }

    /**
     * @param url - A link to a tab or page on the site.
     */
    @ZenCodeType.Method
    public ButtonInfo setURL(String url){
        this.clickURL = url;
        return this;
    }

    @Override
    public ISimpleInfoContent<ButtonInfo> setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public ISimpleInfoContent<ButtonInfo> addPos(int x, int y) {
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
    public Consumer<ButtonInfo> getConsumer() {
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
