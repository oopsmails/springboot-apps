# springboot-apps


====> Spring Boot Security Jwt Authentication
There is NO AuthorizationServer, just generating jwt locally.

securing our REST APIs with JWT(JSOn Web Token) authentication

http://www.devglan.com/spring-security/spring-boot-jwt-auth 


com.oopsmails.springboot.security.authapi
springboot-security-authapi
com.oopsmails.springboot.security.authapi.jwt
springboot-security-authapi-jwt


com.oopsmails.springboot.security.authapi.jwt
SpringbootSecurityAuthApiJwtApplication

Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbGV4MTIzIiwic2N.v9A80eU1VDo2Mm9UqN2FyEpyT79IUmhg

JWT Authentication Mechanism
Following class extends OncePerRequestFilter that ensures a single execution per request dispatch. This class checks for the authorization header and authenticates the JWT token and sets the authentication in the context.Doing so will protect our APIs from those requests which do not have any authorization token.The configuration about which resource to be protected and which not can be configured in WebSecurityConfig.java




--> signup
curl -H "Content-Type: application/json" -X POST -d '{"username":"albert", "password":"test123", "age":"22", "salary":"555"}' http://localhost:8086/signup

--> generate-token
curl -H "Content-Type: application/json" -X POST -d '{"username":"albert", "password":"test123"}' http://localhost:8086/token/generate-token

{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGJlcnQiLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9kZXZnbGFuLmNvbSIsImlhdCI6MTUyMzU4NzMwOSwiZXhwIjoxNTIzNjA1MzA5fQ.7Lm69ySiMsQ_N4EdMRnb5M0XKvy1XGWlJBuFOxPBhQE"}

--> call UserController

curl -X "GET" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGJlcnQiLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9kZXZnbGFuLmNvbSIsImlhdCI6MTUyMzU4NzMwOSwiZXhwIjoxNTIzNjA1MzA5fQ.7Lm69ySiMsQ_N4EdMRnb5M0XKvy1XGWlJBuFOxPBhQE" "http://localhost:8086/users"


curl -X "GET" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGJlcnQiLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9kZXZnbGFuLmNvbSIsImlhdCI6MTUyMzM4NzU4OCwiZXhwIjoxNTIzNDA1NTg4fQ.CMdRZ0HoVwalLbjHhUTia6tyOFR_fCpyRMam_5BbWw4" "http://localhost:8086/users/1"





