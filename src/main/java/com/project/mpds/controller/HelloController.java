package com.project.mpds.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Rainful
 * @create 2022-02-18
 **/

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world") // todo 1
    /* 这里我们确定好请求方式 总计四种 get / post / put / delete 分别对应 @GetMapping / @PostMapping / @PutMapping / @DeleteMapping */
    /*
        括号里面代表路径 最上面有个 requestMapping 代表层级目录 所以这个方法的地址就是 /hello/world
        稍后启动之后可以访问浏览器 localhost:8080/hello/world 就可以看到hello world了
     */
    public String helloWorld(){
        // todo 2 在这里写一个 public 方法 返回的类型先写字符串吧 String
        return "Hello World";
    }


}
