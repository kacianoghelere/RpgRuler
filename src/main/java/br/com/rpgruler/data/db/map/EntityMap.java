package br.com.rpgruler.data.db.map;

import br.com.rpgruler.data.entitity.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Mapa de constantes para o banco de dados
 *
 * @author kaciano
 */
public class EntityMap {

    /**
     * Retorna o mapa de arquivos de dados
     *
     * @return <code>Map(Class<?>, String)</code> Mapa de arquivos de dados
     */
    public Map<Class<?>, String> getMap() {
        Map<Class<?>, String> map = new HashMap<>();
        map.put(Element.class, "ElementDB");
        map.put(PrimeMaterial.class, "MaterialsDB");
        map.put(ArmorType.class, "ArmorTypeDB");
        map.put(WearType.class, "WearTypeDB");
        map.put(Effect.class, "EffectDB");
        map.put(EffectType.class, "EffectTypeDB");
        map.put(Menu.class, "MenuDB");
        map.put(MenuItem.class, "MenuItemDB");        
        map.put(Perk.class, "PerkDB");        
        map.put(PerkType.class, "PerkTypeDB");        
        map.put(WeaponType.class, "WeaponTypeDB");        
        return map;
    }

}
