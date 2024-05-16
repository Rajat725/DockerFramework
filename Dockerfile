FROM bellsoft/liberica-openjdk-alpine:17

# Install required packages
RUN apk add --no-cache curl jq dos2unix

# Set the working directory
WORKDIR /home/DockerFramework

# Copy your application files
COPY target/docker-framework-package ./ 
COPY runner.sh runner.sh

# Convert line endings of runner.sh to Unix format
RUN dos2unix runner.sh

# Set the entry point for the container
ENTRYPOINT ["sh", "runner.sh"]

#ENTRYPOINT java -Dseleniumgridenabled=${GRID} \
#           -Dhuburl=${HUBURL} \
#           -cp 'libs/*' \
#           org.testng.TestNG \
#           -threadcount ${THREAD_COUNT} \
#           suites-xml/${XMLFILE}

