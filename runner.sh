#!/bin/bash

#-------------------------------------------------------------------
#  This script expects the following environment variables
#     HUB_HOST
#     BROWSER
#     THREAD_COUNT
#     TEST_SUITE
#-------------------------------------------------------------------

# Let's print what we have received
echo "-------------------------------------------"
echo "HUBURL        : ${HUBURL:-http://selenium-hub:4444}"
echo "GRID          : ${GRID:-true}"
echo "THREAD_COUNT  : ${THREAD_COUNT:-2}"
echo "XMLFILE       : ${XMLFILE:-testng.xml}"
echo "-------------------------------------------"

# Do not start the tests immediately. Hub has to be ready with browser nodes
echo "Checking if hub is ready..!"
count=0
while ! curl -sSL "http://selenium-hub:4444/wd/hub/status" 2>&1 \
        | jq -r '.value.ready' 2>&1 | grep "true" >/dev/null; do
    echo 'Waiting for the Grid'
    sleep 1
done
# At this point, selenium grid should be up!
echo "Selenium Grid is up and running. Running the test...."

# Start the java command
java -Dseleniumgridenabled="${GRID}" \
     -Dhuburl="${HUBURL}" \
     -cp 'libs/*' \
     org.testng.TestNG \
     -threadcount "${THREAD_COUNT}" \
     suites-xml/"${XMLFILE}"
