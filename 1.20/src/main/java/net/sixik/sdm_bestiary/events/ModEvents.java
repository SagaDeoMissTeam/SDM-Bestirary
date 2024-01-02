package net.sixik.sdm_bestiary.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sixik.sdm_bestiary.SDMBestiary;
import net.sixik.sdm_bestiary.data.PlayerHistory;
import net.sixik.sdm_bestiary.data.PlayerHistoryProvider;


@Mod.EventBusSubscriber(modid = SDMBestiary.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PlayerHistoryProvider.PLAYER_HISTORY).isPresent()){
                event.addCapability(new ResourceLocation(SDMBestiary.MODID, "bestiary_property"), new PlayerHistoryProvider());
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerDead(PlayerEvent.Clone event){
        if(event.isWasDeath()){
            event.getOriginal().getCapability(PlayerHistoryProvider.PLAYER_HISTORY).ifPresent(oldState -> {
                event.getOriginal().getCapability(PlayerHistoryProvider.PLAYER_HISTORY).ifPresent(newState -> {
                    newState.copyFrom(oldState);
                });
            });
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerHistory.class);
    }
}
