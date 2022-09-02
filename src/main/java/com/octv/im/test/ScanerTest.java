package com.octv.im.test;

import com.octv.im.constant.EventNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class ScanerTest {
    // 需要扫描的路径
    private static final String scanPackage = "com.octv.im";

    /**
     * 启动就开始扫描到map
     */
    @PostConstruct
    public void init() {
        discoverComponents();
    }


    public void discoverComponents() {
        // 扫描获取BeanDefinition列表
        Set<BeanDefinition> beanDefinitions = getBeanDefinitions(EventNode.class);
        for (BeanDefinition def : beanDefinitions) {
            try {
                //
                String clazzName = def.getBeanClassName();
                Class<?> clazz = Class.forName(clazzName);
                System.out.println("name -------->    +"  + clazzName);
                // 获取类上面的自定义注解
                EventNode node = clazz.getAnnotation(EventNode.class);
                // 注解上的参数信息
                String component = node.component();
            } catch (Exception e) {
                log.error("load class fail", e);
            }
        }
        log.info("Found following definitions: {}");
    }

    /**
     * 扫描包，获取类
     *
     * @param componentType
     * @return
     */
    private Set<BeanDefinition> getBeanDefinitions(final Class<? extends Annotation> componentType) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(componentType));
        Set<BeanDefinition> defs = new HashSet<>();
        defs.addAll(scanner.findCandidateComponents(scanPackage));
        return defs;
    }
}
