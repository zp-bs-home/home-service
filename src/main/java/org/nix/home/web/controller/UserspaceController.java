package org.nix.home.web.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * 用户主页控制器
 */
@RestController
@RequestMapping(value = "/userspace")
public class UserspaceController {

    /**
     * 查询一个用户的主页信息
     *
     * @param username 用户名字
     * @return 返回用户主页展示信息
     */
    @GetMapping(value = "/{username}")
    public String userspace(@PathVariable String username) {
        return StrUtil.format("查询用户主页信息：{}", username);
    }

    /**
     * 获取当前登陆用户的设置信息
     *
     * @param username 用户名
     * @return 用户设置页面的默认值
     */
    @GetMapping(value = "/{username}/profile")
    public String getProfile(@PathVariable String username) {
        return username;
    }

    /**
     * 保存用户设置的一些信息
     *
     * @param username 登陆用户名
     * @param keepInfo 待保存的信息
     * @return 处理结果
     */
    @PostMapping(value = "/{username}/profile")
    public String setProfile(@PathVariable String username, @ModelAttribute Object keepInfo) {
        return keepInfo.toString() + username;
    }

    /**
     * 获取用户头像信息
     *
     * @param username 用户名字
     * @return 头像链接
     */
    @GetMapping(value = "/{username}/avatar")
    public String getAvatar(@PathVariable String username) {
        return username;
    }

    /**
     * 设置用户头像信息
     *
     * @param username 用户名
     * @return 处理结果
     */
    @PostMapping(value = "/{username}/avatar")
    public String setAvatar(@PathVariable String username) {
        return username;
    }

    /**
     * 用户主页空间
     *
     * @param order     排序方式，默认最新排序（new/hot）
     * @param keyword   文章关键字 == 博客的标签
     * @param async     是否异步获取
     * @param pageIndex 分页页码
     * @param pageSize  每页数据量
     * @param catalog   博客分类id
     * @param username  用户名
     * @return 返回查询数据结果
     */
    @GetMapping(value = "/{username}/blog")
    public String blog(
            @RequestParam(value = "order", defaultValue = "new") String order,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "async", defaultValue = "false") boolean async,
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "catalog", required = false) Integer catalog,
            @PathVariable String username
    ) {
        return StrUtil.format("{},{},{},{},{}", order, keyword, async, pageIndex, pageSize);
    }

    /**
     * 获取用户新增博客的时候的初始化信息
     *
     * @param principal 登陆信息
     * @return 初始化信息
     */
    @GetMapping(value = "/blog/edit")
    public String getEdit(Principal principal) {
        return principal.getName();
    }

    /**
     * 保存新增的博客信息
     *
     * @param principal 登陆信息
     * @param blog      博客信息
     * @return
     */
    @PostMapping(value = "/blog/edit")
    public String setEdit(Principal principal, @ModelAttribute Object blog) {
        return principal.getName();
    }

    /**
     * 获取编辑某篇博客的初始化信息
     *
     * @param principal 登录用户信息
     * @param blogId    待修改的博客id
     * @return 处理结果
     */
    @GetMapping(value = "/blog/edit/{blogId}")
    public String updateEdit(Principal principal, @PathVariable Integer blogId) {
        return principal.getName();
    }

    /**
     * 保存更新后的博客信息
     *
     * @param principal 登陆用户信息
     * @param blogId    博客id
     * @param blog      更新的内容
     * @return 处理结果
     */
    @PostMapping(value = "/blog/edit/{blogId}")
    public String updateEdit(Principal principal,
                             @PathVariable Integer blogId,
                             @ModelAttribute Object blog
    ) {
        return principal.getName();
    }

}
