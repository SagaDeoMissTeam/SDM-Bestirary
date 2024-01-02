package net.sixik.sdm_bestiary.client;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.event.EventResult;
import dev.ftb.mods.ftblibrary.icon.Color4I;
import dev.ftb.mods.ftblibrary.ui.CustomClickEvent;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.sixik.sdm_bestiary.client.gui.BestiaryScreen;
import net.sixik.sdm_bestiary.SDMBestiary;
import net.sixik.sdm_bestiary.SDMBestiaryCommon;
import net.sixik.sdm_bestiary.config.ConfigClient;
import net.sixik.sdm_bestiary.configurations.themes.SDMTheme;
import net.sixik.sdm_bestiary.configurations.themes.SDMThemes;
import org.lwjgl.glfw.GLFW;

public class SDMBestiaryClient extends SDMBestiaryCommon {

    public static SDMTheme sdmTheme = getTheme();

    public static SDMTheme getTheme(){
        SDMTheme tm = ConfigClient.THEMES.get().getTheme();
        if(ConfigClient.THEMES.get() == SDMThemes.CUSTOM){
            tm = new SDMTheme(
                    Color4I.fromString(ConfigClient.BACKGROUND.get()),
                    Color4I.fromString(ConfigClient.SHADOW.get()),
                    Color4I.fromString(ConfigClient.REACT.get()),
                    Color4I.fromString(ConfigClient.STOKE.get())
            );
        }
        return tm;
    }

    public static final ResourceLocation OPEN_GUI = new ResourceLocation(SDMBestiary.MODID, "open_gui");

    public static final String SDMSHOP_CATEGORY = "key.category.bestiary";
    public static final String KEY_NAME = "key.sdm.bestiary";
    public static KeyMapping KEY_SHOP = new KeyMapping(KEY_NAME, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_N, SDMSHOP_CATEGORY);


    @Override
    public void preInit() {
        CustomClickEvent.EVENT.register(this::customClick);
        MinecraftForge.EVENT_BUS.addListener(this::onKeyRegister);
        MinecraftForge.EVENT_BUS.addListener(this::keyInput);
    }

    public EventResult customClick(CustomClickEvent event) {
        if(event.id().equals(OPEN_GUI)) {
            new BestiaryScreen().openGui();
            return EventResult.interruptTrue();
        }
        return EventResult.pass();
    }

    public void keyInput(InputEvent.Key event) {
        if (KEY_SHOP.consumeClick()) {
            new BestiaryScreen().openGui();
        }
    }

    public void onKeyRegister(RegisterKeyMappingsEvent event){
        event.register(KEY_SHOP);
    }
}
