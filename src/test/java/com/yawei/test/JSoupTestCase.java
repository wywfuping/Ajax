package com.yawei.test;

import com.yawei.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

public class JSoupTestCase {
    @Test
    public void testGetImage() throws IOException, InterruptedException {

        for (int i = 1; i < 3; i++) {

            Document document = Jsoup.connect("http://www.topit.me/pop?p=" + i).cookie("is_click", "1").get();
            Elements elements = document.select("#content .catalog .e>a");

            for (Element element : elements) {
                String href = element.attr("href");

                Document bigImageDoc = Jsoup.connect(href).cookie("is_click", "1").get();
                Element imgElement = bigImageDoc.select("#content>a").first();
                String imgSrc = imgElement.attr("href");

                System.out.println(imgSrc);
                //Thread.sleep(5000);
                String fileName = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
                HttpUtil.getStream(imgSrc, "F:/download/" + fileName);
            }
        }

    }


    @Test
    public void testWeiboImage() throws IOException, InterruptedException {

        Document document = Jsoup.connect("http://photo.weibo.com/tags/best/tag/%E5%B0%8F%E6%B8%85%E6%96%B0?prel=p3_1").get();
        Elements elements = document.select("#wf_wrap #waterfall .m_pin_box .photoArea a");
        System.out.println(elements);
       /* for (Element element : elements) {
            String href = element.attr("href");

            Document bigImageDoc = Jsoup.connect(href).cookie("is_click", "1").get();
            Element imgElement = bigImageDoc.select("#wf_wrap #waterfall>a").first();
            String imgSrc = imgElement.attr("href");

            System.out.println(imgSrc);
            String fileName = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            HttpUtil.getStream(imgSrc, "F:/download/" + fileName);
        }*/
    }
}

