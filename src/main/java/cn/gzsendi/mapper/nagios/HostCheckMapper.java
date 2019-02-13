package cn.gzsendi.mapper.nagios;

import cn.gzsendi.annotation.DataSource;
import cn.gzsendi.model.nagios.NagiosHostCheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author Nacht
 * Created on 26/11/2018
 */
@Mapper
@DataSource(DataSource.NAGIOS)
public interface HostCheckMapper {
    /**
     * 获取所有的主机检查历史数据
     */
    public List<NagiosHostCheck> listHostChecks();

    /**
     * 获取指定时间段内的主机检查历史数据
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<NagiosHostCheck> listHostChecksByDate(@Param("beginDate") Date beginDate, @Param("endDate")Date endDate);
}
