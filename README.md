jufan cloud
=====
[Jufan Co.Ltd](http://www.juxiangfen.com/)

center
----------
http://localhost:10100
<br>
<br>
<br>

config
----------
依赖center

http://localhost:10199/demo-consumer/env
<br>

provider
----------
依赖center

http://localhost:10200
<br>
http://localhost:10200/service-instances/demo-provider
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
<br>
<br>
<br>