public class Datas {
    private int dia;
    private int mes;
    private String[] data = new String[20];

    public Datas(){}

    public String getFormData(int i){
        return this.data[i];
    }
    public void setFormData(int dia, int mes,int i){
        this.dia = dia;
        this.mes = mes;

        this.data[i] = (Integer.toString(getDia())+"/"+Integer.toString(getMes()));
    }


    public int getDia(){return this.dia;}
    public int getMes(){return this.mes;}

    public void setDia(int dia){this.dia = dia;}
    public void setMes(int mes){this.mes = mes;}

}
