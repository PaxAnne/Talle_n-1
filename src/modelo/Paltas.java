package modelo;

/**
 *
 * @author fernando-vasquez_paz-muñoz
 */
public class Paltas {

    long AveragePrice;
    long Volume;
    long smallHass;
    long largeHass;
    long extraLargeHass;
    long TotalBags;

    public Paltas(long AveragePrice, long Volume, long smallHass, long largeHass, long extraLargeHass, long TotalBags) {
        this.AveragePrice = AveragePrice;
        this.Volume = Volume;
        this.smallHass = smallHass;
        this.largeHass = largeHass;
        this.extraLargeHass = extraLargeHass;
        this.TotalBags = TotalBags;
    }
    
    //numero,Date,AveragePrice,Total Volume,4046,4225,4770,Total Bags,Small Bags,Large Bags,XLarge Bags,type,year,region

    @Override
    public String toString() {
        return "Info{" + "AveragePrice=" + AveragePrice + ", Volume=" + Volume + ", smallHass=" + smallHass + ", largeHass=" + largeHass + ", extraLargeHass=" + extraLargeHass + ", TotalBags=" + TotalBags + '}';
    }

    public long getVolume() {
        return Volume;
    }

    public long getTotalBags() {
        return TotalBags;
    }

    public static Paltas[] insertionSort(Paltas[] info){
        Paltas[] a = info;
        int in, out;
        int nElems = a.length;
        for(out=1; out<nElems; out++){
            long temp = a[out].Volume;            
            in = out; 
            
            while(in>0 && a[in-1].Volume >= temp){
                a[in] = a[in-1];           
                --in;                       
            }
            a[in].Volume = temp;                  
        }
        return a;
    }
    
    public static Paltas[] quickSort(Paltas[] info,int left, int right){
        if(left>right){
            int index = partitionIt(info, left, right);
            
            quickSort(info, left, index-1);
            quickSort(info, index, right);
        }
        return info;
    }
    
    public static int partitionIt(Paltas[] info, int left, int right){
        int i = left-1;
        int pivot = right;
        Paltas temp;
        
        for (int j = left; j < right; j++) {
            if(info[j].Volume <= info[pivot].Volume){
                i++;
                temp = info[j];
                info[j] = info[i];
                info[i] = temp;
            }
        }
        
        temp = info[i+1];
        info[i+1] = info [right];
        info[right] = temp;
        
        return i+1;
    }
}
