$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/stops.feature");
formatter.feature({
  "name": "Find a stop and access modes",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Get Stop",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "John is looking for a stop",
  "keyword": "Given "
});
formatter.step({
  "name": "tester hits API and John searches for \u003cstop1\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Success status code is coming",
  "keyword": "Then "
});
formatter.step({
  "name": "a stop named \u003cstopName\u003e is found",
  "keyword": "And "
});
formatter.step({
  "name": "the stop provides more than one mode of transport",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "stop1",
        "stopName"
      ]
    },
    {
      "cells": [
        "\"Wynyard Station\"",
        "\"Wynyard Station, Sydney\""
      ]
    }
  ]
});
formatter.scenario({
  "name": "Get Stop",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "John is looking for a stop",
  "keyword": "Given "
});
formatter.match({
  "location": "GetStop.john_is_looking_for_a_stop()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "tester hits API and John searches for \"Wynyard Station\"",
  "keyword": "When "
});
formatter.match({
  "location": "GetStop.tester_hits_api_and_john_searches_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success status code is coming",
  "keyword": "Then "
});
formatter.match({
  "location": "GetStop.success_status_code_is_coming()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a stop named \"Wynyard Station, Sydney\" is found",
  "keyword": "And "
});
formatter.match({
  "location": "GetStop.a_stop_named_is_found(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the stop provides more than one mode of transport",
  "keyword": "And "
});
formatter.match({
  "location": "GetStop.the_stop_provides_more_than_one_mode_of_transport()"
});
formatter.result({
  "status": "passed"
});
});