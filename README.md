# Springboot-dubbo

springboot整合dubbo的工程示例，采用了zookeeper作为注册中心。

boot版本是`2.3`

dubbo使用`org.apache.dubbo`的`dubbo-spring-boot-starter`

zk客户端使用官方最新推荐的`curator`

放弃使用xml配置方式，使用推荐的注解+配置文件形式