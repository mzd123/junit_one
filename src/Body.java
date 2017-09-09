import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
public class Body {
    private String mailNo;
    private String update;
    private String updateStr;
    private String ret_code;
    private String flag;
    private String dataSize;
    private String status;
    private String tel;
    private String expSpellName;
    private List<Data> data;
    private String expTextName;

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getUpdateStr() {
        return updateStr;
    }

    public void setUpdateStr(String updateStr) {
        this.updateStr = updateStr;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDataSize() {
        return dataSize;
    }

    public void setDataSize(String dataSize) {
        this.dataSize = dataSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getExpSpellName() {
        return expSpellName;
    }

    public void setExpSpellName(String expSpellName) {
        this.expSpellName = expSpellName;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getExpTextName() {
        return expTextName;
    }

    public void setExpTextName(String expTextName) {
        this.expTextName = expTextName;
    }

    @Override
    public String toString() {
        return "Body{" +
                "mailNo='" + mailNo + '\'' +
                ", update='" + update + '\'' +
                ", updateStr='" + updateStr + '\'' +
                ", ret_code='" + ret_code + '\'' +
                ", flag='" + flag + '\'' +
                ", dataSize='" + dataSize + '\'' +
                ", status='" + status + '\'' +
                ", tel='" + tel + '\'' +
                ", expSpellName='" + expSpellName + '\'' +
                ", data=" + data +
                ", expTextName='" + expTextName + '\'' +
                '}';
    }
}
