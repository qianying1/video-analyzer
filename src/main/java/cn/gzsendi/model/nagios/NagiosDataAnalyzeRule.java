package cn.gzsendi.model.nagios;

/**
 * @Author Nacht
 * Created on 29/11/2018
 */
public class NagiosDataAnalyzeRule {
    /**
     *
     */
    private int id;

    /**
     * 解析规则名称
     */
    private String name;

    /**
     * 规则匹配正则
     */
    private String matchExpression;

    /**
     * 指标值提取正则
     */
    private String valueExtractExpression;

    /**
     * 对应的指标id
     */
    private int collectIndexId;

    /**
     * 状态0停用1启用
     */
    private int status;

    /**
     * 说明
     */
    private String comment;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatchExpression() {
        return matchExpression;
    }

    public void setMatchExpression(String matchExpression) {
        this.matchExpression = matchExpression;
    }

    public String getValueExtractExpression() {
        return valueExtractExpression;
    }

    public void setValueExtractExpression(String valueExtractExpression) {
        this.valueExtractExpression = valueExtractExpression;
    }

    public int getCollectIndexId() {
        return collectIndexId;
    }

    public void setCollectIndexId(int collectIndexId) {
        this.collectIndexId = collectIndexId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "NagiosDataAnalyzeRule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matchExpression='" + matchExpression + '\'' +
                ", valueExtractExpression='" + valueExtractExpression + '\'' +
                ", collectIndexId=" + collectIndexId +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                '}';
    }
}
