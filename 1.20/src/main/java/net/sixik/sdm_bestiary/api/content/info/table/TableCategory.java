package net.sixik.sdm_bestiary.api.content.info.table;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.network.chat.Component;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@ZenRegister
//@Document("mods/sdm/bestiary/api/content/info/table/TableCategory")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.table.TableCategory")
public class TableCategory {
    @ZenCodeType.Field
    public Component text;

    public List<TableContent> contentList = new ArrayList<>();
    public Consumer<TableCategory> consumer = s -> {};

    @ZenCodeType.Constructor
    public TableCategory(Consumer<TableCategory> consumer){
        this.consumer = consumer;
        consumer.accept(this);
    }
    @ZenCodeType.Constructor
    public TableCategory(Component text){
        this.text = text;
    }

    @ZenCodeType.Method
    public TableCategory addContent(TableContent contentList){
        this.contentList.add(contentList);
        return this;
    }
}
