from maven as maven
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
COPY --from=maven /build/target/gs-mysql-data-0.1.0.jar app.jar
ENTRYPOINT ["/usr/bin/java" , "-jar", "app.jar" ]



