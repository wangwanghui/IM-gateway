FROM java:8

COPY *.jar /usr/local/bin/gateway-0.0.1-SNAPSHOT.jar

COPY /config /usr/local/bin/config

CMD ["--server.port=9011"]

EXPOSE 9011

# ENTRYPOINT 执行项目 app.jar及外部配置文件，多个配置文件逗号隔开
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/usr/local/bin/gateway-0.0.1-SNAPSHOT.jar","--spring.config.location=/usr/local/bin/config/bootstrap.yml"]
