package net.legacy.progression_reborn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import net.fabricmc.loader.api.FabricLoader;

public class PRConfig {

  public static boolean compat_datapacks_enabled;
  public static boolean modified_vanilla_armor_mixin;
  public static boolean modified_vanilla_tools_mixin;

  public PRConfig() {}

  public static void main() throws IOException {
    Path configPath = Path.of(FabricLoader.getInstance().getConfigDir().toString(), "progression-reborn-config-v1.json");
    try {
      if (configPath.toFile().createNewFile()) {
        JsonObject jsonObjects = getJsonObject();
        PrintWriter pw = new PrintWriter(configPath.toString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        pw.print(gson.toJson(jsonObjects));
        pw.flush();
        pw.close();
      }
      JsonObject obj = (JsonObject) JsonParser.parseReader(new FileReader(configPath.toString()));
      JsonObject config = (JsonObject) obj.get("config");

      compat_datapacks_enabled = config.get("compat_datapacks_enabled").getAsBoolean();
      modified_vanilla_armor_mixin = config.get("modified_vanilla_armor_mixin").getAsBoolean();
      modified_vanilla_tools_mixin = config.get("modified_vanilla_tools_mixin").getAsBoolean();

    } catch (final IOException e) {
      System.err.println("An error occurred, delete the progression reborn config file in your config/ and relaunch");
    }
  }

  private static JsonObject getJsonObject() {

    JsonObject jsonObjects = new JsonObject();

    JsonObject configObject = new JsonObject();
    configObject.addProperty("compat_datapacks_enabled", true);
    configObject.addProperty("modified_vanilla_armor_mixin", true);
    configObject.addProperty("modified_vanilla_tools_mixin", true);
    jsonObjects.add("config", configObject);

    return jsonObjects;
  }
}
