package br.com.rpgruler.data.db;

import br.com.gmp.utils.object.ObjectCopy;
import br.com.rpgruler.data.db.constant.EntityMap;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Genérico para embasamento
 *
 * @author kaciano
 * @version 1.0
 * @param <T> Classe de entidade
 */
public class GenericDAO<T> {

    private Class<T> objectClass;
    private String prefix = "db/";
    private String database;
    private String sufix = ".yap";

    private ObjectServer objectServer;

    /**
     * Cria nova instancia de GenericDAO
     */
    public GenericDAO() {
        this.objectClass = (Class<T>) ((ParameterizedType) (getClass()
                .getGenericSuperclass())).getActualTypeArguments()[0];
        this.database = prefix + (new EntityMap().getMap().get(objectClass)) + sufix;
        File file = new File("db");
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * Busca todos os dados da entidade
     *
     * @return <code>T</code> Entidade
     */
    public List<T> getList() {
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        ObjectSet os = query.execute();
        List<T> objs = new ArrayList<>();
        objs.addAll(os);
        db.close();
        return objs;
    }

    /**
     * Insere a entidade no banco de dados
     *
     * @param entity <code>T</code> Entidade
     */
    public void insert(T entity) {
        ObjectContainer db = Db4o.openFile(database);
        db.store(entity);
        db.commit();
        db.close();
    }

    /**
     * Insere as entidades no banco de dados
     *
     * @param entities <code>List(T)</code> Entidades
     */
    public void insertAll(List<T> entities) {
        ObjectContainer db = Db4o.openFile(database);
        entities.stream().forEach((entity) -> {
            db.store(entity);
        });
        db.commit();
        db.close();
    }

    /**
     * Atualiza a entidade
     *
     * @param entity <code>T</code> Entidade
     * @throws java.lang.IllegalAccessException Acesso ilegal
     */
    public void update(T entity) throws IllegalArgumentException, IllegalAccessException {
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        ObjectSet<T> get = db.queryByExample(entity);
        ObjectCopy.copy(entity, get);
        db.store(get);
        db.commit();
        db.close();
    }

    /**
     * Deleta todos os objetos da lista
     *
     * @param entities <code>List(T)</code> Lista a ser deletada
     */
    public void deleteAll(List<T> entities) {
        ObjectContainer db = Db4o.openFile(database);
        entities.stream().forEach((entity) -> {
            ObjectSet<T> os = db.queryByExample(entity);
            db.delete(os.next());
        });
        db.commit();
        db.close();
    }

    /**
     * Deleta a entidade
     *
     * @param entity <code>T</code> Entidade
     */
    public void delete(T entity) {
        ObjectContainer db = Db4o.openFile(database);
        ObjectSet<T> os = db.queryByExample(entity);
        db.delete(os.next());
        db.commit();
        db.close();
    }

    /**
     * Retorna a entidade a partir do ID
     *
     * @param id <code>Integer</code> ID
     * @return <code>T</code> Entidade
     */
    public T queryByID(int id) {
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        query.descend("id").constrain(id);
        ObjectSet<T> os = query.execute();
        List<T> list = new ArrayList<>();
        list.addAll(os);
        db.close();
        for (T entity : list) {
            return entity;
        }
        return null;
    }

    /**
     * Efetua a busca com base no campo informado
     *
     * @param field <code>String</code> Campo a ser verificado
     * @param value <code>Object</code> Valor da busca
     * @return <code>List(T)</code> Lista contendo o resultado
     */
    public List<T> queryByField(String field, Object value) {
        List<T> list = new ArrayList<>();
        ObjectContainer db = Db4o.openFile(database);
        Query query = db.query();
        query.constrain(objectClass);
        query.descend(field).constrain(value);
        ObjectSet<T> os = query.execute();
        list.addAll(os);
        db.close();
        return list;
    }

    /**
     *
     * @return
     */
    public Class<T> getObjectClass() {
        return objectClass;
    }

    /**
     *
     * @param oClass
     */
    public void setObjectClass(Class<T> oClass) {
        this.objectClass = oClass;
    }

    /**
     *
     * @return
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     *
     * @param prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     *
     * @return
     */
    public String getDatabase() {
        return database;
    }

    /**
     *
     * @param database
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     *
     * @return
     */
    public String getSufix() {
        return sufix;
    }

    /**
     *
     * @param sufix
     */
    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

//    /**
//     *
//     * @return
//     */
//    public ObjectServer getObjectServer() {
//        return objectServer;
//    }
//    /**
//     *
//     * @param objectServer
//     */
//    public void setObjectServer(ObjectServer objectServer) {
//        this.objectServer = objectServer;
//    }
}
