package cn.edu.szu.train.generator.server;

import cn.edu.szu.train.generator.util.FreeMarkerUtil;
import freemarker.template.TemplateException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ServerGenerator {
    static String servicePath = "[module]/src/main/java/cn/edu/szu/train/[module]/service/";
    static String pomPath = "generator\\pom.xml";
    static {
        new File(servicePath).mkdirs();
    }

    public static void main(String[] args) throws IOException, TemplateException, DocumentException {
        // 获取mybatis-generator
        String generatorPath = getGeneratorPath();
        // 如generator-config-member.xml，得到module = member
        String module = generatorPath.replace("src/main/resources/generator-config-", "").replace(".xml", "");
        System.out.println("module:" + module);
        servicePath = servicePath.replace("[module]", module);
        System.out.println("servicePath:" + servicePath);

        // 读取table节点
        Document document = new SAXReader().read("generator/" + generatorPath);
        Node table = document.selectSingleNode("//table");
        System.out.println(table);
        Node tableName = table.selectSingleNode("@tableName");
        Node domainObjectName = table.selectSingleNode("@domainObjectName");
        System.out.println(tableName.getText() + "/" + domainObjectName.getText());

        // 示例：表明jiawa_test
        // Domain = JiawaTest
        String Domain = domainObjectName.getText();
        // domain = jiawaTest
        String domain = Domain.substring(0, 1).toLowerCase() + Domain.substring(1);
        // do_main
        String do_main = tableName.getText().replaceAll("_", "-");
        HashMap<String, Object> param = new HashMap<>();
        param.put("Domain", Domain);
        param.put("domain", domain);
        param.put("do_main", do_main);
        System.out.println(param);

        FreeMarkerUtil.initConfig("service.ftl");
        FreeMarkerUtil.generator(servicePath + Domain + "Service.java", param);
    }

    private static String getGeneratorPath() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        HashMap<String, String> map = new HashMap<>();
        map.put("pom", "http://maven.apache.org/POM/4.0.0");
        saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
        saxReader.setEncoding("UTF-8");
        Document document = saxReader.read(pomPath);
        Node node = document.selectSingleNode("//pom:configurationFile");
        System.out.println(node.getText());
        return node.getText();
    }
}
