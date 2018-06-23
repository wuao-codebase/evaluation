package top.watech.evaluation.po;

public class Evaluat {
    private String XXXM;
    private String XYMC;
    private String SANJMC;
    private String BYXFZS;  //总学分
    private String JSZS;    // 教师总数
    private String FGJSZS;  //副教授
    private String ZGJSZS;  // 正教授
    private String BSJSZS;  // 博士
    private String ZXSRS;  // 在校生总数
    private String ZSBF; //总设备费用
    private String ZYTUSHU; //生均图书
    private String DNJXJF; //教学支出
    private String XNSXJD; //校外基地
    private String XWSXJD; //校内基地

    public String getXNSXJD() {
        return XNSXJD;
    }

    public void setXNSXJD(String XNSXJD) {
        this.XNSXJD = XNSXJD;
    }

    public String getXWSXJD() {
        return XWSXJD;
    }

    public void setXWSXJD(String XWSXJD) {
        this.XWSXJD = XWSXJD;
    }

    public String getBSJSZS() {
        return BSJSZS;
    }

    public void setBSJSZS(String BSJSZS) {
        this.BSJSZS = BSJSZS;
    }

    public String getDNJXJF() {
        return DNJXJF;
    }

    public void setDNJXJF(String DNJXJF) {
        this.DNJXJF = DNJXJF;
    }

    public String getZSBF() {
        return ZSBF;
    }

    public void setZSBF(String ZSBF) {
        this.ZSBF = ZSBF;
    }

    public String getBYXFZS() {
        return BYXFZS;
    }
    public void setBYXFZS(String BYXFZS) {
        this.BYXFZS = BYXFZS;
    }

    public String getXXXM() {
        return XXXM;
    }

    public void setXXXM(String XXXM) {
        this.XXXM = XXXM;
    }

    public String getXYMC() {
        return XYMC;
    }

    public void setXYMC(String XYMC) {
        this.XYMC = XYMC;
    }

    public String getSANJMC() {
        return SANJMC;
    }

    public void setSANJMC(String SANJMC) {
        this.SANJMC = SANJMC;
    }

    public String getJSZS() {
        return JSZS;
    }

    public void setJSZS(String JSZS) {
        this.JSZS = JSZS;
    }

    public String getFGJSZS() {
        return FGJSZS;
    }

    public void setFGJSZS(String FGJSZS) {
        this.FGJSZS = FGJSZS;
    }

    public String getZGJSZS() {
        return ZGJSZS;
    }

    public void setZGJSZS(String ZGJSZS) {
        this.ZGJSZS = ZGJSZS;
    }

    public String getZXSRS() {
        return ZXSRS;
    }

    public void setZXSRS(String ZXSRS) {
        this.ZXSRS = ZXSRS;
    }

    public String getZYTUSHU() {
        return ZYTUSHU;
    }

    public void setZYTUSHU(String ZYTUSHU) {
        this.ZYTUSHU = ZYTUSHU;
    }

    @Override
    public String toString() {
        return "Evaluat{" +
                "XXXM='" + XXXM + '\'' +
                ", XYMC='" + XYMC + '\'' +
                ", SANJMC='" + SANJMC + '\'' +
                ", JSZS='" + JSZS + '\'' +
                ", FGJSZS='" + FGJSZS + '\'' +
                ", ZGJSZS='" + ZGJSZS + '\'' +
                ", ZXSRS='" + ZXSRS + '\'' +
                '}';
    }
}
