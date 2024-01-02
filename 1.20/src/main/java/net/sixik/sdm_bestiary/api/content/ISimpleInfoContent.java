package net.sixik.sdm_bestiary.api.content;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;

@ZenRegister
@Document("mods/sdm/bestiary/api/content/ISimpleInfoContent")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.ISimpleInfoContent")
public interface ISimpleInfoContent<T extends ISimpleInfoContent<?>> extends IInfoContent{

    @ZenCodeType.Method
    ISimpleInfoContent<T> setPos(int x, int y);

    @ZenCodeType.Method
    ISimpleInfoContent<T> addPos(int x, int y);
    @ZenCodeType.Method
    int getX();
    @ZenCodeType.Method
    int getY();

    Consumer<T> getConsumer();
    void apply();

    @ZenCodeType.Method
    void setSize(int w, int h);

    boolean isDrawBackground();

}
