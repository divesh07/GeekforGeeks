package TestRail;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TRActions {

    public static void getProjects(APIClient client) throws Exception{
        JSONObject c = (JSONObject) client.sendGet("get_projects/300");
        System.out.println(c.get("title"));
    }

    public static void main(String[] args) throws Exception {
        int projectId = 8;
        //int embraceSuiteId = 112;
        //int embraceSectionId = 2649;

        int embraceSuiteId = 95;
        int embraceSectionId = 3656;

        String url = "https://thoughtspotqa.testrail.net/";
        String user = "codemonkey@thoughtspot.com";
        String password = "hudson805";

        APIClient client = new APIClient(url);
        client.setUser(user);
        client.setPassword(password);
        // GET project
        // There is one project in TestRail named "ThoughtSpot" with id : 8
        JSONArray object = (JSONArray) client.sendGet("get_projects/:ThoughtSpot");
        System.out.println(object);

        // Get All Test Suites ( Project id : 8)
        object = (JSONArray) client.sendGet("get_suites/"+ projectId);
        System.out.println(object);

        // Get Embrace Test Suites ( Project id : 8) ( Suite id : 112 )
        JSONObject suite = (JSONObject) client.sendGet("get_suite/"+ embraceSuiteId);
        System.out.println(suite);

        // Get Test cases in the Suite Test Suites ( Project id : 8) ( Suite id : 112 )
        // Section ID - Embrace Security Pass through - 2649
        // Section ID - Embrace SpotIQ - 2648
        // Section ID - Embrace Pass through functions - 3655

        JSONArray secuityPassThough = (JSONArray) client.sendGet("get_cases/8&suite_id="
                + embraceSuiteId + "&section_id=" + embraceSectionId);
        System.out.println("Total test cases " + secuityPassThough.size());
        System.out.println(secuityPassThough);

        // priority_id":  4 for critical (P0)
        JSONArray priorityZero = (JSONArray) client.sendGet("get_cases/8&suite_id=112&section_id"
                + "=2649&priority_id=4");
        System.out.println("Total P0 test cases " + priorityZero.size());

        // priority_id": 3 for HIGH (P1)
        JSONArray priorityOne = (JSONArray) client.sendGet("get_cases/8&suite_id=112&section_id"
                + "=2649&priority_id=3");
        System.out.println("Total P1 test cases " + priorityOne.size());

        // Change Type of test case from Functional ( type id 6 )to Automated once its automated
        // Once automated type if of test would change to 3
        JSONArray automated = (JSONArray) client.sendGet("get_cases/8&suite_id=112&"
                + "section_id=2649&type_id=3");
        System.out.println("Total Automated test cases " + automated.size());

        // No default filters for custom field , use iterators and filter
        // if target for automation is true field custom_targeted_for_automation = 2 else would be 1
        // if automated : custom_automated = true
        int totalTestToBeAutomated = 0;
        int totalAutomatedTests = 0;
        Iterator<JSONObject> iterator = secuityPassThough.iterator();
        while (iterator.hasNext()){
            JSONObject testDetailsObject = iterator.next();
            Long value = (Long) testDetailsObject.get("custom_targeted_for_automation");
            if (value == 2) {
                totalTestToBeAutomated++ ;
            }
            if ((boolean) testDetailsObject.get("custom_automated")){
                totalAutomatedTests++;
            }
        }
        System.out.println("Total test which can Automated : " + totalTestToBeAutomated);
        System.out.println("Total tests Automated : " + totalAutomatedTests);
        System.out.println("Total tests left for Automation : " +
                (totalTestToBeAutomated - totalAutomatedTests));


        // Status of All the runs via Test Plan
        JSONArray testPlans = (JSONArray) client.sendGet("get_plans/8");
        Long testPlanId = null;
        Long passed_count = null;
        Long failed_count = null;
        Iterator<JSONObject> testPlanIterator = testPlans.iterator();
        while (testPlanIterator.hasNext()){
            JSONObject testDetailsObject = testPlanIterator.next();
            String name = (String) testDetailsObject.get("name");
            if (name.equalsIgnoreCase("SecurityPassThrough")) {
                testPlanId = (Long) testDetailsObject.get("id");
                passed_count = (Long) testDetailsObject.get("passed_count");
                failed_count = (Long) testDetailsObject.get("failed_count");
                break;
            }
        }
        System.out.println("Test Plan Id " + testPlanId);

        // TODO : Assert plan id is not null
        System.out.println("Total passed tests in a Test plan " + passed_count);
        System.out.println("Total failed tests in a Test plan " + failed_count);

        // Get all runs of a plan
        JSONObject testRuns = (JSONObject) client.sendGet("get_plan/"+ testPlanId);
        System.out.println(testRuns);
        JSONArray entries = (JSONArray) testRuns.get("entries");
        JSONObject entry = (JSONObject) entries.get(0);
        JSONArray runs = (JSONArray) entry.get("runs");
        JSONObject run = (JSONObject) runs.get(0);
        Long runId = (Long) run.get("id");
        Long passed_count_latest_run = (Long) run.get("passed_count");
        Long failed_count_latest_run = (Long) run.get("failed_count");

        System.out.println("Total passed tests in the latest Test run " + passed_count_latest_run);
        System.out.println("Total failed tests in the latest Test run " + failed_count_latest_run);
        System.out.println("Test Run Id " + runId);

        // TODO : Assert run id is not null
        JSONObject testRun = (JSONObject) client.sendGet("get_run/"+ runId);
        System.out.println(testRun);

        //*****************
        // REPORTS

        // Get Report id by Project Name
        JSONArray reports = (JSONArray) client.sendGet("get_reports/"+ projectId);
        System.out.println(reports);
        Long reportId = null;
        Iterator<JSONObject> reportsIterator = reports.iterator();
        while (reportsIterator.hasNext()) {
            JSONObject report = reportsIterator.next();
            if (((String) report.get("name")).equalsIgnoreCase("SecurityPassThrough")) {
                reportId = (Long) report.get("id");
                break;
            }
        }
        // TODO : Assert report id is not null
        System.out.println("Test Report Id " + reportId);

        // Run Report id by Project Name
        JSONObject report = (JSONObject) client.sendGet("run_report/"+ reportId);
        System.out.println(report);
        String report_url = (String) report.get("report_url");
        System.out.println("Report url : " + report_url);
        String report_html = (String) report.get("report_html");
        System.out.println("Report html link : " + report_html);
        String report_pdf = (String) report.get("report_pdf");
        System.out.println("Report pdf link : " + report_pdf);
    }
}
