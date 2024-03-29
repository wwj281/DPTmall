package tmall.XMLRepository;

import java.util.List;

public class ProxyXmlContext<T> implements XMLContext<T>{

    private RealXmlContext realXmlContext;

    public ProxyXmlContext(Class<T> tClass){
        this.realXmlContext = new RealXmlContext(tClass);
    }
    /**
     * 数据存储
     *
     * @param entity 实例类
     */
    @Override
    public void save(Object[] entity) {
        realXmlContext.save(entity);
    }

    /**
     * 解析XML文件：通过XML文件创建实例
     *
     * @param entity 传入类，eg:User.class
     * @return 返回该类的实例对象
     */
    @Override
    public List<T> init(Class entity) {
        return realXmlContext.init(entity);
    }

    /**
     * 根据ID删除XML数据库中的数据
     *
     * @param id 需要删除元素的id
     */
    @Override
    public void deleteById(String id) {
        realXmlContext.deleteById(id);
    }

    /**
     * 根据ID寻找对象
     *
     * @param id 元素ID
     * @return 返回相同ID组成的对象
     */
    @Override
    public T findById(String id) {
        return (T) realXmlContext.findById(id);
    }

    /**
     * 数据更新
     *
     * @param oldValue 旧值
     * @param newValue 新值
     * @return 返回对象
     */
    @Override
    public T updateById(String oldValue, String newValue) {
        return (T) realXmlContext.updateById(oldValue, newValue);
    }
}
