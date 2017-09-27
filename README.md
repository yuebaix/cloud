jufan cloud
=
<a href="http://www.juxiangfen.com"><img width="100" height="50" src="http://www.juxiangfen.com/prd/images/logo.png"><br>
[Jufan Co.Ltd](http://www.juxiangfen.com/)

`hosts`
-
    #localserver hosts settings
    127.0.0.1 center0.jufandev.com
    127.0.0.1 center1.jufandev.com
    127.0.0.1 center2.jufandev.com
    127.0.0.1 config0.jufandev.com
    127.0.0.1 config1.jufandev.com
    127.0.0.1 config2.jufandev.com
    
`center`
-
    default
    http://localhost:10100
    java -jar center-1.0-SNAPSHOT.jar --jerry.activeprofile=multi0 &
    http://localhost:10100
    java -jar center-1.0-SNAPSHOT.jar --jerry.activeprofile=multi1 &
    http://localhost:10101
    java -jar center-1.0-SNAPSHOT.jar --jerry.activeprofile=multi2 &
    http://localhost:10102
    
`config`
-
    depend on center
    
    default
    http://localhost:10199/demo-consumer/env
    java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi0 &
    http://localhost:10199/demo-consumer/env
    java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi1 &
    http://localhost:10198/demo-consumer/env
    java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi2 &
    http://localhost:10197/demo-consumer/env

`provider`
-
    depend on center
    
    http://localhost:10200
    http://localhost:10200/service-instances/demo-provider
    java -jar provider-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &
    java -jar provider-1.0-SNAPSHOT.jar --server.port=10200 &
    java -jar provider-1.0-SNAPSHOT.jar --server.port=10201 &
    java -jar provider-1.0-SNAPSHOT.jar --jerry.activeprofile=multi --server.port=10200 &
    
`consumer`
-
    depend on provider,config
    
    http://localhost:10300/env
    --http://localhost:10300
    --http://localhost:10300/show
    http://localhost:10300/show/demo-provider
    http://localhost:10300/show/demo-consumer
    http://localhost:10300/whoisthis
    java -jar consumer-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &
    http://localhost:10300/hystrix/
    http://localhost:10300/hystrix.stream
    http://localhost:10300/get/2
    http://localhost:10300/show

`gateway`
-
    depend on center,provider
    
    http://localhost:10200/service-instances/demo-provider
    java -jar gateway-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &
    java -jar gateway-1.0-SNAPSHOT.jar --server.port=20000 &
    java -jar gateway-1.0-SNAPSHOT.jar --jerry.activeprofile=multi --server.port=20000 &
    http://localhost:20000/singleton
    http://localhost:20000/multi
    
