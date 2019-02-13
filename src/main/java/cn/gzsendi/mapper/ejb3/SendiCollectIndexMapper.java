package cn.gzsendi.mapper.ejb3;

import cn.gzsendi.annotation.DataSource;
import cn.gzsendi.model.sendi.SendiCollectIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Nacht
 * Created on 03/12/2018
 */
@Mapper
@DataSource(DataSource.EJB3)
public interface SendiCollectIndexMapper {
    /**
     * 新增
     */
    public int insertCollectIndex(@Param("collectindex") SendiCollectIndex collectindex);

    /**
     * 删除
     */
    public int deleteCollectIndex(@Param("id") int id);

    /**
     * 更新
     */
    public int updateCollectIndex(@Param("collectindex") SendiCollectIndex collectindex);

    /**
     * Load查询
     */
    public SendiCollectIndex getCollectIndexById(@Param("id") int id);
}
