$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("io/connexa/qa/tests/newevent.feature");
formatter.feature({
  "line": 1,
  "name": "User Creates a new Event As a Community Member",
  "description": " I want to create a new event so other Community Members could join to it",
  "id": "user-creates-a-new-event-as-a-community-member",
  "keyword": "Feature"
});
formatter.before({
  "duration": 22741603281,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Invalid Conditions",
  "description": "",
  "id": "user-creates-a-new-event-as-a-community-member;invalid-conditions",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the user is on Create New Event Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he enters \" \" as event name",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "he enters \" \" as short description",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "he enters \" \" as start date",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "he enters \" \" as start hour",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "he enters \" \" as end date",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "he enters \" \" as end hour",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "he clicks Save Button for Event Creation",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "ensure an error \"can\u0027t be blank\" message is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "EventsBDDTest.theUserIsOnCreateNewEventPage()"
});
formatter.result({
  "duration": 766176094,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": " ",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersEventName(String)"
});
formatter.result({
  "duration": 56474765,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": " ",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersShortDescription(String)"
});
formatter.result({
  "duration": 262995894,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": " ",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersStartDate(String)"
});
formatter.result({
  "duration": 91806801,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": " ",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersStartHour(String)"
});
formatter.result({
  "duration": 155255072,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": " ",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersEndDate(String)"
});
formatter.result({
  "duration": 83975219,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": " ",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersEndHour(String)"
});
formatter.result({
  "duration": 88256686,
  "status": "passed"
});
formatter.match({
  "location": "EventsBDDTest.click()"
});
formatter.result({
  "duration": 104158133,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 998166934,
  "status": "passed"
});
formatter.before({
  "duration": 19289527606,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Create a New Event",
  "description": "",
  "id": "user-creates-a-new-event-as-a-community-member;create-a-new-event",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "the user is on Create New Event Page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "he enters \"Automated Event\" as event name",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "he enters \"Automated Event Short Description\" as short description",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "he enters \"YYYY/MM/DD\" as start date",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "he enters \"HH:MM\" as start hour",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "he enters \"YYYY/MM/DD\" as end date",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "he enters \"HH:MM\" as end hour",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "he clicks Save Button for Event Creation",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "ensure the event is created",
  "keyword": "Then "
});
formatter.match({
  "location": "EventsBDDTest.theUserIsOnCreateNewEventPage()"
});
formatter.result({
  "duration": 596479603,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automated Event",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersEventName(String)"
});
formatter.result({
  "duration": 332120957,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automated Event Short Description",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersShortDescription(String)"
});
formatter.result({
  "duration": 158925666,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "YYYY/MM/DD",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersStartDate(String)"
});
formatter.result({
  "duration": 124374959,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HH:MM",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersStartHour(String)"
});
formatter.result({
  "duration": 137926172,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "YYYY/MM/DD",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersEndDate(String)"
});
formatter.result({
  "duration": 117357279,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HH:MM",
      "offset": 11
    }
  ],
  "location": "EventsBDDTest.entersEndHour(String)"
});
formatter.result({
  "duration": 122225970,
  "status": "passed"
});
formatter.match({
  "location": "EventsBDDTest.click()"
});
formatter.result({
  "duration": 118354578,
  "status": "passed"
});
formatter.match({
  "location": "EventsBDDTest.checkEventCreation()"
});
formatter.result({
  "duration": 765358621,
  "status": "passed"
});
formatter.after({
  "duration": 699927802,
  "status": "passed"
});
});