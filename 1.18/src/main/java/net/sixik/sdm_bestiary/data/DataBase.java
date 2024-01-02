package net.sixik.sdm_bestiary.data;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.sixik.sdm_bestiary.api.content.IInfoTabContent;
import net.sixik.sdm_bestiary.api.content.InfoContent;
import net.sixik.sdm_bestiary.api.content.tab.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase extends SimplePreparableReloadListener<Void> {

    public static final DataBase INSTANCE = new DataBase();

    public static Component tittle = TextComponent.EMPTY;
    public static boolean isShowTittle = false;

    public static Map<String, IInfoTabContent> TABCONTENT = new HashMap<>();
    public static Map<String, Group> GROUPCONTENT = new HashMap<>();
    public static List<InfoContent> CONTENT = new ArrayList<>();


    @Override
    protected Void prepare(ResourceManager p_10796_, ProfilerFiller p_10797_) {
        return null;
    }

    @Override
    protected void apply(Void p_10793_, ResourceManager p_10794_, ProfilerFiller p_10795_) {
        TABCONTENT.clear();
        CONTENT.clear();
        GROUPCONTENT.clear();
    }
}
