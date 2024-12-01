//package com.PokeTruck.Backend.Repository;
//
//import com.PokeTruck.Backend.Entity.Pokemon;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
//}

package com.PokeTruck.Backend.Repository;

import com.PokeTruck.Backend.Entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
