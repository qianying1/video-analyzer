package cn.gzsendi.mapper.ejb3;

import cn.gzsendi.annotation.DataSource;
import cn.gzsendi.model.sendi.SendiHost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Nacht
 * Created on 27/11/2018
 */
@Mapper
@DataSource(DataSource.EJB3)
public interface SendiHostMapper {
    /**
     * 新增
     */
    public int insertHost(@Param("sendiHost")SendiHost sendiHostInfo);

    /**
     * 删除
     */
    public int deleteHost(@Param("id") int id);

    /**
     * 更新
     */
    public int updateHost(@Param("sendiHost") SendiHost sendiHostInfo);

    /**
     * Load查询
     */
    public SendiHost getHost(@Param("id") int id);
}
