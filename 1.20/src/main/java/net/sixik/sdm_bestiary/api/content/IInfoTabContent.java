package net.sixik.sdm_bestiary.api.content;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.tab.Group;
import org.openzen.zencode.java.ZenCodeType;

import javax.annotation.Nullable;
import java.util.List;


@ZenRegister
@Document("mods/sdm/bestiary/api/content/IInfoTabContent")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.IInfoTabContent")
public interface IInfoTabContent {

    @ZenCodeType.Method
    String getID();
    @ZenCodeType.Method
    Group getGroup();

    @ZenCodeType.Method
    Component getComponent();
    @ZenCodeType.Method
    @Nullable
    Icon getIcon();

    @ZenCodeType.Method
    List<IInfoTabContent> getContents();

    @ZenCodeType.Method
    InfoContent getInfoContent();
    @ZenCodeType.Method
    void setComponent(Component component);

    @ZenCodeType.Method
    default IInfoTabContent addInfoContent(InfoContent content){
        return null;
    }

//    @ZenCodeType.Method
//    void create();
}
