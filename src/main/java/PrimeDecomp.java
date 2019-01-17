import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeDecomp {
    public static String factors(int n) {
        String decomp = new String("");
        int resutl = n/2;
        int resutl2 = 0;
        if(resutl * 2 < n){
            resutl2 = resutl+1;
        }else{
            resutl2 = resutl;
        }
        AtomicInteger n1 = new AtomicInteger();
        n1.set(n);
        AtomicInteger n2 = new AtomicInteger();
        n2.set(resutl2);
        AtomicInteger n3 = new AtomicInteger();
        n3.set(resutl);

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
            return calculate(n1,n2,new AtomicInteger(2));
        }).thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            String b = new String(s);
            if(s.isEmpty() && PrimeUtils.isPrime(n)){
                b = "(" + String.valueOf(n) + ")(found)";
            }
            return b;
        }))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
                    String f = new String(s);
                    if(s.indexOf("(found)") > 0){
                        f = f.replace("(found)","");
                    }else{
                        f = s + calculate(n1,new AtomicInteger(n), n3);
                    }

                    return f;
                }));


        try {
            decomp = completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return decomp;
    }




    public static String calculate(AtomicInteger n2,AtomicInteger n1, AtomicInteger range){
        List<String> localResult = new ArrayList<>();
        try{

            int i =  range.get();
            for ( ; i <= n1.get() && n2.get() > 1  ;i++)
            {
                if(PrimeUtils.isPrime(i)){
                    if(n2.get()%i != 0)    continue;
                    int count = 0;
                    while(n2.get()%i == 0)
                    {
                        n2.getAndSet(n2.get() / i);
                        count ++;
                        if(localResult.isEmpty() || localResult.get(localResult.size() - 1).equals(")")){
                            localResult.add("(");
                            localResult.add(String.valueOf(i));
                            continue;
                        }
                        if(!localResult.isEmpty() && localResult.contains(String.valueOf(i)) && !localResult.get(localResult.size() - 1).equals("*")){
                            localResult.add("*");
                            localResult.add("*");
                        }
                    }
                    if(count > 1) localResult.add(String.valueOf(count));
                    localResult.add(")");

                }
            }

        }catch (Exception ex){
            String val = "";
        }
        return  String.join(new String(), localResult);
    }
}
