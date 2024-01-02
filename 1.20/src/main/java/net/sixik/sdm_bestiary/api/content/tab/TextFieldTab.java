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

/**
 * A text element. It has no functional other than how to add a string.
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/tab/TextFieldTab")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.tab.TextFieldTab")
public class TextFieldTab implements IInfoTabContent {

    @ZenCodeType.Field
    public Component text;

    public Consumer<TextFieldTab> consumer = s -> {};
    @ZenCodeType.Constructor
    public TextFieldTab(Consumer<TextFieldTab> consumer){
        this.consumer = consumer;
        consumer.accept(this);
    }

    @Override
    public String getID() {
        return "null";
    }

    @Override
    public Group getGroup() {
        return null;
    }

    @Override
    public Component getComponent() {
        return text;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ItemIcon.getItemIcon(ItemStack.EMPTY);
    }

    @Override
    public List<IInfoTabContent> getContents() {
        return new ArrayList<>();
    }

    @Override
    public InfoContent getInfoContent() {
        return null;
    }

    @Override
    public void setComponent(Component component) {
        this.text = component;
    }
}
