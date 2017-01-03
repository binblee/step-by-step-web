FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD build/libs/web-0.0.1-SNAPSHOT.jar /app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./ura
ndom -jar /app.jar" ]