package com.test.yaml;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlTest {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException {

        Path testResourcePath = Paths.get("./testRsc");
        Path testYml = Paths.get("./testRsc/test_detail.yml");
        Path testMultiYml = Paths.get("./testRsc/test_multi.yml");
        Path inTestYml = Paths.get("/test_detail.yml");

        Path outYml = Paths.get("./testRsc/outTest.yml");
        Path outCustomYml = Paths.get("./testRsc/outCustomTest.yml");

        if (!Files.exists(testResourcePath)) {
            Files.createDirectories(testResourcePath);
        }

        if (!Files.exists(testYml)) {
            Files.createFile(testYml);
        }

        if (!Files.exists(inTestYml)) {
            Files.createFile(inTestYml);
        }

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("test", "testValue");

        DumperOptions options = new DumperOptions();
        // options.setDefaultFlowStyle(FlowStyle.FLOW);
        options.setDefaultFlowStyle(FlowStyle.BLOCK);
        Yaml yaml = new Yaml(options);

        // InputStream inputStr = new FileInputStream(testYml.toFile());
        InputStream inputStr = YamlTest.class.getClassLoader().getResourceAsStream(inTestYml.toString());
        // InputStream inputStr =
        // YamlTest.class.getClassLoader().getResourceAsStream(testYml.toString());
        // //not working

        // load to Map
        Map<String, Object> inputStrMap = yaml.load(inputStr);
        System.out.println(inputStrMap);

        // load to Custom Class
        InputStream customInputStr = new FileInputStream(testYml.toFile());
        Yaml customerYaml = new Yaml(new Constructor(Customer.class));
        Customer customer = customerYaml.load(customInputStr);
        System.out.println(customer);

        // load Multiple Object
        InputStream multiInputStr = new FileInputStream(testMultiYml.toFile());
        int i = 1;
        for (Object cus : customerYaml.loadAll(multiInputStr)) {

            if (cus instanceof Customer) {
                System.out.println(i++ + " : " + cus.toString());
            }
        }

        // Yaml Dump Test
        FileWriter fw = new FileWriter(outYml.toFile());
        yaml.dump(map, fw);

        // dump - StringWriter
        StringWriter sw = new StringWriter();
        yaml.dump(map, sw);
        System.out.println("string writer : " + sw.toString());

        // dump - FileWriter
        FileWriter fwCustom = new FileWriter(outCustomYml.toFile());
        customerYaml.dump(customer, fwCustom);

    }
}
