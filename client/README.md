# Dubbo的客户端

同服务端，请务必将配置文件中的`dubbo.registry.client`字段显式指定为`curator`.

使用`@DubboReference`而不是旧的`@Reference`注解，并务必指定`version`字段