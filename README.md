jufan cloud
=====
<a href="http://www.juxiangfen.com"><img width="100" height="50" src="http://www.juxiangfen.com/prd/images/logo.png"><br>
[Jufan Co.Ltd](http://www.juxiangfen.com/)

center
----------

default
<br>
http://localhost:10100
<br>
java -jar center-1.0-SNAPSHOT.jar --spring.profiles.active=center0 &
<br>
http://localhost:10100
<br>
java -jar center-1.0-SNAPSHOT.jar --spring.profiles.active=center1 &
<br>
http://localhost:10101
<br>
java -jar center-1.0-SNAPSHOT.jar --spring.profiles.active=center2 &
<br>
http://localhost:10102

config
----------
依赖center

default
<br>
http://localhost:10197/demo-consumer/env
<br>
java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi0 &
<br>
http://localhost:10197/demo-consumer/env
<br>
java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi1 &
<br>
http://localhost:10198/demo-consumer/env
<br>
java -jar config-1.0-SNAPSHOT.jar --jerry.activeprofile=multi2 &
<br>
http://localhost:10199/demo-consumer/env

provider
----------
依赖center

http://localhost:10200
<br>
http://localhost:10200/service-instances/demo-provider
<br>
java -jar provider-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &
<br>

consumer
----------
依赖provider,config

http://localhost:10300/env
<br>
--http://localhost:10300
<br>
--http://localhost:10300/show
<br>
http://localhost:10300/show/demo-provider
<br>
http://localhost:10300/show/demo-consumer
<br>
http://localhost:10300/whoisthis
<br>
java -jar consumer-1.0-SNAPSHOT.jar --jerry.activeprofile=multi &
<br>
<br>
<br>
<br>