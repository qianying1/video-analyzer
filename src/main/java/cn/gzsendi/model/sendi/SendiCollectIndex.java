package cn.gzsendi.model.sendi;

/**
 * 指标表实体类
 * @Author Nacht
 * Created on 03/12/2018
 */
public class SendiCollectIndex {
    /**
     *
     */
    private int id;

    /**
     *
     */
    private String nameEn;

    /**
     *
     */
    private String nameZh;

    /**
     *
     */
    private String bigtemplate;

    /**
     *
     */
    private String analysetype;

    /**
     *
     */
    private String sortindex;

    /**
     *
     */
    private String unit;

    /**
     *
     */
    private int zyjhonly;

    /**
     *
     */
    private String maker;

    /**
     *
     */
    private String modifytime;

    /**
     *
     */
    private String visibility;

    /**
     *
     */
    private String page;

    /**
     *
     */
    private String templates;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getBigtemplate() {
        return bigtemplate;
    }

    public void setBigtemplate(String bigtemplate) {
        this.bigtemplate = bigtemplate;
    }

    public String getAnalysetype() {
        return analysetype;
    }

    public void setAnalysetype(String analysetype) {
        this.analysetype = analysetype;
    }

    public String getSortindex() {
        return sortindex;
    }

    public void setSortindex(String sortindex) {
        this.sortindex = sortindex;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getZyjhonly() {
        return zyjhonly;
    }

    public void setZyjhonly(int zyjhonly) {
        this.zyjhonly = zyjhonly;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates;
    }

    @Override
    public String toString() {
        return "SendiCollectIndex{" +
                "id=" + id +
                ", nameEn='" + nameEn + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", bigtemplate='" + bigtemplate + '\'' +
                ", analysetype='" + analysetype + '\'' +
                ", sortindex='" + sortindex + '\'' +
                ", unit='" + unit + '\'' +
                ", zyjhonly=" + zyjhonly +
                ", maker='" + maker + '\'' +
                ", modifytime='" + modifytime + '\'' +
                ", visibility='" + visibility + '\'' +
                ", page='" + page + '\'' +
                ", templates='" + templates + '\'' +
                '}';
    }
}
