package net.sixik.sdm_bestiary.api.content.graphics;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import net.sixik.sdm_bestiary.api.content.IInfoContent;
import net.sixik.sdm_bestiary.api.content.ISimpleGraphicsContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;

/**
 * Allows you to add a color fill.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/graphics/DrawColor")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.graphics.DrawColor")
public class DrawColor implements ISimpleGraphicsContent {

    @ZenCodeType.Field
    public Color4I color;

    @ZenCodeType.Field
    public int x = 0;
    @ZenCodeType.Field
    public int y = 0;
    @ZenCodeType.Field
    public int weight = 0;
    @ZenCodeType.Field
    public int height = 0;

    /**
     * Whether it takes into account the boundaries or not.
     */
    @ZenCodeType.Field
    public boolean isOffset = true;

    public Consumer<DrawColor> consumer = s -> {};
    @ZenCodeType.Constructor
    public DrawColor(Consumer<DrawColor> consumer){
        this.consumer = consumer;
        this.consumer.accept(this);
    }

    @ZenCodeType.Method
    public DrawColor setColor(int red, int green, int blue){
        this.color = Color4I.rgb(red,green,blue);
        return this;
    }
    @ZenCodeType.Method
    public DrawColor setColor(Color4I color){
        this.color = color;
        return this;
    }

    @ZenCodeType.Method
    public DrawColor addPos(int x, int y){
        this.x += x;
        this.y += y;
        return this;
    }

    @ZenCodeType.Method
    public DrawColor setPos(int x, int y){
        this.x = x;
        this.y = y;
        return this;
    }

    @ZenCodeType.Method
    public DrawColor setSize(int weight, int height){
        this.weight = weight;
        this.height = height;
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
    public int getWeight() {
        return weight;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
