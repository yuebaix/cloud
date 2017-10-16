Cloudladder
=
`components`
-
> *miroservice soa noserver*

components | support
---|---
parent | parent pom > *springcloud maven management*
facade | consumer support jar > *feign service template*
center | eureka server > *singleton and multi-instance*
config | eureka client,config server > *singleton and multi-instance*
provider | eureka client > *service-provider*
consumer | eureka client,feign,hystrix,hystrix dashboard > *service-consumer*
redis | redis ability
dfs | fastdfs ability
kafuka | msg queue ability

`architecture`
-
server-instance | support
---|---
center | eureka server > *singleton and multi-instance*
config | eureka client,config server > *singleton and multi-instance*
provider | eureka client > *service-provider*
consumer | eureka client,hystrix,hystrix dashboard > *service-consumer*
gateway | zuul > *cloud gatway and routes*
sso | Oauth2 > *auth center*
app | springboot app