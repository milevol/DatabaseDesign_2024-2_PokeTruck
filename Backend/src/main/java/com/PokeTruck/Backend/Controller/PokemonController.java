//package com.PokeTruck.Backend.Controller;
//
//import com.PokeTruck.Backend.Entity.Pokemon;
//import com.PokeTruck.Backend.Service.PokemonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class PokemonController {
//
//    @Autowired
//    private PokemonService pokemonService;
//
//    @GetMapping("/fetch-pokemon")
//    public List<Pokemon> fetchPokemon() {
//        return pokemonService.fetchAndSavePokemonData();
//    }
//}

package com.PokeTruck.Backend.Controller;

import com.PokeTruck.Backend.Entity.Pokemon;
import com.PokeTruck.Backend.Entity.Order;
import com.PokeTruck.Backend.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // 포켓몬 리스트 조회
    @GetMapping("/list")
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    // 특정 포켓몬의 주문 확인
    @GetMapping("/{pkmId}/order")
    public List<Order> getPokemonOrders(@PathVariable Integer pkmId) {
        return pokemonService.getPokemonOrders(pkmId);
    }
}
