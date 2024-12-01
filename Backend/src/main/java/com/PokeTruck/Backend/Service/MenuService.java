package com.PokeTruck.Backend.Service;

import com.PokeTruck.Backend.Entity.Menu;
import com.PokeTruck.Backend.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getMenusByUserId(Integer userId) {
        return menuRepository.findByUserId(userId);
    }
}
