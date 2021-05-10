package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
    @Value("${git.commit.message.short}")
    private String commitMessage;

    @Value("${git.branch}")
    private String branch;

    @Value("${git.commit.id}")
    private String commitId;

    @RequestMapping("/commitId")
    public Map<String, String> getCommitId() {
        Map<String, String> result = new HashMap<>();
        result.put("Commit message",commitMessage);
        result.put("Commit branch", branch);
        result.put("Commit id", commitId);
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
		
		return "Hello Stranger";
	}
	
	@RequestMapping(path = "/versionz", method= RequestMethod.GET)
	public String version() {
		
		return null;
	}

}
