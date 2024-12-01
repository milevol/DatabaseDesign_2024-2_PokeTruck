//package com.PokeTruck.Backend.Service;
//
//import com.PokeTruck.Backend.Entity.Pokemon;
//import com.PokeTruck.Backend.Repository.PokemonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class PokemonService {
//
//    private static final Logger logger = LoggerFactory.getLogger(PokemonService.class);
//
//    private final PokemonRepository pokemonRepository;
//
//    @Autowired
//    public PokemonService(PokemonRepository pokemonRepository) {
//        this.pokemonRepository = pokemonRepository;
//    }
//
//    public List<Pokemon> fetchAndSavePokemonData() {
//        // 이미 데이터가 존재하면 추가 작업을 중단
//        if (pokemonRepository.count() > 0) {
//            logger.info("Pokemon data already exists in the database. Skipping fetch.");
//            return pokemonRepository.findAll();
//        }
//
//        String[] types = {"water", "fire", "grass"};
//        String baseUrl = "https://pokeapi.co/api/v2/type/";
//        RestTemplate restTemplate = new RestTemplate();
//        List<Pokemon> savedPokemon = new ArrayList<>();
//
//        try {
//            for (String type : types) {
//                String apiUrl = baseUrl + type;
//                logger.info("Fetching from URL: {}", apiUrl);
//                Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);
//
//                List<Map<String, Object>> pokemonList = (List<Map<String, Object>>) response.get("pokemon");
//                logger.info("Number of Pokemon fetched for type {}: {}", type, pokemonList.size());
//
//                int count = 0;
//                for (Map<String, Object> pokemonEntry : pokemonList) {
//                    if (count >= 10) break;
//
//                    Map<String, Object> pokemonData = (Map<String, Object>) pokemonEntry.get("pokemon");
//                    String pokemonUrl = (String) pokemonData.get("url");
//
//                    Map<String, Object> pokemonDetails = restTemplate.getForObject(pokemonUrl, Map.class);
//
//                    String englishName = (String) pokemonDetails.get("name");
//                    String koreanName = fetchKoreanName(englishName, restTemplate);
//
//                    List<Map<String, Object>> typesList = (List<Map<String, Object>>) pokemonDetails.get("types");
//                    String firstType = (String) ((Map<String, Object>) typesList.get(0).get("type")).get("name");
//                    String koreanType = typeToKorean(firstType);
//
//                    boolean isLegendary = Boolean.TRUE.equals(pokemonDetails.get("is_legendary"));
//                    boolean isMythical = Boolean.TRUE.equals(pokemonDetails.get("is_mythical"));
//
//                    int rarity = 0;
//                    if (isLegendary) {
//                        rarity = 1;
//                    } else if (isMythical) {
//                        rarity = 2;
//                    }
//
//                    logger.info("Fetched Pokemon: {}, Type: {}, Rarity: {}", koreanName, koreanType, rarity);
//
//                    Pokemon pokemon = Pokemon.builder()
//                            .pkmName(koreanName)
//                            .pkmType(koreanType)
//                            .rarity(rarity)
//                            .build();
//
//                    pokemonRepository.save(pokemon);
//                    savedPokemon.add(pokemon);
//                    count++;
//                }
//            }
//        } catch (Exception e) {
//            logger.error("Error fetching and saving Pokemon data", e);
//        }
//        return savedPokemon;
//    }
//
//    private String fetchKoreanName(String englishName, RestTemplate restTemplate) {
//        try {
//            String speciesUrl = "https://pokeapi.co/api/v2/pokemon-species/" + englishName;
//            Map<String, Object> speciesData = restTemplate.getForObject(speciesUrl, Map.class);
//            List<Map<String, Object>> names = (List<Map<String, Object>>) speciesData.get("names");
//            for (Map<String, Object> nameEntry : names) {
//                Map<String, Object> language = (Map<String, Object>) nameEntry.get("language");
//                if ("ko".equals(language.get("name"))) {
//                    return (String) nameEntry.get("name");
//                }
//            }
//        } catch (Exception e) {
//            logger.error("Error fetching Korean name for Pokemon: {}", englishName, e);
//        }
//        return englishName; // 기본적으로 영어 이름 반환
//    }
//
//    private String typeToKorean(String type) {
//        switch (type) {
//            case "water":
//                return "물";
//            case "fire":
//                return "불";
//            case "grass":
//                return "풀";
//            default:
//                return "알 수 없음";
//        }
//    }
//}

package com.PokeTruck.Backend.Service;

import com.PokeTruck.Backend.Entity.Pokemon;
import com.PokeTruck.Backend.Entity.Order;
import com.PokeTruck.Backend.Repository.PokemonRepository;
import com.PokeTruck.Backend.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, OrderRepository orderRepository) {
        this.pokemonRepository = pokemonRepository;
        this.orderRepository = orderRepository;
    }

    // 포켓몬 리스트 조회
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    // 특정 포켓몬의 주문 확인
    public List<Order> getPokemonOrders(Integer pkmId) {
        return orderRepository.findByPkmId(pkmId);
    }
}

