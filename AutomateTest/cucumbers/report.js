$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Discuz/Login/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Login Discuz",
  "description": "",
  "id": "login;login-discuz",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "Open Discuz\"http://localhost/bbsutf8\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost/bbsutf8",
      "offset": 12
    }
  ],
  "location": "LoginSteps.navigateHomePage(String)"
});
formatter.result({
  "duration": 645376864,
  "status": "passed"
});
formatter.step({
  "line": 4,
  "name": "Login in Discuz with \"qtl\" and \"qtl\"",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "qtl",
      "offset": 22
    },
    {
      "val": "qtl",
      "offset": 32
    }
  ],
  "location": "LoginSteps.loginDiscuz(String,String)"
});
formatter.result({
  "duration": 279645015,
  "status": "passed"
});
formatter.step({
  "line": 5,
  "name": "Login success",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.loginSuccess()"
});
formatter.result({
  "duration": 62194,
  "status": "passed"
});
formatter.after({
  "duration": 629046867,
  "status": "passed"
});
});