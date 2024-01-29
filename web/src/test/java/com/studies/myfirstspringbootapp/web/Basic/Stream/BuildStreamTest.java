package com.studies.myfirstspringbootapp.web.Basic.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 构建流测试
 */
public class BuildStreamTest {
    /**
     * 读取文本文件并生成流成功
     */
    @Test
    public void read_textfile_and_build_stream_success() throws IOException {
        FileToWordsBuilder fileToWordsBuilder = new FileToWordsBuilder();
        Assertions.assertFalse(fileToWordsBuilder.isBuilded());

        //已构建流再次添加内容将抛出IllegalStateException异常
        Stream<String> wordsStream = fileToWordsBuilder.build();
        Assertions.assertThrows(IllegalStateException.class, () -> fileToWordsBuilder.addOtherWord("c"));

        //打印流
        wordsStream.limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}

class FileToWordsBuilder extends TextFileReader {
    boolean isBuilded = false;
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder() throws IOException {
        Path path = Paths.get(this.getFileURI("Cheese.dat"));

        /*
         * 为了确保文件资源被适当地释放，您应该使用 try-with-resources 语句来自动管理资源的关闭。
         * try-with-resources 语句会确保在语句块执行完毕后，无论是正常结束还是遇到异常，资源都会被关闭。
         */
        try (Stream<String> lines = Files.lines(path)) {
            lines.skip(1)
                    .forEach(line -> {
                        for (String word : line.split("[ .?,]+")) {
                            builder.add(word);
                        }
                    });
        }
    }

    /**
     * 添加其他单词
     *
     * @param word ：单词
     */
    public void addOtherWord(String word) {
        builder.add(word);
    }

    /**
     * 要你不调用stream() 方法，就可以继续向builder对象中添加单词。
     *
     * @return : 已构建的单词流
     */
    public Stream<String> build() {
        Stream<String> build = builder.build();
        isBuilded = true;
        return build;
    }

    /**
     * 获得是否已构建
     *
     * @return ：是否已构建流
     */
    public boolean isBuilded() {
        return isBuilded;
    }
}
