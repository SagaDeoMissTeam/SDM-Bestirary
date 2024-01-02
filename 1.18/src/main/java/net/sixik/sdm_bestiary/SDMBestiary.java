package net.sixik.sdm_bestiary;

import com.mojang.logging.LogUtils;
import dev.ftb.mods.ftblibrary.icon.IconProperties;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sixik.sdm_bestiary.api.content.InfoContent;
import net.sixik.sdm_bestiary.api.content.info.HeaderInfo;
import net.sixik.sdm_bestiary.api.content.tab.TextTab;
import net.sixik.sdm_bestiary.client.SDMBestiaryClient;
import net.sixik.sdm_bestiary.config.ConfigInit;
import net.sixik.sdm_bestiary.data.DataBase;
import net.sixik.sdm_bestiary.net.SDMNetwork;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SDMBestiary.MODID)
public class SDMBestiary {

    public static final String MODID = "sdm_bestiary";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SDMBestiary() {
        ConfigInit.init();
        DistExecutor.safeRunForDist(() -> SDMBestiaryClient::new, () -> SDMBestiaryCommon::new).preInit();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(this::addReloadListeners);
    }

    private void commonSetup(final FMLCommonSetupEvent event){
        SDMNetwork.register();
    }

    private void addReloadListeners (AddReloadListenerEvent event) {

        event.addListener(DataBase.INSTANCE);
    }
}
