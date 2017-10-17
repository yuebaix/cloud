    获取token
    http://localhost:20000/sso/oauth/token?grant_type=password&username=mocker&password=nevergiveupnevergivein
    http://localhost:20000/sso/oauth/token
    
    Header:(Authorization)
    BasicAuth
    Username:sso_client
    Password:sso_client_pwd
    Body:(form-data)
    grant_type:password
    username:mocker
    password:nevergiveupnevergivein
    
    测试获取用户信息
    http://localhost:20000/sso/user?access_token=92d21ffb-0e20-4dce-92b8-47f04ef43fa9
    
    测试权限控制
    http://localhost:20000/sso/demo?access_token=76e9aea0-6514-41d2-b964-4b4c79dac675