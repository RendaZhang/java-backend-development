package cn.renda.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Renda Zhang
 * @create 2020-04-22 17:23
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println(path);

        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);

        //3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        //3.1获取第一个name的Element对象
        Element element = elements.get(0);
        //3.2获取数据
        String name = element.text();
        System.out.println(name);

    }
}
