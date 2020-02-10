# eureka-server-demo

[POST] http://localhost:8080/zuul-gateway/api/signin
{
	"username":"admin@gmail.com",
	"password": "admin"
}

Pass header Authorization: <token-generated in /signin service> for following services

http://localhost:8080/zuul-gateway/api/emp-service/v1/emp/1
http://localhost:8080/zuul-gateway/api/dept-service/v1/dept/1
