package org.shika.ToDoApp.Data;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Map;

import org.progcoa.pbjavautils.Console.Console;
import org.progcoa.pbjavautils.Data.Resource;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.nodes.Tag;

@SuppressWarnings("all")
public class Data {
    private final Yaml yaml = new Yaml();
    private final String path;
    private Map<String, TodoData> map;
    private Class aClass;
    private Resource resource;

    private String outPath;

    public Data(String path, Class aClass) {
        this.path = path;
        this.aClass = aClass;

        this.outPath = "options/" + path;

        this.SaveDefault();
        this.Load();
    }

    public TodoData get(String key) {
        return this.map.get(key);
    }

    public void set(String key, TodoData value) {
        this.map.put(key, value);
    }

    public Map getMap() {
        return this.map;
    }

    public void Load() {
        try {
            this.map = (Map)this.yaml.loadAs(new FileInputStream(outPath), Map.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Save() {
        String yamlData = this.yaml.dumpAs(this.map, Tag.YAML, FlowStyle.BLOCK);
        FileWriter filewriter = null;

        try {
            filewriter = new FileWriter(new File(outPath));
            filewriter.write(yamlData);
            filewriter.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    private void SaveDefault() {
        if(new File(outPath).exists()) return;

        this.resource = new Resource(this.aClass);

        try {
            this.resource.loadFile(this.path);
        } catch (URISyntaxException | IOException var2) {
            var2.printStackTrace();
        }

    }
}
