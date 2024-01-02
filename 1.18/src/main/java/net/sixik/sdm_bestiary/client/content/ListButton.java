package net.sixik.sdm_bestiary.client.content;

import dev.ftb.mods.ftblibrary.icon.Icon;
import dev.ftb.mods.ftblibrary.ui.Button;
import dev.ftb.mods.ftblibrary.ui.Panel;
import dev.ftb.mods.ftblibrary.ui.input.MouseButton;
import dev.ftb.mods.ftblibrary.util.TooltipList;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class ListButton extends Button {
    public final Panel parent;
    public ListButton(Panel panel, Component t, Icon i) {
        super(panel, t, i);
        setSize(100, 14);
        parent = panel;
    }

    public int getActualWidth() {
        return Minecraft.getInstance().font.width(title) + 20;
    }

    @Override
    public void addMouseOverText(TooltipList list) {
    }
}
