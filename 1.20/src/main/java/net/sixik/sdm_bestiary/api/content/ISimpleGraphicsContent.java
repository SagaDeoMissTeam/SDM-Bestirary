package net.sixik.sdm_bestiary.api.content;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/sdm/bestiary/api/content/ISimpleGraphicsContent")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.ISimpleGraphicsContent")
public interface ISimpleGraphicsContent extends IInfoContent {
    @ZenCodeType.Method
    int getX();
    @ZenCodeType.Method
    int getY();
    @ZenCodeType.Method
    int getWeight();
    @ZenCodeType.Method
    int getHeight();
}
