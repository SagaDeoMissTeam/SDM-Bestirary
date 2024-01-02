package net.sixik.sdm_bestiary.api.content.info.table;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.network.chat.Component;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@ZenRegister
//@Document("mods/sdm/bestiary/api/content/info/table/TableContent")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.table.TableContent")
public class TableContent {

    @ZenCodeType.Field
    public Component text;
    public List<ISimpleInfoContent<?>> contentList = new ArrayList<>();

    public Consumer<TableContent> consumer = s -> {};
    @ZenCodeType.Constructor
    public TableContent(Consumer<TableContent> consumer){
        this.consumer = consumer;
        consumer.accept(this);
    }
    @ZenCodeType.Constructor
    public TableContent(Component text){
        this.text = text;
    }

    @ZenCodeType.Method
    public TableContent addContent(ISimpleInfoContent<?> content){
        this.contentList.add(content);
        return this;
    }
}
