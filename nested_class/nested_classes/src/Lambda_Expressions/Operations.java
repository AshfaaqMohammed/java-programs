package Lambda_Expressions;


@FunctionalInterface
interface Operations <T>{
    public T operate(T value1, T value2);
}

@FunctionalInterface
interface MiniChallenge1 <T>{
    public void accept(String sentence);
}

interface MiniChallenge2 <T>{
    public T accept(String source);
}
