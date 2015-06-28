package nz.pe.gecko.template.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BlogEntryController {
	
	@RequestMapping("/jstl_core")
	public String jstl01(){
		return "jstl_core";
	}
	
	@RequestMapping("/jstl_format")
	public String jstl02(){
		return "jstl_format";
	}	
	
	@RequestMapping("/blogtest")
	public String blogtest(){
		return "view";
	}
	
	@RequestMapping("/blogtest1")
	public @ResponseBody BlogEntry blogCase1(){

		BlogEntry entry = new BlogEntry();
		entry.setTitle("Test BlogEngry #1");
		
		return entry;
	}	
	
	@RequestMapping(value="/blogtest2", method=RequestMethod.POST)
	public @ResponseBody BlogEntry blogCase2(@RequestBody BlogEntry entry){
		return entry;
	}	
	
    @RequestMapping(value="/blog-entry/{blogEntryId}", method=RequestMethod.GET)
    public ResponseEntity<BlogEntry> blogCase3 (@PathVariable int blogEntryId){
        BlogEntry entry = new BlogEntry();
        entry.setTitle("Title #" + blogEntryId);
        
        ResponseEntity<BlogEntry> rt;

        if(blogEntryId < 200){
        	rt = new ResponseEntity<BlogEntry>(entry, HttpStatus.OK);
        }	else {
        	rt = new ResponseEntity<BlogEntry>(HttpStatus.NOT_FOUND);
        }
        return rt;
    }	
	

	// JSON Example using Map
	@RequestMapping(value="/blogTestByMapBasic")
	public @ResponseBody Map<String, String> blogCase4(){
		Map<String, String> mapObj = new HashMap<String, String>();
		mapObj.put("cat", "meow");
		mapObj.put("dog", "woff");
		mapObj.put("pig", "oink");
		mapObj.put("cow", "moo");
		mapObj.put("bee", "buzz");
		
		return mapObj;
	}		
	
	
	// JSON Example using Map
	@RequestMapping(value="/blogTestByMap")
	public @ResponseBody Map<String, Object> blogCase5(){
		Map<String, Object> jsonObj = new HashMap<String, Object>();

		Map<String, Object> jsonSubObj = null;
		ArrayList <Map<String, Object>> jsonSubObjList = new ArrayList<Map<String,Object>>();
		
		jsonSubObj = new HashMap<String, Object>();
		jsonSubObj.put("idx", 1);
		jsonSubObj.put("title", "Title #1");
		jsonSubObj.put("create_date", new Date());
		jsonSubObjList.add(jsonSubObj);
		
		jsonSubObj = new HashMap<String, Object>();
		jsonSubObj.put("idx", 2);
		jsonSubObj.put("title", "Title #2");
		jsonSubObj.put("create_date", new Date());
		jsonSubObjList.add(jsonSubObj);
		
		jsonObj.put("success", true);
		jsonObj.put("total_count", 2);
		jsonObj.put("result_list", jsonSubObjList);
		
		return jsonObj;
	}	
	

	
	// JSON Example using Map
	@RequestMapping(value="/blogTestByVO")
	public @ResponseBody BlogEntryListObj blogCase6(){
		BlogEntryListObj blogEntryListObj = new BlogEntryListObj();
		
		ArrayList <BlogEntry> list = new ArrayList<BlogEntry>();
		
		BlogEntry blogEntry = new BlogEntry();
		blogEntry.setTitle("Title #1 (VO)");
		list.add(blogEntry);
		
		blogEntry = new BlogEntry();
		blogEntry.setTitle("Title #2 (VO)");
		list.add(blogEntry);
		
		blogEntry = new BlogEntry();
		blogEntry.setTitle("Title #3 (VO)");
		list.add(blogEntry);
		
		blogEntryListObj.setList(list);
		blogEntryListObj.setSuccess(true);
		blogEntryListObj.setTotal_count(3);

		return blogEntryListObj;
	}		
	


}
