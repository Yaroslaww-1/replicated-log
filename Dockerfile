FROM gradle:7.5.1-jdk17 as build
WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle build --no-daemon

FROM openjdk:17-alpine as run
WORKDIR /home/app
COPY --from=build /app/build/docker/main/layers/libs /home/app/libs
COPY --from=build /app/build/docker/main/layers/classes /home/app/classes
COPY --from=build /app/build/docker/main/layers/resources /home/app/resources
COPY --from=build /app/build/docker/main/layers/application.jar /home/app/application.jar
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]
