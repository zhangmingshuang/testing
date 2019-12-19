package com.test.configload;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试Resource目录下的配置properties与yml的加载顺序
 *
 * @author zhangmingshuang
 * @since 2019/12/19
 */
@Component
public class YPConfigCompenter {

    @Value("${file.yml:none}")
    private String yml;
    @Value("${file.prop:none}")
    private String prop;

    @PostConstruct
    public void print() {
        System.out.println(this.getClass().getName() + ">>config>>yml: " + yml + ",prop: " + prop);
    }
}
