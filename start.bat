REM mvn package -DskipTests
for /L %%N IN (1,1,4) DO (
    start java -jar target\zipkin-sleuth-0.0.1-SNAPSHOT.jar --server.port=808%%N --spring.application.name=zipkin%%N
)