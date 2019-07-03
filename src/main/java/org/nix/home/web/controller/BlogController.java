package org.nix.home.web.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客相关控制器
 */
@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    /**
     * 搜索博客信息
     *
     * @param order     排序方式，默认最新排序（new/hot）
     * @param keyword   文章关键字 == 博客的标签
     * @param async     是否异步获取
     * @param pageIndex 分页页码
     * @param pageSize  每页数据量
     * @param catalog   博客分类id
     * @return 返回查询数据结果
     */
    @GetMapping
    public String blog(
            @RequestParam(value = "order", defaultValue = "new") String order,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "async", defaultValue = "false") boolean async,
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "catalog", required = false) Integer catalog
    ) {
        return StrUtil.format("{},{},{},{},{}", order, keyword, async, pageIndex, pageSize);
    }

}
