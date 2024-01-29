package com.studies.myfirstspringbootapp.web.Basic.Stream;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 文本文件读取器
 */
class TextFileReader {
    /**
     * 读取文件
     *
     * @param file ：文件
     * @return ：按行读取的文件内容集合
     * @throws IOException ：文件未找到或URI错误
     */
    public List<String> read(String file) throws IOException {
        URI fileURI = this.getFileURI(file);
        return Files.readAllLines(Paths.get(fileURI));
    }

    /**
     * 获得文件URI
     *
     * @param file ：文件
     * @return : 文件URI
     * @throws IOException : 文件未找到或URI错误
     */
    protected URI getFileURI(String file) throws IOException {
        URL url = getClass().getClassLoader()
                .getResource(file);
        if (url == null) {
            throw new IOException(String.format("文件[%s]未找到", file));
        }

        try {
            return url.toURI();
        } catch (URISyntaxException e) {
            throw new IOException(String.format("文件[%s]未找到", file), e);
        }
    }
}
