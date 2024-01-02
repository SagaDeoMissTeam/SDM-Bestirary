package net.sixik.sdm_bestiary.api.content.info;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.IInfoContent;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;

/**
 * The class of the header. Adds a single-line field.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/info/HeaderInfo")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.HeaderInfo")
public class HeaderInfo implements ISimpleInfoContent<HeaderInfo> {
    @ZenCodeType.Field
    public Component text;
    @ZenCodeType.Field
    public int size;
    @ZenCodeType.Field
    public boolean isCenter;
    @ZenCodeType.Field
    public int x = 0;
    @ZenCodeType.Field
    public int y = 0;

    /**
     * Weight
     */
    @ZenCodeType.Field
    public int w = 16;
    /**
     * Height
     */
    @ZenCodeType.Field
    public int h = 16;
    /**
     * Responsible for displaying the boundaries of the field. It is necessary for convenient editing.
     */
    @ZenCodeType.Field
    public boolean isDrawBackGround = false;
    public Consumer<HeaderInfo> consumer = s -> {};

    @ZenCodeType.Constructor
    public HeaderInfo(Consumer<HeaderInfo> consumer){
        this.consumer = consumer;
        apply();
    }
    @ZenCodeType.Constructor
    public HeaderInfo(Component text, int size){
        this.isCenter = false;
        this.text = text;
        this.size = size;
    }
    @ZenCodeType.Constructor
    public HeaderInfo(Component text, int size, Consumer<HeaderInfo> consumer){
        this.isCenter = false;
        this.text = text;
        this.size = size;
        this.consumer = consumer;
        apply();
    }
    @ZenCodeType.Constructor
    public HeaderInfo(Component text, int size, boolean isCenter){
        this.isCenter = isCenter;
        this.text = text;
        this.size = size;
    }
    @ZenCodeType.Constructor
    public HeaderInfo(Component text, int size, boolean isCenter, Consumer<HeaderInfo> consumer){
        this.isCenter = isCenter;
        this.text = text;
        this.size = size;
        this.consumer = consumer;
        apply();
    }
    @ZenCodeType.Constructor
    public HeaderInfo(Component text, int size, boolean isCenter, int x, int y){
        this.isCenter = isCenter;
        this.text = text;
        this.size = size;
        this.x = x;
        this.y = y;
    }
    @ZenCodeType.Constructor
    public HeaderInfo(Component text, int size, boolean isCenter, int x, int y, Consumer<HeaderInfo> consumer){
        this.isCenter = isCenter;
        this.text = text;
        this.size = size;
        this.x = x;
        this.y = y;
        this.consumer = consumer;
        apply();
    }

    public HeaderInfo copy(){
        return new HeaderInfo(text,size,isCenter,x,y);
    }

    @Override
    public boolean isDrawBackground() {
        return isDrawBackGround;
    }

    @Override
    public HeaderInfo setPos(int x, int y){
        this.x =x;
        this.y = y;
        return this;
    }

    @ZenCodeType.Method
    @Override
    public HeaderInfo addPos(int x, int y){
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public void setSize(int w, int h) {
        this.w = w;
        this.h = h;
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
    public Consumer<HeaderInfo> getConsumer() {
        return consumer;
    }

    @Override
    public void apply() {
        consumer.accept(this);
    }
}
