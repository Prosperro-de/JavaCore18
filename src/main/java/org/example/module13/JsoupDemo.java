package org.example.module13;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://avtozvuk.ua/ua/motul-8100-eco-nergy-5w-30-812306-5l/p25841")
                .get();
        Element element = doc.selectFirst("span.benefits-price__text");
        System.out.println(element.text());
    }
}
