package net.sixik.sdm_bestiary.net.packet.server;

import net.minecraft.network.FriendlyByteBuf;
import net.sixik.sdm_bestiary.data.PlayerData;

import java.util.ArrayList;
import java.util.List;

public class BestiaryInfoS2CPacket {
    public List<String> favoritePage = new ArrayList<>();
    public List<String> searchList = new ArrayList<>();
    public List<String> unlockedPage = new ArrayList<>();

    public BestiaryInfoS2CPacket(PlayerData data){
        this.favoritePage = data.favoritePage;
        this.searchList = data.searchList;
        this.unlockedPage = data.unlockedPage;

    }

    public BestiaryInfoS2CPacket(FriendlyByteBuf buf){
        int t = buf.readInt();
        for(int i = 0; i < t; i++){
            favoritePage.add(buf.readUtf());
        }

    }

    public void toBytes(FriendlyByteBuf buf){

    }
}
