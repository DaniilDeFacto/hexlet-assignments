package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;
    public FileKV(String path, Map<String, String> data) {
        this.path = path;
        var json = Utils.serialize(new HashMap<>(data));
        Utils.writeFile(path, json);
    }

    @Override
    public void set(String key, String value) {
        var content = Utils.readFile(path);
        var data = Utils.unserialize(content);
        data.put(key, value);
        var json = Utils.serialize(new HashMap<>(data));
        Utils.writeFile(path, json);
    }

    @Override
    public void unset(String key) {
        var content = Utils.readFile(path);
        var data = Utils.unserialize(content);
        data.remove(key);
        var json = Utils.serialize(new HashMap<>(data));
        Utils.writeFile(path, json);
    }

    @Override
    public String get(String key, String defaultValue) {
        var content = Utils.readFile(path);
        var data = Utils.unserialize(content);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var content = Utils.readFile(path);
        var data = Utils.unserialize(content);
        return new HashMap<>(data);
    }
}
// END
