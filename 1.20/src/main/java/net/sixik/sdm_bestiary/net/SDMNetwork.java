package net.sixik.sdm_bestiary.net;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.sixik.sdm_bestiary.SDMBestiary;
import net.sixik.sdm_bestiary.net.packet.client.BestiaryInfoC2SPacket;

public class SDMNetwork {
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;
    private static int id(){
        return packetID++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(SDMBestiary.MODID, "message"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(BestiaryInfoC2SPacket.class, id(), NetworkDirection.LOGIN_TO_SERVER)
                .decoder(BestiaryInfoC2SPacket::new)
                .encoder(BestiaryInfoC2SPacket::toBytes)
                .consumerMainThread(BestiaryInfoC2SPacket::handler)
                .add();
    }

    public static <MSG> void sendToServer(MSG message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

}
