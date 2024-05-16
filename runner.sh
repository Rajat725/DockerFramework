echo "-------------------------------------------"
echo "HUBURL        : ${HUBURL:-http://selenium-hub:4444}"
echo "GRID          : ${GRID:-true}"
echo "THREAD_COUNT  : ${THREAD_COUNT:-2}"
echo "XMLFILE       : ${XMLFILE:-testng.xml}"
echo "-------------------------------------------"
# Check if the hub is ready
echo "Checking if the hub is ready..."
count=0
while [ "$(curl -s ${HUBURL:-http://selenium-hub:4444}/status | jq -r .value.ready)" != "true" ]
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
# At this point, Selenium Grid should be up and running
echo "Selenium Grid is up and running. Running the tests..."
# Start the Java command
java -Dseleniumgridenabled="${GRID}" \
     -Dhuburl="${HUBURL}" \
     -cp 'libs/*' \
     org.testng.TestNG \
     -threadcount "${THREAD_COUNT}" \
     suites-xml/"${XMLFILE}"
echo "-------------------------------------------"
