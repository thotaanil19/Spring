# Start Git config server spring boot project
http://localhost:8080/config-server/application1-dev.json

# Start Git config client spring boot project
# For accessing properties from git  
http://localhost:8081/config-client/test

# If any property is changed, then server need to be to restarted. To solve this restarting,
call following refresh api.
http://localhost:8081/config-client/actuator/refresh