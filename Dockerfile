FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
EXPOSE 8080
COPY service/build/libs/parking-lot-application.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
