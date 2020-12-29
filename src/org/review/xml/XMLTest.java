package org.review.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author lijichen
 * @date 2020/10/8 - 16:22
 */
public class XMLTest {
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document read = reader.read("books.xml");

        //获取根节点
        Element rootElement = read.getRootElement();
        //获取根节点中元素集合
        List<Element> books = rootElement.elements();
        for (Element book : books) {
            //获取元素
            Element e = book.element("name");
//            System.out.println(e.asXML());//转换为字符串输出
            String name = e.getText();
            System.out.println(name);
            //合并获取
            String author = book.elementText("author");
            //获取价格
            Double price = Double.valueOf(book.elementText("price"));
            //获取序列号(属性)
            String id = book.attributeValue("id");
            System.out.println(new Book(id,name,author,price));
        }
    }
}
