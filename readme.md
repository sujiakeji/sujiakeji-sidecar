dependencies: 
- docker
- jdk 8
- nexus
- gradle
- rabbitmq
- sujiakeji-eureka-server
- sujiakeji-config-server
- sujiakeji-sidecar-js

update dependencies:
```
gradle dependencyUpdates -Drevision=release --info
```

build: 
```
cd sujiakeji-sidecar
./gradlew idea
./gradlew clean build copyJar -x test
```

start:
```
java -Dspring.profiles.active=dev \
  -DEUREKA_SERVER_HOST=localhost \
  -DEUREKA_SERVER_PORT=9000 \
  -DRABBITMQ_HOST=localhost \
  -DRABBITMQ_PORT=5672 \
  -DSIDECAR_HOST=sujiakeji-sidecar-js \
  -DSIDECAR_PORT=11100 \
  -jar build/libs/sujiakeji-sidecar.jar
```

docker:
```
./gradlew docker

docker build -t sujiakeji/sujiakeji-sidecar:1.0.0-SNAPSHOT .

docker run -it --rm \
  --name sujiakeji-sidecar \
  -p 9200:9200 \
  --link sujiakeji-eureka-server \
  --link sujiakeji-rabbitmq \
  --link sujiakeji-sidecar-js \
  -e EUREKA_SERVER_HOST=sujiakeji-eureka-server \
  -e EUREKA_SERVER_PORT=9000 \
  -e RABBITMQ_HOST=sujiakeji-rabbitmq \
  -e RABBITMQ_PORT=5672 \
  -e SIDECAR_HOST=sujiakeji-sidecar-js \
  -e SIDECAR_PORT=11100 \
  -e SPRING_PROFILES_ACTIVE=dev \
  sujiakeji/sujiakeji-sidecar

docker-compose up
```
