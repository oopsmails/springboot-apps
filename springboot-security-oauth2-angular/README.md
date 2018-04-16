# springboot-apps

Initially from:

http://www.baeldung.com/rest-api-spring-oauth2-angularjs


###################### H2 #####################
jdbc.driverClassName=org.h2.Driver
jdbc.url=jdbc:h2:~/data/oauth2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE
jdbc.user=sa
jdbc.pass=

--> two angular (5), ui frontend.


--> example

1. OAuth2AuthorizationServerConfigInMemory
.inMemory()
-- .jdbc(dataSource()) is commented out

2. OAuth2AuthorizationServerConfig: 
.jdbc(dataSource())

3. OAuth2AuthorizationServerConfigJwt
public DefaultTokenServices tokenServices()
new JwtTokenStore(accessTokenConverter());

curl -X POST --user 'fooClientIdPassword:secret' -d 'grant_type=password&username=tom&password=111' http://localhost:7081/spring-security-oauth-server/oauth/token


curl -X POST --user 'sampleClientId:secret' -d 'grant_type=implicit&username=tom&password=111' http://localhost:7081/spring-security-oauth-server/oauth/authorize




---

http://localhost:4201/
this.oauthService.redirectUri = 'http://localhost:4201/'; <----------- to self app!!!
http://localhost:4202/login







