import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) throws Exception {

        Document lingDoc = Jsoup.connect("http://catalog.illinois.edu/courses-of-instruction/ling/")
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
                .referrer("http://www.google.com")
                .get();


        Elements lingCourses = lingDoc.select("div.courses");
        // course class = courseblock
        String text = lingCourses.text();

        for (Element lingCourse : lingCourses) {
            // the new Element of lingCourse (= 0) in an array of lingCourses (lines))
            System.out.println(text.replace(" ","\n"));
        }

    }

//    public String elementCollector() throws Exception{
//        Document doc = Jsoup.connect("http://catalog.illinois.edu/courses-of-instruction/ling/")
//                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
//                .referrer("http://www.google.com")
//                .get();
//        // grabbed from URL of website and userAgent proves to the website not spiderbot
//
//        Elements titles = doc.select("courseblock");
//        String text = titles.text();
//
////        for (Element title : titles) {
////            System.out.println(text);
//
//        return text;
//    }
}
