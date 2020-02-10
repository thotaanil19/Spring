1. Start Eureka Server springboot
2. Start Emp/Dept springboot services
3. Pass a request to emp services
   /emp/1
   This service internally calls dept micro service, but we didn't hardcode dept service port and host.
   This concept is POC for Service discovery.
