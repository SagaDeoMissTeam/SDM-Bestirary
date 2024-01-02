package net.sixik.sdm_bestiary.api.content.info;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.Theme;
import net.sixik.sdm_bestiary.api.content.IInfoContent;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import net.sixik.sdm_bestiary.api.content.info.table.TableCategory;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The class of the table. Which has columns and other interface elements can be added to them.
 */
@ZenRegister
//@Document("mods/sdm/bestiary/api/content/info/TableInfo")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.TableInfo")
public class TableInfo implements ISimpleInfoContent<ImageInfo> {

    @ZenCodeType.Field
    public List<TableCategory> categoryList = new ArrayList<>();

    @ZenCodeType.Field
    public int sizeTittle = 20;
    @ZenCodeType.Field
    public int sizeContent = 100;
    public Consumer<TableInfo> consumer = s -> {};

    @ZenCodeType.Field
    public int x = 0;
    @ZenCodeType.Field
    public int y = 0;

    /**
     * Weight
     */
    @ZenCodeType.Field
    public int w = 100;
    /**
     * Height
     */
    @ZenCodeType.Field
    public int h = 100;
    @ZenCodeType.Constructor
    public TableInfo(Consumer<TableInfo> consumer){
        this.consumer = consumer;
        consumer.accept(this);
    }

    @ZenCodeType.Method
    public TableInfo addContent(TableCategory category){
        categoryList.add(category);
        return this;
    }
    @Override
    public ISimpleInfoContent<ImageInfo> setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public ISimpleInfoContent<ImageInfo> addPos(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Consumer<ImageInfo> getConsumer() {
        return null;
    }

    @Override
    public void apply() {

    }

    @Override
    public void setSize(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public boolean isDrawBackground() {
        return false;
    }
}
