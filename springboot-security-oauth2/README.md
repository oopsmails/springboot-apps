# springboot-apps


====> Spring Boot Security OAuth2 Example(Bcrypt Encoder)
OAuth2 means there always exists an AuthorizationServerConfig, for generating tokens.
This is using default-token-store, Bcrypt Encoder.

http://www.devglan.com/spring-security/spring-boot-security-oauth2-example

https://github.com/only2dhir/spring-boot-security-oauth2/tree/master

----------------------------------------------

What is OAuth2
OAuth 2 is an authorization framework that enables applications to obtain limited access to user accounts on an HTTP service, such as Facebook, GitHub, and DigitalOcean. It works by delegating user authentication to the service that hosts the user account, and authorizing third-party applications to access the user account. OAuth 2 provides authorization flows for web and desktop applications, and mobile devices.

OAuth2 Roles
OAuth2 provides 4 different roles.

Resource Owner: User

Client: Application

Resource Server: API

Authorization Server: API

OAuth2 Grant Types
Following are the 4 different grant types defined by OAuth2

Authorization Code: used with server-side Applications

Implicit: used with Mobile Apps or Web Applications (applications that run on the user's device)

Resource Owner Password Credentials: used with trusted Applications, such as those owned by the service itself

Client Credentials: used with Applications API access

--------------------------------------

spring-boot-security-oauth2-master


<groupId>com.oopsmails.springboot.security.oauth2</groupId>
<artifactId>springboot-security-oauth2</artifactId>


springboot-security-oauth2-default-token-store


com.oopsmails.springboot.security.oauth2.defaulttokenstore


SpringbootSecurityOAuth2DefaultTokenStoreApplication


==> Error: always generate table name as user, i.e, lowercase

Solution:
@Table(name = "User")

spring.jpa.properties.hibernate.globally_quoted_identifiers=true
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl


==> Generate AuthToken:In the header we have username and password as Alex123 and password respectively as Authorization header.As per Oauth2 specification, Access token request should use application/x-www-form-urlencoded.

curl -X POST --user 'devglan-client:devglan-secret' -d 'grant_type=password&username=Alex123&password=password' http://localhost:8080/oauth/token

--> returning what configured in AuthorizationServerConfig
{"access_token":"cad8e3e1-dedc-4470-acbe-82b3c69af8e6","token_type":"bearer","refresh_token":"ccf77286-54f2-4f88-9b6c-f3ba0c8ce39e","expires_in":3599,"scope":"read write trust"}


==> Accessing resource:
curl -i -H "Accept: application/json" -H "Authorization: Bearer cad8e3e1-dedc-4470-acbe-82b3c69af8e6" -X GET http://localhost:8080/users/user
--> returning Alex123


==> Accessing resource:
curl -i -H "Accept: application/json" -X GET http://localhost:8080/users/user?access_token=662a9878-d56b-41de-a4d8-0c903f125167
--> returning all users

==> Refreshing token:

curl -X POST --user 'devglan-client:devglan-secret' -d 'grant_type=refresh_token&username=Alex123&password=password&refresh_token=0100d9a5-15d1-427f-8857-789b9d63cfff' http://localhost:8080/oauth/token


{"access_token":"0862a342-5a46-4305-a3e5-5afb53de4b61","token_type":"bearer","refresh_token":"0100d9a5-15d1-427f-8857-789b9d63cfff","expires_in":3599,"scope":"read write trust"}

-- Now, 
curl -i -H "Accept: application/json" -X GET http://localhost:8080/users/user?access_token=662a9878-d56b-41de-a4d8-0c903f125167
returning error
{"error":"invalid_token","error_description":"Invalid access token: 662a9878-d56b-41de-a4d8-0c903f125167"}

-- Using new access token will be ok
curl -i -H "Accept: application/json" -X GET http://localhost:8080/users/user?access_token=0862a342-5a46-4305-a3e5-5afb53de4b61


--------------------------------------


====> Spring Boot Security Oauth2 Jwt Auth Example
OAuth2 means there always exists an AuthorizationServerConfig, for generating tokens.
This is using jwt-token-store.

In this article, we will be discussing about OAUTH2 implementation with spring boot security and JWT token and securing REST APIs

http://www.devglan.com/spring-security/spring-boot-oauth2-jwt-example

https://github.com/only2dhir/spring-boot-jwt-auth

springboot-security-oauth2-jwt-token-store


com.oopsmails.springboot.security.oauth2.jwttokenstore


SpringbootSecurityOAuth2JwtTokenStoreApplication

Resource Server Config
Resource in our context is the REST API which we have exposed for the crud operation.To access these resources, client must be authenticated.In real-time scenarios, whenever an user tries to access these resources, the user will be asked to provide his authenticity and once the user is authorized then he will be allowed to access these protected resources.

resourceId: the id for the resource (optional, but recommended and will be validated by the auth server if present).

Since, we have resource-server and auhorization server implementation in the same project, we don't require to redefine our JwtAccessTokenConverter in the resource server config else we need to provide similar JwtAccessTokenConverter implementation in resource server too.


==> Generate AuthToken:In the header we have username and password as Alex123 and password respectively as Authorization header.As per Oauth2 specification, Access token request should use application/x-www-form-urlencoded.

curl -X POST --user 'devglan-client:devglan-secret' -d 'grant_type=password&username=Alex123&password=password' http://localhost:8087/oauth/token

--> returning what configured in AuthorizationServerConfig

{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjM1MDQxOTgsInVzZXJfbmFtZSI6IkFsZXgxMjMiLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6ImJkOGY0NDM2LTRmODMtNGRjYi05ODI1LThkNGUxNjhkYmVjMSIsImNsaWVudF9pZCI6ImRldmdsYW4tY2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIiwidHJ1c3QiXX0.6Q5okrcZ9ZdXsIcaBdZLGjwM8Xugxk5opnYlu9wHnOA","token_type":"bearer","refresh_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJBbGV4MTIzIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIiwidHJ1c3QiXSwiYXRpIjoiYmQ4ZjQ0MzYtNGY4My00ZGNiLTk4MjUtOGQ0ZTE2OGRiZWMxIiwiZXhwIjoxNTIzNTIyMTk4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6IjFlYWRlNmY3LTkzNDEtNGZjOS1iOWY5LTA5MjhjNTRhOGExZiIsImNsaWVudF9pZCI6ImRldmdsYW4tY2xpZW50In0.JloZh6aWteAl10ptyvGZGQieY6feRjF8JKqLGqanNF4","expires_in":3599,"scope":"read write trust","jti":"bd8f4436-4f83-4dcb-9825-8d4e168dbec1"}

==> Accessing resource:
curl -i -H "Accept: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjM1MDQxOTgsInVzZXJfbmFtZSI6IkFsZXgxMjMiLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6ImJkOGY0NDM2LTRmODMtNGRjYi05ODI1LThkNGUxNjhkYmVjMSIsImNsaWVudF9pZCI6ImRldmdsYW4tY2xpZW50Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIiwidHJ1c3QiXX0.6Q5okrcZ9ZdXsIcaBdZLGjwM8Xugxk5opnYlu9wHnOA" -X GET http://localhost:8087/users/user

--> returning all users


--------------------------------------


