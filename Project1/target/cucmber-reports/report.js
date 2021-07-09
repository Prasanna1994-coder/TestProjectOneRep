$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/Features/FileUpload.feature");
formatter.feature({
  "line": 1,
  "name": "File upload",
  "description": "",
  "id": "file-upload",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "launch the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "PageOneStepDef.launch_the_browser()"
});
formatter.result({
  "duration": 1076163770,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "How to upload a file from local",
  "description": "",
  "id": "file-upload;how-to-upload-a-file-from-local",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@AcceptAlert"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I launch demo automation application",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I upload a demo file from local",
  "keyword": "And "
});
formatter.match({
  "location": "FileUploadStepDefinition.i_launch_demo_automation_application()"
});
formatter.result({
  "duration": 43573263254,
  "status": "passed"
});
formatter.match({
  "location": "FileUploadStepDefinition.i_upload_a_demo_file_from_local()"
});
formatter.result({
  "duration": 384788457,
  "status": "passed"
});
});