package net.sixik.sdm_bestiary.net.packet.client;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class BestiaryInfoC2SPacket {

    public BestiaryInfoC2SPacket(){

    }

    public BestiaryInfoC2SPacket(FriendlyByteBuf byteBuf){

    }

    public void toBytes(FriendlyByteBuf byteBuf){

    }

    public boolean handler(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //SERVER
        });
        return true;
    }
}
