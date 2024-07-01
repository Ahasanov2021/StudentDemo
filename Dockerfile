#FROM openjdk:17-alpine
##COPY build/libs/*.jar /app/
#ARG user
#ENV userName=$user
##WORKDIR /app/
##RUN mv /app/*.jar /app/app.jar
##ENTRYPOINT ["java", "-jar", "/app/app.jar"]
#CMD ["sh", "-c", "echo $userName"]