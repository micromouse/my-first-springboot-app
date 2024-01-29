package com.studies.myfirstspringbootapp.web.Basic.Stream;

import org.junit.jupiter.api.Test;

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
     * 生成一般流成功
     */
    @Test
    public void generate_normal_stream_success() throws IOException {
        RandomWordsSupplier wordsSupplier = new RandomWordsSupplier();
        String values = Stream.generate(wordsSupplier)
                .limit(10)
                .collect(Collectors.joining(" "));
        System.out.printf("随机生成10个单词：%s%n", values);
        System.out.printf("所有单词: %s%n", wordsSupplier);
    }

    /**
     * 生成重复对象流成功
     */
    @Test
    public void generate_duplicator_stream_success() {
        Stream.generate(() -> "duplicator")
                .limit(10)
                .forEach(System.out::println);
    }
}

/**
 * 随机单词Supplier
 */
class RandomWordsSupplier extends TextFileReader implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random random = new Random(47);

    /**
     * 初始化单词Supplier
     */
    RandomWordsSupplier() throws IOException {
        List<String> lines = this.read("Cheese.dat");

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

}
