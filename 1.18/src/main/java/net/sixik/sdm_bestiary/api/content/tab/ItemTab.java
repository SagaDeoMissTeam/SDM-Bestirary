package net.sixik.sdm_bestiary.api.content.tab;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.sixik.sdm_bestiary.api.content.IInfoTabContent;
import net.sixik.sdm_bestiary.api.content.InfoContent;
import org.openzen.zencode.java.ZenCodeType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
 * The item button. It looks like an item in the inventory.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/tab/ItemTab")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.tab.ItemTab")
public class ItemTab implements IInfoTabContent {
    @ZenCodeType.Field
    public Component component;
    @ZenCodeType.Field
    public @Nullable ItemStack stack;
    @ZenCodeType.Field
    public Icon icon;

    @ZenCodeType.Field
    public @Nullable InfoContent content = null;
    /**
     * The ID is needed to create links to tabs through different widgets.
     */
    @ZenCodeType.Field
    public String id;

    @ZenCodeType.Field
    public @Nullable Group group = null;

    public Consumer<ItemTab> consumer = s -> {};
    @ZenCodeType.Constructor
    public ItemTab(Consumer<ItemTab> consumer){
        this.consumer = consumer;
        consumer.accept(this);
    }
    @ZenCodeType.Constructor
    public ItemTab(Component component, String id){
        this.component = component;
        this.stack = null;
        this.id = id;
    }
    @ZenCodeType.Constructor
    public ItemTab(Component component, IItemStack stack, String id){
        this.component = component;
        this.stack = stack.getInternal();
        this.id = id;
    }

    @ZenCodeType.Method
    public ItemTab setIcon(Icon icon){
        this.icon = icon;
        return this;
    }

    @ZenCodeType.Method
    public ItemTab addContent(InfoContent content){
        this.content = content;
        return this;
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public ItemTab addInfoContent(InfoContent content) {
        this.content = content;
        return this;
    }

    @Nullable
    public ItemStack getStack() {
        return stack;
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
        return group;
    }

    @Override
    public Component getComponent() {
        return component;
    }

    @Override
    public List<IInfoTabContent> getContents() {
        return new ArrayList<>();
    }

    @Override
    public InfoContent getInfoContent() {
        return content;
    }
}
