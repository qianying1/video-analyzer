package cn.gzsendi.mapper.nagios;

import cn.gzsendi.annotation.DataSource;
import cn.gzsendi.model.nagios.NagiosServiceCheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author Nacht
 * Created on 23/11/2018
 */
@Mapper
@DataSource(DataSource.NAGIOS)
public interface ServiceCheckMapper {


    /**
     * 根据id获取单条指标检查历史数据
     * @param id
     * @return
     */
    public NagiosServiceCheck getServiceCheck(@Param("id") int id);

    /**
     * 获取所有指标检查历史数据
     */
    public List<NagiosServiceCheck> listServiceChecks();

    /**
     * 获取指定时间段的指标检查历史数据
     * @param beginDate
     * @param endDate
     */
    public List<NagiosServiceCheck> listServiceChecksByDate(@Param("beginDate") Date beginDate,@Param("endDate")Date endDate);

    /**
     * 获取指定id之后的数据
     * 用于数据同步场景,每次获取数据记录最后一条记录的id,下次读取从该id开始读取
     * @param id
     * @return
     */
    public List<NagiosServiceCheck> listServiceChecksByLastQueryId(@Param("id") int id);

}
