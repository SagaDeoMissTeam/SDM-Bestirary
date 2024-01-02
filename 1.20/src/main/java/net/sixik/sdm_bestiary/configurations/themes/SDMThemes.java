package net.sixik.sdm_bestiary.configurations.themes;

import dev.ftb.mods.ftblibrary.icon.Color4I;

import javax.annotation.Nullable;

public enum SDMThemes {
    SHADOW("shadow", new SDMTheme(Color4I.rgb(74,64,90),Color4I.rgb(53,46,64),Color4I.rgb(214,154,255), Color4I.rgb(32,28,39))),
    PINK("pink", new SDMTheme(Color4I.rgb(245,245,245),Color4I.rgb(231,170,175),Color4I.rgb(239,207,210), Color4I.rgb(148,	109,	112))),
    DESIDERIUM("desiderium", new SDMTheme(Color4I.rgb(62,19,23), Color4I.rgb(69,22,28), Color4I.rgb(148,118,87), Color4I.rgb(60,48,36))),
    CUSTOM("custom", new SDMTheme(Color4I.BLACK, Color4I.BLACK, Color4I.BLACK, Color4I.BLACK));

    private String id;
    private SDMTheme theme;
    SDMThemes(String id, SDMTheme theme){
        this.theme =theme;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public SDMTheme getTheme() {
        return theme;
    }

    public static @Nullable SDMTheme getThemeFromId(String id){
        for (SDMThemes t :SDMThemes.values()) {
            if(t.id.equals(id)) return t.theme;
        }
        return null;
    }
}
