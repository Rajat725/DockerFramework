FROM bellsoft/liberica-openjdk-alpine:17
WORKDIR /home/DockerFramework
ADD target/docker-framework-package ./
ENTRYPOINT java -Dseleniumgridenabled=${GRID} \
           -Dhuburl=${HUBURL} \
           -cp 'libs/*' \
           org.testng.TestNG \
           -threadcount ${THREAD_COUNT} \
           suites-xml/${XMLFILE}

