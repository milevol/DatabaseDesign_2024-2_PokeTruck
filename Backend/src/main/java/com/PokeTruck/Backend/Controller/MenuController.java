package com.PokeTruck.Backend.Controller;

import com.PokeTruck.Backend.Entity.Menu;
import com.PokeTruck.Backend.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus/{userId}")
    public List<Menu> getMenusByUserId(@PathVariable Integer userId) {
        return menuService.getMenusByUserId(userId);
    }
}
