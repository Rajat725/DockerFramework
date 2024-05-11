FROM bellsoft/liberica-openjdk-alpine:17
RUN apk add curl jq
WORKDIR /home/DockerFramework
ADD target/docker-framework-package ./
ADD runner.sh runner.sh
ENTRYPOINT sh runner.sh
#ENTRYPOINT java -Dseleniumgridenabled=${GRID} \
#           -Dhuburl=${HUBURL} \
#           -cp 'libs/*' \
#           org.testng.TestNG \
#           -threadcount ${THREAD_COUNT} \
#           suites-xml/${XMLFILE}

