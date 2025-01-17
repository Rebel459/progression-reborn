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

  public static boolean modified_armor_values;
  public static boolean modified_tool_values;
  public static boolean mod_integration_datapacks;

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

      modified_armor_values = config.get("modified_armor_values").getAsBoolean();
      modified_tool_values = config.get("modified_tool_values").getAsBoolean();
      mod_integration_datapacks = config.get("mod_integration_datapacks").getAsBoolean();

    } catch (final IOException e) {
      System.err.println("An error occurred, delete the progression reborn config file in your config/ folder and relaunch");
    }
  }

  private static JsonObject getJsonObject() {

    JsonObject jsonObjects = new JsonObject();

    JsonObject configObject = new JsonObject();
    configObject.addProperty("modified_armor_values", true);
    configObject.addProperty("modified_tool_values", true);
    configObject.addProperty("mod_integration_datapacks", true);
    jsonObjects.add("config", configObject);

    return jsonObjects;
  }
}
