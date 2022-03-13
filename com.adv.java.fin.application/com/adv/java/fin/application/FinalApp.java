package com.adv.java.fin.application;

import com.adv.java.xml.Lesson4XML;
import com.adv.java.iostream.Lesson1IOStream;
import com.adv.java.regex.Lesson2RegEx;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

class FinalApp{

    public static void main(String[] args) throws IOException, ClassNotFoundException, XPathExpressionException, ParserConfigurationException, SAXException {
        String[] lesson1argsA = {"--help"};
        String[] lesson1argsB = {"--text"};
        String[] lesson1argsC = {"--binary"};
        String[] lesson1argsD = {"--object"};

        System.out.println(">>>>>>>>>>>>>>>>>Lesson1IOStream");
        System.out.println("===============");
        System.out.println("+++++++++++++++");
        System.out.println("Lesson1IOStream --help");
        Lesson1IOStream.main(lesson1argsA);
        System.out.println("---------------");
        System.out.println("+++++++++++++++");
        System.out.println("Lesson1IOStream --text");
        Lesson1IOStream.main(lesson1argsB);
        System.out.println("---------------");
        System.out.println("+++++++++++++++");
        System.out.println("Lesson1IOStream --binary");
        Lesson1IOStream.main(lesson1argsC);
        System.out.println("---------------");
        System.out.println("+++++++++++++++");
        System.out.println("Lesson1IOStream --object");
        Lesson1IOStream.main(lesson1argsD);
        System.out.println("---------------");
        System.out.println("Lesson1IOStream<<<<<<<<<<<<<<<<<");

        String[] lesson2argsA = {"neighbor-dump.txt"};
        System.out.println(">>>>>>>>>>>>>>>>>Lesson2Regex");
        System.out.println("===============");
        System.out.println("+++++++++++++++");
        System.out.println("Lesson2Regex neighbor-dump.txt ");
        Lesson2RegEx.main(lesson2argsA);
        System.out.println("---------------");
        System.out.println("Lesson2Regex<<<<<<<<<<<<<<<<<");


        System.out.println(">>>>>>>>>>>>>>>>>Lesson4XML");
        System.out.println("===============");
        System.out.println("+++++++++++++++");
        System.out.println("Lesson4XML");
        String[] lesson4argsA = {"JobResult_UCSDExt.xml"};
        Lesson4XML.main(lesson4argsA);
        System.out.println("Lesson4XML<<<<<<<<<<<<<<<<<");
    }
}