package net.sixik.sdm_bestiary.api.content.info;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.world.entity.EntityType;
import net.sixik.sdm_bestiary.api.content.ISimpleInfoContent;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Consumer;

/**
 * Allows you to add mobs to the panel
 */
@ZenRegister
@Document("mods/sdm/bestiary/api/content/info/EntityInfo")
@ZenCodeType.Name("mods.sdm.bestiary.api.content.info.EntityInfo")
public class EntityInfo implements ISimpleInfoContent<EntityInfo> {

    @ZenCodeType.Field
    public EntityType<?> entityType = null;
    @ZenCodeType.Field
    public int x = 0;
    @ZenCodeType.Field
    public int y = 0;
    @ZenCodeType.Field
    public int size = 8;
    @ZenCodeType.Field
    public int yaw = 0;

    public Consumer<EntityInfo> consumer = s -> {};

    @ZenCodeType.Constructor
    public EntityInfo(Consumer<EntityInfo> consumer){
        this.consumer = consumer;
        this.consumer.accept(this);
    }

    @Override
    public ISimpleInfoContent<EntityInfo> setPos(int x, int y) {
        this.x = x;
        this.y = y;

        return this;
    }

    @Override
    public ISimpleInfoContent<EntityInfo> addPos(int x, int y) {
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
    public Consumer<EntityInfo> getConsumer() {
        return consumer;
    }

    @Override
    public void apply() {
        consumer.accept(this);
    }

    @Override
    public void setSize(int w, int h) {
        this.size = w;
    }

    @Override
    public boolean isDrawBackground() {
        return false;
    }
}
