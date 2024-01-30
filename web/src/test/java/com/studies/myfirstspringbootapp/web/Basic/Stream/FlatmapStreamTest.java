package com.studies.myfirstspringbootapp.web.Basic.Stream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 扁平化流测试
 */
public class FlatmapStreamTest extends TextFileReader {
    /**
     * 使用flatMap转换流成功
     */
    @Test
    public void use_flatmap_convert_stream_success() throws IOException {
        try (Stream<String> words = this.flatMapStream()) {
            words.limit(7)
                    .forEach(s -> System.out.printf("%s ", s));
        }
    }

    /**
     * 使用map转换流成功
     */
    @Test
    public void use_map_convert_stream_success() throws IOException {
        try (Stream<Stream<String>> words = this.mapStream()) {
            words.limit(7)
                    .forEach(s -> System.out.printf("%s%n", s));
            /*
             * 输出结果为：
             * java.util.stream.ReferencePipeline$Head@12028586
             * java.util.stream.ReferencePipeline$Head@17776a8
             * java.util.stream.ReferencePipeline$Head@69a10787
             * java.util.stream.ReferencePipeline$Head@2d127a61
             * java.util.stream.ReferencePipeline$Head@2bbaf4f0
             */
        }
    }

    /**
     * 使用flatMap转换流
     *
     * @return ：文件内容转换为单词流
     * @throws IOException ：文件不存在或URI错误
     */
    private Stream<String> flatMapStream() throws IOException {
        return Files.lines(Paths.get(this.getFileURI("Cheese.dat")))
                .skip(1)
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));

    }

    /**
     * 使用map转换流
     *
     * @return ：单词流的流
     * @throws IOException ：文件不存在或URI错误
     */
    private Stream<Stream<String>> mapStream() throws IOException {
        /*
         * Pattern.compile().splitAsStream() 产生的结果为流，
         * 这意味着当我们只是想要一个简单的单词流时，在传入的行流（stream of lines）上调
         * 用map() 会产生一个单词流的流。幸运的是，flatMap() 可以将元素流的流扁平化为
         * 一个简单的元素流。
         */
        return Files.lines(Paths.get(this.getFileURI("Cheese.dat")))
                .skip(1)
                .map(line -> Pattern.compile("\\W+").splitAsStream(line));
    }
}
