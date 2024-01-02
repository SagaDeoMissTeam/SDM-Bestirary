package net.sixik.sdm_bestiary.api.content.info;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.IInfoContent;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import net.sixik.sdm_bestiary.api.content.InfoContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * A text class. It can be multi-line.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/info/TextInfo")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.TextInfo")
public class TextInfo implements ISimpleInfoContent<TextInfo> {

    @ZenCodeType.Field
    public List<Component> componentBooleanMap = new ArrayList<>();
    @ZenCodeType.Field
    public int space = 10;

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

    @ZenCodeType.Field
    public InfoContent parent;

    /**
     * Responsible for displaying the boundaries of the field. It is necessary for convenient editing.
     */
    @ZenCodeType.Field
    public boolean isDrawBackGround = false;

    public Consumer<TextInfo> consumer = s -> {};
    @ZenCodeType.Constructor
    public TextInfo(){
    }
    @ZenCodeType.Constructor
    public TextInfo(Consumer<TextInfo> consumer){
        this.consumer = consumer;
        apply();
    }
    @ZenCodeType.Constructor
    public TextInfo(List<Component> componentBooleanMap){
        this.componentBooleanMap.addAll(componentBooleanMap);
    }
    @ZenCodeType.Constructor
    public TextInfo(List<Component> componentBooleanMa, Consumer<TextInfo> consumer){
        this.componentBooleanMap.addAll(componentBooleanMap);
        this.consumer = consumer;

        apply();
    }

    @ZenCodeType.Method
    public TextInfo addLine(Component string){
        this.componentBooleanMap.add(string);
        return this;
    }

    @ZenCodeType.Method
    public TextInfo setSpace(int space){
        this.space = space;
        return this;
    }

    @Override
    public void setParent(InfoContent parent) {
        this.parent = parent;
    }

    @Override
    public TextInfo setPos(int x, int y){
        this.x =x;
        this.y = y;
        return this;
    }

    @Override
    public TextInfo addPos(int x, int y) {
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
    public Consumer<TextInfo> getConsumer() {
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
        return isDrawBackGround;
    }

    @ZenCodeType.Method
    public int getEndY(){
        int lastY = 0;
        for (int i = 0; i < this.componentBooleanMap.size(); i++){
            lastY = lastY + this.space;
        }

        return lastY;
    }
}
