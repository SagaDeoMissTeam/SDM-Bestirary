package net.sixik.sdm_bestiary.api.content.info;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.icon.Icons;
import dev.ftb.mods.ftblibrary.icon.ImageIcon;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;

/**
 * The class of the icon. It can be either an icon of an object or a picture.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/info/ImageInfo")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.ImageInfo")
public class ImageInfo implements ISimpleInfoContent<ImageInfo> {

    @ZenCodeType.Field
    public Icon icon;
    @ZenCodeType.Field
    public int x = 0;
    @ZenCodeType.Field
    public int y = 0;
    @ZenCodeType.Field
    public int weight = 8;
    @ZenCodeType.Field
    public int height = 8;

    /**
     * Height
     */
    @ZenCodeType.Field
    public int h = 16;
    /**
     * Weight
     */
    @ZenCodeType.Field
    public int w = 16;
    /**
     * Responsible for displaying the boundaries of the field. It is necessary for convenient editing.
     */
    @ZenCodeType.Field
    public boolean isDrawBackGround = false;

    public Consumer<ImageInfo> consumer = s -> {};
    @ZenCodeType.Constructor
    public ImageInfo(Consumer<ImageInfo> consumer){
        this.consumer = consumer;
        apply();
    }
    @ZenCodeType.Constructor
    public ImageInfo(Icon icon, int weight, int height){
        this.icon = icon;
        this.weight = weight;
        this.height = height;
    }
    @ZenCodeType.Constructor
    public ImageInfo(Icon icon, int weight, int height, Consumer<ImageInfo> consumer){
        this.icon = icon;
        this.weight = weight;
        this.height = height;
        this.consumer = consumer;
        apply();
    }

    @Override
    public ImageInfo setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public ImageInfo addPos(int x, int y) {
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
    public void setSize(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public boolean isDrawBackground() {
        return isDrawBackGround;
    }

    @Override
    public Consumer<ImageInfo> getConsumer() {
        return consumer;
    }

    @Override
    public void apply() {
        consumer.accept(this);
    }
}
