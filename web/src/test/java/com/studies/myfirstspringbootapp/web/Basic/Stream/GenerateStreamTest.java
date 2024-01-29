package com.studies.myfirstspringbootapp.web.Basic.Stream;

import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 生产流测试
 */
public class GenerateStreamTest {
    /**
     * 流限制分隔成功
     */
    @Test
    public void stream_limit_and_joining_success() throws IOException {
        WordsSupplier wordsSupplier = new WordsSupplier();
        String values = Stream.generate(wordsSupplier)
                .limit(10)
                .collect(Collectors.joining(" "));
        System.out.printf("随机生成10个单词：%s%n", values);
        System.out.printf("所有单词: %s%n", wordsSupplier);
    }
}

/**
 * 单词Supplier
 */
class WordsSupplier implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random random = new Random(47);

    /**
     * 初始化单词Supplier
     */
    WordsSupplier() throws IOException {
        URI fileURI = this.getFileURI();
        List<String> lines = Files.readAllLines(Paths.get(fileURI));

        //略过第一行读取所有行，使用[空格,点号,问号,逗号]分隔单词
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }

    @Override
    public String get() {
        return words.get(random.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(" "));
    }

    /**
     * 获得文件[Cheese.dat]URI
     *
     * @return : 文件[Cheese.dat]URI
     * @throws IOException : 文件[Cheese.dat]未找到或URI错误
     */
    private URI getFileURI() throws IOException {
        URL url = getClass().getClassLoader()
                .getResource("Cheese.dat");
        if (url == null) {
            throw new IOException("文件[Cheese.dat]未找到");
        }

        try {
            return url.toURI();
        } catch (URISyntaxException e) {
            throw new IOException("文件[Cheese.dat]未找到", e);
        }
    }

}
