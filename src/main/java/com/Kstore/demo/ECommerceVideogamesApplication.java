package com.Kstore.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Kstore.demo.pojo.Videogame;
import com.Kstore.demo.pojo.Customer;
import com.Kstore.demo.pojo.Category;
import com.Kstore.demo.pojo.Software;
import com.Kstore.demo.pojo.Admin;
import com.Kstore.demo.service.VideogameService;
import com.Kstore.demo.service.AdminService;
import com.Kstore.demo.service.CategoryService;
import com.Kstore.demo.service.CustomerService;
import com.Kstore.demo.service.SoftwareService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class ECommerceVideogamesApplication implements CommandLineRunner {

	@Autowired
	private VideogameService videogameService;
	
	@Autowired
	private SoftwareService softwareService;
	
	@Autowired
	private  CategoryService categoryService;
	
	@Autowired
	private  CustomerService customerService;
	
	@Autowired
	private  AdminService adminService;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceVideogamesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		Admin testA1 = new Admin("Valerio", "Password");
		Admin testA2 = new Admin("RemoteAdmin", "PasswordAdmin");
		adminService.save(testA1);
		adminService.save(testA2);
		
		Customer testC1 = new Customer("MarioRossi", "Password1");
		Customer testC2 = new Customer("LucaRossi", "Password2");
		Customer testC3 = new Customer("AlessioProietti", "Password3");
		Customer testC4 = new Customer("MarioRossi4", "Password4");
		Customer testC5 = new Customer("EricaVerdi", "Password5");
		
		 try {
			customerService.save(testC1);
			customerService.save(testC2);
			customerService.save(testC3);
			customerService.save(testC4);
			customerService.save(testC5);
		} catch (Exception err) {
			System.err.println("Errore: " + err);
			err.printStackTrace();
		}
			
	
        Category cat = new Category("fps");
        Category cat2 = new Category("gdr");
        Category cat3 = new Category("rpg");
        Category cat4 = new Category("battle royale");
        Category cat5 = new Category("horror");
        Category cat6 = new Category("survival");
        
        try {
        	categoryService.save(cat);
        	categoryService.save(cat2);
        	categoryService.save(cat3);
        	categoryService.save(cat4);
        	categoryService.save(cat5);
        	categoryService.save(cat6);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
            // Create a URL object with the API endpoint
        	String api_key = "518c59c1f319439d898585180720c107";
    
	
	        // Create a RestTemplate instance
	        RestTemplate restTemplate = new RestTemplate();

	        //  GET request 
	        String apiUrl = "https://api.rawg.io/api/games?count=50&page_size=50&key=" + api_key;
	        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
	        String responseBody = response.getBody();

	        
	        //System.out.print(responseBody);
	        // Convert  to a JSON object
	        ObjectMapper objectMapper = new ObjectMapper();
	       
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            
            // System.out.println("Response as JSON object: " + jsonNode);

            // Extract
            JsonNode results = jsonNode.get("results");
            for (JsonNode gameNode : results) {
                String name = gameNode.has("name") ? gameNode.get("name").asText() : "N/A";
                String description = gameNode.has("description_raw") ? gameNode.get("description_raw").asText() : "N/A";
                String releaseDate = gameNode.has("released") ? gameNode.get("released").asText() : "N/A";
                String cover = gameNode.has("background_image") ? gameNode.get("background_image").asText() : "N/A";
                
                Videogame vdg = new Videogame(name, description, releaseDate, cover);

                videogameService.save(vdg);
            }
            
            Software sft1 = new Software("abobe acrobat");
            Software sft2 = new Software("adobe premiere");
            Software sft3 = new Software("windows11 pro");
            Software sft4 = new Software("windows11 home");
            Software sft5 = new Software("wmware workstation");
            Software sft6 = new Software("red hat enterprise");
            Software sft7 = new Software("windows10 pro");
            Software sft8 = new Software("windows10 home");
            
            try {
            	softwareService.save(sft1);
            	softwareService.save(sft2);
            	softwareService.save(sft3);
            	softwareService.save(sft4);
            	softwareService.save(sft5);
            	softwareService.save(sft6);
            	softwareService.save(sft7);
            	softwareService.save(sft8);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
     
            
            // 	---------------------------------------------------------------------------------------------
            
            String apiUrlGenres = "https://api.rawg.io/api/genres?key=" + api_key;
            
            RestTemplate restGenreTemplate = new RestTemplate();

	        //  GET request 
	        ResponseEntity<String> responseGenre = restGenreTemplate.getForEntity(apiUrlGenres, String.class);
	        String responseGenres = responseGenre.getBody();
	        ObjectMapper objectGenreMapper = new ObjectMapper();

	        JsonNode jsonGenreNode = objectGenreMapper.readTree(responseGenres);

			// System.out.println("Response as JSON object: " + jsonNode);
			
			// Extract
			JsonNode resultsGen = jsonGenreNode.get("results");
	        
            for(JsonNode nd: resultsGen) {
	        	String node2 = nd.has("name") ? nd.get("name").asText() : "N/A";
	            String description2 = nd.has("description_raw") ? nd.get("description_raw").asText() : "N/A";
	            String releaseDate2 = nd.has("released") ? nd.get("released").asText() : "N/A";
	            
	            String cover2 = nd.has("background_image") ? nd.get("background_image").asText() : "N/A";
	            
	            Category catZ= new Category(node2);
	            
	            categoryService.save(catZ);
            }
        
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	

	}
}
