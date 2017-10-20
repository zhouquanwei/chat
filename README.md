# chat
微信公众号
用jaxb 实现java对象生成xml
jaxb生成xml会有文档声明，但是微信不允许有文档声明，所以在jaxb生成xml后我使用dom4j取出rootelement,从而去掉xml文档声明。
为什么我不使用jaxb去除xml文档声明，当然是因为我不会啊！！哈哈
