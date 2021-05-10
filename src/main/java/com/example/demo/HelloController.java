package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${git.commit.id}")
    private String commitId;
    
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/versionz")
    public Map<String, String> getCommitId() {
        Map<String, String> result = new HashMap<>();
        result.put("Commit id", commitId);
        result.put("project-name", "endocode-app");
        return result;
    }

	@RequestMapping(path = "/helloworld", method = RequestMethod.GET)
	public String index(@RequestParam(name="name", required=false) String name) {
		
		if (name != null && !name.equals("")) {
			String str = "";
			for (String w : name.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
				str += w + " ";
			}
			return str;
		}
		
		//logger.info("An INFO Message");
		
		return "Hello Stranger";
	}
	
}
