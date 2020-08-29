# 服务端

重点注意

配置文件下显式配置`dubbo.registry.client`为`curator`

实现类请使用`@DubboService`（而不是旧标准下的`dubbo`包的`@Service`注解）并显式指定`version`参数，避免不必要的麻烦。

