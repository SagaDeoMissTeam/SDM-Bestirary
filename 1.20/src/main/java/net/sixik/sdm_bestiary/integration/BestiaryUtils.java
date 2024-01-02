package net.sixik.sdm_bestiary.integration;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.icon.ImageIcon;
import dev.ftb.mods.ftblibrary.icon.ItemIcon;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.sixik.sdm_bestiary.api.content.IInfoTabContent;
import net.sixik.sdm_bestiary.api.content.InfoContent;
import net.sixik.sdm_bestiary.data.DataBase;
import org.openzen.zencode.java.ZenCodeType;

import static net.sixik.sdm_bestiary.data.DataBase.GROUPCONTENT;
import static net.sixik.sdm_bestiary.data.DataBase.TABCONTENT;

@ZenRegister
@Document("mods/sdm/bestiary/BestiaryUtils")
@ZenCodeType.Name("mods.sdm.bestiary.BestiaryUtils")
public class BestiaryUtils {

    /**
     * Registers the tab element.
     */
    @ZenCodeType.Method
    public static void createGroup(IInfoTabContent tab){
        TABCONTENT.put(tab.getID(), tab);
    }

    /**
     * Registers the tab element.
     */
    @ZenCodeType.Method
    public static void createGroup(IInfoTabContent tab, InfoContent content){
        if(tab.getGroup() != null){
            if(!GROUPCONTENT.containsKey(tab.getGroup().id)) GROUPCONTENT.put(tab.getGroup().id, tab.getGroup());
        }
        tab.addInfoContent(content);
        TABCONTENT.put(tab.getID(), tab);
    }

    @ZenCodeType.Method
    public static Icon createIcon(ResourceLocation id){
        return Icon.getIcon(id);
    }
    @ZenCodeType.Method
    public static Icon createIcon(String id){
        return Icon.getIcon(id);
    }
    @ZenCodeType.Method
    public static Icon createIcon(IItemStack id){
        return ItemIcon.getItemIcon(id.getInternal());
    }

    @ZenCodeType.Method
    public static Icon createImageIcon(ResourceLocation id){
        return ImageIcon.getIcon(id);
    }
    @ZenCodeType.Method
    public static Icon createImageIcon(String id){
        return ImageIcon.getIcon(id);
    }

    @ZenCodeType.Method
    public static void isHideTittle(boolean value){
        DataBase.isShowTittle = value;
    }
    @ZenCodeType.Method
    public static void setTittle(Component value){
        DataBase.tittle = value;
    }

}
