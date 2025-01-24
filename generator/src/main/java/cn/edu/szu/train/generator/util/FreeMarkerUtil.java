package cn.edu.szu.train.generator.util;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FreeMarkerUtil {
    static String ftlPath = "generator\\src\\main\\java\\cn\\edu\\szu\\train\\generator\\ftl\\";

    static Template template;

    /**
     * 读模板
     */
    public static void initConfig(String ftlName) throws IOException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_33);
        config.setDirectoryForTemplateLoading(new File(ftlPath));
        config.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_33));
        template = config.getTemplate(ftlName);
    }

    /**
     * 根据模板，生成文件
     */
    public static void generator(String fileName, Map<String, Object> map) throws IOException, TemplateException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        template.process(map, bw);
        bw.flush();
        fw.close();
    }
}
