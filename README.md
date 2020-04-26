# Demo for sso through Spring boot oauth2
Inspired by this article https://www.cnblogs.com/cjsblog/p/10548022.html

Three projects for demostration
- oauthserver :
    run on soc.wenet.com.cn:8080
- oauthclient :
    run on soc.wenet.com.cn:8082
- itsm:
    another client run on itsm.wenet.com.cn:8083

## Dns configuration
If you want to try on your localmachine, edit hosts file.
```
127.0.0.1   soc.wenet.com.cn
127.0.0.1   itsm.wenet.com.cn
```

## Prepare database enviroment
My db server is running on 192.168.8.205 via docker. docker-compose.yml file is used for a tempory db enviroment.

Any host for db with docker would be fine. Remember to change configuration file for db connection string.

## Initializing setting by sql
Initializing oauth client, user,role and permission table and inserting some test data.

## Start
run "./gradlew bootRun" in each of three projects.