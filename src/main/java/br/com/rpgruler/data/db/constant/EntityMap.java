package br.com.rpgruler.data.db.constant;

import br.com.rpgruler.data.entitity.ArmorType;
import br.com.rpgruler.data.entitity.Effect;
import br.com.rpgruler.data.entitity.Element;
import br.com.rpgruler.data.entitity.Menu;
import br.com.rpgruler.data.entitity.MenuItem;
import br.com.rpgruler.data.entitity.PrimeMaterial;
import br.com.rpgruler.data.entitity.WearType;
import java.util.HashMap;
import java.util.Map;

/**
 * Conjunto de constantes para o banco de dados
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
        map.put(Menu.class, "MenuDB");
        map.put(MenuItem.class, "MenuItemDB");        
        return map;
    }

}
