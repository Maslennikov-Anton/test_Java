import exception.NullInputValues;


public class Helper {

    private static final int MAX_SIZE = 3;
    private static final Integer MIN_SIZE_TOVARA = 100;
    private static final Integer MAX_SIZE_TOVARA = 30_000;
    private static final Integer MIN_SIZE_PRICE_PERCENT = 0;
    private static final Integer MAX_SIZE_PRICE_PERCENT = 100;
    private int size=0;

    private Integer[] target=new Integer[MAX_SIZE];

    public Helper(String[] target) throws NullInputValues {
        try {
            for (String item: target
                    ) {
                this.target[size]=Integer.parseInt(target[size]);
                size++;
            }
        }catch (NullPointerException e){
            throw new NullInputValues("Empty value or string in input file");
        }

    }

    public boolean checker(){
        if (size!=3) return false;
        if (!(this.target[0]>=MIN_SIZE_TOVARA && this.target[0]<=MAX_SIZE_TOVARA) || !(this.target[0]%100==0)) return false;
        if (!(this.target[1]>=MIN_SIZE_PRICE_PERCENT && this.target[1]<=MAX_SIZE_PRICE_PERCENT)) return false;
        if (!(this.target[2]>=MIN_SIZE_PRICE_PERCENT && this.target[2]<=MAX_SIZE_PRICE_PERCENT)) return false;
        return true;
    }

    public int notFoundDetails(){
        double details = ((double)this.target[1]/100)*this.target[0];
        return (int)details;
    }

    public int costs(){
        return this.notFoundDetails()*this.target[2];
    }

    public int getPrice(){
        return this.target[2];
    }


}
