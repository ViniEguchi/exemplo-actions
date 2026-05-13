FROM maven:3.9-eclipse-temurin-21 as builder
LABEL autors="aoki"

WORKDIR /build

COPY . .

RUN mvn clean package -DiskipTests -Dcheckstyle.skip=true

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /build/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]