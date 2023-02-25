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
mvn -U clean install
./local-test.sh
```
