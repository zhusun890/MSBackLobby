package cn.monshine.utils;

import cn.monshine.main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;

public class bungeeUtils {
    public static void connectToServer(Player player, String server) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeUTF("Connect");
        byteArrayDataOutput.writeUTF(server);
        player.sendPluginMessage(main.getInstance(), "BungeeCord", byteArrayDataOutput.toByteArray());
    }
}
