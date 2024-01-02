package net.sixik.sdm_bestiary.api.content.tab;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.icon.ItemIcon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.sixik.sdm_bestiary.api.content.IInfoTabContent;
import net.sixik.sdm_bestiary.api.content.InfoContent;
import org.jetbrains.annotations.Nullable;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static net.sixik.sdm_bestiary.data.DataBase.GROUPCONTENT;

/**
 * A group to which other elements can be added.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/tab/Group")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.tab.Group")
public class Group implements IInfoTabContent {
    @ZenCodeType.Field
    public Component component;

    @ZenCodeType.Field
    public boolean collapse = false;

    @ZenCodeType.Field
    public @Nullable Icon icon = ItemIcon.getItemIcon(ItemStack.EMPTY);
    @ZenCodeType.Field
    public List<IInfoTabContent> content =new ArrayList<>();
    /**
     * The ID is needed to create links to tabs through different widgets.
     */
    @ZenCodeType.Field
    public String id;

    public Consumer<Group> consumer = s -> {};

    @ZenCodeType.Constructor
    public Group(Consumer<Group> consumer){
        this.consumer = consumer;
        consumer.accept(this);
    }
    @ZenCodeType.Constructor
    public Group(Component component, String id){
        this.component = component;
        this.id = id;
    }
    @ZenCodeType.Method
    public Group addContent(IInfoTabContent content){
        return this;
    }
    @ZenCodeType.Method
    public Group addContent(List<IInfoTabContent> content){
        return this;
    }


    @ZenCodeType.Method
    public Group setIcon(Icon icon){
        this.icon = icon;
        return this;
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public List<IInfoTabContent> getContents() {
        return content;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public Group getGroup() {
        return null;
    }

    @Override
    public Component getComponent() {
        return component;
    }

    @Override
    public InfoContent getInfoContent() {
        return null;
    }
}
