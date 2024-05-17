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
echo "HUBURL        : ${HUBURL:-http://hub:4444}"
echo "GRID          : ${GRID:-true}"
echo "THREAD_COUNT  : ${THREAD_COUNT:-2}"
echo "XMLFILE       : ${XMLFILE:-testng.xml}"
echo "-------------------------------------------"

# Do not start the tests immediately. Hub has to be ready with browser nodes
echo "Checking if hub is ready..!"
count=0
while [ "$( curl -s ${HUBURL:-http://hub:4444}/status | jq -r .value.ready )" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"
  if [ "$count" -ge 30 ]
  then
      echo "**** HUB IS NOT READY WITHIN 30 SECONDS ****"
      exit 1
  fi
  sleep 1
done
# At this point, selenium grid should be up!
echo "Selenium Grid is up and running. Running the test...."

# Start the java command
java -Dseleniumgridenabled="${GRID:-true}" \
     -Dhuburl="${HUBURL:-http://hub:4444}" \
     -cp 'libs/*' \
     org.testng.TestNG \
     -threadcount "${THREAD_COUNT:-2}" \
     suites-xml/"${XMLFILE:-testng.xml}"
