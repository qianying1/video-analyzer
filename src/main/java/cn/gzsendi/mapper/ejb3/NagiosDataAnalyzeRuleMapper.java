package cn.gzsendi.mapper.ejb3;

import cn.gzsendi.annotation.DataSource;
import cn.gzsendi.model.nagios.NagiosDataAnalyzeRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Nacht
 * Created on 29/11/2018
 */
@Mapper
@DataSource(DataSource.EJB3)
public interface NagiosDataAnalyzeRuleMapper {
    /**
     * 新增
     */
    public int insertRule(@Param("nagiosDataAnalyzeRule") NagiosDataAnalyzeRule nagiosDataAnalyzeRule);

    /**
     * 删除
     */
    public int deleteRule(@Param("id") int id);

    /**
     * 更新
     */
    public int updateRule(@Param("nagiosDataAnalyzeRule") NagiosDataAnalyzeRule nagiosDataAnalyzeRule);

    /**
     * Load查询
     */
    public NagiosDataAnalyzeRule getRule(@Param("id") int id);

    /**
     * 获取所有nagios解析规则
     * @return
     */
    public List<NagiosDataAnalyzeRule> listRules();
}
