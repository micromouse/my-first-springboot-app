package com.studies.myfirstspringbootapp.web.Basic.Collections;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Map测试
 */
public class MapTest {
    /**
     * 使用HashMap计算数字出现次数成功
     */
    @Test
    public void use_hashmap_calculate_number_count_success() {
        Random random = new Random(47);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int key = random.nextInt(20);
            Integer count = map.get(key);
            map.put(key, count == null ? 1 : count + 1);
        }
        System.out.println(map);
    }
}
