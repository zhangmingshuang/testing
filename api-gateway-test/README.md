# API网关测试
> 非专业测试，只是为了技术选型的基本性能要求测试

## 测试总体（以WRK测试数据为总结）
|框架|QPS|平均延迟|基准QPS|基准平均延迟|QPS下降|延迟增加|
|--|--|--|--|--|--|--|
|[soul](./soul)|-|-|-|-|-|-|
|[spring-cloud-gateway](./spring-cloud-gateway)|7375.29|108.47ms|31106.53|31.90ms|-76%|+3.4倍|
|[spring-cloud-zuul](./spring-cloud-zuul)|5580.81|145.17ms|31307.53|31.56ms|-82%|+4.6倍|
