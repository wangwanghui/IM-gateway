//package com.octv.im.test;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.context.annotation.ComponentScans;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//
///**
// * 以前配置文件的方式被替换成了配置类，即配置类==配置文件
// * @author liayun
// *
// */
//// 这个配置类也是一个组件
//@ComponentScans(value={
//        @ComponentScan(value="com.octv.im", includeFilters={
//                /*
//                 * type：指定你要排除的规则，是按照注解进行排除，还是按照给定的类型进行排除，还是按照正则表达式进行排除，等等
//                 */
//                // 指定新的过滤规则，这个过滤规则是我们自个自定义的，过滤规则就是由我们这个自定义的MyTypeFilter类返回true或者false来代表匹配还是没匹配
//                @Filter(type=FilterType.CUSTOM, classes={MyTypeFilter.class})
//        }, useDefaultFilters=false) // value指定要扫描的包
//})
//@Configuration // 告诉Spring这是一个配置类
//public class MainConfig {
//
//    // @Bean注解是给IOC容器中注册一个bean，类型自然就是返回值的类型，id默认是用方法名作为id
//
//
//}
