package net.sixik.sdm_bestiary.api.content.tab;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.icon.ItemIcon;
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
 * A button that can be fully customized on.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/tab/Text")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.tab.TextTab")
public class TextTab implements IInfoTabContent {
    @ZenCodeType.Field
    public Component component;
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

    public Consumer<TextTab> consumer = s -> {};
    @ZenCodeType.Constructor
    public TextTab(Consumer<TextTab> consumer){
        this.consumer = consumer;
        consumer.accept(this);
    }
    @ZenCodeType.Constructor
    public TextTab(Component component, String id){
        this.component = component;
        this.id = id;
        this.icon = ItemIcon.getItemIcon(ItemStack.EMPTY);
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
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

    @ZenCodeType.Method
    public TextTab setIcon(Icon icon){
        this.icon = icon;
        return this;
    }

    @Override
    public TextTab addInfoContent(InfoContent content) {
        this.content = content;
        return this;
    }

    @Override
    @Nullable
    public Icon getIcon() {
        return icon;
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
