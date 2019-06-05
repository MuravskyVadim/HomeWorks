class Pair<T, K> {
    private T firstParameter;
    private K secondParameter;

    private Pair(T firstParameter, K secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public T getFirst() {
        return firstParameter;
    }

    public K getSecond() {
        return secondParameter;
    }

    public static <T, K> Pair of(T firstParameter, K secondParameter) {
        return new Pair<>(firstParameter, secondParameter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (firstParameter != null
                ? !firstParameter.equals(pair.firstParameter)
                : pair.firstParameter != null) {
            return false;
        }
        return secondParameter != null
                ? secondParameter.equals(pair.secondParameter)
                : pair.secondParameter == null;
    }

    @Override
    public int hashCode() {
        int result = firstParameter != null ? firstParameter.hashCode() : 0;
        result = 31 * result + (secondParameter != null ? secondParameter.hashCode() : 0);
        return result;
    }
}
