package com.Kstore.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Kstore.demo.pojo.product.Category;
import com.Kstore.demo.pojo.product.Software;
import com.Kstore.demo.pojo.product.Platform;
import com.Kstore.demo.pojo.product.Publisher;
import com.Kstore.demo.pojo.product.Store;
import com.Kstore.demo.pojo.product.Videogame;
import com.Kstore.demo.pojo.user.Admin;
import com.Kstore.demo.pojo.user.Customer;
import com.Kstore.demo.service.VideogameService;
import com.Kstore.demo.service.AdminService;
import com.Kstore.demo.service.CategoryService;
import com.Kstore.demo.service.CustomerService;
import com.Kstore.demo.service.PlatformService;
import com.Kstore.demo.service.PublisherService;
import com.Kstore.demo.service.SoftwareService;
import com.Kstore.demo.service.StoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
	private  PlatformService platformService;
	
	@Autowired
	private  StoreService storeService;
	
	@Autowired
	private  PublisherService publisherService;
	
	@Autowired
	private  AdminService adminService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceVideogamesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		

 // 	------------------------------------- ADMIN --------------------------------------------------------
		Admin testA1 = new Admin("Valerio", "Password");
		Admin testA2 = new Admin("RemoteAdmin", "PasswordAdmin");
		adminService.save(testA1);
		adminService.save(testA2);

//	 	------------------------------------- CUSTOMER --------------------------------------------------------
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

//      ------------------------------------- PLATFORM ----------------------------------------------------------
		Platform testP1 = new Platform("PC");
		Platform testP2 = new Platform("PS4");
		Platform testP3 = new Platform("PS5");
		Platform testP4 = new Platform("Xbox 360");
		Platform testP5 = new Platform("Xbox Series X");
		Platform testP6 = new Platform("Xbox Series S");
		Platform testP7 = new Platform("Steam Deck");
		Platform testP8 = new Platform("Nintendo Switch");
		Platform testP9 = new Platform("Cloud");
		 
		 
		try {
			platformService.save(testP1);
			platformService.save(testP2);
			platformService.save(testP3);
			platformService.save(testP4);
			platformService.save(testP5);
			platformService.save(testP6);
			platformService.save(testP7);
			platformService.save(testP8);
			platformService.save(testP9);
		} catch (Exception err) {
			System.err.println("Errore: " + err);
			err.printStackTrace();
		}
			
//		------------------------------------- CATEGORIES --------------------------------------------------------
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
        
//     	------------------------------------- SOFTWARE --------------------------------------------------------
        Software sft1 = new Software("abobe acrobat");
        Software sft2 = new Software("adobe premiere");
        Software sft3 = new Software("Windows11 pro");
        Software sft4 = new Software("Windows11 home");
        Software sft5 = new Software("WmWare workstation");
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
        } catch(Exception e) {
            e.printStackTrace();
        }
 
 // 		------------------------------------- API VIDEOGAMES Request --------------------------------------------------------
        JsonNode resultsGames = ApiRequestTemplate("/games?count=50&page_size=50&");;

//		JSONObject jso = new JSONObject();
//		JSONArray arr = new JSONArray();
//		FileWriter file = new FileWriter("/Users/vgenco/Downloads/demo/demo/src/main/resources/static/assets/fakerDB.json");
		
		try {
//			int sizeRes = resultsGames.size();
            for (JsonNode gameNode : resultsGames) {
 
                String name = gameNode.has("name") ? gameNode.get("name").asText() : "N/A";
                String description = gameNode.has("description_raw") ? gameNode.get("description_raw").asText() : "N/A";
                String releaseDate = gameNode.has("released") ? gameNode.get("released").asText() : "N/A";
                String cover = gameNode.has("background_image") ? gameNode.get("background_image").asText() : "N/A";

                Videogame vdg = new Videogame(name, description, releaseDate, cover);
                videogameService.save(vdg);

//                jso.put("name", name);
//                jso.put("description", description);
//                jso.put("releaseDate", releaseDate);
//                jso.put("cover", cover);
//                
//               	 
//                String iteratore;
//                if (gameNode.iterator().equals(sizeRes)) {
//                	iteratore = ",";
//                } else {
//                	iteratore = "";	                	
//                }
                
//	              file.writeJSONString(jso.toJSONString() + iterator; 
//	              arr.add(responseBody);
            }	            
	    } catch(Exception err) {
        	err.printStackTrace();
        }
//        finally {
//        	 try {
//                 file.flush();
//                 file.close();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//        }

// 	------------------------------------- API CATEGORIES Request --------------------------------------------------------	
		JsonNode resultsGen = ApiRequestTemplate("/genres?");
		
        for(JsonNode nd: resultsGen) {
        	String node2 = nd.has("name") ? nd.get("name").asText() : "N/A";
            String description2 = nd.has("description_raw") ? nd.get("description_raw").asText() : "N/A";
            String releaseDate2 = nd.has("released") ? nd.get("released").asText() : "N/A";
            
            String cover2 = nd.has("background_image") ? nd.get("image_background").asText() : "N/A";
            Category catZ= new Category(node2);
            
            categoryService.save(catZ);
        }          
        
//     	------------------------------------- API PUBLISHER Request --------------------------------------------------------
		JsonNode resultsPublishers = ApiRequestTemplate("/publishers?");
		
	    for(JsonNode nd: resultsPublishers) {
	    	String node_name = nd.has("name") ? nd.get("name").asText() : "N/A";
	        String node_img = nd.has("image_background") ? nd.get("image_background").asText() : "N/A";
	        Publisher publ = new Publisher(node_name, node_img);	
	        publisherService.save(publ);
	    }          
        
//      ------------------------------------- API STORES Request --------------------------------------------------------
		JsonNode resultsStores = ApiRequestTemplate("/stores?");
		
	    for(JsonNode rs: resultsStores) {
	    	String node_name = rs.has("name") ?  rs.get("name").asText() : "N/A";
//	        String node_img =  rs.has("image_background") ?  rs.get("background_image").asText() : "N/A";
	        
	        Store store = new Store(node_name);	
	        storeService.save(store);
	    }        
	}
	
	
	
	private JsonNode ApiRequestTemplate(String params) {

		String api_key = "key=518c59c1f319439d898585180720c107";
	    String apiUrl = "https://api.rawg.io/api" + params + api_key;
	    
	    RestTemplate restTemp = new RestTemplate();
	    
	    //  GET request 
	    ResponseEntity<String> response = restTemp.getForEntity(apiUrl, String.class);
	    String responseExt = response.getBody();
	    
	    ObjectMapper objMapper = new ObjectMapper();
	    
	    JsonNode jsonResult = null;
		try {
			jsonResult = objMapper.readTree(responseExt);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException err) {
			err.printStackTrace();
		}
		return jsonResult.get("results");
	}
}
