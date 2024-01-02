package net.sixik.sdm_bestiary.api.content;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/sdm/bestiary/api/content/IInfoContent")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.IInfoContent")
public interface IInfoContent {

    @ZenCodeType.Method
    default void setParent(InfoContent content){

    }
}
