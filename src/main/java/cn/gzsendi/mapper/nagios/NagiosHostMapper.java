package cn.gzsendi.mapper.nagios;

import cn.gzsendi.annotation.DataSource;
import cn.gzsendi.model.nagios.NagiosHost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Nacht
 * Created on 27/11/2018
 */
@Mapper
@DataSource(DataSource.NAGIOS)
public interface NagiosHostMapper {
    /**
     * 新增
     */
    public int insertHost(@Param("nagiosHosts")NagiosHost nagiosHostInfo);

    /**
     * 删除
     */
    public int deleteHost(@Param("id") int id);

    /**
     * 更新
     */
    public int updateHost(@Param("nagiosHosts") NagiosHost nagiosHostInfo);

    /**
     * 查询
     */
    public NagiosHost getHost(@Param("id") int id);

    /**
     * 查询所有主机数据
     */
    public List<NagiosHost> listAllHosts();
}
