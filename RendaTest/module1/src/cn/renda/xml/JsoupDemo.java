package cn.renda.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Renda Zhang
 * @create 2020-04-22 18:12
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);

        System.out.println("-----------------------");

        Elements elements1 = document.select("student[number=\"itcast_0002\"] > age");
        System.out.println(elements1);
    }
}
