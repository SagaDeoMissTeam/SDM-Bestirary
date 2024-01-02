package net.sixik.sdm_bestiary.api.content.graphics;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import net.sixik.sdm_bestiary.api.content.ISimpleGraphicsContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;


@ZenRegister
@Document("mods/sdm/bestiary/api/content/graphics/DrawReact")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.graphics.DrawReact")
public class DrawReact implements ISimpleGraphicsContent {
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

    @ZenCodeType.Field
    public boolean isGradient = false;
    @ZenCodeType.Field
    public int strangeGradient = 0;

    @ZenCodeType.Field
    public boolean roundEdges = false;

    /**
     * Whether it takes into account the boundaries or not.
     */
    @ZenCodeType.Field
    public boolean isOffset = true;

    public Consumer<DrawReact> consumer = s -> {};
    @ZenCodeType.Constructor
    public DrawReact(Consumer<DrawReact> consumer){
        this.consumer.accept(this);
        consumer.accept(this);
    }

    @ZenCodeType.Method
    public DrawReact setColor(int red, int green, int blue){
        this.color = Color4I.rgb(red,green,blue);
        return this;
    }
    @ZenCodeType.Method
    public DrawReact setColor(Color4I color){
        this.color = color;
        return this;
    }

    @ZenCodeType.Method
    public DrawReact addPos(int x, int y){
        this.x += x;
        this.y += y;
        return this;
    }

    @ZenCodeType.Method
    public DrawReact setPos(int x, int y){
        this.x = x;
        this.y = y;
        return this;
    }
    @ZenCodeType.Method
    public DrawReact setSize(int weight, int height){
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
