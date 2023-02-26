# Read Me First

# Build application

```shell
mvn -U clean install
```

## Build Unit Test only test class

```shell
mvn clean test -Dtest="DummySpringbootAppJPATests"
mvn clean test -Dtest="DummySpringbootAppTests"
mvn clean test -Dtest="DummySpringbootAppWebMockTests"
mvn clean test -Dtest="ConstantsMapperTest"
```

# Running application in local

```shell
mvn -U clean install -DskipTests
mvn -U clean install
./local-test.sh
```

# Swagger (rest api test)

```http request
http://localhost:9000/swagger-ui/#/
```
> Swagger and SpringFox starter mistake [fixed][springfoxFixed]

[springfoxFixed]: <https://forum.huawei.com/enterprise/en/springboot-is-updated-to-2-6-7-startup-error-failed-to-start-bean-documentationpluginsbootstrapper/thread/1002077-893>
