package net.sixik.sdm_bestiary.api.content;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.sixik.sdm_bestiary.api.content.IInfoContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
 * The main window that contains all the interface elements
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/InfoContent")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.InfoContent")
public class InfoContent {

    public List<IInfoContent> content = new ArrayList<>();
    public @ZenCodeType.Nullable Consumer<InfoContent> consumer =  s -> {};

    @ZenCodeType.Field
    public int weight = 0;

    @ZenCodeType.Field
    public int space = 19;

    @ZenCodeType.Constructor
    public InfoContent(){
        this.consumer = s -> {};
        apply();
    }
    @ZenCodeType.Constructor
    public InfoContent(Consumer<InfoContent> consumer){
        this.consumer = consumer;
        apply();
    }

    /**
     * A method that adds different widgets to the information window.
     * @param content - Buttons, Fields, Tables, Fills, etc
     */
    @ZenCodeType.Method
    public InfoContent addContent(IInfoContent content){
        content.setParent(this);
        this.content.add(content);
        return this;
    }

    @ZenCodeType.Method
    public int getWeight() {
        return weight;
    }

    public void apply(){
        consumer.accept(this);
    }
}
