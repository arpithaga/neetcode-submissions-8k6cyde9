static class Singleton {
    private static Singleton s1=null;
    String val;
    private Singleton() {      
    }

    public static Singleton getInstance() {
        if(s1==null){
            s1=new Singleton();
        }
        return s1;
    }

    public String getValue() {
        return val;
    }

    public void setValue(String value) {
        this.val=value;
    }
    
}
