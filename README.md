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
    http://localhost:10199/c-demo-consumer/env
    java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi0 &
    http://localhost:10199/c-demo-consumer/env
    java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi1 &
    http://localhost:10199/c-demo-consumer/env
    java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi2 &
    http://localhost:10199/c-demo-consumer/env

`provider`
-
    depend on center
    
    http://localhost:10200
    http://localhost:10200/service-instances/b-demo-provider
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
    http://localhost:10300/show/b-demo-provider
    http://localhost:10300/show/c-demo-consumer
    http://localhost:10300/whoisthis
    java -jar consumer-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &

`sso`
-
    depend on provider,config
    
    --http://localhost:10400
    --http://localhost:10400/show
    http://localhost:10400/show/b-demo-provider
    http://localhost:10400/show/c-sso
    java -jar sso-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &

`monitor`
-
    depend on center,consumer,sso
    
    java -jar monitor-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &
    
    monitor-page:
    http://localhost:10099/hystrix
    --http://localhost:10099/turbine.stream

`gateway`
-
    depend on center,provider
    
    java -jar gateway-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &
    java -jar gateway-1.0-SNAPSHOT.jar --server.port=20000 &
    java -jar gateway-1.0-SNAPSHOT.jar --jerry.activeprofile=multi --server.port=20000 &
    --http://localhost:20000/singleton
    --http://localhost:20000/multi
    http://localhost:20000/b-demo-provider

> cloud-status-page:
>> http://localhost:10100
> monitor-page:
>> http://localhost:10099/hystrix
        <br>
       --http://localhost:10099/turbine.stream