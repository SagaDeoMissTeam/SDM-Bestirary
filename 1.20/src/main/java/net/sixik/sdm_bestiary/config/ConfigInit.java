package net.sixik.sdm_bestiary.config;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.sixik.sdm_bestiary.SDMBestiary;

import java.nio.file.Path;

public class ConfigInit {
    public static Path path = FMLPaths.CONFIGDIR.get();
    public static void init(){

        ModLoadingContext.get().registerConfig(
                ModConfig.Type.CLIENT,
                ConfigClient.SPEC
        );
        ConfigClient.init(path.resolve(SDMBestiary.MODID + "-client.toml"));

//        ModLoadingContext.get().registerConfig(
//                ModConfig.Type.COMMON,
//                ConfigCommon.SPEC
//        );
//        ConfigCommon.init(path.resolve(SDMBestiary.MODID + "-common.toml"));
    }
}
