package robertbeckwith.uiuctransfer;

/**
 * Created by rjbec on 5/6/2017.
 */

public class Transfers {
        private int code,uiuccode;
        private String symbol,name,cod,uiucsymbol,ssHum,westerneastern, description, transferStatus,majors;

        //General engineering classes
        public Transfers(String symbol,String name,int code, String transferStatus,String description,String majors){
            this.setName(name);
            this.setCode(code);
            this.setSymbol(symbol);
            this.setTransferStatus(transferStatus);
            this.setDescription(description);
            this.setMajors(majors);
        }

        // General elective classes
        public Transfers(String symbol, String name, int code, String cod, String uiucsymbol,int uiuccode, String ssHum,String westerneastern, String description ) {
            this.setSymbol(symbol);
            this.setName(name);
            this.setCode(code);
            this.setCod(cod);
            this.setUiucsymbol(uiucsymbol);
            this.setUiuccode(uiuccode);
            this.setSsHum(ssHum);
            this.setWesterneastern(westerneastern);
            this.setDescription(description);
        }
        public String getSymbol(){
            return symbol;
        }
        public void setSymbol(String symbol){
            this.symbol=symbol;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getCod() {
            return cod;
        }

        public void setCod(String cod) {
            this.cod = cod;
        }

        public String getUiucsymbol(){
            return uiucsymbol;
        }
        public void setUiucsymbol(String uiucsymbol){
            this.uiucsymbol=uiucsymbol;
        }

        public int getUiuccode(){
            return uiuccode;
        }
        public void setUiuccode(int uiuccode){
            this.uiuccode = uiuccode;
        }

        public String getSsHum(){
            return ssHum;
        }
        public void setSsHum(String ssHum){
            this.ssHum = ssHum;
        }

        public String getWesterneastern(){
            return westerneastern;
        }
        public void setWesterneastern(String westerneastern){
            this.westerneastern=westerneastern;
        }

        public String getDescription() {
        return description;
    }

        public void setDescription(String description) {
        this.description = description;
    }
        public void setTransferStatus(String transferStatus){this.transferStatus=transferStatus;}
        public String getTransferStatus(){return transferStatus;}

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }
}