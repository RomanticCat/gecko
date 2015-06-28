package template.test;

import nz.pe.gecko.template.test.*;
import java.util.*;

import org.junit.*;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BlogEntryControllerTest {
	@InjectMocks
	private BlogEntryController controller;

	@Mock
	private BlogEntryService blogEntryService;
	
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testCase1() throws Exception{
		mockMvc.perform(get("/blogtest1")).andDo(print());
	}
	@Test
	public void testCase2() throws Exception{
		mockMvc.perform(post("/blogtest2")
				.content("{\"title\":\"Test Blog Title #2\"}")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(jsonPath("$.title", is("Test Blog Title #2")))
		.andDo(print());
	}
	
	@Test
	public void testCase3() throws Exception {
		BlogEntry entry = new BlogEntry();
		//entry.setTitle("Title #100");
		entry.setTitle("Title #1");
		
		when(blogEntryService.find(1)).thenReturn(entry);
		
		mockMvc.perform(get("/blog-entry-wrong-url/100"))
			.andExpect(status().isNotFound());
		
		mockMvc.perform(get("/blog-entry/1"))
		    .andExpect(jsonPath("$.title", is(entry.getTitle())))
		    .andExpect(status().isOk())
		    .andDo(print());
	}
	
	@Test
	public void testCase4() throws Exception{
		mockMvc.perform(get("/blogTestByMapBasic"))
		.andDo(print());
	}
		
	
	@Test
	public void testCase5() throws Exception{
		mockMvc.perform(get("/blogTestByMap"))
		.andDo(print());
	}
	
	
	@Test
	public void testCase6() throws Exception{
		mockMvc.perform(get("/blogTestByVO"))
		.andDo(print());
	}	
	
	
	@Test
	public void matcherSample() throws Exception {
		assertThat("0이 아니겠지?", 1, not(0));
		assertThat("앞에값이 크겠지?", 2000, greaterThan(1000));
        assertThat("앞에값이 크거나 같겠지?", 1000, greaterThanOrEqualTo(1000));
        assertThat("앞에값이 작겠지?", 2000, lessThan(5000));
        assertThat("앞에값이 작거나 같겠지?", 1000, lessThanOrEqualTo(1000));
        assertThat("앞뒤가 같겠지?", "하이", equalTo("하이"));
        assertThat("앞뒤가 대소문자 구분없이 같겠지?", "aabbcc", equalToIgnoringCase("AaBbCc"));
        assertThat("앞뒤 공백은 좀 바주고 같겠지?", "하이 ", equalToIgnoringWhiteSpace(" 하이"));
        assertThat("널이 아니겠지?", new String("널 아니다"), is(notNullValue()));
        assertThat("리스트가 비어있겠지?", new ArrayList<Object>(), empty());
        assertThat("배열이 비어있겠지?", new String[0], emptyArray());
        assertThat("문자열에 포함되어 있지?", "abc", containsString("b"));
        assertThat("시작하는 단어가 맞지?", "abc", org.hamcrest.Matchers.startsWith("a"));
        assertThat("끝나는 단어가 맞지?", "abc", org.hamcrest.Matchers.endsWith("c"));
 
 
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "title #a");
        map.put("content", "Welcome #1");
        mapList.add(map);
        map = new HashMap<String, String>();
        map.put("title", "title #b");
        map.put("content", "Welcome #2");
        assertThat("해쉬맵에서 해당 필드의 값이 동일하지?", map, hasEntry("title", "title #b"));
        mapList.add(map);
        assertThat("배열중에서 특정 키의 값이 존재 하지?", mapList, org.hamcrest.Matchers.<Map<String, String>>hasItem(hasEntry("title", "title #a")));
 
        List<BlogEntry> list = new ArrayList<BlogEntry>();
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setTitle("title #1");
        list.add(blogEntry);
        blogEntry = new BlogEntry();
        blogEntry.setTitle("title #2");
        assertThat("빈에서 해당 필드의 값이 동일하지?", blogEntry, hasProperty("title", is("title #2")));
        list.add(blogEntry);
        assertThat("배열중에서 특정 필드의 값이 존재 하지?", list, org.hamcrest.Matchers.<BlogEntry>hasItem(hasProperty("title", is("title #1"))));
        
	
	}
}
