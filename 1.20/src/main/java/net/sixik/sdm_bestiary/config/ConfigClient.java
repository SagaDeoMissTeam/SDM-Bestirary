package net.sixik.sdm_bestiary.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.sixik.sdm_bestiary.configurations.themes.SDMThemes;

import java.nio.file.Path;

public class ConfigClient {

    public static void init(Path file)
    {
        final CommentedFileConfig configData = CommentedFileConfig.builder(file)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        SPEC.setConfig(configData);
    }
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.EnumValue<SDMThemes> THEMES;
    public static SDMThemes defaultTheme = SDMThemes.SHADOW;

    public static final ForgeConfigSpec.ConfigValue<String> BACKGROUND;
    public static final ForgeConfigSpec.ConfigValue<String> SHADOW;
    public static final ForgeConfigSpec.ConfigValue<String> REACT;
    public static final ForgeConfigSpec.ConfigValue<String> STOKE;
    public static String defaultBackground = "#5555FF";
    public static String defaultShadow = "#5555FF";
    public static String defaultReact = "#5555FF";
    public static String defaultStoke = "#5555FF";



    public static final String THEMES_NAME = "Shop Theme";

    static {
        BUILDER.push("THEMES");

        THEMES = BUILDER.defineEnum(THEMES_NAME, defaultTheme);

        BUILDER.push("THEMES_CUSTOM");
        BUILDER.comment("Colors Settings");
        BACKGROUND = BUILDER.define("background", defaultBackground);
        SHADOW = BUILDER.define("shadow", defaultShadow);
        REACT = BUILDER.define("react", defaultReact);
        STOKE = BUILDER.define("stoke", defaultStoke);

        BUILDER.pop();
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
