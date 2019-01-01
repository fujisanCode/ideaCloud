spring-boot-admin-server中引入了security
需要在config中设置过滤/actuator/** 的请求，否则admin无法检测到应用的运行状态